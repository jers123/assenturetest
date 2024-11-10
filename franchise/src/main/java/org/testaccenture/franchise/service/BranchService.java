package org.testaccenture.franchise.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.testaccenture.franchise.model.dto.branch.BranchCreateDTO;
import org.testaccenture.franchise.model.dto.branch.BranchOutputDTO;
import org.testaccenture.franchise.model.dto.branch.BranchProductDTO;
import org.testaccenture.franchise.model.dto.branch.BranchUpdateDTO;
import org.testaccenture.franchise.model.entity.Branch;
import org.testaccenture.franchise.model.entity.Franchise;
import org.testaccenture.franchise.model.repository.IBranchRepository;
import org.testaccenture.franchise.model.repository.IFranchiseRepository;
import org.testaccenture.franchise.utils.mappers.BranchMapper;
import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

import static org.testaccenture.franchise.utils.Constants.BRANCH_NAME_EXISTS;
import static org.testaccenture.franchise.utils.Constants.FRANCHISE_BRANCH_NOT_EXISTS;
import static org.testaccenture.franchise.utils.Constants.NO_CONTENT;
import static org.testaccenture.franchise.utils.Constants.NO_CONTENT_ID;
import static org.testaccenture.franchise.utils.Constants.SUCCESSFULLY_CREATED_BRANCH;
import static org.testaccenture.franchise.utils.Constants.SUCCESSFULLY_UPDATED_BRANCH;
import static org.testaccenture.franchise.utils.Constants.YES_CONTENT;
import static org.testaccenture.franchise.utils.SystemConstants.API_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.CREATE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ALL_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ID_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_STOCK_PRODUCT_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.UPDATE_PATH;

@Service
@Validated
public class BranchService implements IBranchService {

	@Autowired
	private IBranchRepository repository;

	@Autowired
	private IFranchiseRepository franchiseRepository;

	@Autowired
	private ReplyMessageSimple<BranchOutputDTO> replyMessageSimple;

	@Autowired
	private ReplyMessageList<BranchUpdateDTO> replyMessageList;

	@Autowired
	private BranchMapper mapper;
	
	@Override
	public ReplyMessageSimple<BranchOutputDTO> getCreate(BranchCreateDTO entityDto) {
		replyMessageSimple.setUri(getUri(CREATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			String name = repository.searchByName(0, entityDto.getIdFranchise(), entityDto.getBranchName());
			Franchise franchise = franchiseRepository.findById(entityDto.getIdFranchise()).orElse(null);
			if (name != null) {
				messages.add(BRANCH_NAME_EXISTS);
			}
			if (franchise == null) {
				messages.add(FRANCHISE_BRANCH_NOT_EXISTS);
			}
			if (name == null && franchise != null) {
				Branch entity = new Branch();
				entity.setIdFranchise(franchise);
				entity = mapper.create(entityDto, entity);
				BranchOutputDTO entityOutput = mapper.readAll(repository.save(entity));
				replyMessageSimple.setHttpStatus(HttpStatus.CREATED);
				replyMessageSimple.setError(false);
				messages.add(SUCCESSFULLY_CREATED_BRANCH);
				replyMessageSimple.setResponse(entityOutput);
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			replyMessageSimple.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageSimple.setMessage(messages);
		replyMessageSimple.setDate(LocalDateTime.now());
		return replyMessageSimple;
	}

	@Override
	public ReplyMessageList<BranchUpdateDTO> getFindAll() {
		replyMessageList.setUri(getUri(GET_ALL_PATH));
		replyMessageList.setError(true);
		replyMessageList.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			List<Branch> entities = repository.searchAll();
			if (!entities.isEmpty()) {
				List<BranchUpdateDTO> entitiesDto = mapper.readList(entities);
				messages.add(YES_CONTENT);
				replyMessageList.setResponse(entitiesDto);
			} else {
				messages.add(NO_CONTENT);
			}
			replyMessageList.setHttpStatus(HttpStatus.OK);
			replyMessageList.setError(false);
		} catch (Exception e) {
			replyMessageList.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageList.setMessage(messages);
		replyMessageList.setDate(LocalDateTime.now());
		return replyMessageList;
	}

	@Override
	public ReplyMessageSimple<BranchOutputDTO> getFindById(Integer id) {
		replyMessageSimple.setUri(getUri(GET_ID_PATH, id));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Branch entity = repository.findById(id).orElse(null);
			if (entity != null) {
				BranchOutputDTO entityDto = mapper.readAll(entity);
				replyMessageSimple.setHttpStatus(HttpStatus.OK);
				replyMessageSimple.setError(false);
				messages.add(YES_CONTENT);
				replyMessageSimple.setResponse(entityDto);
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + id);
			}
		} catch (Exception e) {
			replyMessageSimple.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageSimple.setMessage(messages);
		replyMessageSimple.setDate(LocalDateTime.now());
		return replyMessageSimple;
	}
	
	@Override
	public ReplyMessageSimple<BranchProductDTO> getByMaxStoctProduct(Integer id) {
		ReplyMessageSimple<BranchProductDTO> replyMessage = new ReplyMessageSimple<>();
		replyMessage.setUri(getUri(GET_STOCK_PRODUCT_PATH, id));
		replyMessage.setError(true);
		replyMessage.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Franchise entity = franchiseRepository.findById(id).orElse(null);
			if (entity != null) {
				BranchProductDTO entityDto = mapper.reardSpecial(entity, repository.searchByMaxStockFromProduct(id));
				replyMessage.setHttpStatus(HttpStatus.OK);
				replyMessage.setError(false);
				messages.add(YES_CONTENT);
				replyMessage.setResponse(entityDto);
			} else {
				replyMessage.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + id);
			}
		} catch (Exception e) {
			replyMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessage.setMessage(messages);
		replyMessage.setDate(LocalDateTime.now());
		return replyMessage;
	}

	@Override
	public ReplyMessageSimple<BranchOutputDTO> getUpdate(BranchUpdateDTO entityDto) {
		replyMessageSimple.setUri(getUri(UPDATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Branch entity = repository.findById(entityDto.getIdBranch()).orElse(null);
			if (entity != null) {
				String name = repository.searchByName(entityDto.getIdBranch(), entityDto.getIdFranchise(), entityDto.getBranchName());
				Franchise franchise = franchiseRepository.findById(entityDto.getIdFranchise()).orElse(null);
				if (name != null) {
					messages.add(BRANCH_NAME_EXISTS);
				}
				if (franchise == null) {
					messages.add(FRANCHISE_BRANCH_NOT_EXISTS);
				}
				if (name == null && franchise != null) {
					entity.setIdFranchise(franchise);
					entity = mapper.update(entityDto, entity);
					BranchOutputDTO entityOutput = mapper.readAll(repository.save(entity));
					replyMessageSimple.setHttpStatus(HttpStatus.CREATED);
					replyMessageSimple.setError(false);
					messages.add(SUCCESSFULLY_UPDATED_BRANCH);
					replyMessageSimple.setResponse(entityOutput);
				} else {
					replyMessageSimple.setHttpStatus(HttpStatus.CONFLICT);
				}
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + entityDto.getIdBranch());
			}
		} catch (Exception e) {
			replyMessageSimple.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageSimple.setMessage(messages);
		replyMessageSimple.setDate(LocalDateTime.now());
		return replyMessageSimple;
	}
	
	@Override
	public String getUri(String method) {
		return API_PATH + BRANCH_PATH + method;
	}

	@Override
	public String getUri(String method, Integer id) {
		return API_PATH + BRANCH_PATH + method + id;
	}
}
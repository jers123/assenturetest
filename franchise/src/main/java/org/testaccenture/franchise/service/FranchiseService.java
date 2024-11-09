package org.testaccenture.franchise.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.testaccenture.franchise.model.dto.franchise.FranchiseCreateDTO;
import org.testaccenture.franchise.model.dto.franchise.FranchiseOutputDTO;
import org.testaccenture.franchise.model.dto.franchise.FranchiseUpdateDTO;
import org.testaccenture.franchise.model.entity.Franchise;
import org.testaccenture.franchise.model.repository.IFranchiseRepository;
import org.testaccenture.franchise.utils.mappers.IMapper;
import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

import static org.testaccenture.franchise.utils.Constants.FRANCHISE_NAME_EXISTS;
import static org.testaccenture.franchise.utils.Constants.NO_CONTENT;
import static org.testaccenture.franchise.utils.Constants.NO_CONTENT_ID;
import static org.testaccenture.franchise.utils.Constants.SUCCESSFULLY_CREATED_FRANCHISE;
import static org.testaccenture.franchise.utils.Constants.SUCCESSFULLY_UPDATED_FRANCHISE;
import static org.testaccenture.franchise.utils.Constants.YES_CONTENT;
import static org.testaccenture.franchise.utils.SystemConstants.API_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.CREATE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ALL_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ID_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.UPDATE_PATH;

@Service
@Validated
public class FranchiseService implements IBaseService<FranchiseCreateDTO, FranchiseUpdateDTO, FranchiseOutputDTO> {

	@Autowired
	private IFranchiseRepository repository;

	@Autowired
	private ReplyMessageSimple<FranchiseOutputDTO> replyMessageSimple;

	@Autowired
	private ReplyMessageList<FranchiseUpdateDTO> replyMessageList;

	@Autowired
	private IMapper<FranchiseCreateDTO, FranchiseUpdateDTO, FranchiseOutputDTO, Franchise> mapper;

	@Override
	public ReplyMessageSimple<FranchiseOutputDTO> getCreate(FranchiseCreateDTO entityDto) {
		replyMessageSimple.setUri(getUri(CREATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			String name = repository.searchByName(0, entityDto.getFrachiseName());
			if (name != null) {
				messages.add(FRANCHISE_NAME_EXISTS);
				replyMessageSimple.setHttpStatus(HttpStatus.CONFLICT);
			} else {
				Franchise entity = mapper.create(entityDto);
				FranchiseOutputDTO entityOutput = mapper.readAll(repository.save(entity));
				replyMessageSimple.setHttpStatus(HttpStatus.CREATED);
				replyMessageSimple.setError(false);
				messages.add(SUCCESSFULLY_CREATED_FRANCHISE);
				replyMessageSimple.setResponse(entityOutput);
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
	public ReplyMessageList<FranchiseUpdateDTO> getFindAll() {
		replyMessageList.setUri(getUri(GET_ALL_PATH));
		replyMessageList.setError(true);
		replyMessageList.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			List<Franchise> entities = repository.searchAll();
			if (!entities.isEmpty()) {
				List<FranchiseUpdateDTO> entitiesDto = mapper.readList(entities);
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
	public ReplyMessageSimple<FranchiseOutputDTO> getFindById(Integer id) {
		replyMessageSimple.setUri(getUri(GET_ID_PATH, id));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Franchise entity = repository.findById(id).orElse(null);
			if (entity != null) {
				FranchiseOutputDTO entityDto = mapper.readAll(entity);
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
	public ReplyMessageSimple<FranchiseOutputDTO> getUpdate(FranchiseUpdateDTO entityDto) {
		replyMessageSimple.setUri(getUri(UPDATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Franchise entity = repository.findById(entityDto.getIdFranchise()).orElse(null);
			if (entity != null) {
				String name = repository.searchByName(entityDto.getIdFranchise(), entityDto.getFrachiseName());
				if (name != null) {
					messages.add(FRANCHISE_NAME_EXISTS);
					replyMessageSimple.setHttpStatus(HttpStatus.CONFLICT);
				} else {
					entity = mapper.update(entityDto, entity);
					FranchiseOutputDTO entityOutput = mapper.readAll(repository.save(entity));
					replyMessageSimple.setHttpStatus(HttpStatus.CREATED);
					replyMessageSimple.setError(false);
					messages.add(SUCCESSFULLY_UPDATED_FRANCHISE);
					replyMessageSimple.setResponse(entityOutput);
				}
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + entityDto.getIdFranchise());
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
		return API_PATH + FRANCHISE_PATH + method;
	}

	@Override
	public String getUri(String method, Integer id) {
		return API_PATH + FRANCHISE_PATH + method + id;
	}
}
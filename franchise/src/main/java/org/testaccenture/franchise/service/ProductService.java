package org.testaccenture.franchise.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.testaccenture.franchise.model.dto.product.ProductCreateDTO;
import org.testaccenture.franchise.model.dto.product.ProductUpdateDTO;
import org.testaccenture.franchise.model.entity.Branch;
import org.testaccenture.franchise.model.entity.Product;
import org.testaccenture.franchise.model.repository.IBranchRepository;
import org.testaccenture.franchise.model.repository.IProductRepository;
import org.testaccenture.franchise.utils.mappers.ProductMapper;
import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

import static org.testaccenture.franchise.utils.Constants.BRANCH_PRODUCT_NOT_EXISTS;
import static org.testaccenture.franchise.utils.Constants.NO_CONTENT;
import static org.testaccenture.franchise.utils.Constants.NO_CONTENT_ID;
import static org.testaccenture.franchise.utils.Constants.PRODUCT_NAME_EXISTS;
import static org.testaccenture.franchise.utils.Constants.SUCCESSFULLY_CREATED_PRODUCT;
import static org.testaccenture.franchise.utils.Constants.SUCCESSFULLY_DELETED_PRODUCT;
import static org.testaccenture.franchise.utils.Constants.SUCCESSFULLY_UPDATED_PRODUCT;
import static org.testaccenture.franchise.utils.Constants.YES_CONTENT;
import static org.testaccenture.franchise.utils.SystemConstants.API_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.CREATE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.DELETE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ALL_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ID_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.UPDATE_PATH;

@Service
@Validated
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository repository;

	@Autowired
	private IBranchRepository branchRepository;

	@Autowired
	private ReplyMessageSimple<ProductUpdateDTO> replyMessageSimple;

	@Autowired
	private ReplyMessageList<ProductUpdateDTO> replyMessageList;

	@Autowired
	private ProductMapper mapper;

	@Override
	public ReplyMessageSimple<ProductUpdateDTO> getCreate(ProductCreateDTO entityDto) {
		replyMessageSimple.setUri(getUri(CREATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			String name = repository.searchByName(0, entityDto.getIdBranch(), entityDto.getProductName());
			Branch branch = branchRepository.findById(entityDto.getIdBranch()).orElse(null);
			if (name != null) {
				messages.add(PRODUCT_NAME_EXISTS);
			}
			if (branch == null) {
				messages.add(BRANCH_PRODUCT_NOT_EXISTS);
			}
			if (name == null && branch != null) {
				Product entity = new Product();
				entity.setIdBranch(branch);
				entity = mapper.create(entityDto, entity);
				ProductUpdateDTO entityOutput = mapper.read(repository.save(entity));
				replyMessageSimple.setHttpStatus(HttpStatus.CREATED);
				replyMessageSimple.setError(false);
				messages.add(SUCCESSFULLY_CREATED_PRODUCT);
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
	public ReplyMessageList<ProductUpdateDTO> getFindAll() {
		replyMessageList.setUri(getUri(GET_ALL_PATH));
		replyMessageList.setError(true);
		replyMessageList.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			List<Product> entities = repository.searchAll();
			if (!entities.isEmpty()) {
				List<ProductUpdateDTO> entitiesDto = mapper.readList(entities);
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
	public ReplyMessageSimple<ProductUpdateDTO> getFindById(Integer id) {
		replyMessageSimple.setUri(getUri(GET_ID_PATH, id));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Product entity = repository.findById(id).orElse(null);
			if (entity != null) {
				ProductUpdateDTO entityDto = mapper.read(entity);
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
	public ReplyMessageSimple<ProductUpdateDTO> getUpdate(ProductUpdateDTO entityDto) {
		replyMessageSimple.setUri(getUri(UPDATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Product entity = repository.findById(entityDto.getIdProduct()).orElse(null);
			if (entity != null) {
				String name = repository.searchByName(entityDto.getIdProduct(), entityDto.getIdBranch(), entityDto.getProductName());
				Branch branch = branchRepository.findById(entityDto.getIdBranch()).orElse(null);
				if (name != null) {
					messages.add(PRODUCT_NAME_EXISTS);
				}
				if (branch == null) {
					messages.add(BRANCH_PRODUCT_NOT_EXISTS);
				}
				if (name == null && branch != null) {
					entity.setIdBranch(branch);
					entity = mapper.update(entityDto, entity);
					ProductUpdateDTO entityOutput = mapper.read(repository.save(entity));
					replyMessageSimple.setHttpStatus(HttpStatus.CREATED);
					replyMessageSimple.setError(false);
					messages.add(SUCCESSFULLY_UPDATED_PRODUCT);
					replyMessageSimple.setResponse(entityOutput);
				} else {
					replyMessageSimple.setHttpStatus(HttpStatus.CONFLICT);
				}
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + entityDto.getIdProduct());
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
	public ReplyMessageSimple<ProductUpdateDTO> getDelete(Integer id) {
		replyMessageSimple.setUri(getUri(DELETE_PATH, id));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			Product entity = repository.findById(id).orElse(null);
			if (entity != null) {
				repository.delete(entity);
				replyMessageSimple.setHttpStatus(HttpStatus.OK);
				replyMessageSimple.setError(false);
				messages.add(SUCCESSFULLY_DELETED_PRODUCT);
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
	public String getUri(String method) {
		return API_PATH + PRODUCT_PATH + method;
	}

	@Override
	public String getUri(String method, Integer id) {
		return API_PATH + PRODUCT_PATH + method + id;
	}
}
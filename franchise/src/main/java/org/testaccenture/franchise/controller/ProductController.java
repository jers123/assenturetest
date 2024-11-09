package org.testaccenture.franchise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testaccenture.franchise.annotation.RestApi;
import org.testaccenture.franchise.model.dto.product.ProductCreateDTO;
import org.testaccenture.franchise.model.dto.product.ProductUpdateDTO;
import org.testaccenture.franchise.service.IProductService;
import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

import static org.testaccenture.franchise.utils.SystemConstants.API_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.answerList;
import static org.testaccenture.franchise.utils.SystemConstants.answerSimple;

@RestApi
@RequestMapping(path = API_PATH + PRODUCT_PATH)
public class ProductController implements IProductController {

	@Autowired
	private IProductService service;

	@Override
	public ResponseEntity<ReplyMessageSimple> create(ProductCreateDTO entityDto) {
		try {
			return answerSimple(service.getCreate(entityDto));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageList> getAll() {
		try {
			return answerList(service.getFindAll());
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageSimple> getById(Integer id) {
		try {
			return answerSimple(service.getFindById(id));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageSimple> update(ProductUpdateDTO entityDto) {
		try {
			return answerSimple(service.getUpdate(entityDto));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageSimple> delete(Integer id) {
		try {
			return answerSimple(service.getDelete(id));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
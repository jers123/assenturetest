package org.testaccenture.franchise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testaccenture.franchise.annotation.RestApi;
import org.testaccenture.franchise.model.dto.franchise.FranchiseCreateDTO;
import org.testaccenture.franchise.model.dto.franchise.FranchiseOutputDTO;
import org.testaccenture.franchise.model.dto.franchise.FranchiseUpdateDTO;
import org.testaccenture.franchise.service.IBaseService;
import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

import static org.testaccenture.franchise.utils.SystemConstants.API_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.answerList;
import static org.testaccenture.franchise.utils.SystemConstants.answerSimple;

@RestApi
@RequestMapping(path = API_PATH + FRANCHISE_PATH)
public class FranchiseController implements IBaseController<FranchiseCreateDTO, FranchiseUpdateDTO> {

	@Autowired
	private IBaseService<FranchiseCreateDTO, FranchiseUpdateDTO, FranchiseOutputDTO> service;

	@Override
	public ResponseEntity<ReplyMessageSimple> create(FranchiseCreateDTO entityDto) {
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
	public ResponseEntity<ReplyMessageSimple> update(FranchiseUpdateDTO entityDto) {
		try {
			return answerSimple(service.getUpdate(entityDto));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
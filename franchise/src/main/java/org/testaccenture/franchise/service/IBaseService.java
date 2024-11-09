package org.testaccenture.franchise.service;

import org.testaccenture.franchise.model.dto.BaseEntityDTO;
import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;
import org.springframework.transaction.annotation.Transactional;

public interface IBaseService<BC extends BaseEntityDTO, BU extends BaseEntityDTO, BO extends BaseEntityDTO> {
	@Transactional()
	ReplyMessageSimple<BO> getCreate(BC entityDto);

	@Transactional(readOnly = true)
	ReplyMessageList<BU> getFindAll();

	@Transactional(readOnly = true)
	ReplyMessageSimple<BO> getFindById(Integer id);

	@Transactional()
	ReplyMessageSimple<BO> getUpdate(BU entityDto);

	String getUri(String method);

	String getUri(String method, Integer id);
}
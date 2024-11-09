package org.testaccenture.franchise.service;

import org.springframework.transaction.annotation.Transactional;
import org.testaccenture.franchise.model.dto.product.ProductCreateDTO;
import org.testaccenture.franchise.model.dto.product.ProductUpdateDTO;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

public interface IProductService extends IBaseService<ProductCreateDTO, ProductUpdateDTO, ProductUpdateDTO> {
	@Transactional()
	ReplyMessageSimple<ProductUpdateDTO> getDelete(Integer id);
}
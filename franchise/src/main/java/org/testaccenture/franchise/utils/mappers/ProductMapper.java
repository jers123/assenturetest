package org.testaccenture.franchise.utils.mappers;

import org.springframework.stereotype.Component;
import org.testaccenture.franchise.model.dto.product.ProductCreateDTO;
import org.testaccenture.franchise.model.dto.product.ProductUpdateDTO;
import org.testaccenture.franchise.model.entity.Product;

@Component
public class ProductMapper implements IMapper<ProductCreateDTO, ProductUpdateDTO, ProductUpdateDTO, Product> {

	@Override
	public Product create(ProductCreateDTO entityDto) {
		Product entity = new Product();
		entity.setProductName(entityDto.getProductName());
		entity.setStock(entityDto.getStock());
		return entity;
	}
	
	public Product create(ProductCreateDTO entityDto, Product entity) {
		entity.setProductName(entityDto.getProductName());
		entity.setStock(entityDto.getStock());
		return entity;
	}

	@Override
	public ProductUpdateDTO read(Product entity) {
		ProductUpdateDTO entityDto = new ProductUpdateDTO();
		entityDto.setIdProduct(entity.getIdProduct());
		entityDto.setProductName(entity.getProductName());
		entityDto.setIdBranch(entity.getIdBranch().getIdBranch());
		entityDto.setStock(entity.getStock());
		return entityDto;
	}
	
	@Override
	public ProductUpdateDTO readAll(Product entity) {
		return null;
	}

	@Override
	public Product update(ProductUpdateDTO entityDto, Product entity) {
		entity.setProductName(entityDto.getProductName());
		entity.setStock(entityDto.getStock());
		return entity;
	}
}
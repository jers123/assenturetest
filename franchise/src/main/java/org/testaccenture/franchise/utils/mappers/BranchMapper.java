package org.testaccenture.franchise.utils.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testaccenture.franchise.model.dto.branch.BranchCreateDTO;
import org.testaccenture.franchise.model.dto.branch.BranchOutputDTO;
import org.testaccenture.franchise.model.dto.branch.BranchUpdateDTO;
import org.testaccenture.franchise.model.entity.Branch;
import org.testaccenture.franchise.model.entity.Product;

@Component
public class BranchMapper implements IMapper<BranchCreateDTO, BranchUpdateDTO, BranchOutputDTO, Branch> {

	@Autowired
	private ProductMapper mapper;
	
	@Override
	public Branch create(BranchCreateDTO entityDto) {
		Branch entity = new Branch();
		entity.setBranchName(entityDto.getBranchName());
		return entity;
	}
	
	public Branch create(BranchCreateDTO entityDto, Branch entity) {
		entity.setBranchName(entityDto.getBranchName());
		entityDto.setIdFranchise(entity.getIdFranchise().getIdFranchise());
		return entity;
	}

	@Override
	public BranchUpdateDTO read(Branch entity) {
		BranchUpdateDTO entityDto = new BranchUpdateDTO();
		entityDto.setIdBranch(entity.getIdBranch());
		entityDto.setBranchName(entity.getBranchName());
		entityDto.setIdFranchise(entity.getIdFranchise().getIdFranchise());
		return entityDto;
	}
	
	@Override
	public BranchOutputDTO readAll(Branch entity) {
		BranchOutputDTO entityDto = new BranchOutputDTO();
		entityDto.setIdBranch(entity.getIdBranch());
		entityDto.setBranchName(entity.getBranchName());
		entityDto.setIdFranchise(entity.getIdFranchise().getIdFranchise());
		List<Product> products = entity.getProducts();
		if (products == null || products.isEmpty()) {
			entityDto.setProducts(null);
		} else {
			entityDto.setProducts(mapper.readList(products));
		}
		return entityDto;
	}

	@Override
	public Branch update(BranchUpdateDTO entityDto, Branch entity) {
		entity.setBranchName(entityDto.getBranchName());
		entityDto.setIdFranchise(entity.getIdFranchise().getIdFranchise());
		return entity;
	}
}
package org.testaccenture.franchise.utils.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testaccenture.franchise.model.dto.branch.BranchCreateDTO;
import org.testaccenture.franchise.model.dto.branch.BranchOutputDTO;
import org.testaccenture.franchise.model.dto.branch.BranchProductDTO;
import org.testaccenture.franchise.model.dto.branch.BranchUpdateDTO;
import org.testaccenture.franchise.model.dto.branch.ProductBranchDTO;
import org.testaccenture.franchise.model.entity.Branch;
import org.testaccenture.franchise.model.entity.Franchise;
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
	
	public BranchProductDTO reardSpecial(Franchise entity, List<Object[]> list) {
		BranchProductDTO entityDto = new BranchProductDTO();
		entityDto.setIdFranchise(entity.getIdFranchise());
		entityDto.setFrachiseName(entity.getFranchiseName());
		if(list == null || list.isEmpty()) {
			entityDto.setBranchs(null);
		} else {
			entityDto.setBranchs(list.stream()
				.map(record -> new ProductBranchDTO(
					((Integer) record[0]).intValue(),
					(String) record[1],
					((Integer) record[2]).intValue(),
					(String) record[3],
					((Integer) record[4]).intValue()
				))
				.collect(Collectors.toList()));
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
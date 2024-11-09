package org.testaccenture.franchise.utils.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testaccenture.franchise.model.dto.franchise.FranchiseCreateDTO;
import org.testaccenture.franchise.model.dto.franchise.FranchiseOutputDTO;
import org.testaccenture.franchise.model.dto.franchise.FranchiseUpdateDTO;
import org.testaccenture.franchise.model.entity.Branch;
import org.testaccenture.franchise.model.entity.Franchise;

@Component
public class FranchiseMapper implements IMapper<FranchiseCreateDTO, FranchiseUpdateDTO, FranchiseOutputDTO, Franchise> {

	@Autowired
	private BranchMapper mapper;
	
	@Override
	public Franchise create(FranchiseCreateDTO entityDto) {
		Franchise entity = new Franchise();
		entity.setFranchiseName(entityDto.getFrachiseName());
		return entity;
	}

	@Override
	public FranchiseUpdateDTO read(Franchise entity) {
		FranchiseUpdateDTO entityDto = new FranchiseUpdateDTO();
		entityDto.setIdFranchise(entity.getIdFranchise());
		entityDto.setFrachiseName(entity.getFranchiseName());
		return entityDto;
	}
	
	@Override
	public FranchiseOutputDTO readAll(Franchise entity) {
		FranchiseOutputDTO entityDto = new FranchiseOutputDTO();
		entityDto.setIdFranchise(entity.getIdFranchise());
		entityDto.setFrachiseName(entity.getFranchiseName());
		List<Branch> branchs = entity.getBranchs();
		if (branchs == null || branchs.isEmpty()) {
			entityDto.setBranchs(null);
		} else {
			entityDto.setBranchs(mapper.readList(branchs));
		}
		return entityDto;
	}

	@Override
	public Franchise update(FranchiseUpdateDTO entityDto, Franchise entity) {
		entity.setFranchiseName(entityDto.getFrachiseName());
		return entity;
	}
}
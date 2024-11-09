package org.testaccenture.franchise.utils.mappers;

import org.testaccenture.franchise.model.dto.BaseEntityDTO;
import org.testaccenture.franchise.model.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public interface IMapper<BEC extends BaseEntityDTO, BEU extends BaseEntityDTO, BEO extends BaseEntityDTO, BE extends BaseEntity> {
	BE create(BEC entityDto);
	BEU read(BE entity);
	BEO readAll(BE entity);
	default List<BEU> readList(List<BE> entities) {
		List<BEU> entitiesDto = new ArrayList<>();
		for (BE entity : entities) {
			entitiesDto.add(read(entity));
		}
		return entitiesDto;
	}
	default List<BEO> readListAll(List<BE> entities) {
		List<BEO> entitiesDto = new ArrayList<>();
		for (BE entity : entities) {
			entitiesDto.add(readAll(entity));
		}
		return entitiesDto;
	}
	BE update(BEU entityDto, BE entity);
}
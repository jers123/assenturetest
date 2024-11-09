package org.testaccenture.franchise.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.testaccenture.franchise.model.entity.Franchise;

import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_ALL_QUERY;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_NAME_QUERY;
import static org.testaccenture.franchise.utils.SystemConstants.ID;
import static org.testaccenture.franchise.utils.SystemConstants.NAME;

@Repository
public interface IFranchiseRepository extends JpaRepository<Franchise, Integer> {
	@Query(value = FRANCHISE_ALL_QUERY)
	List<Franchise> searchAll();

	@Query(value = FRANCHISE_NAME_QUERY)
	String searchByName(@Param(ID) Integer id, @Param(NAME) String name);
}
package org.testaccenture.franchise.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.testaccenture.franchise.model.entity.Branch;

import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_ALL_QUERY;
import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_NAME_QUERY;
import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_FRANCHISE_QUERY;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE;
import static org.testaccenture.franchise.utils.SystemConstants.ID;
import static org.testaccenture.franchise.utils.SystemConstants.NAME;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer> {
	@Query(value = BRANCH_ALL_QUERY)
	List<Branch> searchAll();

	@Query(value = BRANCH_NAME_QUERY)
	String searchByName(@Param(ID) Integer id, @Param(FRANCHISE) Integer idFranchise, @Param(NAME) String name);
	
	@Query(value = BRANCH_FRANCHISE_QUERY)
	List<Branch> searchByFranchise(@Param(ID) Integer id);
}
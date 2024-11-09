package org.testaccenture.franchise.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.testaccenture.franchise.model.entity.Product;

import static org.testaccenture.franchise.utils.SystemConstants.BRANCH;
import static org.testaccenture.franchise.utils.SystemConstants.ID;
import static org.testaccenture.franchise.utils.SystemConstants.NAME;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_ALL_QUERY;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_BRANCH_QUERY;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_NAME_QUERY;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = PRODUCT_ALL_QUERY)
	List<Product> searchAll();

	@Query(value = PRODUCT_NAME_QUERY)
	String searchByName(@Param(ID) Integer id, @Param(BRANCH) Integer idBranch, @Param(NAME) String name);
	
	@Query(value = PRODUCT_BRANCH_QUERY)
	List<Product> searchByBranch(@Param(ID) Integer id);
}
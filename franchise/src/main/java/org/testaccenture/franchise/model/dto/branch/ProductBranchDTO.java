package org.testaccenture.franchise.model.dto.branch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductBranchDTO {
	private Integer idBranch;
	private String branchName;
	private Integer idProduct;
	private String productName;
	private Integer stock;
}
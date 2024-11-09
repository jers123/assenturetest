package org.testaccenture.franchise.model.dto.branch;

import java.util.List;

import org.testaccenture.franchise.model.dto.product.ProductUpdateDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchOutputDTO extends BranchUpdateDTO {
	private List<ProductUpdateDTO> products;
}
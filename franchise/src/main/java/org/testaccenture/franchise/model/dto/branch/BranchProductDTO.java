package org.testaccenture.franchise.model.dto.branch;

import java.util.List;

import org.testaccenture.franchise.model.dto.franchise.FranchiseUpdateDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchProductDTO extends FranchiseUpdateDTO {
	private List<ProductBranchDTO> branchs;
}
package org.testaccenture.franchise.model.dto.franchise;

import java.util.List;

import org.testaccenture.franchise.model.dto.branch.BranchUpdateDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchiseOutputDTO extends FranchiseUpdateDTO {
	private List<BranchUpdateDTO> branchs;
}
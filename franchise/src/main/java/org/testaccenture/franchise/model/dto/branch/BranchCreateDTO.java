package org.testaccenture.franchise.model.dto.branch;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.testaccenture.franchise.model.dto.BaseEntityDTO;

import static org.testaccenture.franchise.utils.Constants.ID_NOT_NULL;
import static org.testaccenture.franchise.utils.Constants.ID_VALUE_MINIMUM;
import static org.testaccenture.franchise.utils.Constants.BRANCH_NAME_NOT_BLANK;
import static org.testaccenture.franchise.utils.Constants.BRANCH_NAME_NOT_NULL;
import static org.testaccenture.franchise.utils.Constants.BRANCH_NAME_SIZE;
import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_NAME_LENGTH;

@Getter
@Setter
public class BranchCreateDTO extends BaseEntityDTO {
	@NotNull(message=BRANCH_NAME_NOT_NULL)
	@NotBlank(message=BRANCH_NAME_NOT_BLANK)
	@Size(min=1, max=BRANCH_NAME_LENGTH, message=BRANCH_NAME_SIZE)
	private String branchName;
	
	@NotNull(message=ID_NOT_NULL)
	@Min(value=1, message=ID_VALUE_MINIMUM)
	private Integer idFranchise;
}
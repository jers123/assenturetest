package org.testaccenture.franchise.model.dto.franchise;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.testaccenture.franchise.model.dto.BaseEntityDTO;

import static org.testaccenture.franchise.utils.Constants.FRANCHISE_NAME_NOT_BLANK;
import static org.testaccenture.franchise.utils.Constants.FRANCHISE_NAME_NOT_NULL;
import static org.testaccenture.franchise.utils.Constants.FRANCHISE_NAME_SIZE;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_NAME_LENGTH;

@Getter
@Setter
public class FranchiseCreateDTO extends BaseEntityDTO {
	@NotNull(message=FRANCHISE_NAME_NOT_NULL)
	@NotBlank(message=FRANCHISE_NAME_NOT_BLANK)
	@Size(min=1, max=FRANCHISE_NAME_LENGTH, message=FRANCHISE_NAME_SIZE)
	private String frachiseName;
}
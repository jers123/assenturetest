package org.testaccenture.franchise.model.dto.franchise;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static org.testaccenture.franchise.utils.Constants.ID_NOT_NULL;
import static org.testaccenture.franchise.utils.Constants.ID_VALUE_MINIMUM;

@Getter
@Setter
public class FranchiseUpdateDTO extends FranchiseCreateDTO {
	@NotNull(message=ID_NOT_NULL)
	@Min(value=1, message=ID_VALUE_MINIMUM)
	private Integer idFranchise;
}
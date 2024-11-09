package org.testaccenture.franchise.model.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static org.testaccenture.franchise.utils.Constants.ID_NOT_NULL;
import static org.testaccenture.franchise.utils.Constants.ID_VALUE_MINIMUM;

@Getter
@Setter
public class ProductUpdateDTO extends ProductCreateDTO {
	@NotNull(message=ID_NOT_NULL)
	@Min(value=1, message=ID_VALUE_MINIMUM)
	private Integer idProduct;
}
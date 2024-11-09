package org.testaccenture.franchise.model.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.testaccenture.franchise.model.dto.BaseEntityDTO;

import static org.testaccenture.franchise.utils.Constants.ID_NOT_NULL;
import static org.testaccenture.franchise.utils.Constants.ID_VALUE_MINIMUM;
import static org.testaccenture.franchise.utils.Constants.PRODUCT_NAME_NOT_BLANK;
import static org.testaccenture.franchise.utils.Constants.PRODUCT_NAME_NOT_NULL;
import static org.testaccenture.franchise.utils.Constants.PRODUCT_NAME_SIZE;
import static org.testaccenture.franchise.utils.Constants.PRODUCT_STOCK_MINIMUM;
import static org.testaccenture.franchise.utils.Constants.PRODUCT_STOCK_NOT_NULL;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_NAME_LENGTH;

@Getter
@Setter
public class ProductCreateDTO extends BaseEntityDTO {
	@NotNull(message=PRODUCT_NAME_NOT_NULL)
	@NotBlank(message=PRODUCT_NAME_NOT_BLANK)
	@Size(min=1, max=PRODUCT_NAME_LENGTH, message=PRODUCT_NAME_SIZE)
	private String productName;
	
	@NotNull(message=ID_NOT_NULL)
	@Min(value=1, message=ID_VALUE_MINIMUM)
	private Integer idBranch;
	
	@NotNull(message=PRODUCT_STOCK_NOT_NULL)
	@Min(value=0, message=PRODUCT_STOCK_MINIMUM)
	private Integer stock;
}
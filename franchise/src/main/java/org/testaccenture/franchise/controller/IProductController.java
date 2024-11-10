package org.testaccenture.franchise.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.testaccenture.franchise.utils.Constants.ID_VALUE_MINIMUM;
import static org.testaccenture.franchise.utils.SystemConstants.DELETE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.ID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.testaccenture.franchise.model.dto.product.ProductCreateDTO;
import org.testaccenture.franchise.model.dto.product.ProductUpdateDTO;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

public interface IProductController extends IBaseController<ProductCreateDTO, ProductUpdateDTO> {
	@DeleteMapping(value = DELETE_PATH + "{" + ID + "}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> delete(@Valid @PathVariable(ID) @Min(value = 1, message = ID_VALUE_MINIMUM) Integer id);
}
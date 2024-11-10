package org.testaccenture.franchise.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.testaccenture.franchise.utils.Constants.ID_VALUE_MINIMUM;
import static org.testaccenture.franchise.utils.SystemConstants.GET_STOCK_PRODUCT_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.ID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.testaccenture.franchise.model.dto.branch.BranchCreateDTO;
import org.testaccenture.franchise.model.dto.branch.BranchUpdateDTO;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

public interface IBranchController extends IBaseController<BranchCreateDTO, BranchUpdateDTO> {
	@GetMapping(value = GET_STOCK_PRODUCT_PATH + "{" + ID + "}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> getByMaxStoctProduct(@PathVariable(ID) @Min(value = 1, message = ID_VALUE_MINIMUM) Integer id);
}
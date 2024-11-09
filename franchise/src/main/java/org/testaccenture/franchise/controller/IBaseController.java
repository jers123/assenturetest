package org.testaccenture.franchise.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.testaccenture.franchise.model.dto.BaseEntityDTO;
import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.testaccenture.franchise.utils.Constants.ID_VALUE_MINIMUM;
import static org.testaccenture.franchise.utils.SystemConstants.CREATE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.DELETE_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ALL_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.GET_ID_PATH;
import static org.testaccenture.franchise.utils.SystemConstants.ID;
import static org.testaccenture.franchise.utils.SystemConstants.UPDATE_PATH;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface IBaseController<BC extends BaseEntityDTO, BU extends BaseEntityDTO> {
	@PostMapping(value = CREATE_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> create(@Valid @RequestBody BC entityDto);

    @GetMapping(GET_ALL_PATH)
    ResponseEntity<ReplyMessageList> getAll();

    @GetMapping(value = GET_ID_PATH + "{" + ID + "}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> getById(@PathVariable(ID) @Min(value = 1, message = ID_VALUE_MINIMUM) Integer id);

    @PutMapping(value = UPDATE_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> update(@Valid @RequestBody BU entityDto);
}
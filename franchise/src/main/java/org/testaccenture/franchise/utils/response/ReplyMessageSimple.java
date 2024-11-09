package org.testaccenture.franchise.utils.response;

import lombok.Getter;
import lombok.Setter;
import org.testaccenture.franchise.model.dto.BaseEntityDTO;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ReplyMessageSimple<BO extends BaseEntityDTO> extends ReplyMessage {
	private BO response;
}
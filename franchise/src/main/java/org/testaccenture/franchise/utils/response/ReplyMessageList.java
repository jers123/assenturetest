package org.testaccenture.franchise.utils.response;

import lombok.Getter;
import lombok.Setter;
import org.testaccenture.franchise.model.dto.BaseEntityDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class ReplyMessageList<BO extends BaseEntityDTO> extends ReplyMessage {
	private List<BO> response;
}
package org.testaccenture.franchise.service;

import org.springframework.transaction.annotation.Transactional;
import org.testaccenture.franchise.model.dto.branch.BranchCreateDTO;
import org.testaccenture.franchise.model.dto.branch.BranchOutputDTO;
import org.testaccenture.franchise.model.dto.branch.BranchProductDTO;
import org.testaccenture.franchise.model.dto.branch.BranchUpdateDTO;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;

public interface IBranchService extends IBaseService<BranchCreateDTO, BranchUpdateDTO, BranchOutputDTO> {
	@Transactional(readOnly = true)
	ReplyMessageSimple<BranchProductDTO> getByMaxStoctProduct(Integer id);
}
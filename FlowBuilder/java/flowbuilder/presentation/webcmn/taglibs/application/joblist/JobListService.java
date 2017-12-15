/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.application.joblist;


import java.util.List;

import fbcom.framework.exceptions.SysException;
import flowbuilder.domain.user.UserRole;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.Condition;
import flowbuilder.presentation.webcmn.taglibs.view.joblist.JobDTO;

/**
 *�@�Č��ꗗ���`����C���^�[�t�F�C�X�B <BR>
 */
public interface JobListService {
	/**
	 * �g�D�̒��Ƀ��[�U�̏����擾����
	 * 
	 * @param joblist �Č��ꗗ��ʂ֓`�������BEAN
	 * @return User ���[�UBEAN
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public List<JobDTO> getJobListDTO(List<Condition> condition,String userId,String orgId,UserRole userRole) throws SysException;
}

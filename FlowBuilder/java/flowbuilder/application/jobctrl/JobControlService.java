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
package flowbuilder.application.jobctrl;

import fbcom.framework.exceptions.SysException;
import flowbuilder.domain.jobctrl.JobCtrlParameter;

/**
 * ����t���O�ɂ���āA����̑�������s����B<BR>
 */
public interface JobControlService {

	/**
	 * ����t���O�ɂ���āA����̑�������s����B
	 * 
	 * @param jobParameters
	 *            �_������p�̃p�����[�^
	 *            
	 * @throws SysException
	 *             �V�X�e���̃G���[���������܂����B<BR>
	 */
	public void jobControl(JobCtrlParameter jobParameters) throws SysException;

}

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
package flowbuilder.application.jobshow;

import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.jobshow.JobShow;
import fbcom.framework.exceptions.SysException;

/**
 * �W���u�\������̃C���^�t�F�[�X <BR>
 */
public interface JobShowService {

	/**
	 * ���i����p�̐V�����W���u�̎擾���āAJSP��ʗp��BEAN��߂�B
	 * 
	 * @param joblist�@�_������p�̃p�����[�^
	 * @param userIp�@���[�UIP
	 * @return�@JSP��ʗp��BEAN
	 * @throws SysException�@
	 *  		�V�X�e���̃G���[���������܂����B<BR>
	 */
	public JobShow getNewJobShow(JobList joblist,String userIp) throws SysException;
	
	
	/**
	 * �������Č����擾���āAJSP��ʗp��BEAN��߂�B
	 * 
	 * @param joblist�@�_������p�̃p�����[�^
	 * @return�@JSP��ʗp��BEAN
	 * @throws SysException
	 *  		�V�X�e���̃G���[���������܂����B<BR>
	 */
	public JobShow getJobShow(JobList joblist) throws SysException;
}

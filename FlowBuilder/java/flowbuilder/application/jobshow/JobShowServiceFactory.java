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

import fbcom.framework.exceptions.SysException;

/**
 * �W���u�\����static�t�@�N�g�����\�b�h��񋟂���B <BR>
 */
public class JobShowServiceFactory {
	/**
	 * static�t�@�N�g�����\�b�h�����Ȃ̂ŁA�C���X�^���X�������Ȃ��B
	 */
	private JobShowServiceFactory() {
	}

	/**
	 * �W���u�\���̃C���X�^���X���擾����B
	 * 
	 * @return UserService
	 * @throws Exception 
	 */
	public static JobShowService getOrgListServiceInstance() throws SysException {
		return new JobShowServiceImpl();
	}
}
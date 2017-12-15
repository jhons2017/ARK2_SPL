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

/**
 * �Č������static�t�@�N�g�����\�b�h��񋟂���B <BR>
 */
public class JobControlServiceFactory {
	/**
	 * static�t�@�N�g�����\�b�h�����Ȃ̂ŁA�C���X�^���X�������Ȃ��B
	 */
	private JobControlServiceFactory() {
	}

	/**
	 * �Č�����̃C���X�^���X���擾����B
	 * 
	 * @return JobControlService�@�Č�����C���X�^���X
	 * @throws Exception 
	 */
	public static JobControlService getControlServiceInstance() throws SysException {
		return new JobControlServiceImpl();
	}
}
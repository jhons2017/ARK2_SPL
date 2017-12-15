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
package flowbuilder.presentation.webcmn.taglibs.application.print;

import fbcom.framework.exceptions.SysException;

/**
 * �Č������static�t�@�N�g�����\�b�h��񋟂���B <BR>
 */
public class JobPrintServiceFactory {
	/**
	 * static�t�@�N�g�����\�b�h�����Ȃ̂ŁA�C���X�^���X�������Ȃ��B
	 */
	private JobPrintServiceFactory() {
	}

	/**
	 * �Č�����̃C���X�^���X���擾����B
	 * 
	 * @return JobControlService�@�Č�����C���X�^���X
	 * @throws Exception 
	 */
	public static JobPrintService getControlServiceInstance() throws SysException {
		return new JobPrintServiceImpl();
	}
}
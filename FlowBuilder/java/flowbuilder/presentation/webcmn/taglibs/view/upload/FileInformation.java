/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/04/27
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/18 BY. ZHANGXINFENG (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.view.upload;
/**
 * �A�b�v���[�h��FileInformation <BR>
 */
public class FileInformation {
	
	// �t�@�C�����O�̐ݒ�
	private String fileName = "";
	
	// �t�@�C���p�X�̐ݒ�
	private String fileSrc = "";
	
	// image�p�X�̐ݒ�
	private String incoPath = "";
	
	// image�p�X���擾����
	public String getIncoPath() {
		return incoPath;
	}
	
	// image�p�X�̐ݒ�
	public void setIncoPath(String incoPath) {
		this.incoPath = incoPath;
	}
	
	// �t�@�C�����O���擾����
	public String getFileName() {
		return fileName;
	}
	
	// �t�@�C�����O�̐ݒ�
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// �t�@�C���p�X���擾����
	public String getFileSrc() {
		return fileSrc;
	}

	// �t�@�C���p�X�̐ݒ�
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

}

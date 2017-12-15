/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/14
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/14 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.application.util.email;

/**
 * ���[��BEAN�B
 */
public class EmailBean {

	/**
	 * ���[���̎��B
	 */
	private String title;
	
	/**
	 * ���[���̓��e�B
	 */
	private String content;
	
	/**
	 * ���惊�X�g�B
	 */
	private String reciverEmailAddr;
	
	/**
	 * CC���X�g�B
	 */
	private String ccEmailAddr;

	/**
	 * return content�@String ���[���̓��e
	 */
	public String getEmailContent() {
		return content;
	}
	
	/**
	 * ���[�����e����ݒu����
	 * @param content ���[�����e
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * return�@ccEmailAddr�@String ���[����CC
	 */
	public String getCCEmailAddress() {
		return ccEmailAddr;
	}

	/**
	 * CC�ꗗ��ݒu����
	 * @param ccEmailAddr CC�ꗗ
	 */
	public void setCCEmailAddress(String ccEmailAddr) {
		this.ccEmailAddr = ccEmailAddr;
	}

	/**
	 * return�@reciverEmailAddress String�@���[���̈���
	 */
	public String getReciverEmailAddress() {
		return reciverEmailAddr;
	}

	/**
	 * ����ꗗ��ݒu����
	 * @param reciverEmailAddr ����ꗗ
	 */
	public void setReciverEmailAddress(String reciverEmailAddr) {
		this.reciverEmailAddr = reciverEmailAddr;
	}

	/**
	 * return�@title String�@���[���̎��
	 */
	public String getEmailTitle() {
		return title;
	}

	/**
	 * ���[������ݒu����
	 * @param ���[�����
	 */
	public void setEmailTitle(String title) {
		this.title = title;
	}
}
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
 * メールBEAN。
 */
public class EmailBean {

	/**
	 * メールの主題。
	 */
	private String title;
	
	/**
	 * メールの内容。
	 */
	private String content;
	
	/**
	 * 宛先リスト。
	 */
	private String reciverEmailAddr;
	
	/**
	 * CCリスト。
	 */
	private String ccEmailAddr;

	/**
	 * return content　String メールの内容
	 */
	public String getEmailContent() {
		return content;
	}
	
	/**
	 * メール内容をを設置する
	 * @param content メール内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * return　ccEmailAddr　String メールのCC
	 */
	public String getCCEmailAddress() {
		return ccEmailAddr;
	}

	/**
	 * CC一覧を設置する
	 * @param ccEmailAddr CC一覧
	 */
	public void setCCEmailAddress(String ccEmailAddr) {
		this.ccEmailAddr = ccEmailAddr;
	}

	/**
	 * return　reciverEmailAddress String　メールの宛先
	 */
	public String getReciverEmailAddress() {
		return reciverEmailAddr;
	}

	/**
	 * 宛先一覧を設置する
	 * @param reciverEmailAddr 宛先一覧
	 */
	public void setReciverEmailAddress(String reciverEmailAddr) {
		this.reciverEmailAddr = reciverEmailAddr;
	}

	/**
	 * return　title String　メールの主題
	 */
	public String getEmailTitle() {
		return title;
	}

	/**
	 * メール主題を設置する
	 * @param メール主題
	 */
	public void setEmailTitle(String title) {
		this.title = title;
	}
}
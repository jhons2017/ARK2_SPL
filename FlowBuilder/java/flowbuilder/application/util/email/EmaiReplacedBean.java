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
 * �u���p�̃C���t�HBEAN�B
 */
public class EmaiReplacedBean {
	
	/**
	 * �u�������ID�B
	 */
	private String id = "";
	
	/**
	 * �u���̓��e�B
	 */
	private String value = "";

	/**
	 * 
	 * @�߂�̒u�������ID�B
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @�ݒu�͒u�������ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @�߂�̒u���̓��e�B
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @�ݒu�͒u���������e�B
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
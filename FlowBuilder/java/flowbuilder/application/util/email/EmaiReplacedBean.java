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
 * 置換用のインフォBEAN。
 */
public class EmaiReplacedBean {
	
	/**
	 * 置換されるID。
	 */
	private String id = "";
	
	/**
	 * 置換の内容。
	 */
	private String value = "";

	/**
	 * 
	 * @戻るの置換されるID。
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @設置は置換されるID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @戻るの置換の内容。
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @設置は置換される内容。
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
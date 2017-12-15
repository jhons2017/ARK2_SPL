/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/04/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.domain.jobctrl;

/**
 * 	案件詳細画面の引数	<br>
 */
public class JobControl {
	
	/** パラメータ名 */
	private String _paramName = "";
	
	/** パラメータ値 */
	private String _paramValue = "";

	/**
	 * パラメータ名の取得
	 * 
	 * @return　_paramName　パラメータ名
	 */
	public String getParamName() {
		return _paramName;
	}

	/**
	 * パラメータ名の設定
	 * 
	 * @param value パラメータ名
	 */
	public void setParamName(String name) {
		_paramName = name;
	}

	/** 
	 * パラメータ値の取得
	 * 
	 * @return　_paramValue　パラメータ値
	 */
	public String getParamValue() {
		return _paramValue;
	}
	
	/**
	 * パラメータ値の設定
	 * 
	 * @param value パラメータ値
	 */
	public void setParamValue(String value) {
		_paramValue = value;
	}

}

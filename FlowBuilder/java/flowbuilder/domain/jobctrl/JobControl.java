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
 * 	�Č��ڍ׉�ʂ̈���	<br>
 */
public class JobControl {
	
	/** �p�����[�^�� */
	private String _paramName = "";
	
	/** �p�����[�^�l */
	private String _paramValue = "";

	/**
	 * �p�����[�^���̎擾
	 * 
	 * @return�@_paramName�@�p�����[�^��
	 */
	public String getParamName() {
		return _paramName;
	}

	/**
	 * �p�����[�^���̐ݒ�
	 * 
	 * @param value �p�����[�^��
	 */
	public void setParamName(String name) {
		_paramName = name;
	}

	/** 
	 * �p�����[�^�l�̎擾
	 * 
	 * @return�@_paramValue�@�p�����[�^�l
	 */
	public String getParamValue() {
		return _paramValue;
	}
	
	/**
	 * �p�����[�^�l�̐ݒ�
	 * 
	 * @param value �p�����[�^�l
	 */
	public void setParamValue(String value) {
		_paramValue = value;
	}

}

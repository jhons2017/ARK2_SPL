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
package flowbuilder.domain.user;

/**
 * ����
 */
public final class Section
{
	/** ����No */
	private String _no;

	/** �������� */
	private String _name;
	
	/**
	 * ����No�̎擾
	 * 
	 * @return String ����No
	 */
	public String getNo()
	{
		return _no;
	}

	/**
	 * ����No�̐ݒ�
	 * 
	 * @param no ����No
	 */
	public void setNo(String no)
	{
		_no = no;
	}

	/**
	 * �������̂̎擾
	 * 
	 * @return String ��������
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * �������̂̐ݒ�
	 * 
	 * @param name ��������
	 */
	public void setName(String name)
	{
		_name = name;
	}
}
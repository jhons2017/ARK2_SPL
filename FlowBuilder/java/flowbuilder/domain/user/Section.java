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
 * ®
 */
public final class Section
{
	/** ®No */
	private String _no;

	/** ®¼Ì */
	private String _name;
	
	/**
	 * ®NoÌæ¾
	 * 
	 * @return String ®No
	 */
	public String getNo()
	{
		return _no;
	}

	/**
	 * ®NoÌÝè
	 * 
	 * @param no ®No
	 */
	public void setNo(String no)
	{
		_no = no;
	}

	/**
	 * ®¼ÌÌæ¾
	 * 
	 * @return String ®¼Ì
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * ®¼ÌÌÝè
	 * 
	 * @param name ®¼Ì
	 */
	public void setName(String name)
	{
		_name = name;
	}
}
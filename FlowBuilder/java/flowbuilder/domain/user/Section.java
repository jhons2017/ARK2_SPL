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
 * Š‘®
 */
public final class Section
{
	/** Š‘®No */
	private String _no;

	/** Š‘®–¼Ì */
	private String _name;
	
	/**
	 * Š‘®No‚Ìæ“¾
	 * 
	 * @return String Š‘®No
	 */
	public String getNo()
	{
		return _no;
	}

	/**
	 * Š‘®No‚Ìİ’è
	 * 
	 * @param no Š‘®No
	 */
	public void setNo(String no)
	{
		_no = no;
	}

	/**
	 * Š‘®–¼Ì‚Ìæ“¾
	 * 
	 * @return String Š‘®–¼Ì
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * Š‘®–¼Ì‚Ìİ’è
	 * 
	 * @param name Š‘®–¼Ì
	 */
	public void setName(String name)
	{
		_name = name;
	}
}
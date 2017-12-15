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
package flowbuilder.dao.user;

import java.util.List;

import flowbuilder.domain.user.Section;
import fbcom.framework.exceptions.XmlAccessSysException;

/**
 * 所属 DAO interface 
 */
public interface SectionDAO
{
	/**
	 * 所属 件数の取得
	 * 
	 * @return Count 所属の数
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public int getCount() throws XmlAccessSysException;

	/**
	 * 所属 List の取得
	 * 
	 * @param beginIndex 検索開始インデックス（1以上)
	 * @param count 取得したい所属の数（1以上）
	 * @return List 中身は Section
	 * @throws IndexOutOfBoundsException 配列の境界を超えてアクセスしたの場合
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<Section> getList(int beginIndex, int count) throws XmlAccessSysException;

	/**
	 * 所属 List の取得
	 * 
	 * @return List 中身は Cause 原因区分
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<Section> getList() throws XmlAccessSysException;

	/**
	 * 所属 の取得
	 * 
	 * @param sectionNo 所属No
	 * @return Section 所属
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public Section selectById(String sectionNo) throws XmlAccessSysException;
	
	/**
	 * 所属 の取得
	 * 
	 * @param sectionNo 所属No
	 * @return Section 所属
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public Section selectByName(String sectionName) throws XmlAccessSysException;
	
	/**
	 * 所属 の取得
	 * 
	 * @return Section 所属
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<Section> getAllOrgList() throws XmlAccessSysException;
	
}

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

import flowbuilder.domain.user.Role;
import fbcom.framework.exceptions.XmlAccessSysException;

/**
 * 権限 DAO interface 
 */
public interface RoleDAO
{
	/**
	 * 権限 件数の取得
	 * 
	 * @return Count 権限の数
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public int getCount() throws XmlAccessSysException;

	/**
	 * 権限 List の取得
	 * 
	 * @param beginIndex 検索開始インデックス（1以上)
	 * @param count 取得したい権限の数（1以上）
	 * @return List 中身は Section
	 * @throws IndexOutOfBoundsException 配列の境界を超えてアクセスしたの場合
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List getList(int beginIndex, int count) throws XmlAccessSysException;

	/**
	 * 権限 List の取得
	 * 
	 * @return List 中身は Cause 原因区分
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List<Role> getList() throws XmlAccessSysException;

	/**
	 * 権限 の取得
	 * 
	 * @param ｒｏｌｅNo 権限No
	 * @return Section 権限
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public Role select(String roleNo) throws XmlAccessSysException;
	
}

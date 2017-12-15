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

import flowbuilder.domain.user.User;
import fbcom.framework.exceptions.XmlAccessSysException;


/**
 * ユーザーのアクセスオブジェクト
 */
public interface UserDAO
{
	/**
	 * ユーザー件数の取得
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return int ユーザー件数
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public int getCount(UserQueryInfo query) throws XmlAccessSysException;

	/**
	 * ユーザー SummaryList の取得
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @param beginIndex 表示開始インデックス
	 * @param count 表示件数
	 * @return List 中身は、UserDTO
	 * @throws IndexOutOfBoundsException 配列の境界を超えてアクセスしたの場合
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List getSummaryList(UserQueryInfo query, int beginIndex, int count) throws XmlAccessSysException;
	
	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return List 中身は User 
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List<User> getList(UserQueryInfo query) throws XmlAccessSysException;
	
	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return List 中身は User 
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List<User> getList(String loginName) throws XmlAccessSysException;

	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param String orgId 組織ID
	 * @return List 中身は User 
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List<User> getListByOrgId(String orgId) throws XmlAccessSysException;
	
	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param String orgId 組織ID
	 * @return List 中身は User 
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List<User> getUpUsersId(String orgId,String roleId) throws XmlAccessSysException;
	
	/**
	 * ユーザーの取得
	 * 
	 * @param loginName ログイン名称
	 * @return User ユーザー
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public User select(String loginName) throws XmlAccessSysException;
	
	/**
	 * ユーザーの取得
	 * 
	 * @param loginName ログイン名称
	 * @param orgId 組織名称
	 * @return User ユーザー
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public User select(String loginName,String orgId) throws XmlAccessSysException;

	/**
	 * ユーザー の登録
	 * 
	 * @param user ユーザー
	 * @throws DataAccessSysException システムエラーの場合
	 * @throws DataAccessAppException アプリケーションエラーの場合。
	 */
	public void insert(User user) throws XmlAccessSysException;

	/**
	 * ユーザーの編集
	 * 
	 * @param user ユーザー
	 * @throws DataAccessSysException システムエラーの場合
	 * @throws DataAccessAppException アプリケーションエラーの場合。
	 */
	public void update(User user) throws XmlAccessSysException;

	/**
	 * ユーザーの削除
	 * 
	 * @param userNo ユーザーNo
	 * @throws DataAccessSysException システムエラーの場合
	 * @throws DataAccessAppException アプリケーションエラーの場合。
	 */
	public void delete(String userNo) throws XmlAccessSysException;
}
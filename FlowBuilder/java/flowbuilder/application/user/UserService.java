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
package flowbuilder.application.user;

import java.util.List;

import fbcom.framework.exceptions.DataAccessAppException;
import fbcom.framework.exceptions.DataAccessSysException;
import fbcom.framework.exceptions.RecordNotFoundAppException;
import fbcom.framework.exceptions.SysException;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.user.UserQueryInfo;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.User;
import flowbuilder.view.user.UserDTO;

/**
 *  ユーザー管理サービスを定義するインターフェイス。 <br>
 */
public interface UserService
{
	/**
	 * ユーザーの検索条件を設定する。 
	 * 
	 * @param query ユーザーの検索条件
	 */
	public void setQuery(UserQueryInfo query);
	
	/**
	 * 検索条件にヒットしたユーザーの数を取得する。 <BR> 
	 * 事前条件：setQuery()が実行されていること。
	 * 
	 * @return int 検索条件にヒットしたユーザーの数
	 * @throws SysException システムエラーの場合。
	 */
	public int getCountOfUser() throws SysException;
	
	/**
	 *  検索条件を満たすユーザーの概要の一覧を取得する。 <BR> 
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR> 
	 *	検索結果がcountで指定した数に満たない場合、取得可能な分だけのListを返す。 <BR>
	 *	例えば、検索結果が50件であり、getUserSummaryList(41, 20)とした場合、 <BR> 41件～50件目のユーザーのリストを返す。 <BR>
	 *	事前条件：setQuery()が実行されていること。 
	 * 
	 * @param beginIndex 開始インデックス(1以上)
	 * @param count 取得したい数
	 * @return List 中身はUserDTO。
	 * @throws SysException システムエラーの場合。
	 */
	public List getUserSummaryList(int beginIndex,int count) throws SysException;
	
	/**
	 *  検索条件を満たすユーザー情報リストを取得する <BR>
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR>
	 *	事前条件：setQuery()が実行されていること。
	 * 
	 * @return List 中身はUser。
	 * @throws DataAccessSysException 指定されたユーザが存在しない場合。
	 */
	public List getUserList() throws XmlAccessSysException;
	
	/**
	 * ユーザー情報を取得する。
	 * 
	 * @return User ユーザー
	 * @param loginName    ログイン名
	 * @throws NullPointerException loginNameがnullの場合。
	 * @throws DataAccessAppException 指定されたユーザが存在しない場合。
	 * @throws SysException システムエラーの場合。
	 */
	public User getUser(String loginName)
	  			throws SysException,RecordNotFoundAppException;
	
	/**
	 * ユーザー情報を取得する。
	 * 
	 * @return User ユーザー
	 * @param loginName    ログイン名
	 * @throws NullPointerException loginNameがnullの場合。
	 * @throws DataAccessAppException 指定されたユーザが存在しない場合。
	 * @throws SysException システムエラーの場合。
	 */
	public User getUser(String loginName,String orgId)
	  			throws SysException,RecordNotFoundAppException;
	
	
	/**
	 * ユーザー情報を取得する。
	 * 
	 * @return User ユーザー
	 * @param loginName    ログイン名
	 * @throws NullPointerException loginNameがnullの場合。
	 * @throws DataAccessAppException 指定されたユーザが存在しない場合。
	 * @throws SysException システムエラーの場合。
	 */
	public UserDTO getUserInfo(String loginName,String orgId,String roleId)
	  			throws SysException,RecordNotFoundAppException;
	
	/**
	 *  検索条件を満たすユーザー情報リストを取得する <BR>
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR>
	 *	事前条件：setQuery()が実行されていること。
	 * 
	 * @return List 中身はUser。
	 * @throws DataAccessSysException 指定されたユーザが存在しない場合。
	 */
	public List<User> getUpUsersId(String orgId,String roleId) throws XmlAccessSysException;
	
	/**
	 * ユーザーを登録する。
	 * 
	 * @param user ユーザー
	 * @throws NullPointerException equipmentがnullの場合。
	 * @throws DataAccessAppException 主キー、またはユニーク属性の値が重複の場合、 <BR>
	 * 				または設定可能な値の範囲を超える場合、 <BR>
	 * 			 	または必須項目が入力されていない場合
	 * @throws DataAccessSysException システムエラーの場合。
	 */
	public void createUser(User user)
	  			throws XmlAccessSysException;
	
	/**
	 * ユーザーを変更する。
	 * 
	 * @param user    :更新されるユーザー情報
	 * @throws NullPointerException oldUserまたはnewUserがnullの場合。
	 * @throws DataAccessAppException 主キー、またはユニーク属性の値が重複の場合、 <BR>
	 * 		 		または設定可能な値の範囲を超える場合、 <BR>
	 * 		 		または必須項目が入力されていない場合、 <BR>
	 * 				または指定したキーに対応するレコードが存在しない場合
	 * @throws SysException システムエラーの場合。
	 */
	public void updateUser(User user)
	  			throws SysException;
	
	/**
	 * ユーザーを削除する。
	 * 
	 * @param userNo    ユーザーNo
	 * @throws NullPointerException userNoがnullの場合。
	 * @throws DataAccessAppException 指定したキーに対応するレコードが存在しない場合
	 * @throws SysException システムエラーの場合。
	 */
	public void deleteUser(String userNo)
				throws SysException;
	
	/**
	 * 組織ＩＤによって組織オブジェクトを取得する。
	 * 
	 * @param sectionNo    組織ＩＤ
	 * @throws SysException システムエラーの場合。
	 */
	public Section getSectionById(String sectionNo)
				throws SysException;
	
	/**
	 * 組織名前によって組織オブジェクトを取得する。
	 * 
	 * @param sectionNo    組織名前
	 * @throws SysException システムエラーの場合。
	 */
	public Section getSectionByName(String sectionName)
				throws SysException;
	
	/**
	 *  検索条件を満たすユーザー情報リストを取得する <BR>
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR>
	 *	 
	 * @return List 中身はUser。
	 * @throws DataAccessSysException 指定されたユーザが存在しない場合。
	 */
	public List getUsersByOrgId(String orgId) throws XmlAccessSysException;
}

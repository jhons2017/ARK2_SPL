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

/**
 * ユーザー検索のための検索条件を定義するインターフェース。 <BR>
 */
public interface UserQueryInfo
{
	/**
	 * ユーザIDの設定
	 * 
	 * @param userId ユーザID
	 */
	public void setUserId(String userId);
	
	/**
	 *  ユーザIDの取得
	 * 
	 * @return String ユーザID
	 */
	public String getUserId();
	
	/**
	 * 氏名の設定
	 * 
	 * @param name 氏名
	 */
	public void setName(String name);
	
	/**
	 * 氏名の取得
	 * 
	 * @return String 氏名
	 */
	public String getName();

	/**
	 * パスワードの設定
	 * 
	 * @param password パスワード
	 */
	public void setPassword(String password);
	
	/**
	 *  パスワードの取得
	 * 
	 * @return String パスワード
	 */
	public String getPassword();
	
	/**
	 * 所属組織Noの設定
	 * 
	 * @param sectionNo 所属No
	 */
	public void setSectionNo(String sectionNo);
	
	/**
	 * 所属組織Noの取得
	 * 
	 * @return String 所属組織No
	 */
	public String getSectionNo();
	
	/**
	 * 権限Noの設定
	 * 
	 * @param sectionNo 所属No
	 */
	public void setRoleNo(String roleNo);
	
	/**
	 * 権限Noの取得
	 * 
	 * @return String 所属組織No
	 */
	public String getRoleNo();

	
}
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
package flowbuilder.application.orglist;

import java.util.List;

import flowbuilder.domain.user.Section;
import flowbuilder.view.orglist.OrgDTO;
import fbcom.framework.exceptions.SysException;

/**
 * ログインサービスを定義するインターフェイス。 <BR>
 */
public interface OrgListService {
	/**
	 * ログインユーザの「組織/権限」一覧の取得
	 * 
	 * @return boolean (ture:成功/false:失敗)
	 * @throws SysException 
	 * @throws SysException システムエラーの場合。
	 * @throws  
	 * @throws NullPointerException ログインユーザーまたはパスワードがnullの場合。
	 */
	
	public List<Section> getAllOrgId() throws SysException;	
	
	/**
	 * ログインユーザの「組織/権限」一覧の取得
	 * 
	 * @param loginUser ログインユーザー
	 * @return boolean (ture:成功/false:失敗)
	 * @throws SysException 
	 * @throws SysException システムエラーの場合。
	 * @throws  
	 * @throws NullPointerException ログインユーザーまたはパスワードがnullの場合。
	 */
	public List<OrgDTO> getOrgList(String loginUser) throws SysException;
}

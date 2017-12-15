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
package flowbuilder.presentation.webcmn.taglibs.application.joblist;


import java.util.List;

import fbcom.framework.exceptions.SysException;
import flowbuilder.domain.user.UserRole;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.Condition;
import flowbuilder.presentation.webcmn.taglibs.view.joblist.JobDTO;

/**
 *　案件一覧を定義するインターフェイス。 <BR>
 */
public interface JobListService {
	/**
	 * 組織の中にユーザの情報を取得する
	 * 
	 * @param joblist 案件一覧画面へ伝える情報のBEAN
	 * @return User ユーザBEAN
	 * @throws SysException システムエラーの場合。
	 */
	public List<JobDTO> getJobListDTO(List<Condition> condition,String userId,String orgId,UserRole userRole) throws SysException;
}

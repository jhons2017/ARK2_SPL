/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/05
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.UserRole;
import flowbuilder.presentation.webcmn.taglibs.common.validate.IValidate;
import flowbuilder.presentation.webcmn.taglibs.common.validate.ValidateFactory;
import flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo;

/**
 * 部品のスーパークラス　<BR>
 */
abstract class PartParent extends BodyTagSupport {
	/**
	 * ジョブの共通操作
	 */
	private JobOprater jobOpr = null;
	
	private PartCheckCondition checkCondition = null;
	
	/**
	 * 組織ID
	 */
	protected String _orgId = "";

	/**
	 * ユーザID
	 */
	protected String _userId = "";

	/**
	 * 部品XML
	 */
	protected String _partXml = "";

	/**
	 * 案件ドキュメント
	 */
	protected Document _job = null;

	/**
	 * チェック機能用のXML
	 */
	protected String _checkXml = "";

	/**
	 * ユーザルール
	 */
	protected UserRole _userRole = null;
	
	/**
	 * 操作者指定情報を取得する (非表示)
	 */
	protected String strhiddenUser = "";

	/**
	 * 権限指定情報を取得する (非表示)
	 */ 
	protected String strhiddenRole = "";

	/**
	 * 組織指定情報を取得する (非表示)
	 */ 
	protected String strhiddenOrg = "";
	
	/**
	 * 操作者指定情報を取得する (表示)
	 */ 
	protected String strdisplayUser = "";

	/**
	 * 権限指定情報を取得する (表示)
	 */ 
	protected String strdisplayRole = "";
	
	/**
	 * 組織指定情報を取得する (表示)
	 */ 
	protected String strdisplayOrg = "";

	/**
	 * 操作者指定情報を取得する (編集)
	 */ 
	protected String streditionUser = "";

	/**
	 * 権限指定情報を取得する (編集)
	 */ 
	protected String streditionRole = "";
	
	/**
	 * 組織指定情報を取得する (編集)
	 */
	protected String streditionOrg = "";

	/**
	 * 操作者指定情報を取得する (必須)
	 */ 
	protected String strvitalUser = "";

	/**
	 * 権限指定情報を取得する (必須)
	 */ 
	protected String strvitalRole = "";
	
	/**
	 * 組織指定情報を取得する (必須)
	 */ 
	protected String strVitalOrg = "";
	
	protected Document part = null;
	
	/**
	 * 頁ID
	 */
	protected PageInfo _pInfo;
	
	/**
	 * 頁の設定
	 * 
	 * @param pInfo　頁ID
	 */
	public void setPageInfo(PageInfo pInfo) {
		_pInfo = pInfo;
	}
	
	/**
	 * 組織の設定
	 * 
	 * @param orgId　組織ID
	 */
	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	/**
	 * ユーザーIDの設定
	 * 
	 * @param userId　ユーザーID
	 */
	public void setUserId(String userId) {
		_userId = userId;
	}

	/**
	 * 部品XMLの設定
	 * 
	 * @param partXml　部品XML
	 */
	public void setPartXml(String partXml) {
		_partXml = partXml;
	}

	/**
	 * ジョブドキュメントの設定
	 * 
	 * @param job　ジョブファイル
	 */
	public void setJob(Document job) {
		_job = job;
	}
	
	/**
	 * チェックインフォの設定
	 * 
	 * @param checkXml　チェックインフォ
	 */
	public void setCheck(String checkXml) {
		_checkXml = checkXml;
	}

	/**
	 * ユーザルールの設定
	 * 
	 * @param userRole　ユーザルール
	 */
	public void setUserRole(UserRole userRole) {
		_userRole = userRole;
	}
	
	/**
	 * タグ初期処理
	 * 
	 * @return int
	 */
	public int doStartTag() throws JspException {
		jobOpr = new JobOprater();
		checkCondition = new PartCheckCondition();
		StringBuffer html = toHTML();
		html.append(toValidateJs());
		try {
			pageContext.getOut().print(html.toString());
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}

		return SKIP_BODY;
	}

	/**
	 * 終了処理
	 * 
	 * @return int
	 */
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer　作成のHTML
	 */
	protected abstract StringBuffer toHTML();


	private void init(){
		// 部品ＸＭＬドキュメント取得する
		part = ParseXmlString.getParsedDocument(_partXml);

		// ======非表示の確認======
		// 非表示エレメントを取得する
		Element hiddenElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "非表示"), 0);
		// 非表示の操作
		if ( hiddenElement != null ){
			// 操作者指定情報を取得する
			strhiddenUser = XmlOperator.getAttrValue(hiddenElement, "user");
	
			// 権限指定情報を取得する
			strhiddenRole = XmlOperator.getAttrValue(hiddenElement, "role");
	
			// 組織指定情報を取得する
			strhiddenOrg = XmlOperator.getAttrValue(hiddenElement, "org");
		}
		
		
		// ======表示の確認======
		// 表示エレメントを取得する
		Element displayElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "表示"), 0);
		// 表示の操作
		if ( displayElement != null ){
			// 操作者指定情報を取得する
			strdisplayUser = XmlOperator.getAttrValue(displayElement, "user");
	
			// 権限指定情報を取得する
			strdisplayRole = XmlOperator.getAttrValue(displayElement, "role");
			
			// 組織指定情報を取得する
			strdisplayOrg = XmlOperator.getAttrValue(displayElement, "org");
		}
		
		// ======編集の確認======
		// 編集エレメントを取得する
		Element editionElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "編集"), 0);
		// 編集の操作
		if ( editionElement != null ){
			// 操作者指定情報を取得する
			streditionUser = XmlOperator.getAttrValue(editionElement, "user");
	
			// 権限指定情報を取得する
			streditionRole = XmlOperator.getAttrValue(editionElement, "role");
			
			// 組織指定情報を取得する
			streditionOrg = XmlOperator.getAttrValue(editionElement, "org");
		}
		
		// ======必須の確認======
		// 必須エレメントを取得する
		Element vitalElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "必須"), 0);
		// 必須の操作
		if ( vitalElement != null ){
			// 操作者指定情報を取得する
			strvitalUser = XmlOperator.getAttrValue(vitalElement, "user");
	
			// 権限指定情報を取得する
			strvitalRole = XmlOperator.getAttrValue(vitalElement, "role");
			
			// 組織指定情報を取得する
			strVitalOrg = XmlOperator.getAttrValue(vitalElement, "org");
		}
	}
	
	protected String getShowCase(){
		this.init();
		
		String bResult = "";
		
		// 案件現在状態を取得
		String strCurState = jobOpr.getCurrentState(_job);
		// 起案人組織ＩＤ
		String strCreatOrg = jobOpr.getOrgID(_job);
		// 編集場合権限チェック
		if (checkCondition.checkUserCondition(_job, strCurState, streditionUser, _userId)
				|| (checkCondition.checkRoleCondition(strCurState, streditionRole, _orgId, _userId)
						&& checkCondition.checkOrgCondition(streditionOrg,_orgId,strCreatOrg))) {
			
			bResult = "edit";
			
			// 必須マック
			if (checkCondition.checkUserCondition(_job, strCurState, strvitalUser, _userId)
					|| (checkCondition.checkRoleCondition(strCurState, strvitalRole, _orgId, _userId)
							&& checkCondition.checkOrgCondition(strVitalOrg,_orgId,strCreatOrg))) {
				bResult = "mustEdit";
			}			
       // 表示場合権限チェック
		} else if (checkCondition.checkUserCondition(_job, strCurState, strdisplayUser, _userId)
					|| (checkCondition.checkRoleCondition(strCurState, strdisplayRole, _orgId, _userId)
						&& checkCondition.checkOrgCondition(strdisplayOrg,_orgId,strCreatOrg))) {
			bResult = "display";
		// 非表示場合権限チェック
		} else if (checkCondition.checkUserCondition(_job, strCurState, strhiddenUser, _userId)
					|| (checkCondition.checkRoleCondition(strCurState, strhiddenRole, _orgId, _userId)
						&& checkCondition.checkOrgCondition(strhiddenOrg,_orgId,strCreatOrg))) {
						
			bResult = "nodisplay";
		}
		
		return bResult;
	}
	/**
	 * チェックJSの作成
	 * 
	 * @return String　作成のJS
	 */
	private String toValidateJs() {
		//チェック機能の共通インタフェース
		IValidate validate = null;
		//案件操作のクラス
		JobOprater jobopr = new JobOprater();
		
		//チェックオブジェクトを生成する
		try {
			validate = ValidateFactory.create(jobopr.getCurrentState(_job), _checkXml);
		} catch (SysException e) {

			e.printStackTrace();
		}
		
		// 部品ＸＭＬドキュメント取得する
		Document part = ParseXmlString.getParsedDocument(_partXml);
		
		// タグのノードを取得する
		Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

		//　タグの名前の取得する
		String strtagName = XmlOperator.getAttrValue(tagElement, "name");
		
		String[] str = strtagName.split("/");
		
		
		StringBuffer result = new StringBuffer("<SCRIPT LANGAUGE='JavaScript'>\n");
			
		for(int i = 0;i<str.length;i++){
			if(!"".equals(str[i])) {
				result.append("var bResult = true;\n");
				result.append("var " + str[i] + "= new Object();\n");
				result.append(str[i] + ".Validate = function() {\n");
				result.append(validate.print());
				result.append("};\n");
			}
		}
			
		result.append("\n</SCRIPT>");
		
		return result.toString();
	}
}

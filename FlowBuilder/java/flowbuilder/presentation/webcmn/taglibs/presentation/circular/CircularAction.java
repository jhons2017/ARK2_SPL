package flowbuilder.presentation.webcmn.taglibs.presentation.circular;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.RecordNotFoundAppException;
import fbcom.framework.exceptions.SysException;
import flowbuilder.application.orglist.OrgListService;
import flowbuilder.application.orglist.OrgListServiceFactory;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.AuthorityChecker;


/**
 * 案件表示画面処理を行うコントローラ。 <BR>
 */
public final class CircularAction extends DispatchAction
{
	/** 遷移目標画面 */
	private final String FORWARD_SUCCESS = "success";
	
	/** 遷移ログアウト目標画面 */
	private final String FORWARD_LOGOUT = "logout";
	
	/** ファイルインフォの取得 */
	private XmlFileProperity fileOpr = null;
		
	/**
	 * 案件処理の初期
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward init(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String target = null;
		
		//urlパラメータ名前を取得
		String httpParamName = "";
		
		//urlパラメータを取得
		String httpParamOrgId = "";
		
		//案件IDを取得
		String httpParamJobId = "";
		
		//ユーザレストを取得
		String strUserlst = "";
		
		if (AuthorityChecker.isSessionValid(request)) {
			// urlパラメータを取得
			Enumeration enmNam = request.getParameterNames();

			// リクエスト数を数える
			while (enmNam.hasMoreElements()) {
				httpParamName = (String) enmNam.nextElement().toString();
				// 組織IDを取得
				if ("orgId".equals(httpParamName)) {
					httpParamOrgId = (String) (request
							.getParameter(httpParamName).trim());
					// 案件IDを取得
				} else if ("jobId".equals(httpParamName)) {
					httpParamJobId = (String) (request
							.getParameter(httpParamName).trim());
				}
			}

			// 案件ファイルあり、回覧人ユーザを取得
			if (!"".equals(httpParamJobId)) {
				// ファイルインフォの取得
				fileOpr = new XmlFileProperity("Path.Xml.File");

				// ファイルインフォのパスを取得
				String documentsXML = fileOpr.getJobFileDir(httpParamJobId);

				// 案件ファイルを取得する。
				Document doc = DBXmlFileConn.getDocument(documentsXML);
				Element controlEle = (Element) XmlOperator.getNodeList(doc,
						"Document").item(0);
				NodeList controlLst = controlEle
						.getElementsByTagName("control");

				int len = controlLst.getLength();

				// 回覧者を取得
				for (int i = 0; i < len; i++) {
					Element controlNode = XmlOperator.getElement(controlLst, i);
					if ("circularID".equals(XmlOperator.getAttrValue(
							controlNode, "id"))) {
						if (controlNode.hasChildNodes()) {
							strUserlst = (String) controlNode.getFirstChild()
									.getNodeValue();
							break;
						}
					}
				}
			}
			// ユーザIDより、全部の組織を取得
			UserService userService = UserServiceFactory
					.getUserServiceInstance();
			List queryUserlst = userService.getUsersByOrgId(httpParamOrgId);
			// 選中の回覧者を保存
			if (!"".equals(strUserlst)) {
				request.setAttribute("selectedUserlst", makeToList(strUserlst));
				// 初期を設定
			} else {
				request.setAttribute("selectedUserlst", new ArrayList());
			}
			// 全部の組織を取得
			OrgListService orglstService = OrgListServiceFactory
					.getOrgListServiceInstance();
			List<Section> orgLst = orglstService.getAllOrgId();

			request.setAttribute("orglst", orgLst);
			request.setAttribute("queryUserlst", queryUserlst);

			target = FORWARD_SUCCESS;
		} else {
			target = FORWARD_LOGOUT;
		}
		return mapping.findForward(target);
	}
	/**
	 * 案件処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward change(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String target = null;
		
		//urlパラメータを取得
		String httpParamName = "";
		
		//組織を取得
		String httpParamOrgId = "";
		
		//回覧者
		String strSelectedUsers = "";
		
		if (AuthorityChecker.isSessionValid(request)) {
			// urlパラメータを取得
			Enumeration enmNam = request.getParameterNames();

			CircularForm changeForm = (CircularForm) form;

			// リクエスト数を数える
			while (enmNam.hasMoreElements()) {
				// パラメータを取得
				httpParamName = enmNam.nextElement().toString();
				// 組織を取得
				if ("orgId".equals(httpParamName)) {
					httpParamOrgId = (String) (request
							.getParameter(httpParamName).trim());
					break;
				}
			}
			// 全部の組織を取得
			OrgListService orglstService = OrgListServiceFactory
					.getOrgListServiceInstance();
			List<Section> orgLst = orglstService.getAllOrgId();

			// ユーザIDより、全部の組織を取得
			UserService userService = UserServiceFactory
					.getUserServiceInstance();
			List queryUserlst = userService.getUsersByOrgId(httpParamOrgId);

			// 回覧者を取得
			strSelectedUsers = changeForm.getSelectedUsers();

			// 選中の回覧者を取得
			request.setAttribute("selectedUserlst",
					makeToList(strSelectedUsers));
			request.setAttribute("orglst", orgLst);
			request.setAttribute("queryUserlst", queryUserlst);

			target = FORWARD_SUCCESS;
		} else {
			target = FORWARD_LOGOUT;
			}
		return mapping.findForward(target);
	}
	
	/**
	 * 
	 * @param strSelectedUsers 選中のユーザ
	 * @return　ユーザレスト
	 */	
	private List<User> makeToList(String strSelectedUsers){
		
		//ユーザレスト
		List<User> selectedUserlst = new ArrayList<User>();
		
		//ユーザサービス
		UserService userService;
		
		try {
			if (!"".equals(strSelectedUsers)) {			
				//ユーザサービス
				userService = UserServiceFactory.getUserServiceInstance();
				
				//ユーザレストが転換
				String[] arraySelectedUsers = strSelectedUsers.split(",");
				
				int selectedUserNum = arraySelectedUsers.length;
				//ユーザレスト
				for (int i = 0; i < selectedUserNum; i++) {
					selectedUserlst.add(userService.getUser(arraySelectedUsers[i]));
				} 
			}
		} catch (RecordNotFoundAppException e) {
			
		} catch (SysException e) {
		}
		return selectedUserlst;
	}
}
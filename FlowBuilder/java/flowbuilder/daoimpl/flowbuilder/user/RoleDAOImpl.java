package flowbuilder.daoimpl.flowbuilder.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.user.RoleDAO;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.domain.user.Role;

final class RoleDAOImpl implements RoleDAO {
	/**
	 * ロギング
	 */
	private static Log _log = LogFactory.getLog(UserDAOImpl.class);
	
	private Document filedoc = null;
	
	/**
	 * 
	 *
	 */
	public RoleDAOImpl(){
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");
		String roleXmlPath = fileconn.getFileDir("manage","roles.xml");
		
		//ドキュメントの取得
		filedoc = DBXmlFileConn.getDocument(roleXmlPath);
	}
	
	/**
	 * 権限 件数の取得
	 * 
	 * @return Count 権限の数
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public int getCount() throws XmlAccessSysException {
		return 0;
	}

	/**
	 * 権限 List の取得
	 * 
	 * @param beginIndex 検索開始インデックス（1以上)
	 * @param count 取得したい権限の数（1以上）
	 * @return List 中身は Section
	 * @throws IndexOutOfBoundsException 配列の境界を超えてアクセスしたの場合
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List getList(int beginIndex, int count) throws XmlAccessSysException {
		return null;
	}

	/**
	 * 権限 List の取得
	 * 
	 * @return List 中身は Cause 原因区分
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List getList() throws XmlAccessSysException {
		int count = 2;
		
		String firstTag = "role1";
		
		Role role = null;
		
		List<Role> roleGrp = new ArrayList<Role>();
		
		
		while(filedoc.getElementsByTagName(firstTag).getLength() != 0){
			NodeList roleList = filedoc.getElementsByTagName(firstTag);
			int roleListCount = roleList.getLength();
			for(int i=0;i<roleListCount;i++){
				Element element = (Element)roleList.item(i);
					
				String strRoleId = element.getAttribute("id");
				String strRoleName = element.getAttribute("name");
	
				role = new Role();
				
				role.setRoleID(strRoleId);
				 
				role.setRoleName(strRoleName);
				
				roleGrp.add(role);
			}
			
			firstTag = "role" + count++;
			
		}
		
		return roleGrp;
	}

	/**
	 * 権限 の取得
	 * 
	 * @param ｒｏｌｅNo 権限No
	 * @return Section 権限
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public Role select(String roleNo) throws XmlAccessSysException {
		List<Role> roleGrp = this.getList();
		
		Role role = null;

		int length = roleGrp.size();
		
		for(int i=0;i<length;i++){
			role = roleGrp.get(i);
			if(roleNo.equals(role.getRoleId())){
				break;
			}
		}	
		return role;
	}
	
}

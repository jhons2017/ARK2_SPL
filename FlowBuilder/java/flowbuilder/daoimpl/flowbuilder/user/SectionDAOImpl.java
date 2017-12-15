package flowbuilder.daoimpl.flowbuilder.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.user.SectionDAO;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.domain.user.Section;

final class SectionDAOImpl implements SectionDAO {
	/**
	 * ロギング
	 */
	private static Log _log = LogFactory.getLog(SectionDAOImpl.class);
	
	private List<Section> orgGrpALL = new ArrayList<Section>();	
	
	private Document filedoc = null;
	
	/**
	 * 
	 *
	 */
	public SectionDAOImpl(){
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");
		String roleXmlPath = fileconn.getFileDir("manage","organization.xml");
		
		//ドキュメントの取得
		filedoc = DBXmlFileConn.getDocument(roleXmlPath);
	}
	
	
	/**
	 * 所属 件数の取得
	 * 
	 * @return Count 所属の数
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public int getCount() throws XmlAccessSysException {
		return 0;
	}

	/**
	 * 所属 List の取得
	 * 
	 * @param beginIndex 検索開始インデックス（1以上)
	 * @param count 取得したい所属の数（1以上）
	 * @return List 中身は Section
	 * @throws IndexOutOfBoundsException 配列の境界を超えてアクセスしたの場合
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<Section> getList(int beginIndex, int count) throws XmlAccessSysException {
		return null;
	}

	/**
	 * 所属 List の取得
	 * 
	 * @return List 中身は Cause 原因区分
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<Section> getList() throws XmlAccessSysException {
		int count = 2;
		
		String firstTag = "org1";
		
		Section org = null;
		
		List<Section> orgGrp = new ArrayList<Section>();
		
		
		while(filedoc.getElementsByTagName(firstTag).getLength() != 0){
			NodeList roleList = filedoc.getElementsByTagName(firstTag);
			int roleListCount = roleList.getLength();
			for(int i=0;i<roleListCount;i++){
				Element element = (Element)roleList.item(i);
					
				String strOrgId = element.getAttribute("id");
				String strOrgName = element.getAttribute("name");
	
				org = new Section();
				
				org.setNo(strOrgId);
				 
				org.setName(strOrgName);
				
				orgGrp.add(org);
			}
			
			firstTag = "org" + count++;
			
		}
		
		return orgGrp; 
	}

	/**
	 * 所属 の取得
	 * 
	 * @param sectionNo 所属No
	 * @return Section 所属
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public Section selectById(String sectionNo) throws XmlAccessSysException {
		List<Section> orgGrp = this.getList();
		
		Section org = null;

		int length = orgGrp.size();
		
		for(int i=0;i<length;i++){
			org = orgGrp.get(i);
			if(sectionNo.equals(org.getNo())){
				break;
			}
		}	
		return org;
	}
	
	/**
	 * 所属 の取得
	 * 
	 * @param sectionNo 所属No
	 * @return Section 所属
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public Section selectByName(String sectionName) throws XmlAccessSysException {
		List<Section> orgGrp = this.getList();
		
		Section org = null;

		int length = orgGrp.size();
		
		for(int i=0;i<length;i++){
			org = orgGrp.get(i);
			if(sectionName.equals(org.getName())){
				break;
			}
		}	
		return org;
	}
	
	/**
	 * 所属 List の取得
	 * 
	 * @return Section 所属
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<Section> getAllOrgList() throws XmlAccessSysException {
		
		Element root = filedoc.getDocumentElement();
		visit(root);
		
		return orgGrpALL; 
	}

	/**
	 * 全部の組織を取得
	 * 
	 * @param element　エレメント
	 */
	private void visit(Element element) {
		NodeList children = element.getChildNodes();
		//組織を取得
		for (int i = 0; i < children.getLength(); i++) {
	        if (Node.ELEMENT_NODE == children.item(i).getNodeType()) {
	        	Section section = new Section();
	        	//組織IDを取得
	        	section.setNo(((Element)children.item(i)).getAttribute("id"));
	        	//組織名前を取得
	        	section.setName(((Element)children.item(i)).getAttribute("name"));
	        	//組織レストの追加
	        	orgGrpALL.add(section);
		        visit((Element)children.item(i));
	        }
	    }
		    
	}
}

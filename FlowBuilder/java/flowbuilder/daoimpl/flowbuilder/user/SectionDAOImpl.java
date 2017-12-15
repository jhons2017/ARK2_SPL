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
	 * ���M���O
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
		
		//�h�L�������g�̎擾
		filedoc = DBXmlFileConn.getDocument(roleXmlPath);
	}
	
	
	/**
	 * ���� �����̎擾
	 * 
	 * @return Count �����̐�
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public int getCount() throws XmlAccessSysException {
		return 0;
	}

	/**
	 * ���� List �̎擾
	 * 
	 * @param beginIndex �����J�n�C���f�b�N�X�i1�ȏ�)
	 * @param count �擾�����������̐��i1�ȏ�j
	 * @return List ���g�� Section
	 * @throws IndexOutOfBoundsException �z��̋��E�𒴂��ăA�N�Z�X�����̏ꍇ
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<Section> getList(int beginIndex, int count) throws XmlAccessSysException {
		return null;
	}

	/**
	 * ���� List �̎擾
	 * 
	 * @return List ���g�� Cause �����敪
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
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
	 * ���� �̎擾
	 * 
	 * @param sectionNo ����No
	 * @return Section ����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
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
	 * ���� �̎擾
	 * 
	 * @param sectionNo ����No
	 * @return Section ����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
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
	 * ���� List �̎擾
	 * 
	 * @return Section ����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<Section> getAllOrgList() throws XmlAccessSysException {
		
		Element root = filedoc.getDocumentElement();
		visit(root);
		
		return orgGrpALL; 
	}

	/**
	 * �S���̑g�D���擾
	 * 
	 * @param element�@�G�������g
	 */
	private void visit(Element element) {
		NodeList children = element.getChildNodes();
		//�g�D���擾
		for (int i = 0; i < children.getLength(); i++) {
	        if (Node.ELEMENT_NODE == children.item(i).getNodeType()) {
	        	Section section = new Section();
	        	//�g�DID���擾
	        	section.setNo(((Element)children.item(i)).getAttribute("id"));
	        	//�g�D���O���擾
	        	section.setName(((Element)children.item(i)).getAttribute("name"));
	        	//�g�D���X�g�̒ǉ�
	        	orgGrpALL.add(section);
		        visit((Element)children.item(i));
	        }
	    }
		    
	}
}

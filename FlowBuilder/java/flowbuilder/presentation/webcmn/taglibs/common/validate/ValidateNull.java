/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/25
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/08 BY. YANGZHEN (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common.validate;

/**
 * NULL�̃`�F�b�N
 * 
 * @auther YANGZHEN
 */
public class ValidateNull extends ValidateParent{

	/**
	 * �X�N���v�g���o�͂���B
	 * @param partName ���i��HTML���O
	 * @param htmlId ���i�̖��O
	 * @return�@���i�ɑΉ�����X�N���v�g
	 */
	public void onPrint(StringBuffer sbuf) {
		String js = "csNull('" + _params.get("htmlId") + "','" + _params.get("partName") + "');";
		sbuf.append(js);
	}

}

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
 * �O��̓��t���r�`�F�b�N
 * 
 * @auther YANGZHEN
 */
public class ValidateDateFromTo extends ValidateParent {

	/**
	 * �X�N���v�g���o�͂���B
	 * @param partName ���i��HTML���O
	 * @param startTime �J�n���t
	 * @param endTime �������t
	 * @return�@htmlId ���i�̖��O
	 * @return�@���i�ɑΉ�����X�N���v�g
	 */
	public void onPrint(StringBuffer sbuf) {
		String js = "csDatetoCompare('" + _params.get("startTime") + "','" + _params.get("endTime") + "','" + _params.get("partName") + "')";
		sbuf.append(js);
	}
}

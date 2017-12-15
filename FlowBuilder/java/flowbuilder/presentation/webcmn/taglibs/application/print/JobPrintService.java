/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. CHENBIN (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.application.print;

import javax.servlet.http.HttpServletResponse;

/**
 * 操作フラグによって、特定の操作を実行する。<BR>
 */
public interface JobPrintService {
	public void jobPrint(String jobId, HttpServletResponse response);

}

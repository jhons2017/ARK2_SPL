package flowbuilder.presentation.webcmn.taglibs.domain.print;

public class PrintInformation {

		/** row */
		private int _row;

		/** col */
		private int _col;
		
		/** valD */
		private String _val= "";
		
		/** sheetNo */
		private int _sheetNo;
		public PrintInformation(String s, int r, int c, int sh) {
		
			this._row = r;
			this._col = c;
			this._sheetNo = sh;
			this._val = s;

		}
		/**
		 * rowの設定 <br>
		 * 
		 * @param int row 
		 */
		public void setRow(int row)
		{
			_row = row;
		}

		/**
		 * rowの取得 <br>
		 * 
		 * @return int
		 */
		public int getRow()
		{
			return _row;
		}

		/**
		 * colの設定 <br>
		 * 
		 * @param int col 
		 */
		public void setCol(int col)
		{
			_col = col;
		}

		/**
		 * colの取得 <br>
		 * 
		 * @return int
		 */
		public int getCol()
		{
			return _col;
		}
		
		/**
		 * valの設定 <br>
		 * 
		 * @param int val 
		 */
		public void setVal(String val)
		{
			_val = val;
		}

		/**
		 * valの取得 <br>
		 * 
		 * @return int
		 */
		public String getVal()
		{
			return _val;
		}
		
		/**
		 * sheetNoの設定 <br>
		 * 
		 * @param int sheetNo 
		 */
		public void setSheetNo(int sheetNo)
		{
			_sheetNo = sheetNo;
		}

		/**
		 * sheetNoの取得 <br>
		 * 
		 * @return int
		 */
		public int getSheetNo()
		{
			return _sheetNo;
		}
}

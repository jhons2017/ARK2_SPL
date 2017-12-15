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
		 * row�̐ݒ� <br>
		 * 
		 * @param int row 
		 */
		public void setRow(int row)
		{
			_row = row;
		}

		/**
		 * row�̎擾 <br>
		 * 
		 * @return int
		 */
		public int getRow()
		{
			return _row;
		}

		/**
		 * col�̐ݒ� <br>
		 * 
		 * @param int col 
		 */
		public void setCol(int col)
		{
			_col = col;
		}

		/**
		 * col�̎擾 <br>
		 * 
		 * @return int
		 */
		public int getCol()
		{
			return _col;
		}
		
		/**
		 * val�̐ݒ� <br>
		 * 
		 * @param int val 
		 */
		public void setVal(String val)
		{
			_val = val;
		}

		/**
		 * val�̎擾 <br>
		 * 
		 * @return int
		 */
		public String getVal()
		{
			return _val;
		}
		
		/**
		 * sheetNo�̐ݒ� <br>
		 * 
		 * @param int sheetNo 
		 */
		public void setSheetNo(int sheetNo)
		{
			_sheetNo = sheetNo;
		}

		/**
		 * sheetNo�̎擾 <br>
		 * 
		 * @return int
		 */
		public int getSheetNo()
		{
			return _sheetNo;
		}
}

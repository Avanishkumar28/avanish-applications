package av.app.calcutator.enums;

import java.util.List;

import av.app.calcutator.excel.ExcelFileReader;
import av.app.calcutator.pojo.Transaction;

public enum FileType {
	
	XLS{

		@Override
		public List<Transaction> processFile() {
			
			return new ExcelFileReader().readFile();
		}
		
	},XLSX{

		@Override
		public List<Transaction> processFile() {
			return new ExcelFileReader().readFile();
		}
		
	};

	
	public abstract List<Transaction> processFile(); 
}

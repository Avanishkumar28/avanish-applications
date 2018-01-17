package av.app.income_calculator.serviceImpl;

import java.util.List;

import av.app.income_calculator.enums.FileType;
import av.app.income_calculator.exception.InvalideFileException;
import av.app.income_calculator.pojo.AvgCapitalIncome;
import av.app.income_calculator.pojo.CapitalIncome;
import av.app.income_calculator.service.FileProcessor;

public class FileProcessorImpl implements FileProcessor{
	
	private FileType fileType;
	
	public FileProcessorImpl(FileType fileType) {
		this.fileType = fileType;
	}

	@Override
	public List<CapitalIncome> readFile() {
		List<CapitalIncome> capitalIncomes = null;
		switch(fileType) {
		case CSV:
			capitalIncomes = CSVFileProcessor.readCSVFile();
			break;
		case XLS:
			capitalIncomes = ExcelFileProcessor.readExcelFile(fileType);
			break;
		case XLSX:
			capitalIncomes = ExcelFileProcessor.readExcelFile(fileType);
			break;
		case XML:
			//to be Implemented yet
			break;
		default:
			throw new InvalideFileException("Invalide file type");
		}
		return capitalIncomes;
	}

	@Override
	public void writeFile(List<AvgCapitalIncome> avgIncomes) {
		switch(fileType) {
		case CSV:
			CSVFileProcessor.writeCSVFile(avgIncomes);
			break;
		case XLS:
			ExcelFileProcessor.writeExcelFile(fileType, avgIncomes);
			break;
		case XLSX:
			ExcelFileProcessor.writeExcelFile(fileType, avgIncomes);
			break;
		case XML:
			//to be Implemented yet
			break;
		default:
			throw new InvalideFileException("Invalide file type");
		}
		
	}

}

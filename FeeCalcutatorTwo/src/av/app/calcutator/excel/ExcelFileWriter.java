package av.app.calcutator.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import av.app.calcutator.constants.AppConstant;
import av.app.calcutator.pojo.TransactionReport;
import av.app.calcutator.service.AppFileWriter;

public class ExcelFileWriter implements AppFileWriter {

	@Override
	public void createReportFile(List<TransactionReport> transactionReports) {
		try(FileOutputStream fileOutputStream = new FileOutputStream(new File(AppConstant.OUTPUT_FILE));
				Workbook workbook = new XSSFWorkbook();) {
			
			Sheet sheet = workbook.createSheet("Transaction Report");
			int rowCounter = 0;
			Row headerRow = sheet.createRow(rowCounter++);
			createHeader(headerRow);
			for(TransactionReport transactionReport : transactionReports) {
				Row dataRow = sheet.createRow(rowCounter++);
				createDataRow(dataRow, transactionReport);
			}
			
			workbook.write(fileOutputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	private void createHeader(Row headerRow) {
		headerRow.createCell(0).setCellValue("Client Id");    
		headerRow.createCell(1).setCellValue("Transaction Type");
		headerRow.createCell(2).setCellValue("Transaction Date");
		headerRow.createCell(3).setCellValue("Priority");
		headerRow.createCell(4).setCellValue("Processing Fee");
		
	}
	
	private void createDataRow(Row dataRow, TransactionReport transactionReport) {
		dataRow.createCell(0).setCellValue(transactionReport.getClientId());    
		dataRow.createCell(1).setCellValue(transactionReport.getTransactionType());
		dataRow.createCell(2).setCellValue(transactionReport.getTransactionDate());
		dataRow.createCell(3).setCellValue(transactionReport.getPriorityFlag());
		dataRow.createCell(4).setCellValue(transactionReport.getProcessingFee());
		
	}

}

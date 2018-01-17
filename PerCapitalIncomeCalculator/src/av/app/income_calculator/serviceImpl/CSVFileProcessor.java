package av.app.income_calculator.serviceImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import av.app.income_calculator.constent.AppConstents;
import av.app.income_calculator.main.AppHealper;
import av.app.income_calculator.pojo.AvgCapitalIncome;
import av.app.income_calculator.pojo.CapitalIncome;

public class CSVFileProcessor {

	public static List<CapitalIncome> readCSVFile() {
		List<CapitalIncome> capitalIncomes = null;
		try(FileReader fileInputStream = new FileReader(new File(AppConstents.INPUT_FILE+".csv"));
				BufferedReader br = new BufferedReader(fileInputStream);) {
			
			capitalIncomes = br.lines()
							   .skip(1)
							   .map(line -> AppHealper.mapToCapitalIncome(line))
							   .collect(Collectors.toList());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return capitalIncomes;
	}

	
	public static void writeCSVFile(List<AvgCapitalIncome> avgIncomes) {
		try(FileWriter fileWriter = new FileWriter(new File(AppConstents.OUTPUT_FILE+".csv"));
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
			StringBuilder sb = new StringBuilder();
			createHeader(sb);
			
			for(AvgCapitalIncome avgCapitalIncome : avgIncomes) {
				
				createDataRow(sb, avgCapitalIncome);
			}
			
			bufferedWriter.write(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void createDataRow(StringBuilder sb, AvgCapitalIncome avgCapitalIncome) {
		sb.append(avgCapitalIncome.getCityOrCountry()).append(AppConstents.COMMA)
		  .append(avgCapitalIncome.getGender()).append(AppConstents.COMMA)
		  .append(avgCapitalIncome.getAvgIncome()).append("\n");
		
	}


	private static void createHeader(StringBuilder sb) {
		sb.append("City/Country").append(AppConstents.COMMA)
		  .append("Gender").append(AppConstents.COMMA)
		  .append("Avg Income(in USD)").append("\n");
		
	}

}

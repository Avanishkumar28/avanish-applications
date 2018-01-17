package av.app.income_calculator.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import av.app.income_calculator.enums.FileType;
import av.app.income_calculator.pojo.AvgCapitalIncome;
import av.app.income_calculator.pojo.CapitalIncome;
import av.app.income_calculator.service.FileProcessor;
import av.app.income_calculator.serviceImpl.FileProcessorImpl;

public class CapitalIncomeCalculator {

	public static void main(String[] args) {
		FileProcessor fileProcessor = new FileProcessorImpl(FileType.CSV);
		List<CapitalIncome> capitalIncomes = fileProcessor.readFile();
		
		//capitalIncomes.forEach(System.out :: println);
		
		Map<String, Double> avgIncomeGroupByCityOrCountryAndGender = capitalIncomes.stream()
				.collect(Collectors.groupingBy(capitalIncome -> AppHealper.cityOrCountryWithGender(capitalIncome),
						Collectors.averagingDouble(CapitalIncome::getIncome)
				));

		//avgIncomeGroupByCityOrCountryAndGender.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v));
		List<AvgCapitalIncome> avgCapitalIncomes = AppHealper.getAvgCapitalIncome(avgIncomeGroupByCityOrCountryAndGender);
		//avgCapitalIncomes.forEach(System.out :: println);
		
		fileProcessor.writeFile(avgCapitalIncomes);
		
		System.out.println("All task done!");
	}

}

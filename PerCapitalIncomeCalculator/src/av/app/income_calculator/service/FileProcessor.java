package av.app.income_calculator.service;

import java.util.List;

import av.app.income_calculator.pojo.AvgCapitalIncome;
import av.app.income_calculator.pojo.CapitalIncome;

public interface FileProcessor {

	public List<CapitalIncome> readFile();
	
	public void writeFile(List<AvgCapitalIncome> avgIncomes);
}

package av.app.income_calculator.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import av.app.income_calculator.constent.AppConstents;
import av.app.income_calculator.enums.CurrancyType;
import av.app.income_calculator.enums.Gender;
import av.app.income_calculator.pojo.AvgCapitalIncome;
import av.app.income_calculator.pojo.CapitalIncome;

public class AppHealper {

	public static CapitalIncome mapToCapitalIncome(String line) {
		String[] lineArray = line.split(AppConstents.COMMA);
		
		return new CapitalIncome(lineArray[0], 
						lineArray[1], 
						Gender.valueOf(lineArray[2]), 
						Double.parseDouble(lineArray[3]), 
						CurrancyType.valueOf(lineArray[4]));
	}

	public static String cityOrCountryWithGender(CapitalIncome capitalIncome) {
		if(capitalIncome.getCountry() != null && !"".equals(capitalIncome.getCountry().trim()))
			return capitalIncome.getCountry()+"_"+capitalIncome.getGender()+"_"+capitalIncome.getCurrancy();
		else
			return capitalIncome.getCity()+"_"+capitalIncome.getGender()+"_"+capitalIncome.getCurrancy();
	}

	public static List<AvgCapitalIncome> getAvgCapitalIncome(Map<String, Double> avgIncomeGroupByCityOrCountryAndGender) {
		List<AvgCapitalIncome> avgCapitalIncomes = new ArrayList<>();
		for(Map.Entry<String, Double> entry : avgIncomeGroupByCityOrCountryAndGender.entrySet()) {
			String[] entryArray =  entry.getKey().split("_");
			double incomeInUSD = formateCurrancyDigite(CurrancyType.valueOf(entryArray[2]).currancyToUSD(entry.getValue()));
			avgCapitalIncomes.add(
					new AvgCapitalIncome(entryArray[0], 
							Gender.valueOf(entryArray[1]), 
							incomeInUSD)
					);
		}
		
		return avgCapitalIncomes;
	}
	
	public static double formateCurrancyDigite(double currancy) {
		return Double.parseDouble(new DecimalFormat("##.##").format(currancy));
	}

}

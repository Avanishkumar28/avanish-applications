package av.app.income_calculator.pojo;

import av.app.income_calculator.enums.Gender;

public class AvgCapitalIncome {

	private String cityOrCountry;
	private Gender gender;
	private double avgIncome;
	
	public AvgCapitalIncome(String cityOrCountry, Gender gender, double avgIncome) {
		super();
		this.cityOrCountry = cityOrCountry;
		this.gender = gender;
		this.avgIncome = avgIncome;
	}

	public String getCityOrCountry() {
		return cityOrCountry;
	}

	public Gender getGender() {
		return gender;
	}

	public double getAvgIncome() {
		return avgIncome;
	}

	@Override
	public String toString() {
		return "AvgCapitalIncome [cityOrCountry=" + cityOrCountry + ", gender=" + gender + ", avgIncome=" + avgIncome
				+ "]";
	}
	
	
}

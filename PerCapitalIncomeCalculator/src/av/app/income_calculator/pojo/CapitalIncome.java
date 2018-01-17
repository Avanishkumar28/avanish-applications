package av.app.income_calculator.pojo;

import av.app.income_calculator.enums.CurrancyType;
import av.app.income_calculator.enums.Gender;

public class CapitalIncome {
	
	private String city;
	private String country;
	private Gender gender;
	private double income;
	private CurrancyType currancy;
	
	public CapitalIncome(String city, String country, Gender gender, double income, CurrancyType currancy) {
		super();
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.income = income;
		this.currancy = currancy;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public Gender getGender() {
		return gender;
	}

	public double getIncome() {
		return income;
	}

	public CurrancyType getCurrancy() {
		return currancy;
	}

	@Override
	public String toString() {
		return "CapitalIncome [city=" + city + ", country=" + country + ", gender=" + gender + ", income=" + income
				+ "]";
	}
	
	

}

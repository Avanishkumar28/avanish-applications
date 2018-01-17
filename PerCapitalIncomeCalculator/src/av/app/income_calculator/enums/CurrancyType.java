package av.app.income_calculator.enums;

public enum CurrancyType {
	
	INR {
		@Override
		public double currancyToUSD(double income) {
			return income/66;
		}
	},
	EUR {
		@Override
		public double currancyToUSD(double income) {
			return income/0.5;
		}
	},
	USD {
		@Override
		public double currancyToUSD(double income) {
			return income;
		}
	},
	JYN {
		@Override
		public double currancyToUSD(double income) {
			return income/1.66;
		}
	};
	
	
	public abstract double currancyToUSD(double income); 

}

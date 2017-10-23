package av.streams;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFactory {
	
	private List<Employee> employees;
	
	
	public EmployeeFactory() {
		employees = new ArrayList<>();
		employees.add(new Employee(1, "Sajal", 60_000, "Fujitsu", true));
		employees.add(new Employee(2, "Amit", 45_000, "Fujitsu", true));
		employees.add(new Employee(3, "Abhinav", 50_000, "Fujitsu", true));
		employees.add(new Employee(4, "Vibhor", 50_000, "Fujitsu", true));
		employees.add(new Employee(5, "Punit", 55_000, "Fujitsu", true));
		
		employees.add(new Employee(6, "Rashika", 70_000, "STMicro", false));
		employees.add(new Employee(7, "Anuj", 1_60_000, "STMicro", false));
		employees.add(new Employee(8, "Kanika", 80_000, "STMicro", false));
		
		employees.add(new Employee(9, "Jitendra", 65_000, "Jindal Steel", false));
		employees.add(new Employee(10, "Arun", 1_30_000, "Jindal Steel", false));
		
		employees.add(new Employee(11, "Ali", 30_000, "CRIS", true));
		employees.add(new Employee(12, "Neelesh", 40_000, "CTS", true));
		
	}


	public List<Employee> getEmployees() {
		return employees;
	}


}

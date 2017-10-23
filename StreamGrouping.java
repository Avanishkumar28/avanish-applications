package av.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamGrouping {
	
	//groupBySalary
	public static Map<Integer, List<Employee>> groupBySalary(List<Employee> allEmployees){
		Map<Integer, List<Employee>> empBySalary = null;
		if(!allEmployees.isEmpty()) {
			empBySalary = new HashMap<>(); 
					
			for(Employee emp : allEmployees) {
				List<Employee> sameSalaryEmp = empBySalary.get(emp.getSalary());
				if(sameSalaryEmp != null) {
					sameSalaryEmp.add(emp);
				}else {
					sameSalaryEmp = new ArrayList<>();
					sameSalaryEmp.add(emp);
				}
				empBySalary.put(emp.getSalary(), sameSalaryEmp);
			}
		}
		
		
		return empBySalary;
	}
	
	//groupByCompany
	
	//groupBySalary > 50_000

	public static void main(String[] args) {
		EmployeeFactory eFactory = new EmployeeFactory();
		List<Employee> eList = eFactory.getEmployees();
	
		System.out.println(groupBySalary(eList));
	}

}










/*return allEmployees.stream()
.collect(Collectors.groupingBy(Employee :: getSalary));*/


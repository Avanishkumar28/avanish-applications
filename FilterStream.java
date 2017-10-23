package av.streams;

import java.util.ArrayList;
import java.util.List;

public class FilterStream {
	
	//filter all Subcontractor
	public static List<Employee> filterSubcontractors(List<Employee> allEmployees){
		List<Employee> subSubcontractors = null;
		if(!allEmployees.isEmpty()) {
			subSubcontractors = new ArrayList<>();
			for(Employee emp : allEmployees) {
				if (emp.isSubcontractor()) 
					subSubcontractors.add(emp);
			}
		}
		
		return subSubcontractors;
	}

	public static void main(String[] args) {
		EmployeeFactory eFactory = new EmployeeFactory();
		List<Employee> eList = eFactory.getEmployees();
		
		System.out.println(filterSubcontractors(eList));

	}

}

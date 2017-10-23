package av.streams;

public class Employee {
	
	private int id;
	private String name;
	private int salary;
	private String company;
	private boolean isSubcontractor;
	
	
	
	
	public Employee(int id, String name, int salary, String company, boolean isSubcontractor) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.company = company;
		this.isSubcontractor = isSubcontractor;
	}
	
	//Setters and Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public boolean isSubcontractor() {
		return isSubcontractor;
	}
	public void setSubcontractor(boolean isSubcontractor) {
		this.isSubcontractor = isSubcontractor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + id;
		result = prime * result + (isSubcontractor ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (id != other.id)
			return false;
		if (isSubcontractor != other.isSubcontractor)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return "Employee[ID:"+id+", Name: "+name+", Company: "+company+", Salary: "+salary+"]";
	}
	
	

}

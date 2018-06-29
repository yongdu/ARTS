package yong.du.keep.learning;

public class Employee {

	private String firstName;
	private String lastName;
	private double salary;
	private String department;
	
	// constructor
	public Employee(String firstName, String lastName, double salary, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}
	
	// set firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// get last name
	public String getFirstName() {
		return this.firstName;
	}
	// set lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
		
	// get firstName
	public String getLastName() {
		return this.lastName;
	}
	// set department
	public void setDepartment(String department) {
		this.department = department;
	}
			
	// get department
	public String getDeparetment() {
		return this.department;
	}
	
	// set salary
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	// get salary
	public Double getSalary() {
		return this.salary;
	}
	
	// return Employee's first and last name combined
	public String getName() {
		return String.format("%s %s", getFirstName(),getLastName());
	}
	
	// return a string contains the employee's information
	@Override
	public String toString() {
		return String.format("%-8s %-8s %8.2f   %s", getFirstName(),getLastName(),getSalary(),getDeparetment());
	}
	
	
	
	
}

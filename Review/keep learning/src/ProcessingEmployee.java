package yong.du.keep.learning;

// Processing streams of Employee object
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployee {

	public static void main(String [] args) {
		// initialize array of employees
		Employee[] employees = {
				new Employee("Java","SE",7000,"IT"),
				new Employee("Python","NH",5000,"IT"),
				new Employee("Golang","US",8600,"IT"),
				new Employee("Php","CH",4000,"Sales"),
				new Employee("Luke","DK",3225.5,"HR"),
				new Employee("Json","CZ",4560,"Marketing"),
				new Employee("Ada","UK",9560,"Robotic"),
				new Employee("Zen","CN",18000,"VD"),
		};
		
		// get list view of the employees
		List<Employee> list = Arrays.asList(employees);
		
		// display all employees
		System.out.println("Complete Employee list:");
		list.stream().forEach(System.out::println);
		
		// predicate that returns true for salaries in the range $4000 -$6000
		Predicate<Employee> fourToSixThousand = e->(e.getSalary() >=4000 && e.getSalary() <=6000);
		
		// Display Employees with salaries in the range $4000 - $6000, sorted into ascending order by salary
		System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary:%n");
		list.stream()
		    .filter(fourToSixThousand)
		    .sorted(Comparator.comparing(Employee::getSalary))
		    .forEach(System.out::println);
		
		// Display first Employees with salaries in the range $4000 - $6000
		System.out.printf("%nFirst employees who earns $4000-$6000 per month sorted by salary:%n%s%n",
						list.stream()
					    .filter(fourToSixThousand)
					    .findFirst()
					    .get()
					      );
				
		// Display the employees whose salaries is lowest in the range $4000 - $6000
		System.out.printf("%nThe employee who earns lowest salary in $4000-$6000 per month :%n%s%n",
			list.stream()
			    .filter(fourToSixThousand)
			    .sorted(Comparator.comparing(Employee::getSalary))
			    .findFirst()
			    .get());
		
		// Display the employees whose salaries is highest in the range $4000 - $6000
				System.out.printf("%nThe employee who earns hightest salary in $4000-$6000 per month:%n%s%n",
					list.stream()
					    .filter(fourToSixThousand)
					    .sorted(Comparator.comparing(Employee::getSalary).reversed())
					    .findFirst()
					    .get());
		// Function for getting the first and last names from employee
		Function<Employee,String> byFirstName = Employee::getFirstName;
		Function<Employee,String> byLastName = Employee::getLastName;		
		Function<Employee,Double> bySalary = Employee::getSalary;
		
		// Comparator for comparing Employee by first name then last name
		Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);
		Comparator<Employee> salaryThenLastThenFirst = Comparator.comparing(bySalary).thenComparing(byLastName).thenComparing(byFirstName);
		// Sort employee by last name, then fist name in ascending order
		System.out.printf("%nSort employee in ascending order by last name, then first name%n");
		list.stream()
		    .sorted(lastThenFirst)
		    .forEach(System.out::println);
		
		// Sort employee by last name, then fist name in descending order
		System.out.printf("%nSort employee in ascending order by last name, then first name%n");
		list.stream()
			.sorted(lastThenFirst.reversed())
			.forEach(System.out::println);
		
		// Display unique employee last name sorted
		System.out.printf("%nUnique employee  last name%n");
		list.stream()
		    .map(byLastName)
		    .distinct()
		    .sorted(String.CASE_INSENSITIVE_ORDER)
		    .forEach(System.out::println);
		
		// Display only first name and last names
		System.out.printf("%nDisplay employee in ascending order by last name, then first name%n");
		list.stream()
		    .sorted(salaryThenLastThenFirst.reversed())
		    .map(Employee::getName)
		    .forEach(System.out::println);
	}
}

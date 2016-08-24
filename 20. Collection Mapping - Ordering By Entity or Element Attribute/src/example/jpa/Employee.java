package example.jpa;
/* One-to-Many relationship between Employee & Department. Many Employees can be there in one Department. 
 * Refer to Department class. 
 */

import javax.persistence.*;
@Entity
public class Employee implements Comparable<Employee>{

	@Id private int id;
	private String name;
	private int salary;
	@ManyToOne
	private Department department;
	public Employee(){}

	public Employee(int id){
		this.id=id;	
	}

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

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name="
				+ name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee arg0) {
		// TODO Auto-generated method stub
		return arg0.salary-salary;
	}
	
}

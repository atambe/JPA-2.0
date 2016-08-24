package example.jpa;
/* One-to-Many relationship between Employee & Department. Many Employees can be there in one Department. 
 * Refer to Department class. 
 */

import javax.persistence.*;
@Entity
public class Employee {

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
		return "Employee [department=" + department + ", id=" + id + ", name="
				+ name + ", salary=" + salary + "]";
	}
	
}

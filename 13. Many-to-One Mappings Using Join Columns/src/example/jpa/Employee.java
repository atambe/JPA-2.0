package example.jpa;
/*If no @JoinColumn annotation is used, a default column name will be assumed. 
 * The default is formed using both source and target entities.
 * e.g. department is field name in Employee and id is identity in Department so the resultant column name
 * would be DEPARTMENT_ID
 */

import javax.persistence.*;
@Entity
public class Employee {

	@Id private int id;
	private String name;
	private int salary;
	@ManyToOne
	@JoinColumn (name="DEPT_ID")
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

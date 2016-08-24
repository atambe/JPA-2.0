package example.jpa;
/* One-to-One relationship between Employee & WorkStation.
 *  
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
	@OneToOne
	private WorkStation workStation;
	
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

	public WorkStation getWorkStation() {
		return workStation;
	}

	public void setWorkStation(WorkStation workStation) {
		this.workStation = workStation;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [department=" + department + ", id=" + id + ", name="
				+ name + ", salary=" + salary + ", workStation=" + workStation
				+ "]";
	}
	
}

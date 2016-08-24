package example.jpa;
import java.util.List;

import javax.persistence.*;
/*
 * Many-to-One relation between Employee & Department. List of Employees in Department.
 */

@Entity
public class Department {

	@Id private int id;
	private String name;
	@OneToMany
	private List<Employee> employees;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}

package example.jpa;


import java.util.Map;

import javax.persistence.*;
/*
 * Many-to-One relation between Employee & Department. Map of Employees in Department, where key is id(Entity attribute) and value is Entity
 * Join table is not required.
 */

@Entity
public class Department {

	@Id private int id;
	private String name;
	@OneToMany(mappedBy="department")

	@MapKey(name="id")
	private Map<Integer,Employee> employees;
	
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


	public Map<Integer,Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Map<Integer,Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Department [employeesByCubicle=" + employees + ", id="
				+ id + ", name=" + name + "]";
	}
}

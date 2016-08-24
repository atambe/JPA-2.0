package example.jpa;


import java.util.Map;

import javax.persistence.*;
/*
 * Many-to-One relation between Employee & Department. Map of cubicle-Employee.
 * Join table is explicitly required. Key is of basic type and value is entity.
 */

@Entity
public class Department {

	@Id private int id;
	private String name;
	@OneToMany//(mappedBy="department")

	@MapKeyColumn(name="CUB_ID")
	private Map<String,Employee> employeesByCubicle;
	
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


	public Map<String,Employee> getEmployeesByCubicle() {
		return employeesByCubicle;
	}


	public void setEmployeesByCubicle(Map<String,Employee> employees) {
		this.employeesByCubicle = employees;
	}


	@Override
	public String toString() {
		return "Department [employeesByCubicle=" + employeesByCubicle + ", id="
				+ id + ", name=" + name + "]";
	}
}

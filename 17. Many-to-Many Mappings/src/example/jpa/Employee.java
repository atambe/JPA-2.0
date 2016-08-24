package example.jpa;


import java.util.Collection;

import javax.persistence.*;
@Entity
public class Employee {

	@Id private int id;
	private String name;
	private int salary;
	@ManyToMany
	private Collection<Project> projects;
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

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", projects="
				+ projects + ", salary=" + salary + "]";
	}
	
}

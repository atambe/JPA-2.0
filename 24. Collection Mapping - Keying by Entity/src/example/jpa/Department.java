package example.jpa;


import java.util.Map;

import javax.persistence.*;
/*
 * To illustrate this case of an entity being used as a key, we can add notion of the seniority an Employee has within the Department.
 * We want to have loose association between Employee and his seniority; and the seniority has to be local to Department.   
 * By defining an element collection Map in Department, with the seniority as the values and Employee entities as keys, the seniority
 * of an Employee can be looked up by using the Employee instance as key. The seniority is stored in a collection table, and if an
 * Employee changes departments none of the other Employee objects needs to change.    
 */

@Entity
public class Department {

	@Id private int id;
	private String name;
	
	@ElementCollection
	@CollectionTable(name="EMP_SENIORITY")
	@MapKeyJoinColumn(name="EMP_ID")
	@Column(name="SENIORITY")
	private Map<Employee,Integer>seniorities;
	
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




	public Map<Employee, Integer> getSeniorities() {
		return seniorities;
	}


	public void setSeniorities(Map<Employee, Integer> seniorities) {
		this.seniorities = seniorities;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", seniorities="
				+ seniorities + "]";
	}
}

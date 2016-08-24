package example.jpa;
/* Collections of embeddables and basic types are not relationships; they are simply collections of elements thus called as element collections.   
 * Elements that are stored in collections are not entities, so they do not have any mapped table. 
 * Embeddables are supposed to be stored in same table as of entity that refers to them, but if there is collection of embeddables it is not possible     
 * to store them in same entity table, due to multiplicity. for this reason element collections are stored in separate table called "Collection Table".
 */

import java.util.Collection;
import java.util.Set;


import javax.persistence.*;
@Entity
public class Employee {

	@Id private int id;
	private String name;
	private int salary;
	@ElementCollection
	private Collection<VacationEntry>vacationDetails;
	@ElementCollection
	private Set<String> nickNames;
	
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

	
	public Collection<VacationEntry> getVacationDetails() {
		return vacationDetails;
	}

	public void setVacationDetails(Collection<VacationEntry> vacationDetails) {
		this.vacationDetails = vacationDetails;
	}

	public Set<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(Set<String> nickNames) {
		this.nickNames = nickNames;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", nickNames="
				+ nickNames + ", salary=" + salary + ", vacationDetails="
				+ vacationDetails + "]";
	}
	
}

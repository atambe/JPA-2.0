package example.jpa;
/*When the keys are basic or embeddable types, they are stored directly in the table being referred to.
 * Depending upon type of mapping, it can be either target entity table, join table, or collection table. 
 * However when keys are entities, only the foreign keys are stored in the table because entities are stored in their own tables.
 * 
 * It is always the type of the value object in the Map that determines what kind of mapping must be used. If the values are entities, 
 * the Map must be mapped as a one-to-many or many-to-many relationship, whereas if the values of the Map are either embeddable or basic types,
 * the Map is mapped as element collection.
 * 
 * In this case as the value is basic type @ElementCollection annotation is used   
 */


import java.util.Map;

import javax.persistence.*;
@Entity
public class Employee {

	@Id private int id;
	private String name;
	private int salary;
	@ElementCollection
	@MapKeyColumn(name="Phone_Type")
	private Map<String , String> phoneNumbers;
	
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

	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phoneNumbers="
				+ phoneNumbers + ", salary=" + salary + "]";
	}
	
}

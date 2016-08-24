package example.jpa;
/* An embedded object is the one that is dependent on an entity of its identity. It has no identity of its own, but is stored as separate    
 * java object. In the database however, the state of the embedded object is stored with rest of the entity state in the database row. 
 * 
 */

import javax.persistence.*;
@Entity
public class Employee {

	@Id private int id;
	private String name;
	private int salary;
	@Embedded Address address;
	
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + ", id=" + id + ", name=" + name
				+ ", salary=" + salary + "]";
	}
	
}

package example.jpa;
/*As the 'Id' is auto-generated provider will put it while persisting the entity. Hence we should not set the Id   
 * property while trying to persist the entity. Not following this will result into error.
 * 
 * The catch here is as provider is going to pick the strategy, it needs to have some persistence resource 
 * to do this, e.g. if it chooses table based strategy it needs to create the table, if it chooses sequence 
 * based strategy it needs to create the sequence. The provider can't always rely on this as the connection 
 * it has acquired may not have adequate permissions. 
 * Hence it would be better to use other generation strategies.    
 */

import javax.persistence.*;
@Entity
public class Employee {

	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	private String name;
	private int salary;

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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}
	
}

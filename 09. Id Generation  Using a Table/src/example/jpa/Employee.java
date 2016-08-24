package example.jpa;
/*The most flexible and portable way to generate identifiers is to use database table.
 * The easiest way to use a table to generate identifiers is to simply specify the generation strategy to be TABLE
 * As generation strategy is indicated but no table is specified, the provider will assume a table of its own.
 * If schema generation is used, it will be created. Hibernate uses schema generation and creates its own sequence.  
 * 
 */
	
import javax.persistence.*;
@Entity
public class Employee {

	@Id @GeneratedValue(strategy=GenerationType.TABLE) 
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

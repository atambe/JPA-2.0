package example.jpa;
/*Some databases support primary key identity column, sometimes referred as 'autonumber' column.
 * Whenever a row is inserted into the table, the identity column will get a unique identifier.
 * Feature is available only if database supports 'autonumber' 
 *  
 *  Oracle dialect doesn't support this hence it would an error.
 */
	
import javax.persistence.*;
@Entity
public class Employee {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
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

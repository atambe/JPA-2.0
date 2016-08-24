package example.jpa;
/* Configuring the comments filed to be fetched lazily will allow an Employee instance returned from a query 
 * have the comments field.
 * 
 * Fetch attribute is not guaranteed to fetch the result in lazy manner. Provider may ignore it and can fetch the 
 * attribute in normal way.
 */

import javax.persistence.*;
@Entity
@Table(name="Emp")
@Access(AccessType.FIELD)
public final class Employee {

	@Id  
	@Column(name="KIN")
	public int id;
	private String name;
	private int salary;
	//@Column(name="comm")
	@Basic(fetch=FetchType.LAZY)
	private String comments; // putting 'comment' as column name results into error. 
							//Reason could be comment is one of the reserve words in SQL.
	@Transient private int phone;

	public Employee(){}

	public Employee(int id){
		this.id=id;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("setId called");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName called");
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		System.out.println("setSalary called");
		this.salary = salary;
	}

	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		System.out.println("setPhone called");
		this.phone = phone;
	}

	public String getComment() {

		return comments;
	}

	public void setComment(String comment) {
		System.out.println("setComment called");
		this.comments = comment;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", salary=" + salary + "]";
	}

}

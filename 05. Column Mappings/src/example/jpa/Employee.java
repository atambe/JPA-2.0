package example.jpa;


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
	@Transient private int phone;

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

	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", salary=" + salary + "]";
	}

}

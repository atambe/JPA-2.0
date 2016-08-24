package example.jpa;
/* Temporal types are the set of time based types. The list of supported types includes 3 java.sql types 
 * java.sql.Date, java.sql.Time, and java.sql.TimeStamp, and it includes 2 java.util types -
 * java.util.Date and java.util.Calendar
 * 
 * The java.util types need additional metadata, to map them to sql types. This is done using @Temporal annotation
 */

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
@Entity
public class Employee {

	@Id private int id;
	private String name;
	private int salary;
	
	@Temporal(TemporalType.DATE)
	private Calendar dob;
	
	private Date startDate;
	
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

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Employee [dob=" + dob + ", id=" + id + ", name=" + name
				+ ", salary=" + salary + ", startDate=" + startDate + "]";
	}
	
}

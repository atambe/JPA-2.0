package example.jpa;
import javax.persistence.*;
import java.util.List;
public class EmployeeService {

	protected EntityManager em;
	
	public EmployeeService(EntityManager em){
		this.em=em;
	}
	
	public Employee createEmployee(int id,String name,int salary){
		
		Employee emp = new Employee(id);
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}
	
	public void removeEmployee(int id){
		Employee emp = findEmployee(id);
		if(emp !=null){
			em.remove(emp);
		}
	}

	public Employee raiseEmployeeSalary(int id, int raise){
		Employee emp = findEmployee(id);
		if(emp !=null){
			emp.setSalary(emp.getSalary()+raise);
		}
		return emp;
	}
	
	public List<Employee> findAllEmployees(){
		TypedQuery<Employee> query = em.createQuery("Select e from Employee e",Employee.class);
		return query.getResultList();
		
	}
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return em.find(Employee.class, id);
	}
}

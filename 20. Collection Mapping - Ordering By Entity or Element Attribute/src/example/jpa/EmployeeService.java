package example.jpa;
import javax.persistence.*;
import java.util.List;
import java.util.Set;
public class EmployeeService {

	protected EntityManager em;
	
	public EmployeeService(EntityManager em){
		this.em=em;
	}
	
	public Employee createEmployee(int id,String name,int salary, Department department){
		
		Employee emp = new Employee(id);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDepartment(department);
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
	
	public List<Department> findAllDepartments(){
		TypedQuery<Department> query = em.createQuery("Select d from Department d", Department.class);
		return query.getResultList();
	}
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return em.find(Employee.class, id);
	}
	
	public Department createDepartment(int id, String name){
			Department dept = new Department(id,name);
			em.persist(dept);
			return dept;
	}

	public Department setEmployeesOnDepartment(int id, Set<Employee>employees){
		Department dept = findDepartment(id);
		dept.setEmployees(employees);
		em.persist(dept);
		return dept;
	}
	public Department findDepartment(int id){
			return em.find(Department.class, id);
	}
}

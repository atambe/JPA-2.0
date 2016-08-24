package example.jpa;



import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;


public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);
		em.getTransaction().begin();
		Department dept1 = service.createDepartment(1, "Timepass");
		Department dept2 = service.createDepartment(2, "Housekeeping");

		Employee emp2 = service.createEmployee(50949, "Renu", 90000, dept1);
		Employee emp1 = service.createEmployee(50970, "Sagar", 60000,dept1);
		Employee emp3 = service.createEmployee(50950, "Mrudula", 80000, dept2);
		
		dept1 = service.findDepartment(1);
		dept2 = service.findDepartment(2);
		Set<Employee> empList1 = new TreeSet<Employee>();
		empList1.add(emp1);
		empList1.add(emp2);
		
		Set<Employee> empList2 = new TreeSet<Employee>();
		empList2.add(emp3);
		
		service.setEmployeesOnDepartment(1, empList1);
		service.setEmployeesOnDepartment(2, empList2);
		
		em.flush();
		
		List<Department> deps = service.findAllDepartments();
		
		for(Department d : deps){
			System.out.println("Department Details :: "+d);
		}
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}

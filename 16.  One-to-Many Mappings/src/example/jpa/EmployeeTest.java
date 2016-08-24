package example.jpa;


import java.util.ArrayList;
import java.util.List;

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

		Employee emp1 = service.createEmployee(50948, "Sagar", 60000,dept1);
		em.getTransaction().commit();
		System.out.println("Persisted "+emp1);
		
		emp1= service.findEmployee(50948);
		System.out.println("Found "+emp1);
		
		em.getTransaction().begin();
		emp1 =service.raiseEmployeeSalary(50948, 20000);
		em.getTransaction().commit();
		System.out.println("Updated "+emp1);
		
		em.getTransaction().begin();
		Employee emp2 = service.createEmployee(50949, "Renu", 90000, dept1);
		Employee emp3 = service.createEmployee(50950, "Mrudula", 80000, dept2);
		
		dept1 = service.findDepartment(1);
		dept2 = service.findDepartment(2);
		List<Employee> empList1 = new ArrayList<Employee>();
		empList1.add(emp1);
		empList1.add(emp2);
		
		List<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(emp3);
		
		service.setEmployeesOnDepartment(1, empList1);
		service.setEmployeesOnDepartment(2, empList2);
		
		em.getTransaction().commit();
		
		List<Employee> emps = service.findAllEmployees();
		
		for(Employee e : emps){
			System.out.println("All employees :: "+e);
		}
		em.close();
		emf.close();
	}

}

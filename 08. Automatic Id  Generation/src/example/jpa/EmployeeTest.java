package example.jpa;


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
		Employee emp = service.createEmployee(50948, "Sagar", 60000);
		em.getTransaction().commit();
		System.out.println("Persisted "+emp);
		
		emp= service.findEmployee(50948);
		System.out.println("Found "+emp);
		
		em.getTransaction().begin();
		emp =service.raiseEmployeeSalary(50948, 20000);
		em.getTransaction().commit();
		System.out.println("Updated "+emp);
		
		em.getTransaction().begin();
		service.createEmployee(50949, "Renu", 50000);
		service.createEmployee(50950, "Mrudula", 90000);
		em.getTransaction().commit();
		
		List<Employee> emps = service.findAllEmployees();
		for(Employee e :emps){
			System.out.println("Found employee :: "+e);
		}
		em.close();
		emf.close();
	}

}

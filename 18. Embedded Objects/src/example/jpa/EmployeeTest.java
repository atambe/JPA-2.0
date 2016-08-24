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
		service.createEmployee(50948, "Sagar", 60000, new Address("D-10","Chintamani Resi","Pune","Maharashtra"));
		service.createEmployee(50949, "Renu", 100000, new Address("Flat #1","Todkar Resi","Mumbai","Maharashtra"));
		service.createEmployee(50950, "Mrudula", 70000, new Address("D-6","Sector 6","Kolhapur","Maharashtra"));
			
		em.getTransaction().commit();
		
		List<Employee> emps = service.findAllEmployees();
		
		for(Employee e : emps){
			System.out.println(e);
		}
		em.close();
		emf.close();
	}

}

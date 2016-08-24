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
		
		Department dept1 = service.createDepartment(1, "Timepass");
		Department dept2 = service.createDepartment(2, "Housekeeping");
		
		WorkStation ws1 = service.createWorkStation(1,"Unit-0");
		WorkStation ws2 = service.createWorkStation(2,"Unit-1");
		WorkStation ws3 = service.createWorkStation(3,"Unit-0");
		
		Employee emp = service.createEmployee(50948, "Sagar", 60000,dept1,ws1);
		em.getTransaction().commit();
		System.out.println("Persisted "+emp);
		
		emp= service.findEmployee(50948);
		System.out.println("Found "+emp);
		
		em.getTransaction().begin();
		emp =service.raiseEmployeeSalary(50948, 20000);
		em.getTransaction().commit();
		System.out.println("Updated "+emp);
		
		em.getTransaction().begin();
		service.createEmployee(50949, "Renu", 90000, dept1,ws2);
		service.createEmployee(50950, "Mrudula", 80000, dept2,ws3);
		
		service.setEmployeeOnWorkStation(1, service.findEmployee(50948));
		service.setEmployeeOnWorkStation(2, service.findEmployee(50949));
		service.setEmployeeOnWorkStation(3, service.findEmployee(50950));
		
		em.getTransaction().commit();
		
		List<Employee> emps = service.findAllEmployees();
		
		for(Employee e : emps){
			System.out.println("All employees :: "+e);
		}
		em.close();
		emf.close();
	}

}

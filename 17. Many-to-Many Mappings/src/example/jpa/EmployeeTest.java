package example.jpa;


import java.util.ArrayList;
import java.util.Collection;
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
		Project p1 = service.createProject(1,"Assurant");
		Project p2 = service.createProject(2,"Barklays");
		Project p3 = service.createProject(3,"HSBC");
		Collection<Project> projects1 = new ArrayList<Project>();
		projects1.add(p1);
		projects1.add(p2);
		
		Collection<Project> projects2 = new ArrayList<Project>();
		projects2.add(p2);
		projects2.add(p3);

		Collection<Project> projects3 = new ArrayList<Project>();
		projects3.add(p1);
		projects3.add(p2);
		projects3.add(p3);
		
		Employee emp1 = service.createEmployee(50948, "Sagar", 60000,projects1);
		Employee emp2 = service.createEmployee(50949, "Renu", 80000,projects2);
		Employee emp3 = service.createEmployee(50950, "Mrudula", 70000,projects3);
		
		Collection<Employee> employees1 = new ArrayList<Employee>();
		employees1.add(emp1);
		employees1.add(emp2);
		
		Collection<Employee> employees2 = new ArrayList<Employee>();
		employees1.add(emp2);
		employees1.add(emp3);
		
		Collection<Employee> employees3 = new ArrayList<Employee>();
		employees1.add(emp1);
		employees1.add(emp2);
		employees1.add(emp3);
		
		service.setEmployeesOnProject(1, employees1);
		service.setEmployeesOnProject(2, employees2);
		service.setEmployeesOnProject(3, employees3);
	
		em.getTransaction().commit();

		List<Employee> employees = service.findAllEmployees();
		
		for(Employee e : employees){
			System.out.println(e);
		}
		em.close();
		emf.close();
	}

}

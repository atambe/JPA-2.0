package example.jpa;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
			service.createEmployee(50948, "Sagar", 60000,new Department());
			service.createEmployee(50949, "Renu", 90000, new Department());
			service.createEmployee(50950, "Mrudula", 80000,new Department());
		em.getTransaction().commit();
		

		em.getTransaction().begin();
		
			Map<Integer,Employee> empMap1 = new Hashtable<Integer,Employee>();
			empMap1.put(50948, service.findEmployee(50948));
			empMap1.put(50949, service.findEmployee(50949));
			
			Map<Integer,Employee> empMap2 = new Hashtable<Integer,Employee>();
			empMap2.put(50950, service.findEmployee(50950));
	
			service.createDepartment(1, "Timepass", empMap1);
			service.createDepartment(2, "Housekeeping",empMap2);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
			service.setDepartmentOnEmployee(50948, service.findDepartment(1));
			service.setDepartmentOnEmployee(50949, service.findDepartment(1));
			service.setDepartmentOnEmployee(50950, service.findDepartment(2));
		em.getTransaction().commit();
		
		List<Employee> emps = service.findAllEmployees();
				for(Employee e : emps){
			System.out.println("All employees :: "+e);
		}
		
		List<Department> depts = service.findAllDepartments();
		
		for(Department d : depts){
			System.out.println("All departments :: "+d);
		}
		em.getTransaction().begin();
			service.raiseEmployeeSalary(50948, 10000);
		em.getTransaction().commit();
		em.close();
		emf.close();
		

	}

}

package example.jpa;

import java.util.HashMap;
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
		Map<String,String> phoneNumbers = new HashMap<String,String>();
		phoneNumbers.put("Home", "020-24283484");
		phoneNumbers.put("Work", "020-40102000");
		phoneNumbers.put("Mobile", "9850276767");
		service.createEmployee(50948, "Sagar", 60000, phoneNumbers);
		em.getTransaction().commit();
		Employee emp = service.findEmployee(50948);
		System.out.println(emp);
		
		em.close();
		emf.close();
	}

}

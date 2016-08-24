package example.jpa;


import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
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
		VacationEntry ve1 = new VacationEntry(new GregorianCalendar(2013, 5, 10),10);
		VacationEntry ve2 = new VacationEntry(new GregorianCalendar(2012, 10, 10),5);
		Collection<VacationEntry> ve = new ArrayList<VacationEntry>();
		ve.add(ve1);
		ve.add(ve2);
		
		Set<String> nickNames = new TreeSet<String>();
		nickNames.add("Sona");
		nickNames.add("Sakha");
		nickNames.add("Pillu");
		
		service.createEmployee(50948, "Renu", 60000,ve,nickNames);
		em.getTransaction().commit();

		Employee emp = service.findEmployee(50948);
		System.out.println(emp);
		
		em.close();
		emf.close();
	}

}

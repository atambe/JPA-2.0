package example.db.main;

import java.util.List;
/* Generate Oracle HR schema entities using reverse engineering tool MinuteProject.
 * Utility is simple. Don't select views for generating classes.
 * 
 * 
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import example.db.Departments;
import example.db.Employees;


public class TestDB {

	/**
	 * @param args
	 */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

	static private EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//runGettingStarted();
		//runFilteringResults();
		//runProjectingResults();
		//runJoinBetweenEntities();
		runAggregateQuery();
	}
	
	public static void runGettingStarted(){
		TypedQuery<Departments> query = em.createQuery("Select d from Departments d", Departments.class);
		List<Departments> depts = query.getResultList();

		for(Departments d : depts){

			System.out.println(d.getDepartmentId() + " "+d.getDepartmentName() );
		}
		
	}
	
	public static void runFilteringResults(){
		TypedQuery<Employees> query = em.createQuery("Select e from Employees e where e.firstName like 'S%'", Employees.class);
		List<Employees>emps = query.getResultList();
		
		for(Employees e : emps){
			System.out.println(e.getFirstName()+" "+e.getLastName());
		}
		
	}

	public static void runProjectingResults(){
		
		// Cannot have typed query for more than one result.
		
		Query query = em.createQuery("Select e.firstName,e.lastName from Employees e where e.firstName like 'S%' order by e.firstName");
		List emps = query.getResultList();
		
		for(Object e : emps){
			Object d[] = (Object[])e;
			System.out.println(d[0] +" "+d[1]);
		}
		
	}
	
	public static void runJoinBetweenEntities(){
		
		Query query = em.createQuery("select e.firstName,d.departmentName from Employees e, Departments d");
		List emps = query.getResultList();
		
		for(Object e : emps){
			Object d[] = (Object[])e;
			System.out.println(d[0] +" "+d[1]);
		}
		
	}
	
	public static void runAggregateQuery(){
		Query query = em.createQuery("select d.departmentId, MAX(e.salary) from Departments d join d.employeesDepartmentsViaDepartmentId e GROUP BY d.departmentId");
		List emps = query.getResultList();
		
		for(Object e : emps){
			Object d[] = (Object[])e;
			System.out.println(d[0] +" "+d[1]);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..");
		query = em.createQuery("select e.departmentId_, MAX(e.salary) from Employees e GROUP BY e.departmentId_");
		emps = query.getResultList();
		for(Object e : emps){
			Object d[] = (Object[])e;
			System.out.println(d[0] +" "+d[1]);
		}
		
	}
}




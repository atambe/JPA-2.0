/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2013/06/23 AD at 11:07:16 IST
*/
package example.db;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;

import example.db.Departments;
import example.db.Employees;
import example.db.JobHistory;
import example.db.Jobs;

/**
 *
 * <p>Title: Employees</p>
 *
 * <p>Description: Domain Object describing a Employees entity</p>
 *
 */
@Entity (name="Employees")
@Table (name="EMPLOYEES")
@NamedQueries({
	 @NamedQuery(name="Employees.findAll", query="SELECT employees FROM Employees employees")
	,@NamedQuery(name="Employees.findByFirstName", query="SELECT employees FROM Employees employees WHERE employees.firstName = :firstName")
	,@NamedQuery(name="Employees.findByFirstNameContaining", query="SELECT employees FROM Employees employees WHERE employees.firstName like :firstName")

	,@NamedQuery(name="Employees.findByLastName", query="SELECT employees FROM Employees employees WHERE employees.lastName = :lastName")
	,@NamedQuery(name="Employees.findByLastNameContaining", query="SELECT employees FROM Employees employees WHERE employees.lastName like :lastName")

	,@NamedQuery(name="Employees.findByEmail", query="SELECT employees FROM Employees employees WHERE employees.email = :email")
	,@NamedQuery(name="Employees.findByEmailContaining", query="SELECT employees FROM Employees employees WHERE employees.email like :email")

	,@NamedQuery(name="Employees.findByPhoneNumber", query="SELECT employees FROM Employees employees WHERE employees.phoneNumber = :phoneNumber")
	,@NamedQuery(name="Employees.findByPhoneNumberContaining", query="SELECT employees FROM Employees employees WHERE employees.phoneNumber like :phoneNumber")

	,@NamedQuery(name="Employees.findByHireDate", query="SELECT employees FROM Employees employees WHERE employees.hireDate = :hireDate")

	,@NamedQuery(name="Employees.findBySalary", query="SELECT employees FROM Employees employees WHERE employees.salary = :salary")

	,@NamedQuery(name="Employees.findByCommissionPct", query="SELECT employees FROM Employees employees WHERE employees.commissionPct = :commissionPct")

})

public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Employees.findAll";
    public static final String FIND_BY_FIRSTNAME = "Employees.findByFirstName";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="Employees.findByFirstNameContaining";
    public static final String FIND_BY_LASTNAME = "Employees.findByLastName";
    public static final String FIND_BY_LASTNAME_CONTAINING ="Employees.findByLastNameContaining";
    public static final String FIND_BY_EMAIL = "Employees.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING ="Employees.findByEmailContaining";
    public static final String FIND_BY_PHONENUMBER = "Employees.findByPhoneNumber";
    public static final String FIND_BY_PHONENUMBER_CONTAINING ="Employees.findByPhoneNumberContaining";
    public static final String FIND_BY_HIREDATE = "Employees.findByHireDate";
    public static final String FIND_BY_SALARY = "Employees.findBySalary";
    public static final String FIND_BY_COMMISSIONPCT = "Employees.findByCommissionPct";
	
    @SequenceGenerator(name = "EMPLOYEESSEQ", sequenceName ="", allocationSize=1 )
    @Id @Column(name="EMPLOYEE_ID" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMPLOYEESSEQ") 
    private Long employeeId;

//MP-MANAGED-ADDED-AREA-BEGINNING @FIRST_NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @FIRST_NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-FIRST_NAME@
    @Column(name="FIRST_NAME"  , length=20 , nullable=true , unique=false)
    private String firstName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @LAST_NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @LAST_NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-LAST_NAME@
    @Column(name="LAST_NAME"  , length=25 , nullable=false , unique=false)
    private String lastName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @EMAIL-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @EMAIL-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-EMAIL@
    @Column(name="EMAIL"  , length=25 , nullable=false , unique=false)
    private String email; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @PHONE_NUMBER-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @PHONE_NUMBER-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-PHONE_NUMBER@
    @Column(name="PHONE_NUMBER"  , length=20 , nullable=true , unique=false)
    private String phoneNumber; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @HIRE_DATE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @HIRE_DATE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-HIRE_DATE@
    @Column(name="HIRE_DATE"   , nullable=false , unique=false)
    private Date hireDate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @SALARY-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @SALARY-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-SALARY@
    @Column(name="SALARY"   , nullable=true , unique=false)
    private java.math.BigDecimal salary; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @COMMISSION_PCT-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @COMMISSION_PCT-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-COMMISSION_PCT@
    @Column(name="COMMISSION_PCT"   , nullable=true , unique=false)
    private java.math.BigDecimal commissionPct; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Departments departmentId;  

    @Column(name="DEPARTMENT_ID"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Long departmentId_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="MANAGER_ID", referencedColumnName = "EMPLOYEE_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Employees managerId;  

    @Column(name="MANAGER_ID"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Long managerId_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="JOB_ID", referencedColumnName = "JOB_ID" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Jobs jobId;  

    @Column(name="JOB_ID" , length=10 , nullable=false , unique=true, insertable=false, updatable=false)
    private String jobId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @departmentsEmployeesViaManagerId-field-EMPLOYEES@
    @OneToMany (targetEntity=example.db.Departments.class, fetch=FetchType.LAZY, mappedBy="managerId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Departments> departmentsEmployeesViaManagerId = new HashSet<Departments>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeesEmployeesViaManagerId-field-EMPLOYEES@
    @OneToMany (targetEntity=example.db.Employees.class, fetch=FetchType.LAZY, mappedBy="managerId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Employees> employeesEmployeesViaManagerId = new HashSet<Employees>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @jobHistoryEmployeesViaEmployeeId-field-EMPLOYEES@
    @OneToMany (targetEntity=example.db.JobHistory.class, fetch=FetchType.LAZY, mappedBy="employeeId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <JobHistory> jobHistoryEmployeesViaEmployeeId = new HashSet<JobHistory>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Employees() {
    }

	/**
	* All field constructor 
	*/
    public Employees(
       Long employeeId,
       String firstName,
       String lastName,
       String email,
       String phoneNumber,
       Date hireDate,
       String jobId,
       java.math.BigDecimal salary,
       java.math.BigDecimal commissionPct,
       Long managerId,
       Long departmentId) {
       //primary keys
       setEmployeeId (employeeId);
       //attributes
       setFirstName (firstName);
       setLastName (lastName);
       setEmail (email);
       setPhoneNumber (phoneNumber);
       setHireDate (hireDate);
       setSalary (salary);
       setCommissionPct (commissionPct);
       //parents
       this.departmentId = new Departments();
       this.departmentId.setDepartmentId(departmentId); //DEPARTMENT_ID
	   setDepartmentId_ (departmentId);
       this.managerId = new Employees();
       this.managerId.setEmployeeId(managerId); //EMPLOYEE_ID
	   setManagerId_ (managerId);
       this.jobId = new Jobs();
       this.jobId.setJobId(jobId); //JOB_ID
	   setJobId_ (jobId);
    }

	public Employees flat() {
	   return new Employees(
          getEmployeeId(),
          getFirstName(),
          getLastName(),
          getEmail(),
          getPhoneNumber(),
          getHireDate(),
          getJobId_(),
          getSalary(),
          getCommissionPct(),
          getManagerId_(),
          getDepartmentId_()
	   );
	}

    public Long getEmployeeId() {
        return employeeId;
    }
	
    public void setEmployeeId (Long employeeId) {
        this.employeeId =  employeeId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-FIRST_NAME@
    public String getFirstName() {
        return firstName;
    }
	
    public void setFirstName (String firstName) {
        this.firstName =  firstName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-LAST_NAME@
    public String getLastName() {
        return lastName;
    }
	
    public void setLastName (String lastName) {
        this.lastName =  lastName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-EMAIL@
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-PHONE_NUMBER@
    public String getPhoneNumber() {
        return phoneNumber;
    }
	
    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber =  phoneNumber;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-HIRE_DATE@
    public Date getHireDate() {
        return hireDate;
    }
	
    public void setHireDate (Date hireDate) {
        this.hireDate =  hireDate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-SALARY@
    public java.math.BigDecimal getSalary() {
        return salary;
    }
	
    public void setSalary (java.math.BigDecimal salary) {
        this.salary =  salary;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-COMMISSION_PCT@
    public java.math.BigDecimal getCommissionPct() {
        return commissionPct;
    }
	
    public void setCommissionPct (java.math.BigDecimal commissionPct) {
        this.commissionPct =  commissionPct;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Departments getDepartmentId () {
    	return departmentId;
    }
	
    public void setDepartmentId (Departments departmentId) {
    	this.departmentId = departmentId;
    }

    public Long getDepartmentId_() {
        return departmentId_;
    }
	
    public void setDepartmentId_ (Long departmentId) {
        this.departmentId_ =  departmentId;
    }
	
    public Employees getManagerId () {
    	return managerId;
    }
	
    public void setManagerId (Employees managerId) {
    	this.managerId = managerId;
    }

    public Long getManagerId_() {
        return managerId_;
    }
	
    public void setManagerId_ (Long managerId) {
        this.managerId_ =  managerId;
    }
	
    public Jobs getJobId () {
    	return jobId;
    }
	
    public void setJobId (Jobs jobId) {
    	this.jobId = jobId;
    }

    public String getJobId_() {
        return jobId_;
    }
	
    public void setJobId_ (String jobId) {
        this.jobId_ =  jobId;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @departmentsEmployeesViaManagerId-getter-EMPLOYEES@
    public Set<Departments> getDepartmentsEmployeesViaManagerId() {
        if (departmentsEmployeesViaManagerId == null){
            departmentsEmployeesViaManagerId = new HashSet<Departments>();
        }
        return departmentsEmployeesViaManagerId;
    }

    public void setDepartmentsEmployeesViaManagerId (Set<Departments> departmentsEmployeesViaManagerId) {
        this.departmentsEmployeesViaManagerId = departmentsEmployeesViaManagerId;
    }	
    
    public void addDepartmentsEmployeesViaManagerId (Departments departments) {
    	    getDepartmentsEmployeesViaManagerId().add(departments);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeesEmployeesViaManagerId-getter-EMPLOYEES@
    public Set<Employees> getEmployeesEmployeesViaManagerId() {
        if (employeesEmployeesViaManagerId == null){
            employeesEmployeesViaManagerId = new HashSet<Employees>();
        }
        return employeesEmployeesViaManagerId;
    }

    public void setEmployeesEmployeesViaManagerId (Set<Employees> employeesEmployeesViaManagerId) {
        this.employeesEmployeesViaManagerId = employeesEmployeesViaManagerId;
    }	
    
    public void addEmployeesEmployeesViaManagerId (Employees employees) {
    	    getEmployeesEmployeesViaManagerId().add(employees);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @jobHistoryEmployeesViaEmployeeId-getter-EMPLOYEES@
    public Set<JobHistory> getJobHistoryEmployeesViaEmployeeId() {
        if (jobHistoryEmployeesViaEmployeeId == null){
            jobHistoryEmployeesViaEmployeeId = new HashSet<JobHistory>();
        }
        return jobHistoryEmployeesViaEmployeeId;
    }

    public void setJobHistoryEmployeesViaEmployeeId (Set<JobHistory> jobHistoryEmployeesViaEmployeeId) {
        this.jobHistoryEmployeesViaEmployeeId = jobHistoryEmployeesViaEmployeeId;
    }	
    
    public void addJobHistoryEmployeesViaEmployeeId (JobHistory jobhistory) {
    	    getJobHistoryEmployeesViaEmployeeId().add(jobhistory);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

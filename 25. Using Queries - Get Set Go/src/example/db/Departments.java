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

import example.db.Employees;
import example.db.JobHistory;
import example.db.Locations;

/**
 *
 * <p>Title: Departments</p>
 *
 * <p>Description: Domain Object describing a Departments entity</p>
 *
 */
@Entity (name="Departments")
@Table (name="DEPARTMENTS")
@NamedQueries({
	 @NamedQuery(name="Departments.findAll", query="SELECT departments FROM Departments departments")
	,@NamedQuery(name="Departments.findByDepartmentName", query="SELECT departments FROM Departments departments WHERE departments.departmentName = :departmentName")
	,@NamedQuery(name="Departments.findByDepartmentNameContaining", query="SELECT departments FROM Departments departments WHERE departments.departmentName like :departmentName")

})

public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Departments.findAll";
    public static final String FIND_BY_DEPARTMENTNAME = "Departments.findByDepartmentName";
    public static final String FIND_BY_DEPARTMENTNAME_CONTAINING ="Departments.findByDepartmentNameContaining";
	
    @SequenceGenerator(name = "DEPARTMENTSSEQ", sequenceName ="", allocationSize=1 )
    @Id @Column(name="DEPARTMENT_ID" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPARTMENTSSEQ") 
    private Long departmentId;

//MP-MANAGED-ADDED-AREA-BEGINNING @DEPARTMENT_NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @DEPARTMENT_NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-DEPARTMENT_NAME@
    @Column(name="DEPARTMENT_NAME"  , length=30 , nullable=false , unique=false)
    private String departmentName; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="MANAGER_ID", referencedColumnName = "EMPLOYEE_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Employees managerId;  

    @Column(name="MANAGER_ID"  , nullable=true , unique=false, insertable=false, updatable=false)
    private Long managerId_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="LOCATION_ID", referencedColumnName = "LOCATION_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Locations locationId;  

    @Column(name="LOCATION_ID"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Long locationId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeesDepartmentsViaDepartmentId-field-DEPARTMENTS@
    @OneToMany (targetEntity=example.db.Employees.class, fetch=FetchType.LAZY, mappedBy="departmentId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Employees> employeesDepartmentsViaDepartmentId = new HashSet<Employees>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @jobHistoryDepartmentsViaDepartmentId-field-DEPARTMENTS@
    @OneToMany (targetEntity=example.db.JobHistory.class, fetch=FetchType.LAZY, mappedBy="departmentId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <JobHistory> jobHistoryDepartmentsViaDepartmentId = new HashSet<JobHistory>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Departments() {
    }

	/**
	* All field constructor 
	*/
    public Departments(
       Long departmentId,
       String departmentName,
       Long managerId,
       Long locationId) {
       //primary keys
       setDepartmentId (departmentId);
       //attributes
       setDepartmentName (departmentName);
       //parents
       this.managerId = new Employees();
       this.managerId.setEmployeeId(managerId); //EMPLOYEE_ID
	   setManagerId_ (managerId);
       this.locationId = new Locations();
       this.locationId.setLocationId(locationId); //LOCATION_ID
	   setLocationId_ (locationId);
    }

	public Departments flat() {
	   return new Departments(
          getDepartmentId(),
          getDepartmentName(),
          getManagerId_(),
          getLocationId_()
	   );
	}

    public Long getDepartmentId() {
        return departmentId;
    }
	
    public void setDepartmentId (Long departmentId) {
        this.departmentId =  departmentId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-DEPARTMENT_NAME@
    public String getDepartmentName() {
        return departmentName;
    }
	
    public void setDepartmentName (String departmentName) {
        this.departmentName =  departmentName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


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
	
    public Locations getLocationId () {
    	return locationId;
    }
	
    public void setLocationId (Locations locationId) {
    	this.locationId = locationId;
    }

    public Long getLocationId_() {
        return locationId_;
    }
	
    public void setLocationId_ (Long locationId) {
        this.locationId_ =  locationId;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeesDepartmentsViaDepartmentId-getter-DEPARTMENTS@
    public Set<Employees> getEmployeesDepartmentsViaDepartmentId() {
        if (employeesDepartmentsViaDepartmentId == null){
            employeesDepartmentsViaDepartmentId = new HashSet<Employees>();
        }
        return employeesDepartmentsViaDepartmentId;
    }

    public void setEmployeesDepartmentsViaDepartmentId (Set<Employees> employeesDepartmentsViaDepartmentId) {
        this.employeesDepartmentsViaDepartmentId = employeesDepartmentsViaDepartmentId;
    }	
    
    public void addEmployeesDepartmentsViaDepartmentId (Employees employees) {
    	    getEmployeesDepartmentsViaDepartmentId().add(employees);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @jobHistoryDepartmentsViaDepartmentId-getter-DEPARTMENTS@
    public Set<JobHistory> getJobHistoryDepartmentsViaDepartmentId() {
        if (jobHistoryDepartmentsViaDepartmentId == null){
            jobHistoryDepartmentsViaDepartmentId = new HashSet<JobHistory>();
        }
        return jobHistoryDepartmentsViaDepartmentId;
    }

    public void setJobHistoryDepartmentsViaDepartmentId (Set<JobHistory> jobHistoryDepartmentsViaDepartmentId) {
        this.jobHistoryDepartmentsViaDepartmentId = jobHistoryDepartmentsViaDepartmentId;
    }	
    
    public void addJobHistoryDepartmentsViaDepartmentId (JobHistory jobhistory) {
    	    getJobHistoryDepartmentsViaDepartmentId().add(jobhistory);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

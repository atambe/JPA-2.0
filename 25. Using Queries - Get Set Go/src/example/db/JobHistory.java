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
import example.db.JobHistoryId;
import example.db.Jobs;

/**
 *
 * <p>Title: JobHistory</p>
 *
 * <p>Description: Domain Object describing a JobHistory entity</p>
 *
 */
@Entity (name="JobHistory")
@Table (name="JOB_HISTORY")
@NamedQueries({
	 @NamedQuery(name="JobHistory.findAll", query="SELECT jobhistory FROM JobHistory jobhistory")
	,@NamedQuery(name="JobHistory.findByEndDate", query="SELECT jobhistory FROM JobHistory jobhistory WHERE jobhistory.endDate = :endDate")

})

public class JobHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "JobHistory.findAll";
    public static final String FIND_BY_ENDDATE = "JobHistory.findByEndDate";
	
    @EmbeddedId
    private JobHistoryId jobHistoryId;
    @Column(name="START_DATE"  , nullable=false , unique=false , insertable=false, updatable=false)
    private Date startDate_;
//MP-MANAGED-ADDED-AREA-BEGINNING @END_DATE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @END_DATE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-END_DATE@
    @Column(name="END_DATE"   , nullable=false , unique=false)
    private Date endDate; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Departments departmentId;  

    @Column(name="DEPARTMENT_ID"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Long departmentId_;

    @MapsId ("EMPLOYEE_ID")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Employees employeeId;  

    @Column(name="EMPLOYEE_ID"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Long employeeId_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="JOB_ID", referencedColumnName = "JOB_ID" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Jobs jobId;  

    @Column(name="JOB_ID" , length=10 , nullable=false , unique=true, insertable=false, updatable=false)
    private String jobId_;

    /**
    * Default constructor
    */
    public JobHistory() {
    }

	/**
	* All field constructor 
	*/
    public JobHistory(
       Long employeeId,
       Date startDate,
       Date endDate,
       String jobId,
       Long departmentId) {
       //primary keys
       this.jobHistoryId = new JobHistoryId();  	
       this.jobHistoryId.setStartDate (startDate);
       //attributes
       setEndDate (endDate);
       //parents
       this.departmentId = new Departments();
       this.departmentId.setDepartmentId(departmentId); //DEPARTMENT_ID
	   setDepartmentId_ (departmentId);
       this.employeeId = new Employees();
       this.employeeId.setEmployeeId(employeeId); //EMPLOYEE_ID
	   setEmployeeId_ (employeeId);
       this.jobId = new Jobs();
       this.jobId.setJobId(jobId); //JOB_ID
	   setJobId_ (jobId);
    }

	public JobHistory flat() {
	   return new JobHistory(
		  getJobHistoryId().getEmployeeId(),
		  getJobHistoryId().getStartDate(),
          getEndDate(),
          getJobId_(),
          getDepartmentId_()
	   );
	}

    public JobHistoryId getJobHistoryId() {
		if (jobHistoryId==null) jobHistoryId = new JobHistoryId();
        return jobHistoryId;
    }
	
    public void setJobHistoryId (JobHistoryId jobHistoryId) {
        this.jobHistoryId =  jobHistoryId;
    }
    public Date getStartDate_() {
        return startDate_;
    }
	
    public void setStartDate_ (Date startDate) {
        this.startDate_ =  startDate_;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-END_DATE@
    public Date getEndDate() {
        return endDate;
    }
	
    public void setEndDate (Date endDate) {
        this.endDate =  endDate;
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
	
    public Employees getEmployeeId () {
    	return employeeId;
    }
	
    public void setEmployeeId (Employees employeeId) {
    	this.employeeId = employeeId;
    }

    public Long getEmployeeId_() {
        return employeeId_;
    }
	
    public void setEmployeeId_ (Long employeeId) {
        this.employeeId_ =  employeeId;
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
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

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

/**
 *
 * <p>Title: Jobs</p>
 *
 * <p>Description: Domain Object describing a Jobs entity</p>
 *
 */
@Entity (name="Jobs")
@Table (name="JOBS")
@NamedQueries({
	 @NamedQuery(name="Jobs.findAll", query="SELECT jobs FROM Jobs jobs")
	,@NamedQuery(name="Jobs.findByJobTitle", query="SELECT jobs FROM Jobs jobs WHERE jobs.jobTitle = :jobTitle")
	,@NamedQuery(name="Jobs.findByJobTitleContaining", query="SELECT jobs FROM Jobs jobs WHERE jobs.jobTitle like :jobTitle")

	,@NamedQuery(name="Jobs.findByMinSalary", query="SELECT jobs FROM Jobs jobs WHERE jobs.minSalary = :minSalary")

	,@NamedQuery(name="Jobs.findByMaxSalary", query="SELECT jobs FROM Jobs jobs WHERE jobs.maxSalary = :maxSalary")

})

public class Jobs implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Jobs.findAll";
    public static final String FIND_BY_JOBTITLE = "Jobs.findByJobTitle";
    public static final String FIND_BY_JOBTITLE_CONTAINING ="Jobs.findByJobTitleContaining";
    public static final String FIND_BY_MINSALARY = "Jobs.findByMinSalary";
    public static final String FIND_BY_MAXSALARY = "Jobs.findByMaxSalary";
	
    @Id @Column(name="JOB_ID" ,length=10)
    private String jobId;

//MP-MANAGED-ADDED-AREA-BEGINNING @JOB_TITLE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @JOB_TITLE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-JOB_TITLE@
    @Column(name="JOB_TITLE"  , length=35 , nullable=false , unique=false)
    private String jobTitle; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @MIN_SALARY-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @MIN_SALARY-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-MIN_SALARY@
    @Column(name="MIN_SALARY"   , nullable=true , unique=false)
    private Long minSalary; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @MAX_SALARY-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @MAX_SALARY-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-MAX_SALARY@
    @Column(name="MAX_SALARY"   , nullable=true , unique=false)
    private Long maxSalary; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeesJobsViaJobId-field-JOBS@
    @OneToMany (targetEntity=example.db.Employees.class, fetch=FetchType.LAZY, mappedBy="jobId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Employees> employeesJobsViaJobId = new HashSet<Employees>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @jobHistoryJobsViaJobId-field-JOBS@
    @OneToMany (targetEntity=example.db.JobHistory.class, fetch=FetchType.LAZY, mappedBy="jobId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <JobHistory> jobHistoryJobsViaJobId = new HashSet<JobHistory>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Jobs() {
    }

	/**
	* All field constructor 
	*/
    public Jobs(
       String jobId,
       String jobTitle,
       Long minSalary,
       Long maxSalary) {
       //primary keys
       setJobId (jobId);
       //attributes
       setJobTitle (jobTitle);
       setMinSalary (minSalary);
       setMaxSalary (maxSalary);
       //parents
    }

	public Jobs flat() {
	   return new Jobs(
          getJobId(),
          getJobTitle(),
          getMinSalary(),
          getMaxSalary()
	   );
	}

    public String getJobId() {
        return jobId;
    }
	
    public void setJobId (String jobId) {
        this.jobId =  jobId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-JOB_TITLE@
    public String getJobTitle() {
        return jobTitle;
    }
	
    public void setJobTitle (String jobTitle) {
        this.jobTitle =  jobTitle;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-MIN_SALARY@
    public Long getMinSalary() {
        return minSalary;
    }
	
    public void setMinSalary (Long minSalary) {
        this.minSalary =  minSalary;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-MAX_SALARY@
    public Long getMaxSalary() {
        return maxSalary;
    }
	
    public void setMaxSalary (Long maxSalary) {
        this.maxSalary =  maxSalary;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeesJobsViaJobId-getter-JOBS@
    public Set<Employees> getEmployeesJobsViaJobId() {
        if (employeesJobsViaJobId == null){
            employeesJobsViaJobId = new HashSet<Employees>();
        }
        return employeesJobsViaJobId;
    }

    public void setEmployeesJobsViaJobId (Set<Employees> employeesJobsViaJobId) {
        this.employeesJobsViaJobId = employeesJobsViaJobId;
    }	
    
    public void addEmployeesJobsViaJobId (Employees employees) {
    	    getEmployeesJobsViaJobId().add(employees);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @jobHistoryJobsViaJobId-getter-JOBS@
    public Set<JobHistory> getJobHistoryJobsViaJobId() {
        if (jobHistoryJobsViaJobId == null){
            jobHistoryJobsViaJobId = new HashSet<JobHistory>();
        }
        return jobHistoryJobsViaJobId;
    }

    public void setJobHistoryJobsViaJobId (Set<JobHistory> jobHistoryJobsViaJobId) {
        this.jobHistoryJobsViaJobId = jobHistoryJobsViaJobId;
    }	
    
    public void addJobHistoryJobsViaJobId (JobHistory jobhistory) {
    	    getJobHistoryJobsViaJobId().add(jobhistory);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

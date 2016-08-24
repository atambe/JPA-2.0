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
	* - name      : DomainEntityJPA2EmbeddedId
	* - file name : DomainEntityJPA2EmbeddedId.vm
	* - time      : 2013/06/23 AD at 11:07:16 IST
*/
package example.db;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

/**
 *
 * <p>Title: JobHistoryId</p>
 *
 * <p>Description: Embedded Id describing a JobHistoryId entity primary key</p>
 *
 */
@Embeddable
public class JobHistoryId implements Serializable {


    @Column(name="EMPLOYEE_ID"  ,nullable=false)
    private Long employeeId;

    @Column(name="START_DATE"  ,nullable=false)
    private Date startDate;

	public Long getEmployeeId() {
        return employeeId;
    }
	
    public void setEmployeeId (Long employeeId) {
        this.employeeId = employeeId;
    }

	public Date getStartDate() {
        return startDate;
    }
	
    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return obj.toString().equals(this.toString());
    }
 
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
 
    @Override
    public String toString() {
        return "JobHistoryId:" 
        + ":" + startDate
        + ":" + employeeId
        ;
    }
    
}

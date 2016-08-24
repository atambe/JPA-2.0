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

import example.db.Countries;

/**
 *
 * <p>Title: Regions</p>
 *
 * <p>Description: Domain Object describing a Regions entity</p>
 *
 */
@Entity (name="Regions")
@Table (name="REGIONS")
@NamedQueries({
	 @NamedQuery(name="Regions.findAll", query="SELECT regions FROM Regions regions")
	,@NamedQuery(name="Regions.findByRegionName", query="SELECT regions FROM Regions regions WHERE regions.regionName = :regionName")
	,@NamedQuery(name="Regions.findByRegionNameContaining", query="SELECT regions FROM Regions regions WHERE regions.regionName like :regionName")

})

public class Regions implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Regions.findAll";
    public static final String FIND_BY_REGIONNAME = "Regions.findByRegionName";
    public static final String FIND_BY_REGIONNAME_CONTAINING ="Regions.findByRegionNameContaining";
	
    @SequenceGenerator(name = "REGIONSSEQ", sequenceName ="", allocationSize=1 )
    @Id @Column(name="REGION_ID" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="REGIONSSEQ") 
    private Integer regionId;

//MP-MANAGED-ADDED-AREA-BEGINNING @REGION_NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @REGION_NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-REGION_NAME@
    @Column(name="REGION_NAME"  , length=25 , nullable=true , unique=false)
    private String regionName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @countriesRegionsViaRegionId-field-REGIONS@
    @OneToMany (targetEntity=example.db.Countries.class, fetch=FetchType.LAZY, mappedBy="regionId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Countries> countriesRegionsViaRegionId = new HashSet<Countries>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Regions() {
    }

	/**
	* All field constructor 
	*/
    public Regions(
       Integer regionId,
       String regionName) {
       //primary keys
       setRegionId (regionId);
       //attributes
       setRegionName (regionName);
       //parents
    }

	public Regions flat() {
	   return new Regions(
          getRegionId(),
          getRegionName()
	   );
	}

    public Integer getRegionId() {
        return regionId;
    }
	
    public void setRegionId (Integer regionId) {
        this.regionId =  regionId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-REGION_NAME@
    public String getRegionName() {
        return regionName;
    }
	
    public void setRegionName (String regionName) {
        this.regionName =  regionName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @countriesRegionsViaRegionId-getter-REGIONS@
    public Set<Countries> getCountriesRegionsViaRegionId() {
        if (countriesRegionsViaRegionId == null){
            countriesRegionsViaRegionId = new HashSet<Countries>();
        }
        return countriesRegionsViaRegionId;
    }

    public void setCountriesRegionsViaRegionId (Set<Countries> countriesRegionsViaRegionId) {
        this.countriesRegionsViaRegionId = countriesRegionsViaRegionId;
    }	
    
    public void addCountriesRegionsViaRegionId (Countries countries) {
    	    getCountriesRegionsViaRegionId().add(countries);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

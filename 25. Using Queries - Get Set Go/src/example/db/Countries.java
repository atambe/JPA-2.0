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
	* - time      : 2013/06/23 AD at 11:07:15 IST
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

import example.db.Locations;
import example.db.Regions;

/**
 *
 * <p>Title: Countries</p>
 *
 * <p>Description: Domain Object describing a Countries entity</p>
 *
 */
@Entity (name="Countries")
@Table (name="COUNTRIES")
@NamedQueries({
	 @NamedQuery(name="Countries.findAll", query="SELECT countries FROM Countries countries")
	,@NamedQuery(name="Countries.findByCountryName", query="SELECT countries FROM Countries countries WHERE countries.countryName = :countryName")
	,@NamedQuery(name="Countries.findByCountryNameContaining", query="SELECT countries FROM Countries countries WHERE countries.countryName like :countryName")

})

public class Countries implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Countries.findAll";
    public static final String FIND_BY_COUNTRYNAME = "Countries.findByCountryName";
    public static final String FIND_BY_COUNTRYNAME_CONTAINING ="Countries.findByCountryNameContaining";
	
    @Id @Column(name="COUNTRY_ID" ,length=2)
    private String countryId;

//MP-MANAGED-ADDED-AREA-BEGINNING @COUNTRY_NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @COUNTRY_NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-COUNTRY_NAME@
    @Column(name="COUNTRY_NAME"  , length=40 , nullable=true , unique=false)
    private String countryName; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="REGION_ID", referencedColumnName = "REGION_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Regions regionId;  

    @Column(name="REGION_ID"  , nullable=true , unique=false, insertable=false, updatable=false)
    private Integer regionId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @locationsCountriesViaCountryId-field-COUNTRIES@
    @OneToMany (targetEntity=example.db.Locations.class, fetch=FetchType.LAZY, mappedBy="countryId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Locations> locationsCountriesViaCountryId = new HashSet<Locations>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Countries() {
    }

	/**
	* All field constructor 
	*/
    public Countries(
       String countryId,
       String countryName,
       Integer regionId) {
       //primary keys
       setCountryId (countryId);
       //attributes
       setCountryName (countryName);
       //parents
       this.regionId = new Regions();
       this.regionId.setRegionId(regionId); //REGION_ID
	   setRegionId_ (regionId);
    }

	public Countries flat() {
	   return new Countries(
          getCountryId(),
          getCountryName(),
          getRegionId_()
	   );
	}

    public String getCountryId() {
        return countryId;
    }
	
    public void setCountryId (String countryId) {
        this.countryId =  countryId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-COUNTRY_NAME@
    public String getCountryName() {
        return countryName;
    }
	
    public void setCountryName (String countryName) {
        this.countryName =  countryName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Regions getRegionId () {
    	return regionId;
    }
	
    public void setRegionId (Regions regionId) {
    	this.regionId = regionId;
    }

    public Integer getRegionId_() {
        return regionId_;
    }
	
    public void setRegionId_ (Integer regionId) {
        this.regionId_ =  regionId;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @locationsCountriesViaCountryId-getter-COUNTRIES@
    public Set<Locations> getLocationsCountriesViaCountryId() {
        if (locationsCountriesViaCountryId == null){
            locationsCountriesViaCountryId = new HashSet<Locations>();
        }
        return locationsCountriesViaCountryId;
    }

    public void setLocationsCountriesViaCountryId (Set<Locations> locationsCountriesViaCountryId) {
        this.locationsCountriesViaCountryId = locationsCountriesViaCountryId;
    }	
    
    public void addLocationsCountriesViaCountryId (Locations locations) {
    	    getLocationsCountriesViaCountryId().add(locations);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

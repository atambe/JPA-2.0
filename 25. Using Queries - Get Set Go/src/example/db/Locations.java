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
import example.db.Departments;

/**
 *
 * <p>Title: Locations</p>
 *
 * <p>Description: Domain Object describing a Locations entity</p>
 *
 */
@Entity (name="Locations")
@Table (name="LOCATIONS")
@NamedQueries({
	 @NamedQuery(name="Locations.findAll", query="SELECT locations FROM Locations locations")
	,@NamedQuery(name="Locations.findByStreetAddress", query="SELECT locations FROM Locations locations WHERE locations.streetAddress = :streetAddress")
	,@NamedQuery(name="Locations.findByStreetAddressContaining", query="SELECT locations FROM Locations locations WHERE locations.streetAddress like :streetAddress")

	,@NamedQuery(name="Locations.findByPostalCode", query="SELECT locations FROM Locations locations WHERE locations.postalCode = :postalCode")
	,@NamedQuery(name="Locations.findByPostalCodeContaining", query="SELECT locations FROM Locations locations WHERE locations.postalCode like :postalCode")

	,@NamedQuery(name="Locations.findByCity", query="SELECT locations FROM Locations locations WHERE locations.city = :city")
	,@NamedQuery(name="Locations.findByCityContaining", query="SELECT locations FROM Locations locations WHERE locations.city like :city")

	,@NamedQuery(name="Locations.findByStateProvince", query="SELECT locations FROM Locations locations WHERE locations.stateProvince = :stateProvince")
	,@NamedQuery(name="Locations.findByStateProvinceContaining", query="SELECT locations FROM Locations locations WHERE locations.stateProvince like :stateProvince")

})

public class Locations implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Locations.findAll";
    public static final String FIND_BY_STREETADDRESS = "Locations.findByStreetAddress";
    public static final String FIND_BY_STREETADDRESS_CONTAINING ="Locations.findByStreetAddressContaining";
    public static final String FIND_BY_POSTALCODE = "Locations.findByPostalCode";
    public static final String FIND_BY_POSTALCODE_CONTAINING ="Locations.findByPostalCodeContaining";
    public static final String FIND_BY_CITY = "Locations.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="Locations.findByCityContaining";
    public static final String FIND_BY_STATEPROVINCE = "Locations.findByStateProvince";
    public static final String FIND_BY_STATEPROVINCE_CONTAINING ="Locations.findByStateProvinceContaining";
	
    @SequenceGenerator(name = "LOCATIONSSEQ", sequenceName ="", allocationSize=1 )
    @Id @Column(name="LOCATION_ID" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LOCATIONSSEQ") 
    private Long locationId;

//MP-MANAGED-ADDED-AREA-BEGINNING @STREET_ADDRESS-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @STREET_ADDRESS-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-STREET_ADDRESS@
    @Column(name="STREET_ADDRESS"  , length=40 , nullable=true , unique=false)
    private String streetAddress; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @POSTAL_CODE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @POSTAL_CODE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-POSTAL_CODE@
    @Column(name="POSTAL_CODE"  , length=12 , nullable=true , unique=false)
    private String postalCode; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @CITY-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @CITY-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-CITY@
    @Column(name="CITY"  , length=30 , nullable=false , unique=true)
    private String city; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @STATE_PROVINCE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @STATE_PROVINCE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-STATE_PROVINCE@
    @Column(name="STATE_PROVINCE"  , length=25 , nullable=true , unique=true)
    private String stateProvince; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="COUNTRY_ID", referencedColumnName = "COUNTRY_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Countries countryId;  

    @Column(name="COUNTRY_ID" , length=2 , nullable=true , unique=true, insertable=false, updatable=false)
    private String countryId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @departmentsLocationsViaLocationId-field-LOCATIONS@
    @OneToMany (targetEntity=example.db.Departments.class, fetch=FetchType.LAZY, mappedBy="locationId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Departments> departmentsLocationsViaLocationId = new HashSet<Departments>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Locations() {
    }

	/**
	* All field constructor 
	*/
    public Locations(
       Long locationId,
       String streetAddress,
       String postalCode,
       String city,
       String stateProvince,
       String countryId) {
       //primary keys
       setLocationId (locationId);
       //attributes
       setStreetAddress (streetAddress);
       setPostalCode (postalCode);
       setCity (city);
       setStateProvince (stateProvince);
       //parents
       this.countryId = new Countries();
       this.countryId.setCountryId(countryId); //COUNTRY_ID
	   setCountryId_ (countryId);
    }

	public Locations flat() {
	   return new Locations(
          getLocationId(),
          getStreetAddress(),
          getPostalCode(),
          getCity(),
          getStateProvince(),
          getCountryId_()
	   );
	}

    public Long getLocationId() {
        return locationId;
    }
	
    public void setLocationId (Long locationId) {
        this.locationId =  locationId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-STREET_ADDRESS@
    public String getStreetAddress() {
        return streetAddress;
    }
	
    public void setStreetAddress (String streetAddress) {
        this.streetAddress =  streetAddress;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-POSTAL_CODE@
    public String getPostalCode() {
        return postalCode;
    }
	
    public void setPostalCode (String postalCode) {
        this.postalCode =  postalCode;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-CITY@
    public String getCity() {
        return city;
    }
	
    public void setCity (String city) {
        this.city =  city;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-STATE_PROVINCE@
    public String getStateProvince() {
        return stateProvince;
    }
	
    public void setStateProvince (String stateProvince) {
        this.stateProvince =  stateProvince;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Countries getCountryId () {
    	return countryId;
    }
	
    public void setCountryId (Countries countryId) {
    	this.countryId = countryId;
    }

    public String getCountryId_() {
        return countryId_;
    }
	
    public void setCountryId_ (String countryId) {
        this.countryId_ =  countryId;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @departmentsLocationsViaLocationId-getter-LOCATIONS@
    public Set<Departments> getDepartmentsLocationsViaLocationId() {
        if (departmentsLocationsViaLocationId == null){
            departmentsLocationsViaLocationId = new HashSet<Departments>();
        }
        return departmentsLocationsViaLocationId;
    }

    public void setDepartmentsLocationsViaLocationId (Set<Departments> departmentsLocationsViaLocationId) {
        this.departmentsLocationsViaLocationId = departmentsLocationsViaLocationId;
    }	
    
    public void addDepartmentsLocationsViaLocationId (Departments departments) {
    	    getDepartmentsLocationsViaLocationId().add(departments);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

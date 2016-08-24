package example.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkStation {
	@Id private int id;
	private  String location;
	public WorkStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkStation(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "WorkStation [id=" + id + ", location=" + location + "]";
	}
}

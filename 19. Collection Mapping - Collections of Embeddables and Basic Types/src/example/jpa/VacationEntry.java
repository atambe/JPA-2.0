package example.jpa;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class VacationEntry {
	
	@Temporal(TemporalType.DATE)
	private Calendar startDate;
	@Column(name="Days")
	private int daysTaken;
	public VacationEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VacationEntry(Calendar startDate, int daysTaken) {
		super();
		this.startDate = startDate;
		this.daysTaken = daysTaken;
	}
	@Override
	public String toString() {
		return "VacationEntry [daysTaken=" + daysTaken + ", startDate="
				+ startDate + "]";
	}
}

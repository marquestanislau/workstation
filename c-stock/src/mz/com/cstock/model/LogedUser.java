package mz.com.cstock.model;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class LogedUser extends User {

	private static final long serialVersionUID = 1L;
	private String imagePath;
	private Calendar dateRegistered;
	private Long id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getLoginDate() {
		return dateRegistered;
	}

	public void setLoginDate(Calendar loginDate) {
		this.dateRegistered = loginDate;
	}

}

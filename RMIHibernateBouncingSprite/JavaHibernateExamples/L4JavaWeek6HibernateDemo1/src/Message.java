import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** EXERCISE FOR READER: read the code, understand it, and insert comments */
@Entity 
//@Table(name="message")
public class Message {
	
	private int mesId;
	private int mesNumber;
	private Calendar mesDate;
	private String client;
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMesId() {
		return mesId;
	}
	public void setMesId(int mesId) {
		this.mesId = mesId;
	}
	@Column
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Column
	public int getMesNumber(){
		return mesNumber;
	}
	public void setMesNumber(int mesNumber){
		this.mesNumber = mesNumber;
	}
	@Column
	public String getClient(){
		return client;
	}
	public void setClient(String client){
		this.client = client;
	}
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getMesDate() {
		return mesDate;
	}
	public void setMesDate(Calendar mesDate) {
		this.mesDate = mesDate;
	}
}

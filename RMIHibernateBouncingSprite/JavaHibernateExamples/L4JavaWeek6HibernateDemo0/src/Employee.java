import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/* This class is an example of a Hibernate Entity.  Employee objects are to be stored in the database.
 */
@Entity
@Table(name = "myEmployee") // optionally we can specify a table name other than
							// the class name
public class Employee {

	private int empId; // these instance variables are not annotated, so
						// Hibernate will use property access
	private String empName;
	private String empEmail;
	private String empAddress;
	private int age;
	private Calendar empStartDate;
	private int doneStoreInDB;

	@Transient // tell hibernate this does not belong database
	public int getdoneStoreInDB() {
		return doneStoreInDB;
	}

	public void setdoneStoreInDB(int doneStoreInDB) {
		this.doneStoreInDB = doneStoreInDB;
	}

	@Column // all attributes will be stored as columns, unless the @Transient
			// annotation is used
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Id // the getter of the primary key is annotated, so Hibernate will use
		// property access
	@GeneratedValue
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Column(nullable = false) // cannot be null
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	// also store as column except being annotated as @Transient
	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	// must be specified for persistent fields or properties of type
	// java.util.Date and java.util.Calendar
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getEmpStartDate() {
		return empStartDate;
	}

	public void setEmpStartDate(Calendar empStartDate) {
		this.empStartDate = empStartDate;
	}
}

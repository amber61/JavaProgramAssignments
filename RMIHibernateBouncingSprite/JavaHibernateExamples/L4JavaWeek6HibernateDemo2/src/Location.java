import java.awt.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	private Point location;
	private int locId;
	
	public Location(){
		location = new Point();
	}
	public Location(Point location){
		this.location = location;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "locId")
	public int getLocId(){
		return locId;
	}
	public void setLocId(int locId){
    	this.locId = locId;
    }	
	public int getXLoc(){
		return (int) location.getX();
	}
	public void setXLoc(int xLoc){
		location.setLocation(xLoc,location.getY());
	}
	public int getYLoc(){
		return (int) location.getY();
	}
	public void setYLoc(int yLoc){
		location.setLocation(location.getX(),yLoc);
	}
}

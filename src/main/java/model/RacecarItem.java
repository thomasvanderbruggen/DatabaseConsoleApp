/** 
 * @author Thomas VanderBruggen - tvanderbruggen
 * CIS175 - Spring 2021
 * 2/21/2021
 */

package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="racecars")
public class RacecarItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; 
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	@Column(name="ARRANGEMENT")
	private String arrangement; 
	@Column(name="DISPLACEMENT")
	private String displacement;
	@Column(name="HORSEPOWER")
	private int horsePower;
	@Column(name="Series")
	private String series; 
	public RacecarItem() {}
	public RacecarItem(String make, String model, String arrangement, String engineDisplacement, int horsePower, String series) { 
		this.make = make; 
		this.model = model; 
		this.displacement = engineDisplacement;
		this.arrangement = arrangement;
		this.horsePower = horsePower; 
		this.series = series;
	}
	public String getArrangement() {
		return arrangement;
	}
	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}
	public String getDisplacement() {
		return displacement;
	}
	public void setDisplacement(String engineDisplacement) {
		this.displacement = engineDisplacement;
	}
	public int getId() {
		return id;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}	
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	public String returnCarInfo() {
		return series + " " + make + " " + model + " " + displacement + " " + arrangement + " producing " + horsePower + " hp"; 
	}
	
}

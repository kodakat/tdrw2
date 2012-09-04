package tdrw;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RawJson {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	@Column
	public int park;
	
	public int getPark() {
		return park;
	}

	public void setPark(int park) {
		this.park = park;
	}

	public Timestamp getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Timestamp queryDate) {
		this.queryDate = queryDate;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Column
	public Timestamp queryDate;
	
	@Column(length = 40000)
	public String json;

	public RawJson(int park, Timestamp date) {
		this.park = park;
		this.queryDate = date;
	}
	
	public RawJson(){
		
	}
}

package tdrw;

import java.util.Date;

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

	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Column
	public Date queryDate;
	
	@Column(length = 40000)
	public String json;

	public RawJson(int park, Date date) {
		this.park = park;
	}
	
	public RawJson(){
		
	}
}

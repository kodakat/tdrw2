package tdrw;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA. User: kodaka Date: 12/05/01 Time: 17:38 To change
 * this template use File | Settings | File Templates.
 */
@Entity
public class AttractionWaiting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private long jsonId;
	
	public long getJsonId() {
		return jsonId;
	}

	public void setJsonId(long jsonId) {
		this.jsonId = jsonId;
	}

	@Column
	private int attrId;

	@Column
	private int areaId;

	@Column
	private String attr_name;

	@Column
	private String area_name;

	@Column
	private String attrUrl;

	@Column
	private String attrImg;

	@Column
	private int attrSort;

	@Column
	private int areaSort;
	
	public int getAreaSort() {
		return areaSort;
	}

	public void setAreaSort(int areaSort) {
		this.areaSort = areaSort;
	}

	@Column
	private int park;

	@Column
	private int status;

	@Column
	private int fastpss;

	@Column
	private String fpTimeFrom;

	@Column
	private String fpTimeTo;

	public int getLimit2() {
		return limit2;
	}

	public void setLimit2(int limit2) {
		this.limit2 = limit2;
	}

	public void setFpTimeFrom(String fpTimeFrom) {
		this.fpTimeFrom = fpTimeFrom;
	}

	public void setFpTimeTo(String fpTimeTo) {
		this.fpTimeTo = fpTimeTo;
	}

	@Column
	private int limit2;

	@Column
	private int wait;

	@Column
	private int greeting;

	@Column
	private String updated;
	
	@Column
	private Timestamp queryDate;

	public Timestamp getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Timestamp queryDate) {
		this.queryDate = queryDate;
	}

	public String getFpTimeFrom() {
		return fpTimeFrom;
	}

	public String getFpTimeTo() {
		return fpTimeTo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAttrId() {
		return attrId;
	}

	public void setAttrId(int attrId) {
		this.attrId = attrId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getAttrUrl() {
		return attrUrl;
	}

	public void setAttrUrl(String attrUrl) {
		this.attrUrl = attrUrl;
	}

	public String getAttrImg() {
		return attrImg;
	}

	public void setAttrImg(String attrImg) {
		this.attrImg = attrImg;
	}

	public int getAttrSort() {
		return attrSort;
	}

	public void setAttrSort(int attrSort) {
		this.attrSort = attrSort;
	}

	public int getPark() {
		return park;
	}

	public void setPark(int park) {
		this.park = park;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFastpss() {
		return fastpss;
	}

	public void setFastpss(int fastpss) {
		this.fastpss = fastpss;
	}

	public int getLimit() {
		return limit2;
	}

	public void setLimit(int limit) {
		this.limit2 = limit;
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public int getGreeting() {
		return greeting;
	}

	public void setGreeting(int greeting) {
		this.greeting = greeting;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttractionWaiting other = (AttractionWaiting) obj;
		if (areaId != other.areaId)
			return false;
		if (areaSort != other.areaSort)
			return false;
		if (area_name == null) {
			if (other.area_name != null)
				return false;
		} else if (!area_name.equals(other.area_name))
			return false;
		if (attrId != other.attrId)
			return false;
		if (attrImg == null) {
			if (other.attrImg != null)
				return false;
		} else if (!attrImg.equals(other.attrImg))
			return false;
		if (attrSort != other.attrSort)
			return false;
		if (attrUrl == null) {
			if (other.attrUrl != null)
				return false;
		} else if (!attrUrl.equals(other.attrUrl))
			return false;
		if (attr_name == null) {
			if (other.attr_name != null)
				return false;
		} else if (!attr_name.equals(other.attr_name))
			return false;
		if (fastpss != other.fastpss)
			return false;
		if (fpTimeFrom == null) {
			if (other.fpTimeFrom != null)
				return false;
		} else if (!fpTimeFrom.equals(other.fpTimeFrom))
			return false;
		if (fpTimeTo == null) {
			if (other.fpTimeTo != null)
				return false;
		} else if (!fpTimeTo.equals(other.fpTimeTo))
			return false;
		if (greeting != other.greeting)
			return false;
		if (id != other.id)
			return false;
		if (jsonId != other.jsonId)
			return false;
		if (limit2 != other.limit2)
			return false;
		if (park != other.park)
			return false;
		if (queryDate == null) {
			if (other.queryDate != null)
				return false;
		} else if (!queryDate.equals(other.queryDate))
			return false;
		if (status != other.status)
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (wait != other.wait)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaId;
		result = prime * result + areaSort;
		result = prime * result
				+ ((area_name == null) ? 0 : area_name.hashCode());
		result = prime * result + attrId;
		result = prime * result + ((attrImg == null) ? 0 : attrImg.hashCode());
		result = prime * result + attrSort;
		result = prime * result + ((attrUrl == null) ? 0 : attrUrl.hashCode());
		result = prime * result
				+ ((attr_name == null) ? 0 : attr_name.hashCode());
		result = prime * result + fastpss;
		result = prime * result
				+ ((fpTimeFrom == null) ? 0 : fpTimeFrom.hashCode());
		result = prime * result
				+ ((fpTimeTo == null) ? 0 : fpTimeTo.hashCode());
		result = prime * result + greeting;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (jsonId ^ (jsonId >>> 32));
		result = prime * result + limit2;
		result = prime * result + park;
		result = prime * result
				+ ((queryDate == null) ? 0 : queryDate.hashCode());
		result = prime * result + status;
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + wait;
		return result;
	}

	@Override
	public String toString() {
		return "AttractionWaiting [id=" + id + ", jsonId=" + jsonId
				+ ", attrId=" + attrId + ", areaId=" + areaId + ", attr_name="
				+ attr_name + ", area_name=" + area_name + ", attrUrl="
				+ attrUrl + ", attrImg=" + attrImg + ", attrSort=" + attrSort
				+ ", areaSort=" + areaSort + ", park=" + park + ", status="
				+ status + ", fastpss=" + fastpss + ", fpTimeFrom="
				+ fpTimeFrom + ", fpTimeTo=" + fpTimeTo + ", limit2=" + limit2
				+ ", wait=" + wait + ", greeting=" + greeting + ", updated="
				+ updated + ", queryDate=" + queryDate + "]";
	}
}

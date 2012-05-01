package tdrw;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: kodaka
 * Date: 12/05/01
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class AttractionWaiting {
    @Id
    public long id;

    @Column
    public int attrId;

    @Column
    public int areaId;

    @Column
    public String attr_name;

    @Column
    public String area_name;

    @Column
    public String attrUrl;

    @Column
    public String attrImg;

    @Column
    public int attrSort;

    @Column
    public int part;

    @Column
    public int status;

    @Column
    public int fastpss;

    @Column
    public int fpTimeFrom;

    @Column
    public int fpTimeTo;

    @Column
    public int limit;

    @Column
    public int wait;

    @Column
    public int greeting;

    @Column
    public String updated;

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

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
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

    public int getFpTimeFrom() {
        return fpTimeFrom;
    }

    public void setFpTimeFrom(int fpTimeFrom) {
        this.fpTimeFrom = fpTimeFrom;
    }

    public int getFpTimeTo() {
        return fpTimeTo;
    }

    public void setFpTimeTo(int fpTimeTo) {
        this.fpTimeTo = fpTimeTo;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttractionWaiting)) return false;

        AttractionWaiting that = (AttractionWaiting) o;

        if (areaId != that.areaId) return false;
        if (attrId != that.attrId) return false;
        if (attrSort != that.attrSort) return false;
        if (fastpss != that.fastpss) return false;
        if (fpTimeFrom != that.fpTimeFrom) return false;
        if (fpTimeTo != that.fpTimeTo) return false;
        if (greeting != that.greeting) return false;
        if (id != that.id) return false;
        if (limit != that.limit) return false;
        if (part != that.part) return false;
        if (status != that.status) return false;
        if (wait != that.wait) return false;
        if (area_name != null ? !area_name.equals(that.area_name) : that.area_name != null) return false;
        if (attrImg != null ? !attrImg.equals(that.attrImg) : that.attrImg != null) return false;
        if (attrUrl != null ? !attrUrl.equals(that.attrUrl) : that.attrUrl != null) return false;
        if (attr_name != null ? !attr_name.equals(that.attr_name) : that.attr_name != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + attrId;
        result = 31 * result + areaId;
        result = 31 * result + (attr_name != null ? attr_name.hashCode() : 0);
        result = 31 * result + (area_name != null ? area_name.hashCode() : 0);
        result = 31 * result + (attrUrl != null ? attrUrl.hashCode() : 0);
        result = 31 * result + (attrImg != null ? attrImg.hashCode() : 0);
        result = 31 * result + attrSort;
        result = 31 * result + part;
        result = 31 * result + status;
        result = 31 * result + fastpss;
        result = 31 * result + fpTimeFrom;
        result = 31 * result + fpTimeTo;
        result = 31 * result + limit;
        result = 31 * result + wait;
        result = 31 * result + greeting;
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }
}

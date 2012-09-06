package tdrw;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tdrw.entity.AttractionWaiting;
import tdrw.entity.RawJson;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

/**
 */
public class Tdrw {
	public static final String tdsUrl = "http://www.tokyodisneyresort.co.jp/todayinfo/tds.json?_=1335615761675";
	public static final String tdlUrl = "http://www.tokyodisneyresort.co.jp/todayinfo/tdl.json?_=1335615761675";

	public Tdrw() {
	}

	public void start() {
		getOnePark(1, tdlUrl);
		getOnePark(2, tdsUrl);
	}

	private void getOnePark(int park, String url) {
		JsonRetriever tb = new UrlJsonRetriever(url);
		String json = tb.getText();
		System.out.println(json);

		RawJson rj = new RawJson(park, new Timestamp(System.currentTimeMillis()));
		rj.setJson(json);
		TdrwDao.insertJson(rj);

//		rj = findRawJsonByPrimaryKey(2L);

		List<Object> list = null;
		try {
			list = decodeJson(rj.getJson());
			processOneJson(list, rj);
		} catch (JSONException ex) {
			System.out.println("Not Open!");
		}
	}

	private void processOneJson(List<Object> list, RawJson json) {
		for (Object field : list) {
			System.out.println(field.toString());
			@SuppressWarnings("unchecked")
			HashMap<String, String> map = (HashMap<String, String>) field;
			AttractionWaiting aw = createAttractionWaingEntity(map);
			aw.setQueryDate(json.getQueryDate());
			aw.setJsonId(json.getId());
			TdrwDao.insertAttractionWaiting(aw);
		}
	}

	private AttractionWaiting createAttractionWaingEntity(
			HashMap<String, String> map) {
		AttractionWaiting aw = new AttractionWaiting();
		aw.setAttrId(Integer.valueOf(map.get("attr_id")));
		aw.setAreaId(Integer.valueOf(map.get("area_id")));
		aw.setAttr_name(map.get("attr_name"));
		aw.setArea_name(map.get("area_name"));
		aw.setAttrUrl(map.get("attr_url"));
		aw.setAttrImg(map.get("attr_img"));
		aw.setAttrSort(Integer.valueOf(map.get("attr_sort")));
		aw.setAreaSort(Integer.valueOf(map.get("area_sort")));
		aw.setPark(Integer.valueOf(map.get("park")));
		aw.setStatus(Integer.valueOf(map.get("status")));
		aw.setFastpss(Integer.valueOf(map.get("fp")));
		aw.setFpTimeFrom(map.get("fp_time_fr"));
		aw.setFpTimeTo(map.get("fp_time_to"));
		aw.setLimit2(Integer.valueOf(map.get("limit")));
		aw.setWait(Integer.valueOf(map.get("wait")));
		aw.setGreeting(Integer.valueOf(map.get("greeting")));
		aw.setUpdated(map.get("update"));
		System.out.println(aw.toString());
		return aw;
		// for (Object key: map.keySet()){
		// System.out.println((String) key + ":" + map.get(key));
		// }

	}


	public List<Object> decodeJson(String json) {
		return JSON.decode(json);
	}

	public List<AttractionWaiting> createEntityList(List<Object> list) {
		return null;
	}
}

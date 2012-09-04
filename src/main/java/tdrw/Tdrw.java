package tdrw;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
		getOnePark(tdlUrl);
		getOnePark(tdsUrl);
	}

	private void getOnePark(String url) {
		TextBuilder tb = new UrlTextBuilder(url);
		String json = tb.getText();
		System.out.println(json);

		RawJson rj = new RawJson(2, new Timestamp(System.currentTimeMillis()));
		rj.setJson(json);
		insertJson(rj);

//		rj = findRawJsonByPrimaryKey(2L);

		List<Object> list = null;
		try {
			list = decodeJson(rj.getJson());
			processOneJson(list, rj.getQueryDate());
		} catch (JSONException ex) {
			System.out.println("Not Open!");
		}
	}

	private void processOneJson(List list, Timestamp queryDate) {
		for (Object field : list) {
			System.out.println(field.toString());
			@SuppressWarnings("unchecked")
			HashMap<String, String> map = (HashMap<String, String>) field;
			AttractionWaiting aw = createAttractionWaingEntity(map);
			aw.setQueryDate(queryDate);
			insertAttractionWaiting(aw);
		}
	}

	private void insertAttractionWaiting(AttractionWaiting aw) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("tdr-unit");
		EntityManager em = factory.createEntityManager();
		EntityTransaction xa = em.getTransaction();
		xa.begin();
		em.persist(aw);
		xa.commit();
		em.close();
		factory.close();
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

	private RawJson findRawJsonByPrimaryKey(long i) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("tdr-unit");
		EntityManager em = factory.createEntityManager();
		RawJson rj = (RawJson) em.find(RawJson.class, new Long(i));
		System.out.println(rj.json);
		return rj;
	}

	private void insertJson(RawJson rj) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("tdr-unit");
		EntityManager em = factory.createEntityManager();
		EntityTransaction xa = em.getTransaction();
		xa.begin();
		em.persist(rj);
		xa.commit();
		em.close();
		factory.close();
	}

	public List decodeJson(String json) {
		return (List) JSON.decode(json);
	}

	public List<AttractionWaiting> createEntityList(List list) {
		return null;
	}
}

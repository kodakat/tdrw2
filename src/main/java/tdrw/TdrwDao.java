package tdrw;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tdrw.entity.AttractionWaiting;
import tdrw.entity.RawJson;

public class TdrwDao {
	private static EntityManagerFactory factory = Persistence
	.createEntityManagerFactory("tdr-unit");
	
	public static RawJson findRawJsonByPrimaryKey(long i) {
		EntityManager em = factory.createEntityManager();
		RawJson rj = (RawJson) em.find(RawJson.class, new Long(i));
		em.close();
//		System.out.println(rj.getJson());
		return rj;
	}
	
	public static void insertAttractionWaiting(AttractionWaiting aw) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction xa = em.getTransaction();
		xa.begin();
		em.persist(aw);
		xa.commit();
		em.close();
	}
	
	public static void insertJson(RawJson rj) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction xa = em.getTransaction();
		xa.begin();
		em.persist(rj);
		xa.commit();
		em.close();
	}

	public static List<AttractionWaiting> listCurrentAttraction(){
		EntityManager em = factory.createEntityManager();
		
		Query queryJson = em.createQuery("select max(j.id) from RawJson j where j.park=2");
		long currentJson = (Long) queryJson.getSingleResult();
		
		// TODO intå^Ç≈éÊÇËèoÇ∑
		long currentJsonId = currentJson;
		Query queryAttr = em.createQuery("select a from AttractionWaiting a where a.jsonId=:jsonId");
		queryAttr.setParameter("jsonId", currentJsonId);
		List<AttractionWaiting> list = queryAttr.getResultList();
		return list;
	}
}

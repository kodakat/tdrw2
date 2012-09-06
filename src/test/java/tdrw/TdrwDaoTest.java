package tdrw;

import java.util.List;

import junit.framework.TestCase;
import tdrw.entity.AttractionWaiting;

public class TdrwDaoTest extends TestCase {
	public void testListCurrentAttraction(){
		List<AttractionWaiting> attrList = TdrwDao.listCurrentAttraction();
		assertTrue(attrList.size() > 0);
	}
}

package tdrw;

import junit.framework.TestCase;

import java.io.*;
import java.util.HashMap;
import java.util.List;

import tdrw.entity.AttractionWaiting;

/**
 * Created with IntelliJ IDEA.
 * User: kodaka
 * Date: 12/05/01
 * Time: 8:35
 * To change this template use File | Settings | File Templates.
 */
public class TdrwTest extends TestCase {
    public void atestDecodeJson() throws FileNotFoundException, IOException{
        String jsonText = readFromFile("/Users/kodaka/tmp/tds.json");
        Tdrw tdrw = new Tdrw();
        List list = tdrw.decodeJson(jsonText);

//        System.out.println(list.toString());
        System.out.println("Size="+ list.size());
        assertEquals(40, list.size());
        for (Object o:list){

            System.out.println(o);
            HashMap m = (HashMap) o;

            System.out.println(m.toString());
            for (Object key : m.keySet()){
                System.out.println(key + ":" + m.get(key));
            }
            System.out.println();
        }
    }

    private String readFromFile(String fileName) throws FileNotFoundException, IOException{
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder(0);

        String line;
        while ((line = br.readLine()) != null ){
            sb.append(line);
        }
        return sb.toString();
    }

    public void atestCreateEntity() throws FileNotFoundException, IOException{
        String jsonText = readFromFile("/Users/kodaka/tmp/tds.json");
        Tdrw tdrw = new Tdrw();
        List list = tdrw.decodeJson(jsonText);
        List<AttractionWaiting> waitingList = tdrw.createEntityList(list);
    }
    
    public void testDummy(){
    }
    
}

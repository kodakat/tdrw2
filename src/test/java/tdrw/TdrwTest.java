package tdrw;

import junit.framework.TestCase;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kodaka
 * Date: 12/05/01
 * Time: 8:35
 * To change this template use File | Settings | File Templates.
 */
public class TdrwTest extends TestCase {
    public void testFile() throws FileNotFoundException, IOException{
        File file = new File("/Users/kodaka/tmp/tdl.json");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder(0);

        String line;
        while ((line = br.readLine()) != null ){
            sb.append(line);
        }
        String jsonText = sb.toString();
//        System.out.println(jsonText);
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
}

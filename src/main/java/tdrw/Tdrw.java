package tdrw;

import net.arnx.jsonic.JSON;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kodaka
 * Date: 12/05/01
 * Time: 8:31
 * To change this template use File | Settings | File Templates.
 */
public class Tdrw {
    public Tdrw(){
    }

    public void start(){

    }

    public List decodeJson(String json){
        List list = (List) JSON.decode(json) ;
        return list;
    }
}

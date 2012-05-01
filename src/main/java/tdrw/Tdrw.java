package tdrw;

import net.arnx.jsonic.JSON;

import java.util.List;

/**
 */
public class Tdrw {
    public Tdrw(){
    }

    public void start(){

    }



    public List decodeJson(String json){
        return (List) JSON.decode(json) ;
    }

    public List<AttractionWaiting> createEntityList(List list) {
        return null;
    }
}

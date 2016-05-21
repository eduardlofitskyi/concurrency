package java5;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollection {

    private ConcurrentHashMap<Integer, String> map;

    public String putToMap(int key, String value){
        return map.putIfAbsent(key, value);
    }

    public String getFromMap(int key){
        return map.get(key);
    }
}

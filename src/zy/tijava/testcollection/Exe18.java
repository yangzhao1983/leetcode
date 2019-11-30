package zy.tijava.testcollection;

import java.util.*;

/**
 * Created by kaiser_zhao on 21/04/2019.
 */
public class Exe18 {
    public static void main(String...strings){
        Map<String, String> kv = new HashMap<>();
        kv.put("k3","v3");
        kv.put("k2","v2");
        kv.put("k1","v1");

        for(String k : kv.keySet()){
            System.out.println("Key = " + k + ", value = " + kv.get(k));
        }

        List<String> keyList = new ArrayList<String>(kv.keySet());
        Collections.sort(keyList);
        Map<String, String> newMap = new LinkedHashMap<>();
        for (String k : keyList){
            newMap.put(k, kv.get(k));
        }

        for(String k:newMap.keySet()){
            System.out.println(k);
        }
    }
}

package utils;

import java.util.*;

public class MapUtils {

    public MapUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {

        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static <K, V> void print(final Map<K, V> map) {
        // 1.
        for (Map.Entry<K, V> entry: map.entrySet())
            //System.out.printf(" Key: %s  Value: %s \n", entry.getKey(), entry.getValue());
            System.out.println( entry.getKey() + " = " +  entry.getValue());

        // 2.
//        for (K key: map.keySet())
//            System.out.println(map.get(key));

        // 3.
//        Iterator<Map.Entry<K, V>> itr = map.entrySet().iterator();
//        while (itr.hasNext())
//            System.out.println(itr.next());
    }
}

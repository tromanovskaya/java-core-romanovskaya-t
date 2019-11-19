package utils;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {

    public CollectionUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> void printList(Collection<?> list) {
        //System.out.println(list.toString());
        Iterator<T> iter = (Iterator<T>) list.iterator();
        int i = 0;
        while (iter.hasNext()) {
            i++;
            System.out.println(i + " " + iter.next());
        }
    }

}

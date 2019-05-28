package GenericController;

import java.util.HashMap;
import java.util.Map;

public class TypeInference {
    public static <K,V> HashMap<K,V> newInstance(){
        return new HashMap<K,V>();
    }
    public static void main(String[] args) {

        Map<String,Map<String,Object>> map = TypeInference.newInstance();
        System.out.println(map);

    }
}

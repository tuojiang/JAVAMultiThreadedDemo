package Chapter_3.Section_1;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-下午1:49
 **/
public class MyList {
    public static List list = new ArrayList();
    public static void add(){
        list.add("大闸蟹");
    }
    public static int size(){
        return list.size();
    }
}

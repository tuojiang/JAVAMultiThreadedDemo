package Chapter_3.Section_1;

import java.io.PipedInputStream;
import java.io.PipedReader;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午4:18
 **/
public class ReadDataChar {
    public void readMethod(PipedReader reader){
        try{

            System.out.println("Read:");
            char[] bytes = new char[20];
            int lengtha = reader.read(bytes);
            while (lengtha != -1){
                String newDate = new String(bytes,0,lengtha);
                System.out.println(newDate);
                lengtha = reader.read(bytes);
            }
            System.out.println();
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

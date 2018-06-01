package Chapter_3.Section_1;

import java.io.PipedInputStream;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午4:18
 **/
public class ReadData {
    public void readMethod(PipedInputStream inputStream){
        try{

            System.out.println("Read:");
            byte[] bytes = new byte[20];
            int lengtha = inputStream.read(bytes);
            while (lengtha != -1){
                String newDate = new String(bytes,0,lengtha);
                System.out.println(newDate);
                lengtha = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

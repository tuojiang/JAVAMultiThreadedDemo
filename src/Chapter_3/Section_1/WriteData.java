package Chapter_3.Section_1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午4:18
 **/
public class WriteData {
    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String data = "" + (i + 1);
                outputStream.write(data.getBytes());
                System.out.println(data);

            }
            System.out.println();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

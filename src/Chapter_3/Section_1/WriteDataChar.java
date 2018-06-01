package Chapter_3.Section_1;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午4:18
 **/
public class WriteDataChar {
    public void writeMethod(PipedWriter writer) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String data = "" + (i + 1);
                writer.write(data);
                System.out.println(data);

            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

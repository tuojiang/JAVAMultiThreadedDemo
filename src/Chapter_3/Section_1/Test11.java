package Chapter_3.Section_1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <p>@description: 1)pipeSteam:同于在不同线程间直接传送数据。
 *                  PipedInputStream/PipedOutputStream
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午4:11
 **/
public class Test11 {
    public static void main(String[] args) {
        try {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);
        ThreadA threadA = new ThreadA(writeData,pipedOutputStream);
        threadA.start();
        Thread.sleep(1000);
        ThreadB threadB = new ThreadB(readData,pipedInputStream);
        threadB.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    static class ThreadA extends Thread{

        private WriteData writeData;
        private PipedOutputStream outputStream;

        public ThreadA(WriteData writeData, PipedOutputStream pipedOutputStream) {
            this.writeData = writeData;
            this.outputStream =pipedOutputStream;
        }

        @Override
            public void run() {
                super.run();
                writeData.writeMethod(outputStream);
            }
    }
    static class ThreadB extends Thread{

        private ReadData readData;
        private PipedInputStream inputStream;

        public ThreadB(ReadData readData, PipedInputStream pipedInputStream) {
            this.readData = readData;
            this.inputStream = pipedInputStream;
        }

        @Override
        public void run() {
            super.run();
            readData.readMethod(inputStream);
        }
    }
}

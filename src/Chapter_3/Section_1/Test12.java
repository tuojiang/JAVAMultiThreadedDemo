package Chapter_3.Section_1;

import java.io.*;

/**
 * <p>@description: 1)pipeSteam:同于在不同线程间直接传送数据。
 *                  PipedWriter/PipedReader
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午4:11
 **/
public class Test12 {
    public static void main(String[] args) {
        try {
        WriteDataChar writeData = new WriteDataChar();
        ReadDataChar readData = new ReadDataChar();
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);
        ThreadA threadA = new ThreadA(writeData,writer);
        threadA.start();
        Thread.sleep(1000);
        ThreadB threadB = new ThreadB(readData,reader);
        threadB.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    static class ThreadA extends Thread{

        private WriteDataChar writeData;
        private PipedWriter outputStream;

        public ThreadA(WriteDataChar writeData, PipedWriter pipedOutputStream) {
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

        private ReadDataChar readData;
        private PipedReader reader;

        public ThreadB(ReadDataChar readData, PipedReader reader) {
            this.readData = readData;
            this.reader = reader;
        }

        @Override
        public void run() {
            super.run();
            readData.readMethod(reader);
        }
    }
}

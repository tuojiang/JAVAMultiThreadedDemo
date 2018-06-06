package Chapter_6;

import java.io.*;

/**
 * Created by boboan on 2018/6/5.
 */
public class Run10 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MyObject10 myObject10 = MyObject10.getInstance();
        FileOutputStream fosRef = new FileOutputStream(new File("myobject.txt"));
        ObjectOutputStream outputStream = new ObjectOutputStream(fosRef);
        outputStream.writeObject(myObject10);
        outputStream.close();
        fosRef.close();
        System.out.println(myObject10.hashCode());
        FileInputStream fisRef = new FileInputStream(new File("myobject.txt"));
        ObjectInputStream inputStream = new ObjectInputStream(fisRef);
        MyObject10 myObject101 = (MyObject10) inputStream.readObject();
        inputStream.close();
        fisRef.close();
        System.out.println(myObject101.hashCode());
    }


}

package Chapter_3.Section_1;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午5:19
 **/
public class Dbtools {

    volatile static boolean isTag = false;
    synchronized public void backupA(){
        try{
            while (isTag == true){
                wait();
            }
            for (int i=0;i<5;i++) {
                System.out.println("@@@@@@@@@");
            }
            isTag = true;
            notifyAll();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    synchronized public void backupB(){
        try{
            while (isTag==false){
                wait();
            }
            for (int i=0;i<5;i++){
                System.out.println("=======");
            }
            isTag=false;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

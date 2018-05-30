package Chapter_2.Section_2.detail_8;

/**
 * <p>@description: 1）内置类与静态内置类
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-30-下午4:58
 **/
public class Run {
    public static void main(String[] args) {
        Publicclass publicclass = new Publicclass();
        publicclass.setUsername("AA");
        publicclass.setPassword("AA PASS");
        Publicclass.Privateclass privateclass = publicclass.new Privateclass();
        privateclass.setName("BB");
        privateclass.setAge("BB AGE");
        System.out.println("public class =" + publicclass.getUsername()+"public password ="+publicclass.getPassword());
        System.out.println("privateclass class =" + privateclass.getName()+"privateclass age ="+privateclass.getAge());

        PublicclassStatic publicclassStatic = new PublicclassStatic();
        publicclassStatic.setUsername("AA publicclassStatic");
        publicclassStatic.setPassword("AA PASS publicclassStatic");
        PublicclassStatic.PrivateclassStatic privateclassStatic = new PublicclassStatic.PrivateclassStatic();
        privateclassStatic.setName("BB publicclassStatic");
        privateclassStatic.setAge("BB AGE publicclassStatic");
        System.out.println("publicclassStatic class =" + publicclass.getUsername()+"public password ="+publicclass.getPassword());
        System.out.println("privateclassstatic class =" + privateclass.getName()+"privateclass age ="+privateclass.getAge());
    }

}

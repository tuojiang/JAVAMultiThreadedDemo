package Chapter_2.Section_2.detail_8;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-30-下午5:13
 **/
public class Publicclass {
    private String username;
    private String password;

    class Privateclass{
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

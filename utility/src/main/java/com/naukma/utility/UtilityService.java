package com.naukma.utility;

public class UtilityService {

    public static User createRandomUser() {
        User res = new User();
        res.setId(UtilCore.generateInt(10000));
        res.setLogin(UtilCore.generateString());
        res.setAge(UtilCore.generateInt(100));

        return res;
    }

    public static Dog createRandomDog() {
        Dog res = new Dog();
        res.setId(UtilCore.generateInt(10000));
        res.setName(UtilCore.generateString());
        return res;
    }

    public static User createUser(String login, int age, String passport) throws Exception {
        User res = new User();
        res.setId(UtilCore.generateInt(1000));
        res.setLogin(login);
        res.setAge(age);

        boolean isLoginValid = UtilCore.checkLogin(res.getLogin());

        if (!isLoginValid) {
            throw new Exception("Login isn't valid. User not created");
        }
        return res;
    }

    public static User createDefaultUser() {
        return new User();
    }

}

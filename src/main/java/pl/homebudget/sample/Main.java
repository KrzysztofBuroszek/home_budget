package pl.homebudget.sample;

import pl.homebudget.user.Users;

public class Main {

    public static void main(String[] args) {

        Users user = new Users();
        user.setName("adam");

        System.out.println(user);
    }


}

package com.example.blm5218_odev;

import java.util.ArrayList;

public class Person {

    private String userName;
    private String password;

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ArrayList<Person> getPersonList(){
        ArrayList<Person> persons=new ArrayList();
        persons.add(new Person("beyzaersu@gmail.com","123"));
        persons.add(new Person("ayşe@gmail.com","1234"));
        persons.add(new Person("burak@gmail.com","12345"));

        return persons;
    }
}

package designpattern.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public   void test(){
        Person person = new Person.Builder()
                .name("John")
                .age(30)
                .address("123 Main St")
                .phoneNumber("555-1234")
                .build();

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Phone Number: " + person.getPhoneNumber());

    }

}
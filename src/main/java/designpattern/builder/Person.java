package designpattern.builder;

/**
 * @author LongyunBian
 * @version 2023/9/25 18:20
 */
public class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private Person(){};
    public static class Builder{
        private Person person = new Person();
        public Builder name(String name) {
            person.name = name;
            return this;
        }

        public Builder age(int age) {
            person.age = age;
            return this;
        }

        public Builder address(String address) {
            person.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            person.phoneNumber = phoneNumber;
            return this;
        }

        public Person build() {
            return person;
        }

    }
}

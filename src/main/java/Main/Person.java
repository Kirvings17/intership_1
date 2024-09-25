package Main;

public class Person {
    public String firstname;
    public String lastname;
    public String country;
    public int age;

    public Person(String firstname, String lastname, String country, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.age = age;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getCountry() {
        return this.country;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return this.firstname + ' ' + this.lastname + ' ' + "from " + this.country + ", age: " + this.age;
    }

    public String toStringNoCountry() {
        return this.firstname + ' ' + this.lastname + ", age: " + this.age;
    }
}
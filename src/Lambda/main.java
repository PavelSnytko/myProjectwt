package Lambda;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
task5();
    }
    static class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Integer getAge() {
            return age;
        }

        public String getPerson() {
            return firstName + " " + lastName + " " + age;
        }
    }

    static void task5() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Anton", "Filippov", 15));
        persons.add(new Person("Martaaaaaaaaaaaaaaaaaaaaaaa", "Bust", 30));
        persons.add(new Person("Gerard", "Depard", 17));

        String res = persons.stream().filter(name -> name.firstName.length() < 17).max((a, b) -> a.getAge().compareTo(b.getAge())).get().getPerson();
        System.out.println(res);
    }
}


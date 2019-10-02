package Lambda;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

/*class Person{
 public static void main(String[] args){
 task5;
 }
 }
 */
/*	Дан класс Person с полями firstName, lastName, age.
   Вывести полное имя самого старшего человека, у которого длина этого имени не превышает 15 символов.*/

class Person {


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


    void task5() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Anton", "Filippov", 15));
        persons.add(new Person("Martaaaaaaaaaaaaaaaaaaaaaaa", "Bust", 30));
        persons.add(new Person("Gerard", "Depard", 17));

        String res = persons.stream().filter(name -> name.firstName.length() < 17).max((a, b) -> a.getAge().compareTo(b.getAge())).get().getPerson();
        System.out.println(res);
    }
}


package demoSort;

import java.util.Date;

public class Student implements Comparable<Student> {
    private String name;
    private String address;
    private int age;
    private Date birthday;

    public Student() {
    }

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
//        return this.getAge() - student.getAge();
    }

    public void showInfo() {
        System.out.println(this.toString());
    }

}


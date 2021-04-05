package demo;

public class Student implements Comparable {
    private String name;
    private int age;
    private int id;
    private String address;

    public Student() {
    }

    public Student(String name, int age, int id, String address) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "demo.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((Student) o).getAge();
    }
}

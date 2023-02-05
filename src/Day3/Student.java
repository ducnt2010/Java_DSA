package Day3;

public class Student implements Comparable {
    public int age;
    public String name;


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object other) {
        // 1 : this > other
        // -1: this < other
        // 0: this ==  other
        Student otherStudent = (Student) other;
        if (this.age > otherStudent.age) {
            return 1;
        } else if (this.age < otherStudent.age) {
            return -1;
        }
        return 0;
    }
}

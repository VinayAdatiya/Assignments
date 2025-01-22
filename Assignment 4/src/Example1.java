import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

abstract class User{
    abstract void msg();
}
class Teacher extends User{
    @Override
    void msg(){
        System.out.println("Teacher ...");
    }
}
class Student extends User{
    @Override
    void msg(){
        System.out.println("Student ...");
    }
}
public class Example1 {
    public static void sendMsg(Set<? extends User> set){
        for (User s:set) {
            s.msg();
        }
    }
    public static void unboundedExample(Set<?> set){
        System.out.println(set);
    }

    public static void lowerboundedExample(Set<? super Integer> set){
        System.out.println(set);
    }
    public static void main(String[] args) {
        Set<Teacher> teacherSet = new HashSet<Teacher>();
        teacherSet.add(new Teacher());
        teacherSet.add(new Teacher());

        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(new Student());
        studentSet.add(new Student());

        Set<Integer> integerSet = new LinkedHashSet<Integer>(Arrays.asList(1,2,3,4,5,6));
        Set<Number> numberSet = new LinkedHashSet<Number>(Arrays.asList(1.2,2.2,3.2));

        System.out.println("-----Upper Bounded-----");
        sendMsg(teacherSet);
        sendMsg(teacherSet);
//        sendMsg(integerSet); //Error :- java: incompatible types:

        System.out.println("-----UnBounded-----");
        unboundedExample(teacherSet);
        unboundedExample(studentSet);
        unboundedExample(integerSet);

        System.out.println("-----Lower Bounded-----");
        lowerboundedExample(integerSet);
        lowerboundedExample(numberSet);
//        lowerboundedExample(teacherSet); //Error :- java: incompatible types:

    }
}
//The ? (question mark) symbol represents the wildcard element. It means any type.
//Here in this code set<? extends User> it means set can be any type of user and here we have two types of user Teacher and Student
//extends also represent Upper Bound :- The purpose of upper bounded wildcards is to decrease the restrictions on a variable. It restricts the unknown type to be a specific type or a subtype of that type.
//Unbounded Wildcards :- The unbounded wildcard type represents the list of an unknown type such as List<?>.
//Lower Bounded Wildcards :- The purpose of lower bounded wildcards is to restrict the unknown type to be a specific type or a supertype of that type.
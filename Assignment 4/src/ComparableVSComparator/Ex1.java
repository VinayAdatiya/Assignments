package ComparableVSComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Ex1 implements Comparable<Ex1> , Comparator<Ex1> {
    String name;
    int age;
    double weight;

    public Ex1(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Ex1() {

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

    @Override
    public String toString() {
        return "Ex1 [name=" + name + ", age=" + age + ", weight=" + weight + " kgs]";
    }

    @Override
    public int compareTo(Ex1 other) {
        return this.age-other.age;
    }

    @Override
    public int compare(Ex1 o1,Ex1 o2){
        return o1.getName().compareTo(o2.getName());
    }

    public static void main(String[] args) {
        Ex1 c1 = new Ex1("Vinay",21,85);
        Ex1 c3 = new Ex1("Raj",25,95);
        Ex1 c2 = new Ex1("Jay",23,70);

        List<Ex1> people = new ArrayList<Ex1>();
        people.add(c2);
        people.add(c1);
        people.add(c3);
        System.out.println("Original people list: " + people);

        Collections.sort(people);
        System.out.println("Sorted people list: " + people);

        Collections.sort(people,new Ex1());
        System.out.println("Sorted people list by name: "+people);
    }
}


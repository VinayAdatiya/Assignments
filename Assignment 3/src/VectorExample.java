import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        //Initializing Vector
        Vector<String> vec = new Vector<>();

        //adding elements into the vector
        //using add()
        vec.add("ABC");
        vec.add("DEF");
        vec.add("GHI");
        System.out.println("Vector :- "+vec);
        System.out.println("Size is: "+vec.size());
        System.out.println("Default capacity is: "+vec.capacity());
        //using addElement()
        vec.addElement("JKL");
        vec.addElement("MNO");
        vec.add("ABC");
        vec.add("DEF");
        vec.add("GHI");
        vec.add("ABC");
        vec.add("DEF");
        vec.add("GHI");
        System.out.println("Vector :- "+vec);
        System.out.println("Size is: "+vec.size());
        System.out.println("Default capacity is: "+vec.capacity()); // Doubles the size if element exceed the size
        System.out.println("First Element: "+vec.firstElement());
        System.out.println("Last Element: "+vec.lastElement());
        if (vec.contains("ABC")){
            System.out.println("index of ABC: "+vec.indexOf("ABC"));
        }
        System.out.println("Get Element(3rd Index): "+vec.get(3));
        System.out.println("Removing Element By Element: "+vec.remove("ABC"));
        System.out.println("Removing Element By Index: "+vec.remove(3));
        vec.removeElementAt(3);
        System.out.println("After Removing 3rd Element 2 times: "+vec);
    }
}

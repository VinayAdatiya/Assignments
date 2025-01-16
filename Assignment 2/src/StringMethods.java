// String is Immutable

// String Implements Serializable , Comparable , CharSequence

// CharSequence is implemented by three classes :-  String , String Buffer and String Builder

// CharSequence interface is used to represent the sequence of characters.

//There are two ways to create String object:
//        1. By string literal    String s = "Hello";
//        2. By new keyword       String s = new String("Hello");

// String is thread Safe

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 1. By Using equals() Method
// 2. By Using == Operator
// 3. By compareTo() Method
// 4. Using startsWith() and endsWith() Method
public class StringMethods {
    public static void main(String[] args) {
        String s="Sachin";
        s.concat(" Tendulkar"); //concat() method appends the string at the end
        System.out.println(s); //will print Sachin because strings are immutable objects

        // String Comparison
        String s1="Sachin";
        String s2="Sachin";
        String s3=new String("Sachin");
        String s4="Saurav";
        String s5="saCHIN";
        String s6="Kohli";
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1.equals(s4));//false
        System.out.println(s1.equalsIgnoreCase(s5));//true
        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);// false

        //compareTo() method compares values lexicographically and returns an integer value that describes if first string is less than, equal to or greater than second string.
        System.out.println(s1.compareTo(s2));//0
        System.out.println(s1.compareTo(s6));//1
        System.out.println(s6.compareTo(s1));//-1

        String str = "Virat Kohli";
        System.out.println(str.startsWith("Virat")); // true
        System.out.println(str.endsWith("Kohli"));  // true

        //String Concatenation
//        1. Using the + Operator
        String v="Virat"+" Kohli";
        System.out.println(v);//Virat Kohli

//        2. Using the String.concat() Method
        String s7=s1.concat(s6);
        System.out.println(s7);//Sachin Kohli

//        3. Using Java StringBuilder or StringBuffer Class
        StringBuilder sbu = new StringBuilder();
        sbu.append("Hello, ");
        sbu.append(s1);
        sbu.append(" ");
        sbu.append(s6);
        String result = sbu.toString();
        System.out.println(result);

        StringBuffer sb= new StringBuffer();
        sb.append("Hello, ");
        sb.append(s1);
        sb.append(" ");
        sb.append(s6);
        String result1 = sb.toString();
        System.out.println(result1);

//        4. Using String.join() Method
        System.out.println(String.join(" ", "Hello,", s1, s6));

//        5. Using the String.format() Method
        System.out.println(String.format("Hello, %s %s", s1, s6));

//        6. Using Collectors.joining() Method (Java 8 and above versions)
        List<String> liststr = Arrays.asList("abc", "pqr", "xyz"); //List of String array
        String str1 = liststr.stream().collect(Collectors.joining(", ")); //performs joining operation
        System.out.println(str1);

        // Differentiation between String , StringBuilder , StringBuffer and

        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");
        System.out.println(sb1.equals(sb2));

        String sb3 = "Hello";
        String sb4 = "Hello";
        System.out.println(sb3.equals(sb4));

        StringBuilder sb5 = new StringBuilder("Hello");
        StringBuilder sb6 = new StringBuilder("Hello");
        System.out.println(sb5.equals(sb6));

        // Checking Hashcode
        System.out.println("StringBuffer Before append :- "+sb1.hashCode());
        sb1.append(" World !");
        System.out.println("StringBuffer After append :- "+sb1.hashCode());

        // Checking Hashcode of String with concat
        System.out.println("String Before append :- "+sb3.hashCode());
        sb3.concat(" World !"); // It will not work
//        System.out.println(sb3);
        System.out.println("String After append :- "+sb3.hashCode());

        // Checking Hashcode of String with +
        System.out.println("String Before append :- "+sb4.hashCode());
        sb4 += " World !";
        System.out.println("String After append :- "+sb4.hashCode());

    }
}

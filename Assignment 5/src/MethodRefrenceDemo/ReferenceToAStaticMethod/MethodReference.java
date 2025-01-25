package MethodRefrenceDemo.ReferenceToAStaticMethod;

import java.util.function.Function;

// Animal Interface with 1 abstract method sound()
interface Animal{
    void sound();
}

class Arithmetic{
    public static int square(int a){
        return a*a;
    }
    public static float square(float a){
        return a*a;
    }
}

//Main Class
public class MethodReference {

    public static void dogBark(){
        System.out.println("Bark...Bark...");
    }

    public static void ThreadStatus(){
        System.out.println("Completed...");
    }

    //Main Method
    public static void main(String[] args) {
        //defined a functional interface and referring a static method to it's functional method dogBark()
        Animal a1 = MethodReference::dogBark;
        a1.sound();

        //using predefined functional interface Runnable to refer static method.
        Thread t1 = new Thread(
                MethodReference::ThreadStatus
        );
        t1.run();

        //Function<T,R> functional Interface
        //use predefined functional interface to refer methods
        Function<Integer,Integer> getSquare = Arithmetic::square;
        System.out.println("Square :- "+getSquare.apply(5));

        //override static methods by referring methods.
        Function<Float,Float> getFloatSquare = Arithmetic::square;
        System.out.println("Float Square :- "+getFloatSquare.apply(5.0f));
    }
}

package MethodRefrenceDemo.ReferenceToAnInstanceMethod;

//Animal Interface with 1 abstract method sound()
interface Animal{
    void sound();
}

public class InstanceMethodReference {
    public void dogBark(){
        System.out.println("Bark...Bark...");
    }

    public void runningStatus(){
        System.out.println("Thread is Completed ...");
    }

    public static void main(String[] args) {
        // Creating an object of main class(InstanceMethodReference) with named as ob1
        InstanceMethodReference ob1 = new InstanceMethodReference();

        // Referring non-static method using reference
        Animal a1 = ob1::dogBark;
        a1.sound();

        //// Referring non-static method using anonymous object
        Animal a2 = new InstanceMethodReference()::dogBark;
        a2.sound();

        // Referring instance (non-static) method
        // Runnable interface contains only one abstract method. So, we can use it as functional interface.
        Thread t1 = new Thread(new InstanceMethodReference()::runningStatus);
        t1.run();

    }

}

class StringBufferExample extends Thread{
    @Override
    public void run() {
        StringBuffer strB = new StringBuffer("Java");
        System.out.println(strB);
        for (int i = 0; i < 20; i++) {
            strB.append(" "+i);
            System.out.println(strB);
        }
    }
}

class StringBuilderExample extends Thread{
    @Override
    public void run() {
        StringBuilder strB = new StringBuilder("Python");
        System.out.println(strB);
        for (int i = 0; i < 20; i++) {
            strB.append(" "+i);
            System.out.println(strB);
        }
    }
}

public class Comparison {
    public static void main(String[] args) {
        StringBufferExample obj1 = new StringBufferExample();
        StringBufferExample obj3 = new StringBufferExample();

        StringBuilderExample obj2 = new StringBuilderExample();
        StringBuilderExample obj4 = new StringBuilderExample();

//        obj1.start();
//        obj3.start();

        obj2.start();
        obj4.start();
    }
}

class SimpleGenericClass<T>{
    T obj;
    void add(T obj){
        this.obj=obj;
    }
    T get(){
        return obj;
    }
    public < E > void printArray(E[] elements) {
        for ( E element : elements){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
//T - Type
//E - Element
//K - Key
//N - Number
//V - Value
public class GenericExample {
    public static void main(String args[]){
        SimpleGenericClass<Integer> m=new SimpleGenericClass<Integer>();
        m.add(2);
        //m.add("vivek");//Compile time error
        System.out.println(m.get());

        Integer[] intArray = { 10,55,66,75,34};
        Character[] charArray = { 'J', 'A', 'V', 'A' };

        System.out.println( "Printing Integer Array" );
        m.printArray( intArray  );

        System.out.println( "Printing Character Array" );
        m.printArray( charArray );
    }
}

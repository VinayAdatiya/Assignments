package MethodRefrenceDemo.ReferenceToAConstructor;

interface Messageable{
    Message getMessage(String msg);
}

class Message{

    private String msg;

    Message(String msg){
        System.out.println(msg);
    }

    Message(String msg,boolean flag){
        if(flag){
            this.msg = msg;
        }
    }
}

public class ConstructorReference {
    public static void main(String[] args) {
        //Traditional Method
        Messageable treditionalMethod = new Messageable() {
            @Override
            public Message getMessage(String msg) {
                return new Message(msg);
            }
        };

        //Modern Method
        Messageable modernMethod = Message::new;

        Message ob = treditionalMethod.getMessage("Traditional Method"); // Treditional
        Message ob1 = modernMethod.getMessage("Modern Method"); // Latest

        //Compilation time error :- Signature matching must be important
        //Messageable storeMessage = Message::new;
        //storeMessage.getMessage("Hello World !",true);

        /*
            What if there is multiple method in interface
            Solution :- It means it is no longer functional interface and all method must be implemented by another class
            to use constructor method reference interface must be functional and signature must be matching with class object that we are returning
        */
    }
}

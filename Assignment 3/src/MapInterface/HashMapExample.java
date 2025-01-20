package MapInterface;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {

        //Initialization of HashMap
        HashMap<Integer , String> hm1 = new HashMap<>(); //Unordered

        //adding elements in hashmap
        hm1.put(001,"Vinay");
        hm1.put(002,"Vikas");
        hm1.put(003,"Krushit");
        System.out.println("Initial Map :- "+hm1);

        //overwriting value based on same key
        hm1.put(001,"Raj");
        System.out.println("Updated Map :- "+hm1);

        //Retirving value by Key
        System.out.println("-----Retirving Element by Key-----");
        System.out.println(hm1.get(2));

        //Checking Whether Hashmap contains a particular key or not
        System.out.println("-----HaspMap.containsKey()-----");
        if(hm1.containsKey(3)){
            System.out.println("Value at Index 3 :- "+hm1.get(3));
        }

        //Removing Elements
        System.out.println("-----Removing Elements by key-----");
        hm1.remove(1);
        System.out.println("HashMap After Removing Element :- "+hm1);

        //Iterating Elements in HashMap using KeySet()
        System.out.println("-----Iterating Elements of HashMap using KeySet-----");
        for (Integer key:hm1.keySet()) {
            System.out.println("Key :- "+key+" Value :- "+hm1.get(key));
        }

        //Iterating Elements in HashMap using entrySet()
        System.out.println("-----Iterating Elements of HashMap using EntrySet-----");
        for (Map.Entry<Integer , String> e:hm1.entrySet()) {
            System.out.println("Key :- "+e.getKey()+" Value :- "+e.getValue());
        }

        //Iterating Elements in HashMap using values()
        System.out.println("-----Iterating Elements of HashMap using Values()-----");
        for (String val :hm1.values()) {
            System.out.println("Value :- "+val);
        }

        // Count Word Frequency using HashMap
        System.out.println("-----Count the Frequency of the Word-----");
        Map<String,Integer> cf = new HashMap<>();
        String paragraph = """
               Hello Vinay.Hello Krushit.Hello Arpan.Hello Vikas.Hello .Vinay Raj Krushit Vikas.
                """;
        for (String word:paragraph.split("[ .\\n]+")) {
            if(cf.containsKey(word)){
                cf.put(word,cf.get(word)+1);
            }
            else{
                cf.put(word,1);
            }
        }
        for (String key:cf.keySet()) {
            System.out.println("Key :- "+key+"  ||  Value :- "+cf.get(key));
        }

        //Sorting with TreeMap
        System.out.println("-----Tree Map Stores Sorted Values By Default as per Key-----");
        Map<Integer, String > studentMap = new TreeMap<>();
        studentMap.put(001 ,"Vinay");
        studentMap.put(005 ,"Harsh");
        studentMap.put(004 ,"Raj");
        studentMap.put(002 ,"krushit");
        studentMap.put(003 ,"Vikas");
        System.out.println("TreeMap :- "+studentMap);

        //Convert Map to List
        System.out.println("-----Convert Map to List-----");
        List<Integer> keyList = new ArrayList<>(studentMap.keySet());
        List<String> valueList = new ArrayList<>(studentMap.values());
        System.out.println("Key :- "+keyList);
        System.out.println("Value :- "+valueList);
    }
}

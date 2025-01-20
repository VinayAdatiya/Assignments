import java.util.*;

public class CombinedAssignment {
    public static void main(String[] args) {
//  Reads a list of names from the user.
//  Stores unique names in a Set.
//  Counts the frequency of each name using a Map.
//  Displays the sorted list of names and their counts.
        Set<String> hs = new HashSet<>();
        Map<String,Integer> hm = new HashMap<>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println(i+". Enter the Name :- ");
            String name = input.nextLine();
            hs.add(name);
            if(hm.containsKey(name)){
                hm.put(name,hm.get(name)+1);
            }
            else{
                hm.put(name,1);
            }
        }
        System.out.println("Unique Names :- "+hs);
        System.out.println("-----Sorted Names and Their Count-----");
        List<Map.Entry<String , Integer>> entryList = new ArrayList<>(hm.entrySet());
        entryList.sort(
                (e1,e2) -> e2.getValue().compareTo(e1.getValue())
        );
        for (Map.Entry<String,Integer> e:entryList) {
            System.out.println("Key :- "+e.getKey()+"  ||  Value :- "+e.getValue());
        }
    }
}

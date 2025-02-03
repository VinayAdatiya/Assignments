package StreamAPIExample;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

public class Q8StreamAPI {
    public static void main(String[] args) {
        System.out.println("-----8. Custom Collectors for Aggregation-----");
        Map<String, Double> depWiseSpend = StreamAPIAssignment.empList.parallelStream().collect(Collector.of(
                HashMap::new,
                (map, emp) -> {
                    map.merge(emp.getDepartment(), emp.getSalary(), Double::sum);
                },
                (map1, map2) -> {
                    for (Map.Entry<String, Double> entry : map2.entrySet()) {
                        String dept = entry.getKey();
                        Double value = entry.getValue();

                        if (map1.containsKey(dept)) {
                            double sum = map1.get(dept) + value;
                            map1.put(dept, sum);
                        } else {
                            map1.put(dept, value);
                        }
                    }
                    return map1;
                }
        ));
        System.out.println("StreamAPIExample.Employee List :- ");
        StreamAPIAssignment.empList.forEach(System.out::println);
        System.out.println("DeptWise Spend Using Custom Collector :- ");
        System.out.println(depWiseSpend.entrySet());
    }
}

package LC.SOL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> map = new HashMap<>();
            for (Employee e : employees) {
                map.put(e.id, e);
            }
            return sum(id, map);
        }

        int sum(int id, Map<Integer, Employee> employees) {
            int sum = employees.get(id).importance;
            if (employees.get(id) != null && !employees.get(id).subordinates.isEmpty()) {
                for (Integer e : employees.get(id).subordinates) {
                    sum += sum(e, employees);
                }
            }
            return sum;
        }

        class Employee {
            // It's the unique id of each node;
            // unique id of this employee
            public int id;
            // the importance value of this employee
            public int importance;
            // the id of direct subordinates
            public List<Integer> subordinates;
        }
    }
}

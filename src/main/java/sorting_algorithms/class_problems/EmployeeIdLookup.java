package sorting_algorithms.class_problems;

import java.util.HashMap;

public class EmployeeIdLookup {

    public static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    public static String getDepartment(HashMap<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };

        HashMap<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));

        String[][] customRecords = {
            {"C01", "Sales"},
            {"C02", "HR"},
            {"C03", "IT"}
        };
        HashMap<String, String> customLookup = buildLookup(customRecords);
        System.out.println(getDepartment(customLookup, "C02"));
        System.out.println(getDepartment(customLookup, "C99"));
    }
}

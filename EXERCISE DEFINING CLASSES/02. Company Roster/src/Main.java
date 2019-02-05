import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfEmployees = Integer.parseInt(bufferedReader.readLine());
        LinkedHashMap<String, Department> departments = new LinkedHashMap<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");

            String employeeName = lines[0];
            double salary = Double.parseDouble(lines[1]);
            String position = lines[2];
            String departmentName = lines[3];
            Department department = null;

            if (!departments.containsKey(departmentName)) {
                department = new Department(departmentName);
                departments.put(departmentName, department);
            } else {
                department = departments.get(departmentName);
            }

            Employee employee = null;
            if (lines.length == 4) {
                employee = new Employee(employeeName, salary, position, department);
            } else if (lines.length == 5) {
                try {
                    int age = Integer.parseInt(lines[4]);
                    employee = new Employee(employeeName, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = lines[4];
                    employee = new Employee(employeeName, salary, position, department, email);
                }

            } else if (lines.length == 6) {
                String email = lines[4];
                int age = Integer.parseInt(lines[5]);
                employee = new Employee(employeeName, salary, position, department, email, age);
            }

            departments.get(departmentName).getEmployees().add(employee);
        }

        List<Employee> employeeList = departments.entrySet().stream()
                .sorted((emp1, emp2) -> {
                    double salary1 = emp1.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).sum();
                    double salary2 = emp2.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).sum();
                    return Double.compare(salary2, salary1);
                })
                .map(emp -> emp.getValue().getEmployees())
                .findFirst().orElse(null);
        System.out.printf("Highest Average Salary: %s%n", employeeList.get(0).getDepartment().getName());

        employeeList.stream().sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
                .forEach(emp -> {
                    System.out.printf("%s %.2f %s %d%n",
                            emp.getName(),
                            emp.getSalary(),
                            emp.getEmail(),
                            emp.getAge());
                });
    }
}

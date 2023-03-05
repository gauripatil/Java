import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(john);
        employeesList.add(tim);
        employeesList.add(jack);
        employeesList.add(snow);
        employeesList.add(red);
        employeesList.add(charming);

        // HERE FOREACH IS TAKING THE LAMBDA AS ITS PARAMETER TO PRINT THE EMPLOYEE NAME
        // POINT 1
        System.out.println("************* PRINT ALL EMPLOYEES ********************");
        employeesList.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        // POINT 2
        System.out.println("************* PRINT EMPLOYEES OLDER THAN 30 ********************");
        employeesList.forEach(employee -> {
            if(employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });

        // POINT 3
        System.out.println("************* PRINT EMPLOYEES YOUNGER THAN 30 ********************");
        employeesList.forEach(employee -> {
            if(employee.getAge() <= 30) {
                System.out.println(employee.getName());
            }
        });

        // HERE WE ARE REPEATING OURSELVES FOR POINT 2 & POINT 3
        // WE CAN MAKE USE OF PREDICATES TO OVERCOME THIS
        // POINT 4 WILL ILLUSTRATE SAME

        // POINT 4:
        printEmployeeByAge(employeesList,
                "******************* PRINT EMPLOYEES OLDER THAN 30 USING PREDICATE **************",
                employee -> employee.getAge() > 30);
        printEmployeeByAge(employeesList,
                "******************* PRINT EMPLOYEES YOUNGER THAN 30 USING PREDICATE **************",
                employee -> employee.getAge() <= 30);
    }

    public static void printEmployeeByAge(List<Employee> employees,
                                          String ageTest,
                                          Predicate<Employee> ageCondition) {
        System.out.println(ageTest);
        for(Employee employee : employees) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }

    }
}
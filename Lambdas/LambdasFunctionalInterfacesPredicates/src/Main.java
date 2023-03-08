import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
        // Anonymous class
        printEmployeeByAge(employeesList, "\n******************* PRINT EMPLOYEES YOUNGER THAN 25 USING ANONYMOUS CLASS **************", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        // INT PREDICATE & CHAINING PREDICATES
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));

        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        // RANDOM NUMBER GENERATOR
        // WAY 1
        System.out.println("************* USING REGULAR WAY *****************");
        Random random = new Random();
        for (int i=0; i<10; i++) {
            System.out.println(random.nextInt(1000));
        }

        // WAY 2
        // SUPPLIER INTERFACE TO GENERATE RANDOM NUMBERS
        Random random1 = new Random();
        Supplier<Integer> randomSupplier =  () -> random1.nextInt(1000);
        System.out.println("************* USING SUPPLIER *****************");
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }


        /// ***************** PRINT LAST NAME  ******************
        // WAY 1
        System.out.println("************* PRINT LAST NAME USING REGUALR WAY *****************");
        employeesList.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last Name is : " + lastName);
        });

        // NOTE:
        // CONSUMER: Doesn`t return any value
        // SUPPLIER: Supplier doesn`t accept any parameter
        // PREDICATE: Only returns true/false
        // But our requirement is to pass a string & to return a string - Here comes job of FUNCTIONAL INTERFACE

        // WAY 2
        System.out.println("************* PRINT FIRST NAME OR LAST NAME RANDOMLY USING FUNCTIONAL INTERFACE *****************");
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random2 = new Random();
        for (Employee employee : employeesList) {
            if(random2.nextBoolean()) {
                System.out.println(printName(getFirstName, employee));
            } else {
                System.out.println(printName(getLastName, employee));
            }
        }

    }

    private static String printName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
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
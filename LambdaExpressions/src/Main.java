import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List <Employee> employeesList = new ArrayList<>();
        employeesList.add(john);
        employeesList.add(tim);
        employeesList.add(jack);
        employeesList.add(snow);

//        WAY 1 - REGULAR FUNCTION
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

//       WAY 2 - LAMBDA EXPRESSION
        Collections.sort(employeesList, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        for(Employee employee : employeesList) {
            System.out.println(employee.getName());
        }


        /////////////////////////////////////////////////////
        // EXAMPLE STRING UPPERCASE & CONCATENATION

        // WAY 1 & WAY 2 of uppercase conversion & concatenation will give same result
        // but with lambda, less code require
        
        //// WAY 1 - Anonymous instance OF UpperConcat
        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, employeesList.get(0).getName(), employeesList.get(1).getName());
        System.out.println("Using anonymous instance of class : " + sillyString);

        //// WAY 2 - Lambda expression
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString2 = doStringStuff(uc, employeesList.get(0).getName(), employeesList.get(1).getName());
        System.out.println( "Using lambda expression : " + sillyString2);


        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }



}



interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        int  i =0;
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression`s class is "+ getClass().getName());
            String result = s1.toUpperCase().concat(s2.toUpperCase());
            return result;
        };

        System.out.println("Another class`s classname is " + getClass().getName());
        return Main.doStringStuff(uc, "String1", "String2");
    }
}
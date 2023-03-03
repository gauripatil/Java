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

        //// WAY 1 - Anonymous instance of class implementing UpperConcat
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


        ///////////////////////////////////////////////////
        /// Lambda & Scope

        // POINT 1 - In this case anonymous inner class is implementing the UpperConcat
        // Hence inside method implementation of upperAndConcat - getClass().getSimpleName() prints empty string
        // as implementing class is anonymous
        GauriAnotherClass gauriAnotherClass = new GauriAnotherClass();
        String result1 = gauriAnotherClass.doSomething();
        System.out.println("Result from GauriAnotherClass : " + result1);


        // IMPORTANT
        // POINT 2 - In this case lambda expression is implementing the UpperConcat
        // Hence inside method implementation of upperAndConcat - getClass().getSimpleName() prints AnotherClass
        // because anonymous instance isnt created and instead lambda expression is treated as nested block of code.
        // and has the same scope as nested block.
        System.out.println();
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println("Result from AnotherClass : " + s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}


class AnotherClass {
    public String doSomething() {
        int  i =0;
        UpperConcat uc = (s1, s2) -> {
            // O/P of below - AnotherClass : The lambda expression`s class is : AnotherClass
            System.out.println("AnotherClass : The lambda expression`s class is "+ getClass().getSimpleName());
            String result = s1.toUpperCase().concat(s2.toUpperCase());
            return result;
        };

        // O/P of below - AnotherClass class`s classname is : AnotherClass
        System.out.println("AnotherClass class`s classname is : " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }
}

class GauriAnotherClass {
    public String doSomething() {
        // O/P of below - GauriAnotherClass class`s name : doSomething : GauriAnotherClass
        System.out.println("GauriAnotherClass class`s name : doSomething : " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                // O/P of below - GauriAnotherClass class`s anonymous class`s name : upperAndConcat :
                System.out.println("GauriAnotherClass class`s anonymous class`s name : upperAndConcat : " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        },"Gauri", "Patil");
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

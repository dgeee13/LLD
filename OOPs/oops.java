import bank.Account;   


interface Vehicle{
    public void start();
    // Vehicle(){ // Interfaces cannot have constructors

    // }
    // void stop(){ // Interfaces cannot have non-abstract fns

    // }
}

interface TwoWheeler{
    
}

class Scooty implements Vehicle, TwoWheeler{
    public void start(){
         System.out.println("Scooty just started");
    }
}
abstract class Animal{ //Abstract class can't be instantiated
    abstract void walk(); // Abstract class can have abstract and non-abstract methods 
    Animal(){ // Abstract class can have constructor and static methods too
         System.out.println("New animal getting created");
    }
    public final void eat(){   // Abstract class can have final methods, which cannot be overridden
        System.out.println("Animal eats");
    }
}

class Horse extends Animal{
     Horse(){
         System.out.println("New horse getting created");
    }
    public void walk(){
        System.out.println("Walks on 4 legs");
    }
    // public void eat(){   // cannot be done
    //     System.out.println("Horse eats");
    // }
}

class Kangaroo extends Animal{
    public void walk(){
        System.out.println("Walks on 2 legs");
    }
}

class Pen{
    //properties or data
    String color;
    String type;

    //methods or member functions
    public void write(){
        System.out.println("Writing something");
    }
    public void printColor(){
        System.out.println(this.color);
    }
}

class Student{
    String name;
    int age;
    static String school; //common for all objects, helpful for saving memory

    public static void changeSchool() {
        school = "newSchool";
    }

    public void printName(){
        System.out.println(this.name);
    }
    //parameterized constructor
    // Student(String name, int age){
    //     this.name = name;
    //     this.age = age;
    //     System.out.println("constructor called");
    // }

    //default constructor
    Student(){
    System.out.println("constructor called");
    }

    //copy constructor
    Student(Student s2){
    this.name = s2.name;
    this.age = s2.age;
    }

    public void printInfo(String name){
        System.out.println(name);
        System.out.println(this.school);
    }

    public void printInfo(int age){
        System.out.println(age);
    }

    public void printInfo(String name,int age){
    System.out.println(name + " " + age);
    }
}

class Shape{
    String color;
    public void area(){
        System.out.println("Displays area");
    }
}

//single level inheritance
//class derived_class_name extends base_class_name
class Triangle extends Shape{
    public void area(int l,int h){
        System.out.println(1/2*l*h);
    }
}


//multi-level inheritance
class EquilateralTriangle extends Triangle{
    public void area(int l,int h){
        System.out.println(1/2*l*h);
    }
}

//hierarchical level inheritance (Circle and Triangle both inherit from Shape)
class Circle extends Shape{
    public void area(int r){
        System.out.println(3.14*r*r);
    }
}

//multiple inheritance is not supported in java through classes
//but we can achieve it using interfaces


public class oops{
    public static void main(String[] args){
        Pen pen1 = new Pen();
        pen1.color = "red";
        pen1.type = "gel";

        // pen1.write();
        // pen1.printColor();

        Pen pen2 = new Pen();
        pen2.color = "blue";
        pen2.type = "ballpoint";

        // pen2.write();
        // pen2.printColor();
        
        Student.school = "JMV";
        Student s1 = new Student();
        s1.name = "John";
        s1.age = 22;
        Student s2 = new Student(s1);
        // s2.printName();

        //polymorphism (compile time polymorphism)
        //function overloading - fns with same name but different parameters
        s1.printInfo(s1.name);

        //inheritance
        Triangle t1 = new Triangle();
        t1.color = "red";


        Account acc1 = new Account();
        acc1.name = "customer1";

        Horse horse = new Horse();
        horse.walk();
        horse.eat();

        Scooty scooty = new Scooty();
        scooty.start();
    }
}



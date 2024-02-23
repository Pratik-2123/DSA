package OOPS;

public class AbstractClass {
    public static void main(String args[]){
        mustang m1 = new mustang();
       }
}
abstract class Animal{
    Animal(){
        System.out.println("Animal Constructor have been called");
    }
    void eat() {
        System.out.println("Animal eats");
    }
    abstract void walk();
}
class horse extends Animal{
    horse(){
        System.out.println("Horse constructor have been called ");
    }
    void walk() {
        System.out.println("Walks on the 4 legs");
    }
}
class mustang extends horse{
    mustang() {
        System.out.println("Mustang constuctor have been called");
    }
}
class chicken extends Animal{
    chicken() {
        System.out.println("Chicken constructor have been called ");
    }
    void walk() {
        System.out.println("Walks on 2 legs ");
    }
}
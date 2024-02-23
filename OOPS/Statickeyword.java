package OOPS;

public class Statickeyword {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.Schoolname = "ABC";
        System.out.println(s1.percentage(80, 80, 80) + "%"); // Example of the static function
   
        Student s2 = new Student();
        System.out.println(s2.Schoolname);
   
        Student s3 = new Student();
        s3.Schoolname = "ghr";
         
       }
}

class Student {
    String name;
    int roll;
    
    static String Schoolname; // Example of the static Properties 

    void setname(String name) {
        this.name = name;
    }  
    String getname() {
        return this.name;
    }
    
    static int percentage(int math, int phy, int chem) {  // Example of the static function
        return (math + phy + chem) / 3;
    }
}
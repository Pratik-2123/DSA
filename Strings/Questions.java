import java.util.Arrays;
public class Questions {
    public static void main(String args[]){
        String str1 = "earth";
        String str2 = "heart";
    
        //to lower case
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
    
        if(str1.length() == str2.length()){
          char[] str1tochararray = str1.toCharArray();
          char[] str2tochararray = str2.toCharArray();
    
          Arrays.sort(str1tochararray);
          Arrays.sort(str2tochararray);
          
          boolean result = Arrays.equals(str1tochararray,str2tochararray);
    
          if (result){
            System.out.println("They are anagrams of each other");
          } else {
            System.out.println("They are not anagrams of each other");
          }
         }
         else {
          System.out.println("They are not anagrams of each other");
         }
}
}
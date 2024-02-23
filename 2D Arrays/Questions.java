public class Questions {
  // Question 1

  public static void Count(int matrix[][]){
    int key=7;
    int count=0;
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        if(matrix[i][j]==7){
          count++;
        }
      }
    }
    System.out.println(count);
  }

  //Question 2
  public static void Sum(int matrix[][]){
    int sum=0;
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        if(i==1){
          sum+=matrix[i][j];
        }
      }
    }
    System.out.println(sum);
  }

 public static void main(String args[]){
  int matrix[][]={{4,7,8},{8,8,7}};
  Count(matrix);
  Sum(matrix);
 }
}


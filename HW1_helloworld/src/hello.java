import java.util.Scanner ;

class Main {
  public static void main(String[] args) {
    
    Scanner keyborad = new Scanner (System.in) ;
    
    String S1 = keyborad.nextLine() ;
    String S2 = keyborad.nextLine() ;
    
    if(S1.equals(S2)){
      System.out.println("case 1 : same") ;
    }
    else{
      System.out.println("case 1 : not same") ;
    }
    
    if(S1.equalsIgnoreCase(S2)){
      System.out.println("case 2 : same") ;
    }
    else{
      System.out.println("case 2 : not same") ;
    }
  }
}
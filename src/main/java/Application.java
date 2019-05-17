import java.util.Scanner;

public class Application {

  public static void main(String args[]) {
    int a,b;

    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the starting point:");
    a = in.nextInt();


    System.out.println("Please enter the length:");
    b = in.nextInt();

    System.out.println(new KeypadGraph().traverse(a,b).get());
  }
}

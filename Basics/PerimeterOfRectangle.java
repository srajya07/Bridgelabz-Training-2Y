import java.util.Scanner;

public class PerimeterOfRectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double l=sc.nextDouble();
        double w=sc.nextDouble();
        double p=2*(l+w);
        System.out.println("Perimeter = "+p);

        sc.close();
    }
}

import java.util.Scanner;

public class KilometersToMiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double km=sc.nextDouble();
        System.out.println("Distance in miles = "+(km*0.621371));

        sc.close();
    }
}

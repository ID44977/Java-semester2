package Example;

import java.util.Scanner;

public class In2Cm {
    public static void main(String[] args) {
        int inch;
        double cm;
        final double CM_PER_INCH = 2.54;
        Scanner in = new Scanner(System.in);

        System.out.print("How many inches? \n");
        inch = in.nextInt();

        cm = inch * CM_PER_INCH;

        System.out.print(inch + "in = ");
        System.out.print(cm + "cm");
    }
}

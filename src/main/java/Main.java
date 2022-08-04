import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("""
                1. Elevar al cuadrado
                2. Elevar al cubo
                0. Salir""");

        while(true) {
            if (scn.hasNextInt()) {
                int input = scn.nextInt();
                switch (input) {
                    case 1 -> System.out.println(12);
                    case 2 -> System.out.println(24);
                    case 0 -> System.out.println("Adios");
                    default -> System.out.println("Introduce 1, 2 o 0");
                }
                if (input == 0)
                    break;
            }
            else {
                scn.nextLine();
                System.out.println("Error entrada");
            }
        }
        scn.close();
    }
}

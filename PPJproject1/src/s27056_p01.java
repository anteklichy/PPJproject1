import java.util.Scanner;

public class s27056_p01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int wynik = 0;
        int val1, val2;
        boolean error = false;
        do {
            String val1B = "", val2B = "", wynikB = "";
            System.out.print("Podaj pierwsza liczbe: ");
            val1 = s.nextInt();
            System.out.print("Podaj druga liczbe: ");
            val2 = s.nextInt();
            if (val1 == 0 && val2 == 0) break;
            System.out.print("Podaj operacje ('+', '-', '*' lub '\\'): ");
            char operacja = s.next().charAt(0);
            switch (operacja) {
                case '+' -> wynik = val1 + val2;
                case '-' -> wynik = val1 - val2;
                case '*' -> wynik = val1 * val2;
                case '\\' -> wynik = val1 / val2;
                default -> error = true;
            }
            int val1helper = val1, val2helper = val2, wynikHelper = wynik, spaceMaker = 4;
            for (int i = 0; i < 32; i++) {
                if (spaceMaker == 0) {
                    spaceMaker = 4;
                    val1B = " " + val1B;
                    val2B = " " + val2B;
                    wynikB = " " + wynikB;
                }
                val1B = ((val1helper % 2) == 0 ? "0" : "1") + val1B;
                val1helper /= 2;
                val2B = ((val2helper % 2) == 0 ? "0" : "1") + val2B;
                val2helper /= 2;
                wynikB = ((wynikHelper % 2) == 0 ? "0" : "1") + wynikB;
                wynikHelper /= 2;
                spaceMaker--;
            }
            if (error) {
                System.out.println("Podano nieprawidlowa operacje. Dostepne operacje to: \n+\n-\n*\n\\");
            } else {
                System.out.print(val1 + " - " + val1B);
                System.out.print("\n" + val2 + " - " + val2B);
                System.out.print("\n" + wynik + " - " + wynikB);
                System.out.println("\n=======================================");
            }
        } while (val1 != 0 && val2 != 0);
        System.out.println("Wybrano 0 i 0.\nKoniec progamu.");
    }
}
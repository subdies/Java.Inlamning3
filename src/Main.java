import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();     //Skapar hissen
        Scanner scanner = new Scanner(System.in); // Skapar en scanner
        boolean meny = true; // Jag skapar en meny bool som avslutas näranvändaren väljer val 3.

        while (meny) { // här tänkte jag använda mig av console.clear som jag gjorde med c# men hittar inget liknande nu som inte skulle överkomplicera.
            System.out.println("Välkommen till hissen!! Gör ett val.");
            System.out.println("1. Åk till en annan våning");
            System.out.println("2. Få reda på vilken våning du är på.");
            System.out.println("3. Avsluta.");

            int menyval = -1;
            while (menyval == -1) {// startar en loop så att användaren måste välja mellan 1-3
                                    // annars måste han skriva igen, jag tyckte att det kunde bli så mycket i dialogrutan vid många
                                    // felinmatningar.
                try {
                    menyval = scanner.nextInt();
                    if (menyval < 1 || menyval > 3) {
                        System.out.println("Välj menllan 1-3");
                        menyval = -1; // för att köra om loopen.
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Skriv in ett heltal.");
                    scanner.nextLine();
                }
            }
                switch (menyval) {
                    case 1: // Kallar på goTo metoden
                        boolean våning = false;
                        while (!våning){ // en till loop som på rad 18 för att inte få upp hela menyn helea tiden vid fel inmatning. Så hittade en lösning för min kommentar på rad 11.
                            System.out.println("Vilken våning vill du åka till (-2 till 10)?");
                            try {
                                int nyVåning = scanner.nextInt();
                                if (nyVåning >= -2 && nyVåning <=10){
                                    elevator.goTo(nyVåning);
                                    våning = true;
                                }else{
                                    System.out.println("Skriv in en giltig våning.");
                                }

                            }catch (InputMismatchException e) {
                                System.out.println("Skriv in en giltig våning.");
                                scanner.nextLine();
                            }

                        }
                        break;
                    case 2: // Kallar på where metoden.
                        elevator.where();
                        break;
                    case 3: // Avslutar boolean
                        meny = false;
                        break;
                    default: // Om användaren skriver något annat än 1-3
                        System.out.println("Fel val, skriv in ett helta l");
            }
        }
    }
}
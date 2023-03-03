// Eksempel på brug af Scanner til at tokenize en fil / EK mar 23

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File tekstfil = new File("test.csv");
        Scanner sc = new Scanner(tekstfil);
        sc.useDelimiter(";|\\n");


        // Spring første linje over
        sc.nextLine();

        // Indlæs hver linje bestående af dato (string) og tre tal (float).
        // Hvis der er fejl i dataene fanges det med InputMismatchException og linjenummer skrives ud,
        // så vi kan finde fejlen i filen.
        int antalFejl = 0;
        int ln = 0;
        String dato;
        Float tal1, tal2, tal3;
        while (sc.hasNext()) {
            ++ln;
            dato = sc.next();
            try {
                tal1 = sc.nextFloat();
                tal2 = sc.nextFloat();
                tal3 = sc.nextFloat();
                // Skriv data ud
                System.out.println(ln + ":" + dato + " " + tal1 + " " + tal2 + " " + tal3);
            } catch (InputMismatchException e) {
                System.out.println("§§§§ Fejl i linje " + ln + " " + dato);
                ++antalFejl;
            }
        }
        if (antalFejl == 0)
            System.out.println("\nIngen fejl. " + ln + " linjer indlæst.");
        else
            System.out.println("\nDer var fejl i indlæsningen af filen. Se log. ");
    }
}

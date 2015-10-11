package teema1;

import java.util.Arrays;
import java.util.Scanner;
/**
 * NB! Lahenda käesolev ülesanne konsoolis. Pole vaja JavaFXi siia segada.
 *
 * 1. Kirjuta lihtne laevade pommitamise mäng, kus arvuti genereerib 1x1
 *    laevad mööda 1 dimensioonilist lauda. See tähendab, et mängulaud
 *    ei ole mitte ruudustik, vaid üks rida.
 *
 * 2. Täienda mängu nii, et nüüd oleks laual ruudustik.
 *
 * 3. Kas oskad ka nii, et laevad ei ole 1x1 vaid 1x2 ja 1x3 ja orienteeruvad
 *    nii vertikaalselt kui ka horisontaalselt?
 */
public class Peamurdja3_laevad {
    public static void main(String[] args)   {
        int row = 0;
        int col = 0;
        while (row < 1 || row > 10) {
            System.out.println("Kui pikk m2nguv2li peaks olema? (1-10)");
            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();
        }

        while (col < 1 || col > 10) {
            System.out.println("Kui lai m2nguv2li peaks olema? (1-10)");
            Scanner sc = new Scanner(System.in);
            col = sc.nextInt();
        }
        char[][] manguLaud = new char[row][col];
        char[][] visualLaud = new char[row][col];

        for (int k = 0; k < visualLaud.length; k++) {
            for (int i = 0; i < visualLaud[k].length; i++) {
                visualLaud[k][i] = '#';
            }
        }

        for (int k = 0; k < manguLaud.length; k++) {
            for (int i = 0; i < manguLaud[k].length; i++) {
                manguLaud[k][i] = '#';
            }
        }

        int laevadeArv = -1;
        while (laevadeArv < 0 || laevadeArv > row * col) {
            System.out.format("Kui palju laevu peaks olema? (0-%d)%n", row * col);
            Scanner sc = new Scanner(System.in);
            laevadeArv = sc.nextInt();
        }

        int shipsCount = laevadeArv;
        int shipsCount2 = laevadeArv;

            while (laevadeArv > 0) {
            int y = (int) Math.floor(Math.random() * manguLaud.length);
            int x = (int) Math.floor(Math.random() * manguLaud[0].length);
            if (manguLaud[y][x] == '#') {
                manguLaud[y][x] = 'V';
                laevadeArv--;
            }
        }

        int positsioonX = -1;
        int positsioonY = -1;
        boolean gameover = false;
        int pommitusi = 0;


        while (!gameover) {

            for (int k = 0; k < visualLaud.length; k++) {
                for (int i = 0; i < visualLaud[k].length; i++) {
                    System.out.print(visualLaud[k][i]);
                }
                System.out.println();

            }

            positsioonX = -1;
            positsioonY = -1;
            while (positsioonX < 0 || positsioonX > visualLaud[0].length-1) {
                System.out.format("Ytle mitmendat postisiooni reas pommitada (0-%d)%n", visualLaud[0].length-1);
                Scanner sc = new Scanner(System.in);
                positsioonX = sc.nextInt();
            }
            while (positsioonY < 0 || positsioonY > visualLaud[0].length-1) {
                System.out.format("Ytle mitmendat rida pommitada (0-%d)%n", visualLaud.length-1);
                Scanner sc = new Scanner(System.in);
                positsioonY = sc.nextInt();
            }

            if (manguLaud [positsioonY][positsioonX] == 'V'){
                System.out.println("Pihtas");
                manguLaud [positsioonY][positsioonX] = 'x';
                visualLaud [positsioonY][positsioonX] = 'x';
                shipsCount--;
            }
            else if (manguLaud [positsioonY][positsioonX] == 'x' || manguLaud [positsioonY][positsioonX] == '0'){
                System.out.println("Siia oled juba pommitanud");
            }
            else {
                System.out.println("M66das");
                manguLaud [positsioonY][positsioonX] = '0';
                visualLaud [positsioonY][positsioonX] = '0';
            }
            pommitusi++;

            if (shipsCount == 0) {
                gameover = true;
                System.out.format("K6ik laevad leitud! %d laeva leidmiseks kulus %d pommi!", shipsCount2, pommitusi);
            }

        }
    }
}

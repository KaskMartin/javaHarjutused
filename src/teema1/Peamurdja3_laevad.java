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
        int suurus = 0;
        while (suurus < 2 || suurus > 50) {
            System.out.println("Kui suur m2nguv2li peaks olema? (2-50)");
            Scanner sc = new Scanner(System.in);
            suurus = sc.nextInt();
        }
        char[] manguLaud = new char[suurus];

        int laevadeArv = -1;
        while (laevadeArv < 0 || laevadeArv > suurus) {
            System.out.format("Kui palju laevu peaks olema? (0-%d)", suurus);
            Scanner sc = new Scanner(System.in);
            laevadeArv = sc.nextInt();
        }

        for (int i = 0; i < manguLaud.length; i++) {
            manguLaud[i] = '#';
        }

        while (laevadeArv > 0) {
            int y = (int) Math.floor(Math.random() * manguLaud.length);
            if (manguLaud[y] == '#') {
                manguLaud[y] = 'V';
                laevadeArv--;
            }
        }

        System.out.print(manguLaud);
    }


}

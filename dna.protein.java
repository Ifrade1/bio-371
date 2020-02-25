/***************************************************************
*
*   Project: DNA --> Protein
*
*
*
*
*****************************************************************/

import java.io.File;   //include.file
import java.util.*; //include .Scanner
import java.util.ArrayList;
import java.io.FileNotFoundException;



class Nucleo {
    public static void main(final String arg[]) {

        //////////////////////// FROM FILE TO ArrayList
        //////////////////////// DNA///////////////////////////////////

        final Scanner scnr = new Scanner(System.in);
        final ArrayList<Character> DNA = new ArrayList<Character>();
        String longWord;

        System.out.println("Is it 5->3?(Y/N): ");
        final char or = scnr.next().charAt(0);

        try {
            final File example = new File("example.txt");
            final Scanner filo = new Scanner(example);

            longWord = filo.nextLine();

            if ((or == 'Y') || (or == 'y')) {
                for (int i = 0; i < longWord.length(); i++) {
                    DNA.add(longWord.charAt(i));
                }
            } else {
                for (int i = longWord.length() - 1; i > 0; i--) {
                    DNA.add(longWord.charAt(i));
                }
            }
            filo.close();
        } catch (final FileNotFoundException e) {
            System.out.println("file not found");
        }

        for (final Character dna : DNA) {
            System.out.print(dna);
        }

        System.out.println();

        ////////////// tRNA/////////////////////////////////////////////////////

        final ArrayList<Character> tRNA = new ArrayList<Character>();

        for (final Character letter : DNA) {

            switch (letter) {
                case ('a'):
                    tRNA.add('U');
                    break;
                case ('t'):
                    tRNA.add('A');
                    break;
                case ('g'):
                    tRNA.add('C');
                    break;
                case ('c'):
                    tRNA.add('G');
                    break;
            }

        }

        for (final Character rna : tRNA) {
            System.out.print(rna);
        }

        scnr.close();
    }
}
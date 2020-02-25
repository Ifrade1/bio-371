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

        System.out.println("Test Stand");
        for (final Character dna : DNA) {
            System.out.print(dna);
        }

        System.out.println();



        ////////////////Aretha--make complementary strand, find ORFs of complementary strand
        final ArrayList<Character> complementDNA = new ArrayList<Character>(); // new complement stran
        final ArrayList<String> ORFB = new ArrayList<String>();
        final ArrayList<String> ORFlocB = new ArrayList<String>();
        String ORFSB = "";

        //////////////////// makes complementary strand in complementDNAfrom DNA, reads
        //////////////////// 5' to 3'
        for (final Character dna : DNA) {
            if (dna == 'a') {
                complementDNA.add('t');
            } else if (dna == 't') {
                complementDNA.add('a');
            } else if (dna == 'c') {
                complementDNA.add('g');
            } else if (dna == 'g') {
                complementDNA.add('c');
            }
        }

        System.out.println("Complementary Strand");

        for (final Character compdna : complementDNA) {
            System.out.print(compdna);
        }
            


        //finds ORF in complementDNA
        for (int i=0; (i + 2) < complementDNA.size(); i++) {
             

            if ((DNA.get(i) == 'a') && (DNA.get(i+1) == 't') && (DNA.get(i+2)) == 'g') {
                
                
                System.out.printf("\nORF found at " + i);
                
                ORFlocB.add(" " + i);
                
                

                for (int o = i; (o + 2) < DNA.size(); o++) {

                    

                    if (o != 0 && o%3 == 0) {
                        
                        

                        if (DNA.get(i) == 't') {
                             if
                            ((DNA.get(i+1) == 'a' && DNA.get(i+2) == 'g') ||
                            (DNA.get(i+1) == 'a' && DNA.get(i+2) == 'a') ||
                            (DNA.get(i+1) == 'g' && DNA.get(i+2) == 'a'))
                         {
                            System.out.println("STOP codon found at " + i);
                            ORFSB = ORFSB + "" + DNA.get(i);
                            ORFSB = ORFSB + "" + DNA.get(i+1);
                            ORFSB = ORFSB + "" + DNA.get(i+2);
                            
                            break;
                        }

                        

                        }
                    }

                    
                    System.out.println(DNA.get(i));
                    ORFSB = ORFSB + "" + DNA.get(i);
                    i++;
                    }

                    
                    ORFB.add(ORFSB);
                    ORFSB = "";
                }

                

                
                

            

        }
        System.out.printf("\nORFs are: " + ORFB);
        System.out.printf("\nORFs at: " + ORFlocB);            






        //////////////////////////Transcribe ORFS--------------------------------------------------------------------Aretha
        
        /*
        
        ArrayList<String> AmRNA =  (ArrayList<String>) ORFA.clone();
        ArrayList<String> BmRNA =  (ArrayList<String>) ORFB.clone();
                

        for (int i=0; i<ORFA.length(); i++) {
            ArrayList<Character> s = ORFA.get(i);
            for (int k=0; k<s.length(); k++) {
            	if (s.charAt(k)=='T') {
               	 	set(k, ‘U’);
		}
		String str = s.toString();
		AmRNA.add(str);
	
           
            }
            System.out.println("ORF 1+:" + str); 
        }	    



       
        
        
//mRNA listed as codons
System.out.println("mRNA listed as codons");
For (i=0; i<AmRNA.length(); i++) {
ArrayList<String> codons = new ArrayList<String>();
	String orf = AmRNA.get(i);
		for (k=1; k<=s.length(); k++) {
			codons.add(orf[k]);
			if (k%3==0) {
			codons.add("-");	
            }
}
System.out.println("ORF 1+:" + codons);
}




        */
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

        System.out.printf("\ntRNA\n");

        for (final Character rna : tRNA) {
            System.out.print(rna);
        }

        scnr.close();
    }

    }
   


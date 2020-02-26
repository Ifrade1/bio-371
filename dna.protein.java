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
//The user inputs y to indicate 5 direction,
            if ((or == 'Y') || (or == 'y')) {
                for (int i = 0; i < longWord.length(); i++) {
                    DNA.add(longWord.charAt(i));
		}
//anyother input causes this to be read in from 3-> 5 direction
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
        
        ArrayList<String> AmRNA =  new ArrayList<String>();
        ArrayList<String> BmRNA =  new ArrayList<String>();
                

        for (int i=0; i<ORFA.size(); i++) {
        ArrayList<Character> mRNA = new ArrayList<Character>();
        String s = ORFA.get(i);
	
        char[] mrna = s.toCharArray();
	
        for (int k=0; k<s.length(); k++) {
                    if (s.charAt(k)=='T') {
                            mrna[k] = 'U';
                    }
	}
          
	String RNA = new String(mrna);
        AmRNA.add(RNA);

        }
         System.out.println("+ ORF: " +AmRNA);
                
//repeat the same for BmRNA
         System.out.println("+ ORF: " +BmRNA);

	
        
                    //mRNA listed as codons

                    ArrayList<String> mRNAcodons = new ArrayList<String>();


                    System.out.println("mRNA listed as codons");
                    for (int i=0; i<AmRNA.size(); i++) {
                      String orf = AmRNA.get(i);
                      char[] orf_char = orf.toCharArray();
                      String codons = new String();
                    		for (int k=1; k<=orf_char.length; k++) {
                    			codons += orf_char[k-1];
                    			if (k%3==0 && k != orf_char.length) {
                    			codons += '-';
                                }
                              }
                      mRNAcodons.add(codons);
                      //  String sepcodons=new String (cars);
                      //  mRNAcodons.add(cars);

                    System.out.println("ORF :" + codons);
                    }

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
   


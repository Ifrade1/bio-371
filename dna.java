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



class Nucleos {
    public static void main(final String arg[]) {

        //////////////////////// FROM FILE TO ArrayList
        //////////////////////// DNA///////////////////////////////////

        final Scanner scnr = new Scanner(System.in);
        final ArrayList<Character> DNA = new ArrayList<Character>();
        String longWord;
        ArrayList<String> codons = new ArrayList<String>();

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


        ////////////////Aretha--make complementary strand, find ORFs of complementary strand
        final ArrayList<Character> complementDNA = new ArrayList<Character>(); // new complement stran
        final ArrayList<String> ORFB = new ArrayList<String>();
        final ArrayList<String> ORFlocB = new ArrayList<String>();
        String ORFSB = "";
	    String ORFBgood = "";

        //////////////////// makes complementary strand in complementDNAfrom DNA, reads
        //////////////////// 5' to 3'

        for(int i = DNA.size()-1; i>=0;i--){
            Character dna = DNA.get(i);
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
       



        /*System.out.println("Complementary Strand(5->3)");

        for (final Character compdna : complementDNA) {
            System.out.print(compdna);
        }*/
            


        //finds ORF in complementDNA
        for (int i=0; (i + 2) < complementDNA.size(); i++) {
                


            if ((complementDNA.get(i) == 'a') && (complementDNA.get(i+1) == 't') && (complementDNA.get(i+2)) == 'g') {
                
                
                //System.out.printf("\nORF found at " + i);
                
                ORFlocB.add(" " + i);
                
                

                for (int o = i; (o + 2) < complementDNA.size(); o++) {

                    

                    if (o != 0 && o%3 == 0) {
                        
                        

                        if (complementDNA.get(i) == 't') {
                             if
                            ((complementDNA.get(i+1) == 'a' && complementDNA.get(i+2) == 'g') ||
                            (DNA.get(i+1) == 'a' && DNA.get(i+2) == 'a') ||
                            (DNA.get(i+1) == 'g' && DNA.get(i+2) == 'a'))
                         {
                            //System.out.println("STOP codon found at " + i);
                            ORFSB = ORFSB + "" + complementDNA.get(i);
                            complementDNA.set(i, MakeUpperCase(complementDNA.get(i)));
                            ORFSB = ORFSB + "" + complementDNA.get(i+1);
                            complementDNA.set(i+1, MakeUpperCase(complementDNA.get(i+1)));

                            ORFSB = ORFSB + "" + complementDNA.get(i+2);
                            complementDNA.set(i+2, MakeUpperCase(complementDNA.get(i+2)));

				     
			                ORFBgood = ORFSB;
		    	            i = i + 2;
                            
                            break;
                        }

                        

                        }
                    }

                    
                   // System.out.println(DNA.get(i));
                    ORFSB = ORFSB + "" + complementDNA.get(i);
                    complementDNA.set(i, MakeUpperCase(complementDNA.get(i)));
                    i++;
                    }

                    if (ORFBgood != "") {
                    	ORFB.add(ORFSB);
		    }
                    ORFSB = "";
		    ORFBgood = "";
                }

                

                
                

                

            

        }
        
        //System.out.printf("\nORFs are: " + ORFB);
        //System.out.printf("\nORFs at: " + ORFlocB);            



// ArrayList<Character> inputA = new ArrayList <Character>();

//     for (int i=0; i < inputS.length(); i++) {
//       char pt = inputS.charAt(i);
//       inputA.add(pt);
//     }

    ArrayList<String> ORFA = new ArrayList<String>();
    //ArrayList<String> ORFloc = new ArrayList<String>();
    String ORFS = new String();
    String ORFgood = new String();

    for (int i=0; (i + 2) < DNA.size(); i++) {
      if ((DNA.get(i) == 'a') && (DNA.get(i+1) == 't') && (DNA.get(i+2)) == 'g') {
        //System.out.println("ORF found at " + i);
        //ORFloc.add("" + i);

        for (int o = 0; i + 2 < DNA.size(); o++) {
          if (o != 0 && o%3 == 0) {
            if (DNA.get(i) == 't') {
              if
                ((DNA.get(i+1) == 'a' && DNA.get(i+2) == 'g') ||
                (DNA.get(i+1) == 'a' && DNA.get(i+2) == 'a') ||
                (DNA.get(i+1) == 'g' && DNA.get(i+2) == 'a'))
              {
                  //System.out.println("STOP codon found at " + i);
                  ORFS = ORFS + "" + DNA.get(i);
                    DNA.set(i, MakeUpperCase(DNA.get(i)));

                  ORFS = ORFS + "" + DNA.get(i+1);
                  DNA.set(i+1, MakeUpperCase(DNA.get(i+1)));

                  ORFS = ORFS + "" + DNA.get(i+2);
                  DNA.set(i+2, MakeUpperCase(DNA.get(i+2)));

                  ORFgood = ORFS;
                  i = i+2;
                  break;
              }
            }
          }
          ORFS = ORFS + "" + DNA.get(i);
          DNA.set(i, MakeUpperCase(DNA.get(i)));
          i++;
        }

        if (ORFgood != "") {
          ORFA.add(ORFgood);
        }

        ORFS = "";
        ORFgood = "";
      }
    }
    //System.out.println(inputA);
    //System.out.printf("\nTemplate ORFs are: " + ORFA);
    //System.out.println("ORFs at: " + ORFloc);


        //////////////////////////Transcribe ORFS--------------------------------------------------------------------Aretha
        

        
        ArrayList<String> AmRNA  = new ArrayList<String>();
        AmRNA = OFRA;
        ArrayList<String> BmRNA = new ArrayList<String>();
        BmRNA =  ORFB;
        /*        
        for (int i=0; i<ORFA.size(); i++) {
            String s = ORFA.get(i);
            for (int k=0; k<s.length(); k++) {
            if (ORFA.get(i)=="T") {
                AmRNA.set(i, "U");
            }
            }
            System.out.println("ORF 1+:" + s); 
        }	    
        for (int i=0; i<ORFB.size(); i++) {
            String s = ORFB.get(i);
            for (int k=0; k<ORFB.size(); k++) {
            if (ORFB.get(i)=="T") {
                BmRNA.set(i, "U");
            }
            }
	    System.out.println("ORF 1+:" + s); 
        }	
        
        
        //mRNA listed as codons
        
        System.out.println("mRNA listed as codons");
        for (int j=0; j<AmRNA.size(); j++) {
        
            String orf = AmRNA.get(j);
                for (int k=1; k<=ORFA.size(); k++) {
                    String thas = ORFA.get(k);
                    codons.add(thas);
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

        //System.out.printf("\ntRNA\n");

        /*for (final Character rna : tRNA) {
            System.out.print(rna);
        }*/

        scnr.close();

        System.out.printf("\nTemplate Strand with ORF found\n");
        for (final Character dna : DNA){
            System.out.print(dna);
        }


        System.out.printf("\nCompleemnt strand with ORF found\n");
        for (final Character compdna : complementDNA) {
            
             System.out.print(compdna);
         }

         System.out.printf("\nnon-Template ORFs are: " + ORFB);
         System.out.printf("\nTemplate ORFs are: " + ORFA);
    }


    public static char MakeUpperCase(char let){
        switch(let){
            case('a'):
                return 'A';
            case('t'):
                return 'T';
            case('g'):
                return 'G';
            case('c'):
                return 'C';
            case('u'):
                return 'U';

        }
        return 'D';
    }
}


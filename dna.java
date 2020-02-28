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
        ///////////////////////////////////// DNA///////////////////////////////////

        final Scanner scnr = new Scanner(System.in);
        final ArrayList<Character> DNA = new ArrayList<Character>();
        String longWord;
        ArrayList<String> codons = new ArrayList<String>();

        System.out.println("Is it 5->3?(Y/N): ");
        final char or = scnr.next().charAt(0);

        try {
            final File example = new File("example.txt");
            final Scanner filo = new Scanner(example);

            longWord = filo.nextLine().toLowerCase();

            if ((or == 'Y') || (or == 'y')) {
                for (int i = 0; i < longWord.length(); i++) {
                    switch(longWord.charAt(i)){
                        case('a'):
                        case('t'):
                        case('g'):
                        case('c'):
                            DNA.add(longWord.charAt(i));
                        break;
                    }
                }
            } else {
                for (int i = longWord.length() - 1; i > 0; i--) {
                    switch(longWord.charAt(i)){
                        case('a'):
                        case('t'):
                        case('g'):
                        case('c'):
                            DNA.add(longWord.charAt(i));
                        break;
                    }
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
       



       /////////////////////////////finds ORF in complementDNA///////////////////////////////
        for (int i=0; (i + 2) < complementDNA.size(); i++) {
            
            if ((complementDNA.get(i) == 'a') && (complementDNA.get(i+1) == 't') && (complementDNA.get(i+2)) == 'g') {
                
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

        ArrayList<String> ORFA = new ArrayList<String>();
        //ArrayList<String> ORFloc = new ArrayList<String>();
        String ORFS = new String();
        String ORFgood = new String();

        for (int i=0; (i + 2) < DNA.size(); i++) {
            if ((DNA.get(i) == 'a') && (DNA.get(i+1) == 't') && (DNA.get(i+2)) == 'g') {

                for (int o = 0; i + 2 < DNA.size(); o++) {
                    if (o != 0 && o%3 == 0) {
                         if (DNA.get(i) == 't') {
                            if
                            ((DNA.get(i+1) == 'a' && DNA.get(i+2) == 'g') ||
                            (DNA.get(i+1) == 'a' && DNA.get(i+2) == 'a') ||
                            (DNA.get(i+1) == 'g' && DNA.get(i+2) == 'a')){
                                
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
        ////////////////////////////NEW: lists ORFs from ORIG DNA strand as codons (Aretha)

       
        ArrayList<String> ORFAcodons = new ArrayList<String>();
        for (int i=0; i<ORFA.size(); i++) {
            String orf = ORFA.get(i);
            char[] orf_char = orf.toCharArray();
            String codon = new String();
                for (int k=1; k<=orf_char.length; k++) {
                    codon += orf_char[k-1];
                    if (k%3==0 && k != orf_char.length) {
                    codon += '-';
                    }
                }
            ORFAcodons.add(codon);
        }
     
        ArrayList<String> ORFBcodons = new ArrayList<String>();
            for (int i=0; i<ORFB.size(); i++) {
                String orf = ORFB.get(i);
                char[] orf_char = orf.toCharArray();
                String codon = new String();
                        for (int k=1; k<=orf_char.length; k++) {
                                        codon += orf_char[k-1];
                                        if (k%3==0 && k != orf_char.length) {
                                        codon += '-';
                                }
                        }
                ORFBcodons.add(codon);
            }



        //////////////////////////Transcribe ORFS--------------------------------------------------------------------Aretha
        
        
        ArrayList<String> AmRNA = new ArrayList<String>();
        ArrayList<String> BmRNA = new ArrayList<String>();
        
                
        for (int i=0; i<ORFA.size(); i++) {
            
            String s = ORFA.get(i);
            for (int k=0; k<s.length(); k++) {
                if (ORFA.get(i)=="t") {
                    //AmRNA.add(MakeRNA(ORFA.get(i)));
                    AmRNA.set(i, "u");
                }
            }
            //System.out.println("ORF-- 1+:" + ORFA.get(i)); 
        }	    
        for (int i=0; i<ORFB.size(); i++) {
            String s = ORFB.get(i);
            for (int k=0; k<ORFB.size(); k++) {
                if (ORFB.get(i)=="t") {
                    BmRNA.set(i, "u");
                }
            }
	    //System.out.println("ORF -- 1+:" + s); 
        }	
        
        for(final String letter : ORFA ){
            AmRNA.add(MakeRNA(letter));
        }
        for(final String letter : ORFB){
            BmRNA.add(MakeRNA(letter));
        }
	    
	    
////////////updated transcription code 2/27
/*
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
			  
for (int i=0; i<ORFB.size(); i++) {
        ArrayList<Character> mRNA = new ArrayList<Character>();
        String s = ORFB.get(i);
        char[] mrna = s.toCharArray();
            for (int k=0; k<s.length(); k++) {
                    if (s.charAt(k)=='T') {
                            mrna[k] = 'U';
                    }
            }
       String RNA = new String(mrna);
       BmRNA.add(RNA);
 }
*/
	    	    
        
        /////////////////////////////////////////////mRNA listed as codons/////////////////////////
        
        ///////////////////////////////////////////////////////////////////////////////
        
        ArrayList<String> AmRNAcodons = new ArrayList<String>();
        for (int i=0; i<AmRNA.size(); i++) {
            String orf = AmRNA.get(i);
            char[] orf_char = orf.toCharArray();
            String codon = new String();
                for (int k=1; k<=orf_char.length; k++) {
                    codon += orf_char[k-1];
                    if (k%3==0 && k != orf_char.length) {
                    codon += '-';
                    }
                }
            AmRNAcodons.add(codon);
        }
     
        ArrayList<String> BmRNAcodons = new ArrayList<String>();
            for (int i=0; i<BmRNA.size(); i++) {
                String orf = BmRNA.get(i);
                char[] orf_char = orf.toCharArray();
                String codon = new String();
                        for (int k=1; k<=orf_char.length; k++) {
                                        codon += orf_char[k-1];
                                        if (k%3==0 && k != orf_char.length) {
                                        codon += '-';
                                }
                        }
                BmRNAcodons.add(codon);
            }
        
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        //System.out.println("mRNA listed as codons");
        for (int j=0; j<AmRNA.size(); j++) {
        
            String orf = AmRNA.get(j);
                for (int k=1; k<ORFA.size(); k++) {
                    String thas = ORFA.get(k);
                    codons.add(thas);
                    if (k%3==0) {
                    codons.add("-");	
                    }
                }
        //System.out.println("ORF 1+:" + codons);
        }

        
        /////////////////////////////////////////////////////////////////////////////
        ////////////// tRNA/////////////////////////////////////////////////////

        final ArrayList<String> tRNAA = new ArrayList<String>();
        final ArrayList<String> tRNAB = new ArrayList<String>();

        for (final String letter : ORFAcodons) {
            int leg = letter.length();
            tRNAA.add(MaketRNA(letter.substring(0, leg-4)));

        }


        for(final String letter: ORFBcodons){
            int leg = letter.length();
            tRNAB.add(MaketRNA(letter.substring(0, leg-4)));

        }

        //System.out.printf("\ntRNA\n");

        /*for (final Character rna : tRNA) {
            System.out.print(rna);
        }*/

        scnr.close();

        System.out.printf("\nORFs and indicate/highlight on the non-template +DNA strand (5’->3’)\n");
        for (final Character dna : DNA){
            System.out.print(dna);
        }


        System.out.printf("\n\nORFs and indicate/highlight on the non-template -DNA strand (5’->3’)\n");
        for (final Character compdna : complementDNA) {
            
             System.out.print(compdna);
         }

        System.out.printf("\n\nDNA ORFs listed");
        System.out.printf("\nORF 1+:" + ORFA);
        System.out.printf("\nORF 1-:" + ORFB);
        
        System.out.printf("\n\nDNA ORFs listed as codons");
        System.out.printf("\nORF 1+:" + ORFAcodons);
        System.out.printf("\nORF 1-:" + ORFBcodons);

        System.out.printf("\n\nmRNA listed");
        System.out.printf("\nORF 1+:" + AmRNA);
        System.out.printf("\nORF 1-:" + BmRNA);

        System.out.printf("\n\nmRNA listed as codons");
        System.out.printf("\nORF 1+:" + AmRNAcodons);
        System.out.printf("\nORF 1-:" + BmRNAcodons);

        System.out.printf("\n\ntRNA listed");
        System.out.printf("\nORF 1+:"+ tRNAA);
        System.out.printf("\nORF 1-:" + tRNAB);
        
         //System.out.printf("\nnon-Template ORFs are: " + ORFB);
         //System.out.printf("\nTemplate ORFs are: " + ORFA);
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

    public static String MakeRNA(String let){
           
        for(int i = 0; i<let.length(); i++){
            switch (let.charAt(i)) {
                    case ('t'):
                        let = let.substring(0,i)+'u' + let.substring(i+1);
                        break;
                    
            }
        }
        return let;
    }

    public static String MaketRNA(String let){
           
        for(int i = 0; i<let.length(); i++){

            switch (let.charAt(i)) {
                    case ('a'):
                        let = let.substring(0,i)+'u' + let.substring(i+1);
                        break;
                    case ('t'):
                    let = let.substring(0,i)+'a' + let.substring(i+1);
                        break;
                    case ('g'):
                    let = let.substring(0,i)+'c' + let.substring(i+1);
                        break;
                    case ('c'):
                    let = let.substring(0,i)+'g' + let.substring(i+1);
                        break;
            }
        }
        return let;
    }

}

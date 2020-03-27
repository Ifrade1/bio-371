import java.io.File;   //include.file
import java.util.*; //include .Scanner
import java.util.ArrayList;
import java.io.FileNotFoundException;

class Nice {
    public static void main(final String arg[]) {

        //////////////////////// Scan from file to Char ArrayList
        final Scanner scnr = new Scanner(System.in);
        final ArrayList<Character> DNA = new ArrayList<Character>();
        String longWord;
        ArrayList<String> codons = new ArrayList<String>();
	String dnaName = "unknown";

	System.out.println("What file?");
	String fileName = scnr.next();

//sets parameters and prints name
        try {
            final File example = new File(fileName);
            final Scanner filo = new Scanner(example);

            System.out.println("Is it 5->3?(Y/N): ");
            final char or = scnr.next().charAt(0);

            while(filo.hasNextLine()){

                longWord = filo.nextLine();//.toLowerCase();


                longWord.replaceAll("\\s+","");


                if ((or == 'Y') || (or == 'y')) {
                    for (int i = 0; i < longWord.length(); i++) {
                        if(longWord.charAt(i) == '>'){

                            dnaName = longWord.substring(i+1, longWord.indexOf(' '));
                            System.out.println("Name found: " + dnaName);
                            break;
                        }
                        else{
                            longWord = longWord.toLowerCase();
                        }
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
                    for (int i = longWord.length() - 1; i >= 0; i--) {
                        if(longWord.charAt(i) == '>'){
                            dnaName = longWord.substring(i+1, longWord.indexOf(' '));
                            System.out.println("Name found: " + dnaName);
                            break;
                        }
                        else{
                            longWord = longWord.toLowerCase();
                        }
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
            }
            filo.close();
        }
	catch (final FileNotFoundException e) {
        	System.out.println("file not found");
        }


        ////////////////makes ArrayList for complementary strand
        final ArrayList<Character> complementDNA = new ArrayList<Character>(); // new complement strand


        //////////////////// makes complementary strand in complementDNAfrom DNA, reads
        //////////////////// 5' to 3'

        for(int i = DNA.size()-1; i>=0;i--){
            char dna = DNA.get(i);
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

        //FILTER, sets minimum orf size
        int minsize = 0; //minimum orf size

        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to filter the size of ORFS?(minimum ORF size if yes, 0 if no)");
        int orfsize =scan.nextInt();
                  minsize = orfsize;


/////////ORFs for complementDNA
  final ArrayList<String> ORFB = new ArrayList<String>();
  final ArrayList<String> ORFlocB = new ArrayList<String>();
  String ORFSB = "";
  String ORFBgood = "";
  final String ComplementDNA = getStringRepresentation(complementDNA);
                  //ArrayList<String> ORFloc = new ArrayList<String>();
                  for (int rf=0; rf<=2 ; rf++) {
                      for (int i=rf; i< ComplementDNA.length()-2; i = i+3) {
                            String codon = ComplementDNA.substring(i, i+3);

                            if (codon.equals("atg")) {
                            	System.out.println("start codon found");
				
				    //////////Changes th ORF to captital in complement strand/////
				complementDNA.set(i, MakeUpperCase(complementDNA.get(i)));
                            	complementDNA.set(i+1, MakeUpperCase(complementDNA.get(i+1)));
                            	complementDNA.set(i+2, MakeUpperCase(complementDNA.get(i+2)));
				    
                            for (int j = i+3; j< ComplementDNA.length() - 2; j = j+3) {
                                    String codon2 = ComplementDNA.substring(j, j+3);
				    
				    //////////Changes th ORF to captital in complement strand/////
				 	complementDNA.set(j, MakeUpperCase(complementDNA.get(j)));
                                	complementDNA.set(j+1, MakeUpperCase(complementDNA.get(j+1)));    
                                	complementDNA.set(j+2, MakeUpperCase(complementDNA.get(j+2)));

				    
                                    System.out.println(codon2);
                                    if ((codon2.equals("taa"))||(codon2.equals("tag"))||(codon2.equals("tga"))) {
                                         String orf = ComplementDNA.substring(i,j+3);
                                         System.out.println("found orf is "+ orf);

                                  if (orf.length() >= minsize) {
                                  ORFBgood = orf;
                                  }

                                  else ORFBgood = "";
                                  System.out.println("ORF good is "+ ORFBgood);


                                  if (ORFBgood != "") {
                                  ORFB.add(ORFBgood);
                                  }

                                  ORFBgood = "";


                                  break;
                            }

                          }

                        }
                      }
                    }

        final String Dna = getStringRepresentation(DNA);
        ArrayList<String> ORFA = new ArrayList<String>();
        //ArrayList<String> ORFloc = new ArrayList<String>();
        String ORFS = new String();
        String ORFgood = new String();

        for (int rf=0; rf<=2 ; rf++) {
            for (int i=rf; i< Dna.length()-2; i = i+3) {
                  String codon = Dna.substring(i, i+3);

                  if (codon.equals("atg")) {
                  System.out.println("start codon found");
			  
			  //////////Changes th ORF to captital in DNA strand/////
			  DNA.set(i, MakeUpperCase(DNA.get(i)));
			  DNA.set(i+1, MakeUpperCase(DNA.get(i+1)));    
			  DNA.set(i+2, MakeUpperCase(DNA.get(i+2)));


                  for (int j = i+3; j< Dna.length() - 2; j = j+3) {
			
			  //////////Changes th ORF to captital in DNA strand/////
				DNA.set(j, MakeUpperCase(DNA.get(j)));
				DNA.set(j+1, MakeUpperCase(DNA.get(j+1)));    
				DNA.set(j+2, MakeUpperCase(DNA.get(j+2)));

                          String codon2 = Dna.substring(j, j+3);
                          System.out.println(codon2);
                          if ((codon2.equals("taa"))||(codon2.equals("tag"))||(codon2.equals("tga"))) {
                               String orf = Dna.substring(i,j+3);
                               System.out.println("found orf is "+ orf);

                        if (orf.length() >= minsize) {
                        ORFgood = orf;
                        }

                        else ORFgood = "";
                        System.out.println("ORF good is "+ ORFgood);


                        if (ORFgood != "") {
                        ORFA.add(ORFgood);
                        }

                        ORFgood = "";


                        break;
                  }

                }

              }
            }
          }








	    ///////lists ORF as codons
	    /////for every third char add a dash, excluding last char
    ////////////////////////////lists ORFs from original DNA strand as codons
    ArrayList<String> ORFAcodons = toCodons(ORFA);
    //TO CODONS
    ArrayList<String> ORFBcodons = toCodons(ORFB);

        //////////////////////////TRANSCRIPTION////

        ArrayList<String> AmRNA = tomRNA(ORFA);
        ArrayList<String> BmRNA = tomRNA(ORFB);
//AmRNA holds mRNA from original DNA strand, BmRNA holds mRNA from complementary strand



        /////////////////////////////////////////////mRNA from original and complementary DNA strand listed as codons//////////////////////////
	///for every third char add a dash, excluding last char
      ArrayList<String> AmRNAcodons = toCodons(AmRNA);
      ArrayList<String> BmRNAcodons = toCodons(BmRNA);


        /////////////////////////////////////////////////////////////////////////////
        ////////////// tRNA codons/////////////////////////////////////////////////////

        final ArrayList<String> tRNAA = new ArrayList<String>();
        final ArrayList<String> tRNAB = new ArrayList<String>();

        for (final String letter : ORFAcodons) {
            int leg = letter.length();
            tRNAA.add(MaketRNA(letter));

        }


        for(final String letter: ORFBcodons){
            int leg = letter.length();
            tRNAB.add(MaketRNA(letter));

        }
///////////////////////TRANSLATION: Turn open reading frames into amino acids////////////
ArrayList<String> ORFBoth = new ArrayList<String>();
ORFBoth.addAll(ORFA);
ORFBoth.addAll(ORFB);
String currentORF;
ArrayList<String> aminoArray = new ArrayList<String>();
String amino = "";
for (int j = 0; j < ORFBoth.size(); j++){
    currentORF = ORFBoth.get(j);
    for (int i = 0; i< currentORF.length(); i= i+3){
/////U
    if (currentORF.charAt(i) == 'u' || currentORF.charAt(i) =='t'){  //Starts with U  || 'T' || 't')
        if (currentORF.charAt(i+1) == 'c'){ //UC*
            amino = amino + "" +'S';// then the amino acid is ser
        }
        else if (currentORF.charAt(i+1) == 'u' || currentORF.charAt(i+1) =='t'){
            if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c'){
                amino = amino + "" +'F';// then amino acid is phe //UUC or UUU
            }
            else if(currentORF.charAt(i+2) == 'a' || currentORF.charAt(i+2) =='g'){
                amino = amino + "" +'L';//then amino acid is leu
            }
        }
        else if (currentORF.charAt(i+1) == 'a'){
            if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c'){//then amino acid is tyr
                amino = amino + "" +'Y';
            }
            else if (currentORF.charAt(i+2) == 'a') {
                amino = amino + "*";
            }
            else if (currentORF.charAt(i+2) =='g'){   //then stop
               amino = amino + "*";
            }
        }
        else if (currentORF.charAt(i+1) == 'g'){
            if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c'){  //then amino acid is cys
                amino = amino + "" + 'C';
            }
            else if(currentORF.charAt(i+2) == 'a'){ // then stop
                amino = amino + "*";
                }
            if (currentORF.charAt(i+2) == 'g'){ // then amino acid is trp
                amino = amino + "" +'W';
            }
        }
    }
    ////C
    if (currentORF.charAt(i) == 'c'){
        if (currentORF.charAt(i+1) == 'c'){ //then the amino acid is pro
            amino = amino + "" +'P'; //CC*
        }
        else if (currentORF.charAt(i+1) == 'u' || currentORF.charAt(i+1) =='t'){ // then the amino acid is leu
        amino = amino + "" +'L'; //CU*
        }
        else if (currentORF.charAt(i+1) == 'a'){ //
                if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c'){// then amino acid is his
                    amino = amino + "" +'H';
                }
                else if (currentORF.charAt(i+2) == 'a' || currentORF.charAt(i+2) =='g' ){ //then amino acid is gln
                    amino = amino + "" +'Q';
                }
            }
        else if (currentORF.charAt(i+1) =='g'){  // then amino acid is arg
            amino = amino + "" +'R';
                }
            }
    //////A
    if  (currentORF.charAt(i) == 'a'){
        if (currentORF.charAt(i+1) == 'c') {  //then the amino acid is thr
        amino = amino + "" +'T';
        }
        else if (currentORF.charAt(i+1) == 'u' || currentORF.charAt(i+1) =='t'){
            if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c' || currentORF.charAt(i+2) =='a'){ //then amino acid is ile
                amino = amino + "" +'I';
            }
            else if (currentORF.charAt(i+2) == 'g'){//then amino acid is met
                amino = amino + "" +'M';
            }
        }
        else if (currentORF.charAt(i+1) == 'a'){
            if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c'){
                amino = amino + "" +'N';
            } //then amino acid is asn
            else if (currentORF.charAt(i+2) == 'a' || currentORF.charAt(i+2) =='g'){
                amino = amino + "" +'K';
            } //then amino acid is lys
        }
        else if (currentORF.charAt(i+1) =='g'){
            if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c'){
                amino = amino + "" +'S';
            } // then amino acid is ser
            else if (currentORF.charAt(i+2) == 'a' || currentORF.charAt(i+2) == 'g'){ //AGG
                amino = amino + "" +'R'; //AGA or AGG
            } //then amino acid is arg
        }
    }
    ///////G
    if (currentORF.charAt(i) == 'g'){
        if (currentORF.charAt(i+1) == 'c'){
            amino = amino + "" + 'A';  //then the amino acid is ala
        }//GC*
        else if (currentORF.charAt(i+1) == 'u' || currentORF.charAt(i+1) =='t'){
            amino = amino + "" +'V'; //then amino acid is val
        } //GU*
        else if (currentORF.charAt(i+1) == 'a'){
            if (currentORF.charAt(i+2) == 'u' || currentORF.charAt(i+2) =='t'|| currentORF.charAt(i+2) == 'c'){
                amino = amino + "" +'D';  //then amino acid is asp
            }
            else if (currentORF.charAt(i+2) == 'a' || currentORF.charAt(i+2) =='g') {// then amino acid is glu
                amino = amino + "" +'E'; //GAG
            }
        }
        else if (currentORF.charAt(i+1) =='g'){ //then amino acid is gly
            amino = amino + "" +'G'; //GG*
            }
        }

    }
    aminoArray.add(amino);
	amino = "";

}
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
        //System.out.printf("\nORF 1+:");
         for(int i=0;i<ORFA.size();i++){
             System.out.printf("\n\nORF" +(1+i)+ "+:"+ORFA.get(i));
         }
        //System.out.printf("\nORF 1-:");
        for(int i=0;i<ORFB.size();i++){
            System.out.printf("\n\nORF "+(1+i)+ "-:"+ORFB.get(i));
        }

        System.out.printf("\n\nDNA ORFs listed as codons");
        //System.out.printf("\nORF 1+:" + ORFAcodons);
        for(int i=0;i<ORFAcodons.size();i++){
            System.out.printf("\n\nORF"+ (i+1) +"+: "+ORFAcodons.get(i));
        }
        //System.out.printf("\nORF 1-:" + ORFBcodons);
        for(int i=0;i<ORFBcodons.size();i++){
            System.out.printf("\n\nORF "+(1+i) +"-: " + ORFBcodons.get(i));
        }

        System.out.printf("\n\nmRNA listed");
        //System.out.printf("\nORF 1+:" + AmRNA);
        for(int i=0;i<AmRNA.size();i++){
            System.out.printf("\n\nmRNA " + (i+1)+ "+: " + AmRNA.get(i));
        }
        //System.out.printf("\nORF 1-:" + BmRNA);
        for(int i=0;i<BmRNA.size();i++){
            System.out.printf("\n\nmRNA " + (1+i) + "-: " + BmRNA.get(i));
        }

        System.out.printf("\n\nmRNA listed as codons");
        //System.out.printf("\nORF 1+:" + AmRNAcodons);
        for(int i=0;i<AmRNAcodons.size();i++){
            System.out.printf("\n\nmRNA " + (1+i) + "+: " + AmRNAcodons.get(i));
        }
        //System.out.printf("\nORF 1-:" + BmRNAcodons);
        for(int i=0;i<BmRNAcodons.size();i++){
            System.out.printf("\n\nmRNA " + (1+i)+ "-: " + BmRNAcodons.get(i));
        }

        System.out.printf("\n\ntRNA listed");
        //System.out.printf("\nORF 1+:"+ tRNAA);
        for(int i=0;i<tRNAA.size();i++){
            System.out.printf("\n\ntRNA "+ (i+1) +"+: " + tRNAA.get(i));
        }
        //System.out.printf("\nORF 1-:" + tRNAB);
        for(int i=0;i<tRNAB.size();i++){
            System.out.printf("\n\ntRNA " + (1+i) + "-: " + tRNAB.get(i));
        }

///Print out Proteins
    for(int i=0;i<aminoArray.size();i++){
    System.out.printf("\n\nProtein " + (1+i) + ": " + aminoArray.get(i));
        }


         //System.out.printf("\nnon-Template ORFs are: " + ORFB);
         //System.out.printf("\nTemplate ORFs are: " + ORFA);
         System.out.printf("\n\n\n\n\t\t\t:)\n");
    }


public static char MakeUpperCase(char let){
        switch(let){
        	case('a'):
		case('A'):	
                	return 'A';
            	case('t'):
		case('T'):
                	return 'T';
            	case('g'):
		case('G'):
                	return 'G';
            	case('c'):
		case('C'):
                	return 'C';
            	case('u'):
		case('U'):
                	return 'U';

        }
        return 'D';
    }




    public static ArrayList<String> toCodons (ArrayList<String> sequence) {
      int size = sequence.size();

      ArrayList<String> incodons = new ArrayList<String>(); //to be returned

      for (int i=0; i<size; i++) {
          String orf = sequence.get(i);
          char[] orf_char = orf.toCharArray();
          String codon = new String();
              for (int k=1; k<=orf_char.length; k++) {
                  codon += orf_char[k-1];
                  if (k%3==0 && k != orf_char.length) {
                  codon += '-';
                  }
              }
          incodons.add(codon);
      }
      return incodons;
    }

    public static ArrayList<String> tomRNA (ArrayList<String> sequence) {
      ArrayList<String> newmRNA = new ArrayList<String>(); //tobereturned
      int size = sequence.size();
          for (int i=0; i<size; i++) {
                  ArrayList<Character> mRNA = new ArrayList<Character>();
                  String s = sequence.get(i);
                  char[] mrna = s.toCharArray();
                      for (int k=0; k<s.length(); k++) {
                              if (s.charAt(k)=='t') {
                                      mrna[k] = 'u';
                              }
                      }
                 String RNA = new String(mrna);
                 newmRNA.add(RNA);
           }
          return newmRNA;
}



public static String getStringRepresentation(ArrayList<Character> list)
{
    StringBuilder builder = new StringBuilder(list.size());
    for(Character ch: list)
    {
        builder.append(ch);
    }
    return builder.toString();
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

package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Read from file to ArrayList DNA ------------------------------------------------Elena
Orientation-correct it to 5’ to 3’ ----tell you in file
If i starts with 3, then there will have to be a loop to flip it
*/

/* Want 5’-3’
Find ORFs -------------------------------------------------------------------------------------- Nic
Find A first
Then T,  then G→ START
If find ATG --- start logging into ArrayList ORF
STOP codon: TAA, TAG, TGA
If find T
If find A
Then if A or G → STOP
If find G then A→ STOP
New array list
*/
	    
//Aretha--make complementary strand, find ORFs of complementary strand
ArrayList<Character> inputB = new ArrayList <Character>();
    ArrayList<String> ORFB = new ArrayList<String>();
    ArrayList<String> ORFlocB = new ArrayList<String>();
    String ORFSB = new String();
	    
//makes complementary strand in inputB from inputA, reads 5' to 3'
for (i=inputA.size(); i=0; i--) {
if inputA.get(i) == 'a' {
	inputB.add('t');
}
	else if inputA.get(i) == 't' {
		inputB.add('a');
	}
		else if inputA.get(i) == 'c' {
			inputB.add('g');
		}
			else if inputA.get(i) == 'g' {
				inputB.add('c');
			}
}

	    //finds ORF in inputB 
    for (i=0; (i + 2) < inputB.size(); i++) {
      if ((inputB.get(i) == 'a') && (inputB.get(i+1) == 't') && (inputB.get(i+2)) == 'g') {
        //System.out.println("ORF found at " + i);
        ORFloc.add("" + i);

        for (int o = 0; i + 2 < inputB.size(); o++) {
          if (o != 0 && o%3 == 0) {
            if (inputB.get(i) == 't') {
              if
                ((inputB.get(i+1) == 'a' && inputB.get(i+2) == 'g') ||
                (inputB.get(i+1) == 'a' && inputB.get(i+2) == 'a') ||
                (inputB.get(i+1) == 'g' && inputB.get(i+2) == 'a'))
              {
                  //System.out.println("STOP codon found at " + i);
                  ORFSB = ORFSB + "" + inputB.get(i);
                  ORFSB = ORFSB + "" + inputB.get(i+1);
                  ORFSB = ORFSB + "" + inputB.get(i+2);
                  i = i+2;
                  break;
              }
            }
          }
          ORFSB = ORFSB + "" + inputB.get(i);
          i++;
        }
        ORFB.add(ORFSB);
        ORFSB = "";
      }
    }
    System.out.println("ORFs are: " + ORFB);
    System.out.println("ORFs at: " + ORFlocB);
  }
}

//Transcribe ORFS--------------------------------------------------------------------Aretha
ArrayList<String> ORFA = new ArrayList<>(); 
ArrayList<String> AmRNA =  (ArrayList<String>) ORFA.clone();
ArrayList<String> ORFB = new ArrayList<>(); 
ArrayList<String> BmRNA =  (ArrayList<String>) ORFB.clone();
	    

for (i=0, i<ORFA.length(), i++) {
	String s = ORFA.get(i);
	for (k=0, k<s.length(); k++) {
		if ORFA.get(i)=="T" {
			AmRNA.set(i, "U");
		}
	}
	System.out.println("ORF 1+:" + s );
}	    

for (i=0, i<ORFB.length(), i++) {
	String s = ORFB.get(i);
	for (k=0, k<s.lengh(); k++) {
	if ORFB.get(i)=="T" {
		BmRNA.set(i, "U");
		}
	}
	System.out.println("ORF 1+:" + s );
}	  




//mRNA listed as codons
System.out.println("mRNA listed as codons");
For (i=0; i<AmRNA.length(); i++) {
ArrayList<String> codons = new ArrayList<String>();
	String orf = AmRNA.get(i);
		For (k=1; k<=s.length(); k++) {
			codons.add(orf[k]);
			If (k%3==0) {
			codons.add(“-“);	
}
}
System.out.println("ORF 1+:" + codons);
}




	 mRNA: Copy ORF ArrayList--- change T to U
//tRNA print it -----------------------------------------------------------------------------------Elena
//Transcribe it by pairings
//Amino acids - use mod to keep track of position in the codon---------------------------Issy 
//I need to turn this into a class, so i don't need to copy and paste this to run it for both orf
/* ArrayList<String> Amino = new ArrayList<String>();
for (int i = 0; i < ){
if (array[i] == ‘u’)||(array[i] == 'U'){  //Starts with U
	if (array [i+1] == ‘c’){
		// then the amino acid is ser
	}
	else if (array[i+1] == ‘u’){
		if (array[i+2] == ‘u’ || ‘c’){
		}
		// then amino acid is phe		
		else( if array[i+2] == ‘a’ ||  ‘g’){
		}
			//then amino acid is leu
	else if (array[i+1] == ‘a’){ 
		if (array [i+2] == 'u' || 'c' )//then amino acid is tyr	
		else if (array[i+2] == ‘a’ || ‘g’) //then stop
			}
	else if (array[i+1] == ‘g’)
		if (array [i+2] == 'u' || 'c')  //then amino acid is cys
			else if( array[i+2] == ‘a’) // then stop
 		if (array [i+2] == g) // then amino acid is trp

if (array[i] = ‘c’)
	if (array [i+1] == ‘c’) //then the amino acid is pro
	else (if array[i+1] == ‘u’) // then the amino acid is leu
	else if (array[i+1] == 'a'){ //
		if (array [i+2] == 'u' || 'c' )// then amino acid is his
		else if (array[i+2] == ‘a’ || ‘g’) //then amino acid is gln
			}
	else if (array[i+1] == ‘g’) // then amino acid is arg


if array[i] = ‘a’
	if array [i+1] == ‘c’  //then the amino acid is thr
	else if array[i+1] == ‘u’
		if (array[i+2] == ‘u’ || ‘c’ || ‘a’)  //then amino acid is ile
		else if( array[i+2] ==  ‘g’)//then amino acid is met
	else if array[i+1] == ‘a’{
		if (array [i+2] == 'u' || 'c') //then amino acid is asn
		else if array[i+2] == ‘a’ || ‘g’ //then amino acid is lys
	else if array[i+1] == ‘g’
		if (array [i+2] == 'u' || 'c') // then amino acid is ser
		else if (array[i+2] == ‘a’) //then amino acid is arg

if array[i] = ‘g’{
	if (array [i+1] == ‘c’ ) //then the amino acid is ala
	else (if array[i+1] == ‘u’) then amino acid is val
	else if (array[i+1] == ‘a’)
		if (array [i+2] == 'u' || 'c' ) //then amino acid is asp
		else if (array[i+2] == ‘a’ || ‘g’) // then amino acid is glu
	else if (array[i+1] == ‘g’) //then amino acid is gly
		}
		*/
/* length 100-10,000
Polarity matters- flip if want(correct orientation)
Print open reading frames, mRNA, tRNA

5` and 3` UTR (only translate Start to Stop), can be in 3’-5’ direction
identify ORF, Start/STOP codon, output mRNA and tRNA w polarity
Translate the sequence into AA

Concat, print out every open reading frame
*/
    }
}

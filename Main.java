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
	for (k=0, k<s.lengh(); k++) {
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

	
/* mRNA: Copy ORF ArrayList--- change T to U
tRNA print it -----------------------------------------------------------------------------------Elena
Transcribe it by pairings
Amino acids - use mod to keep track of position in the codon---------------------------Issy */
 ArrayList<String> Amino = new ArrayList<String>();
(if i mod 3  == 0){
if (array[i] == ‘u’)||(array[i] == 'U'){
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
	else if array[i+1] == ‘a’
If array [i+2] == u || c then amino acid is tyr
Else if array[i+2] == ‘a’ || ‘g’ then stop
Else if array[i+1] == ‘g’
If array [i+2] == u || c then amino acid is cys
Else if array[i+2] == ‘a’ then stop
If array [i+2] == g then amino acid is trp
If array[i] = ‘c’
If array [i+1] == ‘c’ then the amino acid is pro
Else if array[i+1] == ‘u’ then the amino acid is leu
Else if array[i+1] == ‘a’
If array [i+2] == u || c then amino acid is his
Else if array[i+2] == ‘a’ || ‘g’ then amino acid is gln
Else if array[i+1] == ‘g’ then amino acid is arg


If array[i] = ‘a’
If array [i+1] == ‘c’  then the amino acid is thr
Else if array[i+1] == ‘u’
If array[i+2] == ‘u’ || ‘c’ || ‘a’  then amino acid is ile
Else if array[i+2] ==  ‘g’ then amino acid is met
Else if array[i+1] == ‘a’
If array [i+2] == u || c then amino acid is asn
Else if array[i+2] == ‘a’ || ‘g’ then amino acid is lys
Else if array[i+1] == ‘g’
If array [i+2] == u || c then amino acid is ser
Else if array[i+2] == ‘a’ then amino acid is arg
If array[i] = ‘g’
If array [i+1] == ‘c’  then the amino acid is ala
Else if array[i+1] == ‘u’ then amino acid is val
Else if array[i+1] == ‘a’
If array [i+2] == u || c then amino acid is asp
Else if array[i+2] == ‘a’ || ‘g’ then amino acid is glu
Else if array[i+1] == ‘g’ then amino acid is gly


length 100-10,000
Polarity matters- flip if want(correct orientation)
Print open reading frames, mRNA, tRNA

5` and 3` UTR (only translate Start to Stop), can be in 3’-5’ direction
identify ORF, Start/STOP codon, output mRNA and tRNA w polarity
Translate the sequence into AA

Concat, print out every open reading frame
*/
    }
}

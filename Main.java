package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Read from file to ArrayList DNA ------------------------------------------------Elena
Orientation-correct it to 5’ to 3’ ----tell you in file
If i starts with 3, then there will have to be a loop to flip it.
Want 5’-3’
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
/*Transcribe it : Copy ORFs--------------------------------------------------------------------Aretha*/
ArrayList<String> mRNA = new ArrayList<>(); 
ArrayList<String> mRNA =  (ArrayList<String>) DNA.clone();

	    
for (i=0, i<DNA.length, i++) {
	if DNA.get(i)=="T" {
		DNA.set(i, )
	    
	


mRNA: Copy ORF ArrayList--- change T to U
tRNA print it -----------------------------------------------------------------------------------Elena
Transcribe it by pairings
Amino acids - use mod to keep track of position in the codon---------------------------Issy
(if i mod 3  == 0)
If array[i] = ‘u’
If array [i+1] == ‘c’ then the amino acid is ser
Else if array[i+1] == ‘u’
If array[i+2] == ‘u’ || ‘c’ then amino acid is phe
Else if array[i+2] == ‘a’ || or ‘g’ then amino acid is leu
Else if array[i+1] == ‘a’
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

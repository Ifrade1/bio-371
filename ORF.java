//Nicholas Stoltzfus
//Bio371
//2/23/2020

//javac ORF.java
//java ORF

import java.util.ArrayList;

public class ORF {

  public static int i;

  public static void main(String[] args){

    // String inputS = "ccccggttatccccccgaggggagggcgagcgatcccccgctaacatattgttaccagtgacgcagctgtgtattctgcacaggtggccaacgggttccacacttcacagatggtggggatcccggcaaagggcgtgtgtttgcggcccaacacaggcgtagactacgacggcgcctactcagacgcagctcgtgcggcgtgaataacgtactcatcccaactgattctcggcaatctacggagcgacacgattatcaacggctgtctagcagttctaatctcttgccacggtcgtaaaagcctccaagagactgatcatacccatcggcgcagaggtgacacggcgccggtgggtagcggactttgggtcagccgcagttcggcaggggacaggccctg";
    String inputS = "atgaaatagtttttatgaaatgatgatgaaatgaatga";

    ArrayList<Character> inputA = new ArrayList <Character>();

    for (int i=0; i < inputS.length(); i++) {
      char pt = inputS.charAt(i);
      inputA.add(pt);
    }

    ArrayList<String> ORFA = new ArrayList<String>();
    ArrayList<String> ORFloc = new ArrayList<String>();
    String ORFS = new String();

    for (i=0; (i + 2) < inputA.size(); i++) {
      if ((inputA.get(i) == 'a') && (inputA.get(i+1) == 't') && (inputA.get(i+2)) == 'g') {
        //System.out.println("ORF found at " + i);
        ORFloc.add("" + i);

        for (int o = 0; i + 2 < inputA.size(); o++) {
          if (o != 0 && o%3 == 0) {
            if (inputA.get(i) == 't') {
              if
                ((inputA.get(i+1) == 'a' && inputA.get(i+2) == 'g') ||
                (inputA.get(i+1) == 'a' && inputA.get(i+2) == 'a') ||
                (inputA.get(i+1) == 'g' && inputA.get(i+2) == 'a'))
              {
                  //System.out.println("STOP codon found at " + i);
                  ORFS = ORFS + "" + inputA.get(i);
                  ORFS = ORFS + "" + inputA.get(i+1);
                  ORFS = ORFS + "" + inputA.get(i+2);
                  i = i+2;
                  break;
              }
            }
          }
          ORFS = ORFS + "" + inputA.get(i);
          i++;
        }
        ORFA.add(ORFS);
        ORFS = "";
      }
    }
    //System.out.println(inputA);
    System.out.println("ORFs are: " + ORFA);
    System.out.println("ORFs at: " + ORFloc);
  }
}

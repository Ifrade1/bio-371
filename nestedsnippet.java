String currentORFNested;
String ORFSNested = new String();
  ArrayList<String> ORFANested = new ArrayList<String>();
   for (int q=0; q < ORFA.size(); q++) { //testing this with ORFA for now
       currentORFNested = ORFA.get(q);
            //System.out.println(i);
            stringLen = currentORFNested.length(); //current length of ORF
            for (int r = 3; r <= stringLen; r++){ //go through string
                 if (currentORFNested.charAt(r) == 'a' || currentORFNested.charAt(r) == 'A') && (currentORFNested.charAt(r)(i+1) == 't' || currentORFNested.charAt(r)(i) == 'T') && (currentORFNested.charAt(r)(i+2)) == 'g' || currentORFNested.charAt(r)(i) == 'G') {
                    if (r != 0 && r%3 == 0) {
                         if (currentORFNested.charAt(r) == 't' || currentORFNested.charAt(r) == 'T') {
                            if (((currentORFNested.charAt(r+1) == 'a'  ||currentORFNested.charAt(r+1) == 'A') && (currentORFNested.charAt(r+2) == 'g' || currentORFNested.charAt(r+2) == 'G')) || //uag
                             ((currentORFNested.charAt(r+1) == 'a' || currentORFNested.charAt(r+1) == 'A') && currentORFNested.charAt(r+2) == 'a' || currentORFNested.charAt(r+2) == 'g') || //uaa
                            (currentORFNested.charAt(r+1) == 'g' && currentORFNested.charAt(r+2) == 'a'))){  //uga
                                //System.out.println("STOP codon found at " + i);
                                ORFSNested = ORFS + "" + currentORFNested.charAt(i);
                                ORFSNested = ORFS + "" + currentORFNested.charAt(i+1);
                                ORFSNested = ORFS + "" + currentORFNested.charAt(i+2);
                                //FILTER CODE
                                  if (ORFS.length()>=minsize) {
                                                ORFgood = ORFS;
                                                 ORFANested.add(ORFgood);
                                                //System.out.println("o is greater than minsize");
                                         }
                                else ORFgood = "";
                                //FILTER END
                                i = i+2;
                                break;
                            }
                        }
                    }
                    ORFS = ORFS + "" + currentORFNested.charAt(r);
                    i++;
                }
                if (ORFgood != "") {            
                }
                ORFS = "";
                ORFgood = "";
            }
        }

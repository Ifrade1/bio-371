ArrayList<String> aminoArray = new ArrayList<String>();
String amino = "";
public static String Translation(String let){
for (int j = 0; i < ORF.size(); j++){
    amino = aminoArray.get(j);
    for (int i = 0; i< amino.length(); i+3){
/////U 
    if ((ORF.get(i) == 'u'||'U' || 'T' || 't'){  //Starts with U
        if (ORF.get(i+1) == 'c' || 'C'){ //UC*
            amino = amino + "" +'S';// then the amino acid is ser	
        }
        else if (ORF.get(i+1) == 'u'||'U' || 'T' || 't'){
            if (ORF.get(i+2) == 'u'||'U' || 'T' || 't' ||'c' || 'C'){
                amino = amino + "" +'F';// then amino acid is phe
            }                    
            else( if ORF.get(i+2) == 'a' || 'A' || 'g' || 'G'){
                amino = amino + "" +'L';//then amino acid is leu
            }	
        }
        else if (ORF.get(i+1) == 'a' || 'A'){ 
            if (ORF.get(i+2) == 'u'||'U' || 'T' || 't' || 'c' || 'C' ){//then amino acid is tyr
                amino = amino + "" +'Y';
            }	
            else if (ORF.get(i+2) == 'a' || 'A' ||'g' || 'G'){   //then stop  
                amino = amino + "" +'  ';
            }
        }
        else if (ORF.get(i+1) =='g' || 'G'){
            if (ORF.get(i+2) =='u'||'U' || 'T' || 't' || 'c' || 'C'){  //then amino acid is cys
                amino = amino + "" +'c' || 'C';
            }
            else if(ORF.get(i+2) == 'a' || 'A'){ // then stop
                amino = amino + "" +'  ');
                }
            if (ORF .get(i+2) =='g' || 'G'){ // then amino acid is trp
                amino = amino + "" +'W';
            }
        }
    }
    ////C
    if (ORF.get(i) = 'c' || 'C'){
        if (ORF .get(i+1) == 'c' || 'C'){ //then the amino acid is pro
            amino = amino + "" +'P';
        }
        else (if ORF.get(i+1) == 'u'||'U' || 'T' || 't'){ // then the amino acid is leu
        amino = amino + "" +'L';
        }
        else if (ORF.get(i+1) == 'a' || 'A'){ //
                if (ORF .get(i+2) == 'u'||'U' || 'T' || 't' || 'c' || 'C' ){// then amino acid is his
                    amino = amino + "" +'H';
                }
                else if (ORF.get(i+2) == 'a' || 'A' ||'g' || 'G'){ //then amino acid is gln
                    amino = amino + "" +'Q';
                }
        else if (ORF.get(i+1) =='g' || 'G'){  // then amino acid is arg
            amino = amino + "" +'R';
                }
            }
        }
    //////A
    if  (ORF.get(i) = 'a' || 'A'){
        if (ORF .get(i+1) == 'c' || 'C') {  //then the amino acid is thr
        amino = amino + "" +'T';
        }
        else if () ORF.get(i+1) == 'u'||'U' || 'T' || 't'){
            if (ORF.get(i+2) == 'u' || 'c' || 'C' || 'a' || 'A'){ //then amino acid is ile
                amino = amino + "" +'I';
            } 
            else if( ORF.get(i+2) == 'g' || 'G'){//then amino acid is met
                amino = amino + "" +'M';
            }
        }
        else if (ORF.get(i+1) == 'a' || 'A'){
            if (ORF.get(i+2) == 'u'||'U' || 'T' || 't' || 'c' || 'C'){
                amino = amino + "" +'N';
            } //then amino acid is asn
            else if (ORF.get(i+2) == 'a' || 'A' ||'g' || 'G'){
                amino = amino + "" +'K';
            } //then amino acid is lys
        }
        else if (ORF.get(i+1) =='g' || 'G'){
            if (ORF.get(i+2) == 'u'||'U' || 'T' || 't' || 'c' || 'C'){
                amino = amino + "" +'S';
            } // then amino acid is ser
            else if (ORF.get(i+2) == 'a' || 'A'){
                amino = amino + "" +'R';
            } //then amino acid is arg
        }
    }
    ///////G        
    if (ORF.get(i) ='g' || 'G'){
        if (ORF.get(i+1) == 'c' || 'C' ){
            amino = amino + "" + 'A';  //then the amino acid is ala
        } 
        else (if ORF.get(i+1) == 'u'||'U' || 'T' || 't'){
            amino = amino + "" +'V'; //then amino acid is val
        } 
        else if (ORF.get(i+1) == 'a' || 'A'){
            if (ORF.get(i+2) == 'u'||'U' || 'T' || 't' || 'c' || 'C' ){
                amino = amino + "" +'D';  //then amino acid is asp
            }
            else if (ORF.get(i+2) == 'a' || 'A' ||'g' || 'G') {// then amino acid is glu
                amino = amino + "" +'Q';
            }
        }
        else if (ORF.get(i+1) =='g' ||'g' || 'G') //then amino acid is gly
            amino = amino + "" +'G';
            }
        }
    

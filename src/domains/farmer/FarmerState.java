/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.problem.State;
import java.util.stream.Stream;

public class FarmerState implements State {
    
        public FarmerState(String contentx,String contenty,String contentz, String contentxx) {
           // System.out.println( contentx);
            this.content1 = contentx;
            this.content2 = contenty;
            this.content3 = contentz;
            this.content4 = contentxx; 
            characters= new char[4];
            contents= new String[4];
             characters[0]='F';
            characters[1]='W';
            characters[2]='G';
            characters[3]='C';
            contents[0]=this.content1;
            contents[1]=this.content2;
            contents[2]=this.content3;
            contents[3]=this.content4;
            
        }
        @Override
 public int getContent(){
    return 1;
}
        @Override
        public boolean equals(Object other) {
            FarmerState otherFarmer = (FarmerState) other;
            if(otherFarmer== null){ return false;}
           for(int i=0;i<4;i++){
               if (contents[i]!=(String)otherFarmer.getContents()[i]) {
                  // System.out.println(contents[i] + "=="+(String)otherFarmer.getContents()[i]);
                   return false;
               }
           };
           return true;
        }
        @Override
        public String [] getContents(){
            return contents;
        }
        @Override()
        public void setContents(int i, String s ){
            contents[i]=s;
            this.content1=contents[0];
            //System.out.println("content 1 is "+ this.content1);
            this.content2=contents[1];
            //System.out.println("content 2 is "+ this.content2);
            this.content3=contents[2];
            //System.out.println("content 3 is "+ this.content3);
            this.content4=contents[3];
            //System.out.println("content 4 is "+ this.content4);
            
        }
       
        @Override
        public String toString() {  
           
           

            StringBuilder sb = new StringBuilder();
            
            sb.append("   ");
            sb.append(River);
            
            sb.append("   ");
            sb.append(NEW_LINE);
            for(int i=0;i<4;i++){
                
            
            if(contents[i]=="West"){
                sb.append(" ");
                sb.append(characters[i]);
                sb.append(" ");
                sb.append(River);
                sb.append("   ");
                sb.append(NEW_LINE);
                
            }
            else{
                sb.append("   ");
                sb.append(River);
                sb.append(" ");
                sb.append(characters[i]);
                sb.append(" ");
                sb.append(NEW_LINE);
            }
            }
            
            sb.append("   ");
            sb.append(River);
            sb.append("   ");
            
            
            return sb.toString();
        }

       

        private String  content1;
        private String content2;
        private String content3;
        private String  content4;

        private static final String NEW_LINE = "\n";
        private static final String River="|  |";
        private String[] contents;
        private char [] characters;
   
    }

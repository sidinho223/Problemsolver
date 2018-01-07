/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;

/**
 *
 * @author sidim
 */
import framework.problem.State;
import java.util.stream.Stream;

public class ArithmeticState implements State {
    
    
        public ArithmeticState(int contents) {
            this.contents = contents;
        }
        
        @Override
        public int getContent(){
            return contents;
        }

        @Override
        public boolean equals(Object other) {
            ArithmeticState otherArithmetic= (ArithmeticState) other;
            return this.contents==otherArithmetic.contents;
        }

        @Override
        public String toString() {
            
     
            

            StringBuilder sb = new StringBuilder();
            
 
            sb.append("The value is: ");
            sb.append(this.contents);
           
           
            return sb.toString();
        }
       

        @Override
     public String [] getContents(){
         return null;
     };
        @Override
    public void setContents(int i,String s){
    };  

        private final int contents;
        private int sum=0;

        private static final String NEW_LINE = "\n";
    }
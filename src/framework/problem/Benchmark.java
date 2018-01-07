/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.problem;

import domains.puzzle.PuzzleState;

/**
 *
 * @author sidim
 */
public class Benchmark {
     private final String Name;
    private final State initialState;
    private final State finalState;
     
    
    public Benchmark(String Name, State init, State fin){
   
       this.Name=Name;
       this.finalState=fin;
       this.initialState=init;
    
      
        
    }
       
       public State getInitState(){
           return this.initialState;
       }
       public State getfinState(){
           return this.finalState;
       }
       @Override
       public String toString(){
            return this.Name;
       }
       
   
       
}

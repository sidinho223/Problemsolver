/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @thor Sidim
 */
package domains.farmer;

import framework.problem.Mover;
import framework.problem.State;

public class FarmerMover extends Mover {

        public static final String Alone= "Farmer goes Alone";
        public static final String Wolf = "Farmer takes Wolf";
        public static final String Goat = "Farmer takes Goat";
        public static final String CABAGE = "Farmers takes Cabage";
       
    
        public FarmerMover() {
            super.addMove(Alone, s -> tryAlone(s));
            super.addMove(Wolf, s -> tryWolf(s));
            super.addMove(Goat, s -> tryGoat(s));
            super.addMove(CABAGE, s -> tryCABAGE(s));
            
        }

        private State tryAlone(State state) {
            //System.out.println("I'm moving farmer");
            if(state.getContents()[0]=="West"){
                if(state.getContents()[1]==state.getContents()[2] | state.getContents()[2]==state.getContents()[3]){
                return null;
                }
                else{
                    FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"East");
                     return s;
                }
            }
            else{
                
                if(state.getContents()[1]==state.getContents()[2] | state.getContents()[2]==state.getContents()[3]){
                return null;
                }
                else{
                    FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"West");
                     return s;
                }
                                
            }
                                            }
           
        

        private State tryWolf(State state) {
           // System.out.println("I'm moving wolf");
           if(state.getContents()[0]=="West"){
                if(state.getContents()[2]==state.getContents()[3] | state.getContents()[0]!=state.getContents()[1]){
                return null;
                }
                else{
                   FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"East");
                     if(state.getContents()[1]=="West") s.setContents(1,"East" );
                     else s.setContents(1, "West");
                     return s;
                }
            }
            else{
                
                if(state.getContents()[2]==state.getContents()[3] | state.getContents()[0]!=state.getContents()[1]){
                return null;
                }
                else{
                    FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"West");
                     if(state.getContents()[1]=="West") s.setContents(1,"East" );
                     else s.setContents(1, "West");
                     return s;
                }
                                
            }
        }

        private State tryGoat(State state) {
            //System.out.println("I'm moving goat");
             if(state.getContents()[0]=="West"){
                if(state.getContents()[0]!=state.getContents()[2]){
                return null;
                }
                else{
                    FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"East");
                     if(state.getContents()[2]=="West") s.setContents(2,"East" );
                     else s.setContents(2, "West");
                     return s;
                }
            }
            else{
                
                if(state.getContents()[0]!=state.getContents()[2]){
                return null;
                }
                else{
                    FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"West");
                     if(state.getContents()[2]=="West") s.setContents(2,"East" );
                     else s.setContents(2, "West");
                     return s;
                }
                                
            }
        }

        private State tryCABAGE(State state) {
            //System.out.println("I'm moving cabbage");
             if(state.getContents()[0]=="West"){
                if(state.getContents()[2]==state.getContents()[1] | state.getContents()[0]!=state.getContents()[3]){
                return null;
                }
                else{
                    FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"East");
                     if(state.getContents()[3]=="West") s.setContents(3,"East" );
                     else s.setContents(3, "West");
                     return s;
                }
            }
            else{
                
                if(state.getContents()[2]==state.getContents()[1] | state.getContents()[0]!=state.getContents()[3]){
                return null;
                }
                else{
                    FarmerState s = new FarmerState(state.getContents()[0],state.getContents()[1],state.getContents()[2],state.getContents()[3]);
                     s.setContents(0,"West");
                     if(state.getContents()[3]=="West") s.setContents(3,"East" );
                     else s.setContents(3, "West");
                     return s;
                }
                                
            }
        }

        private State illegalMove(State state) {
            return null;
        }
    }

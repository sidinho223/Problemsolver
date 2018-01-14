/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *@author Sidim
 */
package domains.puzzle;

import framework.problem.Mover;
import domains.puzzle.PuzzleState;
import framework.problem.State;

public class PuzzleMover extends Mover {

        public static final String S1 = "SLIDE TILE 1";
        public static final String S2 = "SLIDE TILE 2";
        public static final String S3 = "SLIDE TILE 3";
        public static final String S4 = "SLIDE TILE 4";
        public static final String S5 = "SLIDE TILE 5";
        public static final String S6 = "SLIDE TILE 6";
        public static final String S7 = "SLIDE TILE 7";
        public static final String S8 = "SLIDE TILE 8";
        public static final String S9= " ";
        
    
        public PuzzleMover() {
            super.addMove(S1, s -> tryS1((PuzzleState)s));
            super.addMove(S2, s -> tryS2((PuzzleState)s));
            super.addMove(S3, s -> tryS3((PuzzleState)s));
            super.addMove(S4, s -> tryS4((PuzzleState)s));
            super.addMove(S5, s -> tryS5((PuzzleState)s));
            super.addMove(S6, s -> tryS6((PuzzleState)s));
            super.addMove(S7, s -> tryS7((PuzzleState)s));
            super.addMove(S8, s -> tryS8((PuzzleState)s));
            
    
        }
             private PuzzleState tryS1(PuzzleState state) {
                    return move(state,state.getLocation(1).getRow(),state.getLocation(1).getColumn());
                            }
            private PuzzleState tryS2(PuzzleState state) {
                    return move(state,state.getLocation(2).getRow(),state.getLocation(2).getColumn());
                            }
            private PuzzleState tryS3(PuzzleState state) {
                    return move(state,state.getLocation(3).getRow(),state.getLocation(3).getColumn());
                            }
            private PuzzleState tryS4(PuzzleState state) {
                    return move(state,state.getLocation(4).getRow(),state.getLocation(4).getColumn());
                            }
            private PuzzleState tryS5(PuzzleState state) {
                    return move(state,state.getLocation(5).getRow(),state.getLocation(5).getColumn());
                            }
            private PuzzleState tryS6(PuzzleState state) {
                    return move(state,state.getLocation(6).getRow(),state.getLocation(6).getColumn());
                            }
            private PuzzleState tryS7(PuzzleState state) {
                    return move(state,state.getLocation(7).getRow(),state.getLocation(7).getColumn());
                            }
            private PuzzleState tryS8(PuzzleState state) {
                    return move(state,state.getLocation(8).getRow(),state.getLocation(8).getColumn());
                            }
            private State illegalMove(State state) {
            return null;
        }
             
        private PuzzleState move(PuzzleState state,int row, int col) {
            
        if(row==0 && col==0){
            if(state.getTiles()[0][1]==0){
                
                return new PuzzleState(state,state.getLocation(state.getTiles()[0][0]),state.getLocation(state.getTiles()[0][1]));
               
            }
            else if(state.getTiles()[1][0]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[1][0]),state.getLocation(state.getTiles()[0][0]));
               
            }
            else{
                return null;
            }       
           
        }
        
        else if (row==0 && col==1) {
            if(state.getTiles()[0][0]==0){
                
                return  new PuzzleState(state,state.getLocation(state.getTiles()[0][0]),state.getLocation(state.getTiles()[0][1]));
                
            }
            else if(state.getTiles()[0][2]==0){
               return new PuzzleState(state,state.getLocation(state.getTiles()[0][1]),state.getLocation(state.getTiles()[0][2]));
               
            }
            else if(state.getTiles()[1][1]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[0][1]),state.getLocation(state.getTiles()[1][1]));
               
            }
            else{
                return null;
            }
            
        }
        else if(row==0 && col==2){
            if(state.getTiles()[0][1]==0){
                
                return  new PuzzleState(state,state.getLocation(state.getTiles()[0][1]),state.getLocation(state.getTiles()[0][2]));
                
            }
           
            else if(state.getTiles()[1][2]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[1][2]),state.getLocation(state.getTiles()[0][2]));
               
            }
            else{
                return null;
            }
            
        }
        else if(row==1 && col==0) {
            if(state.getTiles()[1][1]==0){
                
                return  new PuzzleState(state,state.getLocation(state.getTiles()[1][0]),state.getLocation(state.getTiles()[1][1]));
                
            }
            else if(state.getTiles()[0][0]==0){
               return new PuzzleState(state,state.getLocation(state.getTiles()[0][0]),state.getLocation(state.getTiles()[1][0]));
               
            }
            else if(state.getTiles()[2][0]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[2][0]),state.getLocation(state.getTiles()[1][0]));
               
            }
            else{
                return null;
            }
            
        }
        else if(row==1 && col==1) {
            if(state.getTiles()[0][1]==0){
                
                return  new PuzzleState(state,state.getLocation(state.getTiles()[0][1]),state.getLocation(state.getTiles()[1][1]));
                
            }
            else if(state.getTiles()[1][0]==0){
               return new PuzzleState(state,state.getLocation(state.getTiles()[1][1]),state.getLocation(state.getTiles()[1][0]));
               
            }
            else if(state.getTiles()[1][2]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[1][1]),state.getLocation(state.getTiles()[1][2]));
               
            }
            else if(state.getTiles()[2][1]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[1][1]),state.getLocation(state.getTiles()[2][1]));
               
            }
            else{
                return null;
            }
            
        }
        else if(row==1 && col==2) {
           if(state.getTiles()[1][1]==0){
                
                return  new PuzzleState(state,state.getLocation(state.getTiles()[1][2]),state.getLocation(state.getTiles()[1][1]));
                
            }
            else if(state.getTiles()[0][2]==0){
               return new PuzzleState(state,state.getLocation(state.getTiles()[0][2]),state.getLocation(state.getTiles()[1][2]));
               
            }
            else if(state.getTiles()[2][2]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[2][2]),state.getLocation(state.getTiles()[1][2]));
               
            }
            else{
                return null;
            }
        }
       else if(row==2 && col==0) {
           
            if(state.getTiles()[2][1]==0){
                
                return new PuzzleState(state,state.getLocation(state.getTiles()[2][0]),state.getLocation(state.getTiles()[2][1]));
               
            }
            else if(state.getTiles()[1][0]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[1][0]),state.getLocation(state.getTiles()[2][0]));
               
            }
            else{
                return null;
            }       
        }
        else if(row==2 && col==1) {
            if(state.getTiles()[2][0]==0){
                
                return  new PuzzleState(state,state.getLocation(state.getTiles()[2][0]),state.getLocation(state.getTiles()[2][1]));
                
            }
            else if(state.getTiles()[2][2]==0){
               return new PuzzleState(state,state.getLocation(state.getTiles()[2][1]),state.getLocation(state.getTiles()[2][2]));
               
            }
            else if(state.getTiles()[1][1]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[2][1]),state.getLocation(state.getTiles()[1][1]));
               
            }
            else{
                return null;
            }
        }
          else if(row==2 && col==2){
                  if(state.getTiles()[2][1]==0){
                
                return  new PuzzleState(state,state.getLocation(state.getTiles()[2][1]),state.getLocation(state.getTiles()[2][2]));
                
            }
           
            else if(state.getTiles()[1][2]==0){
                return new PuzzleState(state,state.getLocation(state.getTiles()[1][2]),state.getLocation(state.getTiles()[2][2]));
               
            }
            else{
                return null;
            }
             }

        else {
            return null;
        }}
    }

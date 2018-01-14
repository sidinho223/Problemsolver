 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @uthor Sidim
 */
package domains.puzzle;

import framework.problem.Benchmark;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;

public class PuzzleProblem extends Problem {
     private final State initstate1 =  new PuzzleState(new int[][]{new int[]{2, 8, 3}, 
                                                        new int[]{1, 6, 4 }, 
                                                        new int[]{7, 0, 5}});
       
       private final State finalstate1 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name1="Bench 1: 5 moves";
        
       private final State initstate2 =  new PuzzleState(new int[][]{new int[]{3, 6, 4}, 
                                                        new int[]{1, 0, 2 }, 
                                                        new int[]{8, 7, 5}});
       
       private final State finalstate2 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name2="Bench 2: 10 moves";
        
    
       private final State initstate3 =  new PuzzleState(new int[][]{new int[]{3, 0, 4}, 
                                                        new int[]{1, 6, 5 }, 
                                                        new int[]{8, 2, 7}});
       
       private final State finalstate3 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name3="Bench 3: 13 moves";
        
   
       private final State initstate4 =  new PuzzleState(new int[][]{new int[]{2, 1, 3}, 
                                                        new int[]{8, 0, 4 }, 
                                                        new int[]{6, 7, 5}});
       
       private final State finalstate4 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name4="Bench 4: 18 moves";
        
   
       private final State initstate5 =  new PuzzleState(new int[][]{new int[]{4, 2, 0}, 
                                                        new int[]{8, 3, 6 }, 
                                                        new int[]{7, 5, 1}});
       
       private final State finalstate5 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name5="Bench 5: 20 moves";
        
   
       private final State initstate8 =  new PuzzleState(new int[][]{new int[]{5, 6, 7}, 
                                                        new int[]{4, 0, 8 }, 
                                                        new int[]{3, 2, 1}});
       
       private final State finalstate8 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name8="Bench 8: 30 moves";
        
    
       private final State initstate7 =  new PuzzleState(new int[][]{new int[]{5, 2, 7}, 
                                                        new int[]{8, 0, 4 }, 
                                                        new int[]{3, 6, 1}});
       
       private final State finalstate7 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name7="Bench 7: 30 moves";
        
    
       private final State initstate6 =  new PuzzleState(new int[][]{new int[]{1, 6, 3}, 
                                                        new int[]{4, 0, 8 }, 
                                                        new int[]{7, 2  , 5}});
       
       private final State finalstate6 =  new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
       
       
       private final  String name6="Bench 6: 24 moves";
    
        public PuzzleProblem() {
         
            
            super();
            super.setName("8-puzzle");
            StringBuilder sb= new StringBuilder();
            sb.append(INTRO);
            sb.append("\n");
           // sb.append("\n");
            //sb.append(new PuzzleState(end).toString());
            super.setIntroduction(sb.toString());
            super.setMover(new PuzzleMover());
            super.setInitialState(new PuzzleState(init));
            super.setArray();
            
      
            super.setCurrentState(super.getInitialState());
            
            super.setFinalState(new PuzzleState(end));
            Benchmark bench1= new Benchmark(name1,initstate1,finalstate1);
            Benchmark bench2= new Benchmark(name2,initstate2,finalstate2);
            Benchmark bench3= new Benchmark(name3,initstate3,finalstate3);
            Benchmark bench4= new Benchmark(name4,initstate4,finalstate4);
            Benchmark bench5= new Benchmark(name5,initstate5,finalstate5);
            Benchmark bench6= new Benchmark(name6,initstate6,finalstate6);
            Benchmark bench7= new Benchmark(name7,initstate7,finalstate7);
            Benchmark bench8= new Benchmark(name8,initstate8,finalstate8);
           
            super.getBenchmarks().add(bench1);
            super.getBenchmarks().add(bench2);
            super.getBenchmarks().add(bench3);
            super.getBenchmarks().add(bench4);
            super.getBenchmarks().add(bench5);
            super.getBenchmarks().add(bench6);
            super.getBenchmarks().add(bench7);
            super.getBenchmarks().add(bench8);
            
        }
           private static final int [][] end={{1,2,3},{8,0,4},{7,6,5}};
            private static final int [][] init={{2,8,3},{1,6,4},{7,0,5}};
             List <Benchmark> bench;
           
        private static final String INTRO = 
               // "Welcome to the Puzzle, Wolf, Goat, and Cabbage problem. \n \n"+
             
                "You are given a board in which numbered tiles can slide"+
                "around. There is one blank space that holds no tile.  A legal" +
                "move consists of sliding a tile into the blank space if the" +
                "tile is adjacent to it. The goal is to move tiles around until" +
                "the board looks like the final state below.";
              
    }

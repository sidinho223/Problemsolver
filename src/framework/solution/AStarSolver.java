/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.solution;

import domains.puzzle.PuzzleState;
import framework.graph.Vertex;
import framework.problem.Problem;
import framework.problem.State;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/* imports go here */

/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Sidim
 */
public class AStarSolver extends StateSpaceSolver {
    
    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem 
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        /* you must provide */
        this.PQ= new PriorityQueue( 10,this.getComparator());
        super.setQueue(new PriorityQueue( 10,this.getComparator()));
        super.getStatistics().setHeader("A* Search");
        
    }
    
    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     * Search(s)
   d[s] = 0
   pred[s] = null
   PQ = {s}
   while PQ ≠ {} do
      u = Remove[PQ]
      if success
         then return u
      else
         for each v ∈ Expand(u) do
             Add(PQ,v)
   return null
     */
    @Override
    public void add(Vertex v) {
      
        /* you must provide */
        
        v.setDistance(0);
        v.setPredecessor(null);
        Vertex goal= new Vertex(this.getProblem().getFinalState());
        this.PQ.add(v);
        while(!this.PQ.isEmpty()){
            Vertex u=(Vertex)PQ.remove();
            
            PuzzleState p=(PuzzleState)u.getData();
            
            if(p.getHeuristic(this.getProblem().getFinalState())==0){
                this.getQueue().add(u);
                break;
            }
            else{
                List <Vertex> children =this.expand(u);
               for(Vertex child:children){
                   child.setPredecessor(u);
                   child.setDistance(u.getDistance()+1);
                   //System.out.println("the child is "+ child.getData());
                   this.PQ.add(child);
                
            }
        
    }
    }
    }

    
    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
   public final Comparator<Vertex> getComparator() {
    return (v1, v2) -> {
	State goal = this.getProblem().getFinalState();
	State s1 = (State)v1.getData();
	State s2 = (State)v2.getData();
	int h1 = s1.getHeuristic(goal);
	int h2 = s2.getHeuristic(goal);
        int d1= v1.getDistance();
        int d2= v2.getDistance();
      
        if( h1+d1>h2+d2){
            return 1;
        }
        else if(h1+d1<h2+d2){
            return -1;
        }
        
           
	
   return h1 - h2; };
}
    
    private PriorityQueue PQ;
}

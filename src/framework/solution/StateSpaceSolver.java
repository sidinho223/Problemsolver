package framework.solution;

import framework.graph.Vertex;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.LinkedList;
import java.util.List;

/* imports go here */

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Sidim
 */
public class StateSpaceSolver extends Solver {
    
    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        /* you must provide */
        /* here I'm just initializing the linked queue, bfs intance, and adding the right
        header to super
        */
        this.bfs=bfs;
        super.setQueue(new LinkedList <Vertex>());
        if(bfs){
        super.getStatistics().setHeader("Breadth First Search");
        }
        else{
             super.getStatistics().setHeader("Depth First Search");
        }
    }
    
    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v 
     */
    @Override
    public void add(Vertex v) {
	/* you must provide 
        Since we are using a double ended queue
        During BFS, a discovered vertex's neighbors are added at the tail (also called last).
        During DFS, a discovered vertex's neighbors are added at the head
        */
       
        if(bfs){
            ((LinkedList) this.getQueue()).addLast(v);
            
        }
        else{
            ((LinkedList)this.getQueue()).addFirst(v);
            
        }
      
    }
    
    /**
     * This method implements the expand operation required by the 
     * state space search algorithm:

       Expand(u)
          children = {}
          for each name âˆˆ moveNames do
             child = mover.doMove(name, u)
             if child â‰  null and not OccursOnPath(child, u)
                then d[child] = d[u] + 1
                     pred[child] = u
                     add child to children
          return children

     * @param u the vertex being expanded
     * @return 
     */
    @Override
    public List<Vertex> expand(Vertex u) {
	/* you must provide */
        LinkedList<Vertex> children= new LinkedList<>();
          Mover mover=this.getProblem().getMover();
        List<String> moves= mover.getMoveNames();
        for(int i=0;i<moves.size();i++){          
          
            State state = mover.doMove(moves.get(i),(State) u.getData());
            // System.out.println(state +" for "+moves.get(i));
            if(state==null || (this.occursOnPath(new Vertex(state),u))){
                
                
            }else{
                //System.out.println(moves.get(i)+" went through the loop lol");
                //System.out.println("new child"+" and dimension "+(u.getDistance()+1));
                Vertex child= new Vertex(state);
                child.setDistance(u.getDistance() + 1);
                child.setPredecessor(u);
                children.add(child);
            }
            
            }
        return children;
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
        
	/* you must provide */
        while(ancestor!=null){
            if(v.equals(ancestor)){
                return true;
                
            }
            ancestor= ancestor.getPredecessor();
        }
        return false;
    }
    
    /* private instance fields here */
    private final boolean bfs;
}

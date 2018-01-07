/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import domains.farmer.FarmerState;
import framework.graph.Graph;

import framework.graph.Vertex;

/**
 *
 * @author sidim
 */
public class FarmerGraph extends Graph {
   
    
    public FarmerGraph() {
        
        
        this.start = new Vertex(new FarmerState("West", "West", "West", "West"));
        this.v2 = new Vertex(new FarmerState("West", "East", "West", "East"));
        this.v3 = new Vertex(new FarmerState("West", "East", "West", "West"));
        this.v4 = new Vertex(new FarmerState("West", "West", "East", "West"));
        this.v5 = new Vertex(new FarmerState("West", "West", "West", "East"));
        this.end = new Vertex(new FarmerState("East", "East", "East", "East"));
        this.v7 = new Vertex(new FarmerState("East", "West", "East", "West"));
        this.v8 = new Vertex(new FarmerState("East", "West", "East", "East"));
        this.v9 = new Vertex(new FarmerState("East", "East", "West", "East"));
        this.v10 = new Vertex(new FarmerState("East", "East", "East", "West"));
        
     
         this.addEdge(this.start, this.v7);
        this.addEdge(this.v7,this.start);
        this.addEdge(this.v7, this.v4);
        this.addEdge(this.v4, this.v7);
        this.addEdge(this.v4, this.v10);
        this.addEdge(this.v10, this.v4);
        this.addEdge(this.v10, this.v3);
        this.addEdge(this.v3, this.v10);
        this.addEdge(this.v4, this.v8);
        this.addEdge(this.v8, this.v4);
        this.addEdge(this.v8, this.v5);
        this.addEdge(this.v5, this.v8);
        this.addEdge(this.v3, this.v9);
        this.addEdge(this.v9, this.v3);
        this.addEdge(this.v5, this.v9);
        this.addEdge(this.v9, this.v5);
        this.addEdge(this.v9, this.v2);
        this.addEdge(this.v2, this.v9);
        this.addEdge(this.v2, this.end);
        this.addEdge(this.end, this.v2);
        
    }
    public Vertex getStart() {
        return this.start;
    }
     public Vertex getEnd() {
        return this.end;
    }
     
      
     
     
   
    private Vertex start;    
    private  Vertex v2;
    private Vertex v3;
    private Vertex v4;
    private  Vertex v5;
    private Vertex v7;
    private Vertex v8;
    private Vertex v9;
    private Vertex v10;    
    private Vertex end;
    private Vertex v1;
     
}

package framework.ui;

import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import framework.graph.Vertex;
import framework.problem.Benchmark;
import framework.problem.Problem;
import framework.problem.State;
import framework.solution.AStarSolver;
import framework.solution.Solution;
import framework.solution.Solver;
import framework.solution.SolvingAssistant;
import framework.solution.StateSpaceSolver;
import java.awt.Canvas;
import java.util.List;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sidim
 */
public class ProblemGUI extends VBox{
    private Problem problem;
    private Label currentLabel;
    private  Label goalLabel;
    private final List<String> moves;
    private final SolvingAssistant solver;
    private Label moveTitle;
    private VBox movesBox;
    private String message;
    private Text moveMessage;
    public static final Font font = Font.font((String)"Verdana", FontPosture.ITALIC, (double)30.0);
    public static final double sizer = font.getSize();
    private Button solve;
    private Button next;
    private Label stats;
    private Solver solving;
    private Solver bfsSolver;
    private Solver dfsSolver;
    private Solver aStarSolver;
    private Solver enhancedSolver;
    private Solution solution; 
    private ChoiceBox choices;
    private ChoiceBox BenchChoice;
    private Benchmark bench;
    private HBox newParts;
  
    public ProblemGUI(Problem p,double width, double height){
          /*constreuctor  add label and text to the layout*/
          
           this.problem=p;
           this.setPrefWidth(width);
           this.setPrefHeight(height);
           Text welcomeMessage= new Text();
                welcomeMessage.setText( welcome(problem));
                welcomeMessage.setFont(font);
                welcomeMessage.setFill(Color.BLUE);
                welcomeMessage.setWrappingWidth(width-25);
                welcomeMessage.setTextAlignment(TextAlignment.CENTER);
                
            Text introduction= new Text();
            
                introduction.setText(problem.getIntroduction());
                introduction.setWrappingWidth(width-25);
                introduction.setTextAlignment(TextAlignment.CENTER);
             this.moveMessage= new Text (MoveMessages());
                this.moveMessage.setFont(font);
                
                this.moveMessage.setTextAlignment(TextAlignment.CENTER);
                this.moveMessage.setFill(Color.RED);
         
                
               
                this.currentLabel= new Label(problem.getCurrentState().toString()); 
                this.bfsSolver = new StateSpaceSolver(problem, true);
                this.dfsSolver = new StateSpaceSolver(problem, false);
                this.aStarSolver= new AStarSolver(problem);
              
                this.goalLabel= new Label(problem.getFinalState().toString());
        this.currentLabel.setPadding(new Insets(sizer));
        this.goalLabel.setPadding(new Insets(sizer));
        this.currentLabel.setBorder(new Border(new BorderStroke[]{new BorderStroke(null, BorderStrokeStyle.SOLID, null, BorderStroke.MEDIUM)}));
        this.goalLabel.setBorder(new Border(new BorderStroke[]{new BorderStroke(null, BorderStrokeStyle.SOLID, null, BorderStroke.MEDIUM)}));   
        this.moves = problem.getMover().getMoveNames();
        this.solver = new SolvingAssistant(problem);
        this.bfsSolver = new StateSpaceSolver(problem, true);
        this.dfsSolver = new StateSpaceSolver(problem, false);
        this.solving = this.bfsSolver;
        this.stats = new Label();
    
        VBox left = new VBox(sizer, new Node[]{this.makeSolve(), this.makeNext(), this.makeReset()});
        left.setAlignment(Pos.CENTER);
        
        if (problem instanceof PuzzleProblem){
        this.newParts=new HBox(sizer,new Node[]{ left,makeChoices(),makeBenchmark(),this.stats});
        }
        else{
            
            this.newParts=new HBox(sizer,new Node[]{ left,makeChoices(),this.stats});
        }
        this.newParts.setPadding(new Insets(sizer));
        this.newParts.setAlignment(Pos.CENTER);
        
        
        
        
        this.stats.setBorder(new Border(new BorderStroke[]{new BorderStroke(null, BorderStrokeStyle.SOLID, null, BorderStroke.MEDIUM)}));
        this.stats.setPadding(new Insets(sizer));
        
        //this.setSpacing(sizer);
        this.setAlignment(Pos.CENTER);
            
        
                
           super.getChildren().addAll(welcomeMessage,introduction,makeGamePlay(),this.moveMessage,newParts);
        
        }
    
     public final void updateDisplay() {
         /*update the display, so it updates the changes to the current stat*/
      
            this.currentLabel.setText(this.problem.getCurrentState().toString());
            this.goalLabel.setText(this.problem.getFinalState() == null ? "Not applicable" : this.problem.getFinalState().toString());
       
        this.moveTitle.setText(String.format("Moves (%d so far):", this.solver.getMoveCount()));
       this.moveMessage.setText(this.message);
    }

  private String welcome(Problem p){
      /*create welcom strin*/
        StringBuilder builder = new StringBuilder();
        builder.append("Welcome to the ");
        builder.append(p.getName());
        builder.append(" problem.");
        builder.append("\n");
        return builder.toString();
    }
  
  
    private HBox makeGamePlay (){
         /* make the design of the gamplay*/
        HBox GameBox = new HBox(sizer*3);
        GameBox.setSpacing(10);
        GameBox.getChildren().addAll(this.makeStates(this.currentLabel,"Current State"), this.showMoves(), this.makeStates(this.goalLabel, "Goal State:"));
       GameBox.setAlignment(Pos.CENTER);
        return GameBox;
    }
 private VBox makeStates(Label state, String t) {
     /*helper for makeGamePlay() that creaye the current and goal label*/
        VBox vBox = new VBox(sizer);
        vBox.setAlignment(Pos.CENTER);
        Label title = new Label(t);
        title.setFont(Font.font((String)"Verdana", (FontWeight)FontWeight.BOLD, (double)22.0));
        vBox.getChildren().addAll(title,state);
        return vBox;
    }
  private VBox showMoves() {
           /*add moves to the layout*/
        VBox AllMovesBox = new VBox(sizer);
        AllMovesBox.setAlignment(Pos.CENTER);
        this.moveTitle = new Label();
       
        this.movesBox = new VBox();
        this.moves.stream().forEach(move ->  this.movesBox.getChildren().add((this.addButton(move))));
        AllMovesBox.getChildren().addAll(this.moveTitle, this.movesBox);
        
        return AllMovesBox;
    }
  
  private Button addButton(String moveName) {
      /* go through moves array to get moves name. It is a helper for the method above*/
        Button button = new Button(moveName);
        button.setPrefWidth(200);
        button.setOnAction(event -> {
            this.message = "";
            this.solver.tryMove(moveName);
            if (!this.solver.isMoveLegal()) {
                this.message = "Illegal move. Try again.";
            } else if (this.solver.isProblemSolved()) {
                this.message = "You solved the problem. Congratulations.";
            }
            button.disableProperty().bind((ObservableValue)Bindings.not((ObservableBooleanValue)this.next.disableProperty()));
      
            this.updateDisplay();
        }
        );
        return button;
    }

     


    private Button makeReset() {
        /*create the reset button and add eventhandler to it*/
        Button b = new Button("Reset");
       b.setOnAction(event -> {
            this.reset();
            this.solve.setDisable(false);
        }
        );
        return b;
    }
     public void reset() {
        this.solver.reset();
        this.message = "";
        this.updateDisplay();
    }


   private String MoveMessages(){
       System.out.println(this.message+ "\n");
       return this.message;
   }
  private Button makeSolve(){
      this.solve= new Button("solve");
      this.solve.setOnAction(e->{
          this.solve.setDisable(true);
            System.out.println("the current state is "+ this.problem.getInitialState());
            this.solving.solve();
            this.solution = this.solving.getSolution();
            System.out.println(this.solution.next());
            this.stats.setText(this.solving.getStatistics().toString());
      });
      return solve;
  }
  private Button makeNext(){
      next=new Button("Next");
      next.setDisable(true);
     this.next.disableProperty().bind((ObservableValue)Bindings.not((ObservableBooleanValue)this.solve.disableProperty()));
     this.next.setOnAction(e -> {
            if (this.solution.hasNext()) {
                Vertex vertex = this.solution.next();
                State stat = (State)vertex.getData();
                System.out.println("the state is "+stat);
                
                this.solver.update(stat);
                if (this.solver.isProblemSolved()) {
                    this.message = "You solved the problem. Congratulations.";
                }
                this.updateDisplay();
            }
        }
        );
        return this.next;
    
  }
  private ChoiceBox<String> makeChoices() {
        this.choices = new ChoiceBox();
        this.choices.getItems().addAll((Object[])new String[]{"Breadth-First Search", "Depth-First Search", "A* search"});
        this.choices.setValue((Object)"Breadth-First Search");
        
       choices.valueProperty().addListener(e -> {
            if(this.choices.valueProperty().getValue()=="Breadth-First Search"){
            this.solving = this.bfsSolver;
            }
            else if (this.choices.valueProperty().getValue()=="Depth-First Search"){
                System.out.println("I work");
               this.solving = this.dfsSolver; 
            }
            else{
               this.solving= this.aStarSolver;
            }
           
               });
        
           
        
        return this.choices;
    }
  
  public ChoiceBox makeBenchmark(){
       
      this.BenchChoice=new ChoiceBox<>(FXCollections.observableArrayList(problem.getBenchmarks()));
      this.BenchChoice.disableProperty().bind((ObservableValue)Bindings.not((ObservableBooleanValue)this.next.disableProperty()));
      this.BenchChoice.valueProperty().addListener(e -> { 
          Benchmark b= (Benchmark)this.BenchChoice.getValue();
          problem.setCurrentState(b.getInitState());
          problem.setInitialState(b.getInitState());
          this.solver.update(b.getInitState());
          this.updateDisplay();
          
                  } );
      
     
      return this.BenchChoice;
      
  }

   
    
}

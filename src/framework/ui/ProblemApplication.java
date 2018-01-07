/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import domains.arithmetic.ArithmeticProblem;
import domains.dummy.DummyProblem;
import domains.farmer.FarmerProblem;
import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import framework.problem.Problem;
import framework.problem.State;
import framework.ui.ProblemGUI;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class ProblemApplication
extends Application {
    private TabPane tabPane;

    public void start(Stage primaryStage) {
        this.tabPane = new TabPane();
        Problem problem = new DummyProblem();
        this.addProblem(problem, new ProblemGUI(problem, 800, 400));
        problem = new ArithmeticProblem();
        this.addProblem(problem, new ProblemGUI(problem, 800, 500));
        problem = new FarmerProblem();
        this.addProblem(problem, new ProblemGUI(problem, 800, 700));
        problem = new PuzzleProblem();
       this.addProblem(problem, new ProblemGUI(problem, 800, 700));
        Scene scene = new Scene((Parent)this.tabPane);
        primaryStage.setTitle("Problem Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
      private void addProblem(Problem p, ProblemGUI pgui) {
        Tab tab = new Tab();
        tab.setText(p.getName());
        tab.setContent((Node)pgui);
        this.tabPane.getTabs().add(tab);
    }

    public static void main(String[] args) {
        ProblemApplication.launch((String[])args);
    }

  
}

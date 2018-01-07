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
import framework.problem.Mover;
import framework.problem.State;

public class ArithmeticMover extends Mover {
        

        public static final String ADD = "Add 3";
        public static final String SUBSTRACT = "Subtract 5";
        public static final String MULTIPLY = "Multiply by 2";
        public static final String DIVIDE = "Divide by 2";
         public static final String ILL="illegal";
    
        public ArithmeticMover() {
            super.addMove(ADD, s -> tryAdd(s));
            super.addMove(SUBSTRACT, s -> trySub(s));
            super.addMove(DIVIDE, s -> tryDiv(s));
            super.addMove(MULTIPLY, s -> tryMul(s));
             super.addMove(ILL, s -> illegalMove(s));
        }

       

        private State tryAdd(State state) {
            return new ArithmeticState(state.getContent()+3);
        }

        private State trySub(State state) {
            return new ArithmeticState(state.getContent()-5);
        }

        private State tryDiv(State state) {
            return new ArithmeticState(state.getContent()/2);
        }

        private State tryMul(State state) {
            return new ArithmeticState(state.getContent()*2);
        }

        private State illegalMove(State state) {
            return null;
        }
    }
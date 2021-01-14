package Behavioral.Memento.solution;

import java.awt.geom.Point2D;

public class Client {
    public static void main(String[] args) {
        ConnectionSolver connectionSolver = new ConnectionSolver();
        // we can save state here
        ConnectionSolverCaretaker caretaker = new ConnectionSolverCaretaker();

        connectionSolver.setFirstPoint(new Point2D.Double(1.0,1.0));
        connectionSolver.setSecondPoint(new Point2D.Double(5.0,1.0));
        caretaker.saveState(connectionSolver);
        connectionSolver.calculateLine();

        connectionSolver.setFirstPoint(new Point2D.Double(2.0,2.0));
        connectionSolver.setSecondPoint(new Point2D.Double(5.0,4.0));
        connectionSolver.calculateLine();

        //here we restore the state of our old line into new line
        ConnectionSolver newConnectionSolver = new ConnectionSolver();
        caretaker.restoreState(newConnectionSolver);
        newConnectionSolver.calculateLine();
    }
}

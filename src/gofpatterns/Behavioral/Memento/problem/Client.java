package gofpatterns.Behavioral.Memento.problem;

import java.awt.geom.Point2D;

/**
 * the ShopChain is - how to save the state of lines without breaking encapsulation - the good exapmle is use memento pattern
 * but honestly we broke encapsulation but only inside the package
 */
public class Client {
    public static void main(String[] args) {
        ConnectionSolver connectionSolver = new ConnectionSolver();

        connectionSolver.setFirstPoint(new Point2D.Double(1.0,1.0));
        connectionSolver.setSecondPoint(new Point2D.Double(5.0,1.0));

        connectionSolver.calculateLine();
    }
}

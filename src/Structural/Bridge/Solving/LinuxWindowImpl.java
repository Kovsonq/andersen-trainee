package Structural.Bridge.Solving;

import Structural.Bridge.Problem.Window;

public class LinuxWindowImpl extends WindowImpl {
    @Override
    public void draw(int x, int y, int width, int height, String colour) {
        System.out.println("Linux x: " + x + " y:" + y + " width: " + width + " height: " + height + " colour: " + colour);
    }
}

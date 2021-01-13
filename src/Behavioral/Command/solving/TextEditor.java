package Behavioral.Command.solving;

import java.util.LinkedList;
import java.util.Queue;

public class TextEditor {
    private String text = "";

    // array of specific commands
    private Queue<Command> queue = new LinkedList<>();

    public void executeAction(Command command){
        command.action();
        queue.add(command);
    }

    private void undo(){
        // returns and removes the element at the front the container
        Command command = queue.poll();
        if (command!=null){
            command.undo();
        }
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Queue<Command> getQueue(){
        return queue;
    }
    public void setQueue(Queue<Command> queue) {
        this.queue = queue;
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.setText("123");
        ClearTextCommand command = new ClearTextCommand(editor);
        editor.executeAction(command);
        System.out.println("Text is: " + editor.getText());
        editor.undo();
        System.out.println("Text is: " + editor.getText());

        AddTextCommand addTextCommand = new AddTextCommand(editor, " something");
        editor.executeAction(addTextCommand);
        System.out.println("Text is: " + editor.getText());
        editor.undo();
        System.out.println("Text is: " + editor.getText());

    }
}

package Behavioral.Command.problem;

public class TextEditor {
    private String text = "";
    private String undoText = "";

    public void addText(String text){
        undoText = this.text;
        this.text = text;
    }
    public void clearText(){
        undoText = text;
        this.text = "";
    }
    public void undo(){
        this.text = undoText;
    }
    public String getText() {
        return text;
    }


    // only one possible undo
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addText("123");
        editor.clearText();
        System.out.println("Text is: " + editor.getText());
        editor.undo();
        System.out.println("Text is: " + editor.getText());
    }
}

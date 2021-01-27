package part1.gofpatterns.Behavioral.Command.DbExample;

public class SelectCommand implements Command {

    Database database;

    public SelectCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.select();
    }
}

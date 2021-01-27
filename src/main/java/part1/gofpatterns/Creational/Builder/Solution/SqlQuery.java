package part1.gofpatterns.Creational.Builder.Solution;

public class SqlQuery implements Query {
    private String from;
    private String where;


    @Override
    public void execute() {
        System.out.println("Exec SQL from:" + from+ " where " + where);
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}

package gofpatterns.Creational.Builder.Problem;

import gofpatterns.Creational.Builder.Solution.Query;

public class MongoDBQuery implements Query {
    private String from;
    private String where;


    @Override
    public void execute() {
        System.out.println("Exec MongoDB from:" + from+ " where " + where);
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}

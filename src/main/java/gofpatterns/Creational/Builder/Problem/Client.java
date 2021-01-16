package gofpatterns.Creational.Builder.Problem;


public class Client {

    public static void main(String[] args) {

        String from ="client table";
        String where = "client name=...";

        //build the query by using the director
        SqlQuery sqlQuery = new SqlQuery();
        sqlQuery.setFrom(from);
        sqlQuery.setWhere(where);
        sqlQuery.execute();

        MongoDBQuery mongoDBQuery = new MongoDBQuery();
        mongoDBQuery.setFrom(from);
        mongoDBQuery.setWhere(where);
        mongoDBQuery.execute();

    }

}
package part1.gofpatterns.Creational.Builder.Solution;

public class ClientMy {
    public static void main(String[] args) {
        //Setup the director
        QueryBuilderDirector director = new QueryBuilderDirector();

        String from = "client table";
        String where = "client name=...";

        QueryBuilder builder = new SqlQueryBuilder();
        Query query = director.buildQuery(from,where,builder);
        query.execute();

        builder = new MongoDbQueryBuilder();
        query = director.buildQuery(from,where,builder);
        query.execute();


    }
}

package gofpatterns.Creational.Builder.Solution;

public class QueryBuilderDirector {
    /**
     * Create a query bases on the from and the where
     * @param from
     * @param where
     * @param builder to fefine and result of the query or the representation of the query
     * @return
     */
    public Query buildQuery(String from, String where, QueryBuilder builder){
        builder.from(from);
        builder.where(where);
        return builder.getQuery();
    }
}

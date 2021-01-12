package Creational.Builder.Solution;

public class MongoDbQueryBuilder implements QueryBuilder {
    private MongoDBQuery query = new MongoDBQuery();

    @Override
    public void from(String from) {
        query.setFrom(from);
    }

    @Override
    public void where(String where) {
        query.setWhere(where);
    }

    @Override
    public Query getQuery() {
        return query;
    }
}

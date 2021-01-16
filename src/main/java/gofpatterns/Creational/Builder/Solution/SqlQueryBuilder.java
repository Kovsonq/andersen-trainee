package gofpatterns.Creational.Builder.Solution;

public class SqlQueryBuilder implements QueryBuilder {
    private SqlQuery sqlQuery = new SqlQuery();

    @Override
    public void from(String from) {
        sqlQuery.setFrom(from);
    }

    @Override
    public void where(String where) {
        sqlQuery.setWhere(where);
    }

    @Override
    public Query getQuery() {
        return sqlQuery;
    }
}

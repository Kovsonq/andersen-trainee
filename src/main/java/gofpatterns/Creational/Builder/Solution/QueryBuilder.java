package gofpatterns.Creational.Builder.Solution;

public interface QueryBuilder {
    void from(String from);
    void where(String where);
    Query getQuery();
}

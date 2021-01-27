package part1.gofpatterns.Behavioral.TemplateMethod.exapmle;

public abstract class LoanCalculationAlgorithm {

    // this is the base
    public int calculateLoan(){
        return (int) (getBaseAmount()*getInterest()-calculateDiscount());
    }

    // these are extension points
    abstract int getBaseAmount();
    abstract double getInterest();
    abstract int calculateDiscount();
}

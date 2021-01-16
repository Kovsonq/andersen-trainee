package gofpatterns.Behavioral.TemplateMethod.exapmle;

public class CheapLoanCalculation extends LoanCalculationAlgorithm {
    @Override
    int getBaseAmount() {
        return 10000;
    }

    @Override
    double getInterest() {
        return 3.1;
    }

    @Override
    int calculateDiscount() {
        return 400;
    }
}

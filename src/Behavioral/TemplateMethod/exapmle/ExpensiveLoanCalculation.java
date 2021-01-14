package Behavioral.TemplateMethod.exapmle;

public class ExpensiveLoanCalculation extends LoanCalculationAlgorithm {
    @Override
    int getBaseAmount() {
        return 10000;
    }

    @Override
    double getInterest() {
        return 5.4;
    }

    @Override
    int calculateDiscount() {
        return 100;
    }
}

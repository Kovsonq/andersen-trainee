package gofpatterns.Behavioral.TemplateMethod.exapmle;

public class Client {
    public static void main(String[] args) {
        LoanCalculationAlgorithm loanCalculationAlgorithm = new ExpensiveLoanCalculation();
        System.out.println(loanCalculationAlgorithm.calculateLoan());

        LoanCalculationAlgorithm loanCalculationAlgorithm2 = new CheapLoanCalculation();
        System.out.println(loanCalculationAlgorithm2.calculateLoan());
    }
}

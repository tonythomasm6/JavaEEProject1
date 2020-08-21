/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.mbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;

import fit5042.tutex.repository.entities.Loan;
import fit5042.tutex.calculator.MonthlyPaymentCalculator;

/**
 *
 * @author: originally created by Eddie. The following code has been changed in
 * order for students to practice.
 */
@SessionScoped
@ManagedBean(name = "loanManagedBean")
public class LoanManagedBean implements Serializable {

@EJB
private MonthlyPaymentCalculator calculator;

	private Loan loan;

    public LoanManagedBean() {
        this.loan = new Loan();

    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    //Method to calculate the monthly payment amount.
    //Business logic of calculation is kept in the EJB. calculate method is called in the EJB.
    public String calculate() {
        
        double monthlyPayment;
        //You will need to modify the monthlyPayment value and set it as the monthly payment attribute value into the loan instance
        monthlyPayment = calculator.calculate(loan.getPrinciple(), loan.getNumberOfYears(), loan.getInterestRate());
        loan.setMonthlyPayment(monthlyPayment);
        
        
        return "index";
    }
}

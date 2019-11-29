import java.math.BigDecimal;
import java.math.RoundingMode;

class TaskOne {

	String calculateMonthlyRepayment(BigDecimal principleAmount, double installmentRate, int loanTerm, boolean enableLogging) {
		double rate = getRate(installmentRate);
		double totalRepayments = getTotalAmountOfRepayments(loanTerm);
		if (enableLogging) {
			System.out.println("Principle Amount is : " + principleAmount);
			System.out.println("Rate is             : " + rate);
			System.out.println("Total Repayments is : " + totalRepayments);
		}

		String repaymentAmount = principleAmount.multiply(new BigDecimal((rate / (1-Math.pow((1 + rate),(totalRepayments * -1)))))).toString();
		return repaymentAmount.substring(0, repaymentAmount.indexOf(".") + 3);
	}

	String getMaximumRateAllowed(BigDecimal principleAmount, int totalRepayments, double maximumMonthlyRepayment) {
		BigDecimal rate = new BigDecimal("0.01");
		double monthlyRepayment = Double.parseDouble(calculateMonthlyRepayment(principleAmount, rate.doubleValue(), totalRepayments, false));
		while (monthlyRepayment < maximumMonthlyRepayment) {
//			System.out.println("At rate of " +rate+", total repayment per month is " + monthlyRepayment);
//			System.out.println(rate);
			rate = rate.add(new BigDecimal("0.01"));
			monthlyRepayment = Double.parseDouble(calculateMonthlyRepayment(principleAmount, rate.doubleValue(), totalRepayments, false));
		}
		return String.valueOf(rate.subtract(new BigDecimal("0.01")));
	}


	private double getRate(double rateInPercentage) {
		return rateInPercentage / 100 / 12;
	}

	private int getTotalAmountOfRepayments(int loanTerm) {
		return loanTerm * 12;
	}
}

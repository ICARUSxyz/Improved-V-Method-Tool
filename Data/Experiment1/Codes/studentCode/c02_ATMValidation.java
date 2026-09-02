package code;

public class c02_ATMValidation {

	
	public static boolean isValidWithdrawal(double amount, double accountBalance) {
        boolean flag;
        if(amount > 0 && accountBalance > 0 && amount <= accountBalance) {
        	flag = true;
        }
        else flag = false;
        return flag;
    }

    public static void main(String[] args) {
        // testcase-VT:
        double[][] testCases = {
        		{2598.16, 1784.78}, //amount > 0 && accountBalance > 0 && amount > accountBalance
        		{197.64, 102.47}, //amount > 0 && accountBalance > 0 && amount > accountBalance
        		{1015.07, 4908.75}, //amount > 0 && accountBalance > 0 && amount <= accountBalance
        		{-1939.66, 2509.62}, //amount <= 0 && accountBalance > 0 && amount <= accountBalance
        		{1707.62, -753.75}, //amount > 0 && accountBalance <= 0 && amount > accountBalance 
        };

        // testcase-FT:
//        double[][] testCases = {
//        		{-1.7976931348623157E308, 0},
//        		{4.565679614340899E293, 0},
//        		{0, 0},
//        		{-6.4290438513570355E301, -1.7976855920277024E308},
//        		{7.714599345286304E297,3.313395189713529E307},
//        };
        
        // testcase-Z3:
//        double[][] testCases = {
//        		{200, 500},
//        		{600, 400}, 
//        		{0, 300}, 
//        		{100, 0}, 
//        		{300, 300}, 
//        };
        
        // UVT
//        double[][] testCases = {
//        		{2598.16, 1784.78},
//        		{197.64, 102.47}, 
//        		{1015.07, 4908.75},
//        		{1939.66, 2509.62}, 
//        		{1707.62, 753.75}, 
//        };
        
        for (double[] testCase : testCases) {
            boolean result = isValidWithdrawal(testCase[0], testCase[1]);
            System.out.printf("isValidWithdrawal(%.1f, %.1f) = %b%n",
                testCase[0], testCase[1], result);
        }
    }
}

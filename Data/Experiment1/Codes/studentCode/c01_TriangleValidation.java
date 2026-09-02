package code;

public class c01_TriangleValidation {
	public static boolean isValidTriangle(double a, double b, double c) {
		boolean flag;
		if ((a > 0) && (b > 0) && (c > 0) && (a + b > c) && (a + c > b) && (b + c > a)) {
			flag = true;
		} else
			flag = false;
		return flag;
	}

	public static void main(String[] args) {
		// testcase-VT(vibration testing):

    		double[][] testCases = {
            		{1.7, 2.845, 0.99}, //a > 0, b > 0, c > 0, a + b - c > 0, b + c - a > 0, a + c - b <= 0
            		{5.3284, 0.712, 6.9703}, //a > 0, b > 0, c > 0, a + b - c <= 0, b + c - a > 0, a + c - b > 0
            		{4.73336, 19.0923, 15.002}, //a > 0, b > 0, c > 0, a + c - b > 0, a + b - c > 0, b + c - a > 0 
            		{0.179, 6.90, 7.779}, //a > 0, b > 0, c > 0, a + b - c <= 0, b + c - a > 0, a + c - b > 0
            		{18, 1.3413, 13.544},//a > 0, b > 0, c > 0, a + b - c > 0, b + c - a <= 0, a + c - b > 0
            		{-16.6171, 6.9286, 12.4}, // a <= 0 
            		{0.323, -1, 3.223}, // b <= 0
            		{4.73336, 19.0923, -10.643}, // c <= 0         		
//            };

		// testcase-FT(fuzz testing):
//        double[][] testCases = {
//        		{2.07656805837478E298, -1.7976931348623157E308, 0},
//        		{2.07656805837478E298, 0, 0},
//        		{2.092662514630868E298, 4.9E-324, 0},
//        		{7.192970191251195E307, 8.912522337530263E302, 0},
//        		{7.192969784996304E307, -1.7949137296852373E308, 0},
//        		{7.192969784996304E307, -1.5210464161710564E308, 0},
//        		{-1.5210464161710564E308, -1.5210464161710564E308, 2.2250738585072014E-308},
//        		{7.192912329778232E307, 7.822391121039473E307, 1.7976931348623157E308},
//        };

		// testcase-Z3:
//		double[][] testCases = { { 3, 4, 5 }, { 0, 3, 4 }, { 3, -1, 4 }, { 4, 5, 0 }, { 1, 2, 3 }, { 1, 3, 2 },
//				{ 3, 1, 2 }, { 5, 5, 8 }, };

//    		V-method v method
//    		double[][] testCases = {
//            		{2, 2, 2}, 
//            		{5.3284, 0.712, 6.9703},
//            		{4.73336, 19.0923, 15.002}, 
//            		{0.179, 6.90, 7.779}, 
//            		{1, 1, 1},
//            		{-16.6171, 6.9286, 12.4}, 
//            		{0.323, -1, 3.223},
//            		{4.73336, 19.0923, -10.643},      		
            };
		for (double[] testCase : testCases) {
			boolean result = isValidTriangle(testCase[0], testCase[1], testCase[2]);
			System.out.printf("isValidTriangle(%.1f, %.1f, %.1f) = %b%n", testCase[0], testCase[1], testCase[2],
					result);
		}
	}

}

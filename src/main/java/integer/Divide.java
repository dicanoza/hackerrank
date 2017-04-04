package integer;

/**
 * 
 * Divide without using the divide operator must be less than O(n)
 *
 */
public class Divide {

	public static void main(String[] args) {
		System.out.println(divide(-10000000, -2));
	}

	public static int divide(int dividend, int divisor) {

		if (divisor == 0) {
			throw new RuntimeException("Zero as divisor");
		}

		boolean negative = dividend * divisor < 0;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		String dividendStr = String.valueOf(dividend);
		String localDividendStr = "";
		int localDividend = 0;
		String result = "";
		for (int i = 0; i < dividendStr.length(); i++) {
			if (localDividendStr.equals("0")) {
				result += localDividendStr;
				localDividendStr = "";
			}

			localDividendStr += String.valueOf(dividendStr.charAt(i));
			localDividend = Integer.valueOf(localDividendStr);
			if (divisor > localDividend) {
				continue;
			}
			int localResult = 0;
			while (localDividend >= divisor) {
				localDividend -= divisor;
				localResult++;
			}
			result += String.valueOf(localResult);
			localDividendStr = String.valueOf(localDividend);

		}

		return negative ? -1 * Integer.valueOf(result) : Integer.valueOf(result);
	}

}

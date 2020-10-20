package src.com.dcv.oct;


public class Day16Part01 {
    public static void currencyCalculator() {
        System.out.println(getConvertedCurrency(100, "EUR"));
        System.out.println(getConvertedCurrency(100, "USD"));
        System.out.println(getConvertedCurrency(100, "CHF"));
        System.out.println(getConvertedCurrency(100, "SEK"));
        System.out.println(getConvertedCurrency(100, "ASDF"));
        System.out.println(getConvertedCurrency(100, 1.23));
    }
    
    public static double getConvertedCurrency(double amount, String currency) {
        double EurToChf = 1.07;
        double EurToUsd = 1.18;
        double EurToSek = 10.35;
        double result = 0.0;

        switch (currency) {
            case "EUR":
                result = getConvertedCurrency(1, amount);
                break;
            case "CHF":
                result = getConvertedCurrency(EurToChf, amount);
                break;
            case "USD":
                result = getConvertedCurrency(EurToUsd, amount);
                break;
            case "SEK":
                result = getConvertedCurrency(EurToSek, amount);
                break;
            default:
                System.err.println("Unknown currency: " + currency);
                break;
        }
        return result;
    }

    public static double getConvertedCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}

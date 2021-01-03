package util;

public class Utils {
    public static int convertPriceStringToInt(String priceString) {
        return Integer
                .parseInt(priceString.replaceAll("[^0-9]", ""));
    }
}

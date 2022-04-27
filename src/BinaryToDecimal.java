public class BinaryToDecimal {
    public static long binaryToDecimal(long binary){
        String number = String.valueOf(binary);
        char[] digits = number.toCharArray();
        int positions = digits.length;
        double decimal = 0;
        for (int i = 0; i < digits.length; i++){
            int digit = Character.getNumericValue(digits[i]);
            decimal = decimal + (digit *  Math.pow(2, positions - 1));
            positions--;
        }
        return (long) decimal;
    }
}

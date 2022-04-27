public class DecimalToBinary {

    public static String binary = "";
    public static long binaryNumber;

    public static long decimalToBinary(long decimal){
        binary = "";
        binaryNumber = 0;

        if (decimal == 0){
            return 0;
        }

        while (decimal > 0){
            long left = remainders(decimal);
            decimal = left;
        }

        binaryNumber = Long.parseLong(binary);
        return binaryNumber;
    }

    public static long remainders(long decimal){
        if (decimal > 1){
            long remainder = decimal % 2;
            binary = Long.toString(remainder) + binary;
            return (decimal / 2);
        }
        binary = "1" + binary;
        return 0;
    }


}

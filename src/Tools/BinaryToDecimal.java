package Tools;

public class BinaryToDecimal {
    public static void main(String args[]){
        String binaryString="10110";
        int decimal=Integer.parseInt(binaryString,2);
        System.out.println(decimal);
    }

    public static int Decimal (String input){
        return Integer.parseInt(input,2);
    }
}



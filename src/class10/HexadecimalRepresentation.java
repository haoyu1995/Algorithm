package class10;

public class HexadecimalRepresentation {
    public String hex(int number) {
        // Write your solution here
        //bit operation
        StringBuilder res = new StringBuilder("0x");
        if (number == 0){
            res.append('0');
            return res.toString();
        }
        int shift = 28;
        boolean leading = true;
        while (shift >= 0){
            int hexdigi = ((number >> shift) & 15);
            if (!leading || hexdigi != 0){
                if (hexdigi <= 9){
                    res.append((char)('0' + hexdigi));
                }else{
                    char hex = (char)(hexdigi - 10 + 'A');
                    res.append(hex);
                }
                if (leading){
                    leading = false;
                }
            }
            shift -= 4;
        }
        return res.toString();
    }
    public static void main(String[] args){
        HexadecimalRepresentation test = new HexadecimalRepresentation();
        System.out.println(test.hex(4096));
    }
}

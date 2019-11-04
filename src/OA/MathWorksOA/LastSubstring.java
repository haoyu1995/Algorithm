package OA.MathWorksOA;

public class LastSubstring {
    public String lastSubstring(String s) {

        // 2pointer: find the greatest char as start of last substring
        // best: the greatest char
        // i: candidate (s.charAt(best) >= s.charAt(i)) by go through the string

        int i = 1;
        int best = 0;

        while (i < s.length() && best < s.length()){
            char bestc = s.charAt(best);
            char ic = s.charAt(i);
            if (bestc > ic){
                i++;
            }else if (bestc < ic){
                //set best
                best = i;
            }else{ //bestc == ic
                int len = 0;
                while (best+len < s.length() && i+len < s.length() && s.charAt(best+len) == s.charAt(i+len)){
                    len++;
                }
                if (i+len >= s.length()){ //return longer substring
                    break;
                }
                if (s.charAt(best+len) < s.charAt(i+len)){
                    best = i;
                }else{
                    i += len;
                }
            }
            if (best == i){ // avoid best == i
                i++;
            }

        }
        return s.substring(best);

    }

    public static void main(String[] args){
        LastSubstring test = new LastSubstring();
        System.out.println(test.lastSubstring("zrziy"));
    }
}

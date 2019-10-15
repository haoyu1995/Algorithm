package blackrockOA;

public class Question3 {
//    Given a pattern as the first argument and a string of blobs split by | show the
//    number of times the pattern is present in each blob and the total number of matches.

//    Example input: bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32
//
//    输出：
//    The output should consist of the number of occurrences of the pattern per blob (separated by |).
//    Additionally, the final entry should be the summation of all the occurrences (also separated by |).
//
//    Example output: 3|2|1|2|8 where 'bc' was repeated 3 times, 2 times, 1 time, 2 times in the 4 blobs passed in.
//        And 8 is the summation of all the occurrences (3+2+1+2 = 8)
    public void patternCount(String input){
        String[] inputs = input.split(";");
        String pattern = inputs[0];
        String[] blobs = inputs[1].split("\\|");
        int sum = 0;
        String output = "";
        for (String blob : blobs){
            int num = count(pattern,blob);
            sum += num;
            output += num + "|";
        }
        System.out.println(output + sum);
    }
    private int count(String pattern, String blob){
        int count = 0;
        //sliding window
        int left = 0;
        while (left < blob.length()){
            if (blob.charAt(left) == pattern.charAt(0)){
                int i = 0;
                while(i < pattern.length() && left+i < blob.length() && blob.charAt(left+i) == pattern.charAt(i)){
                    i++;
                }
                if(i == pattern.length()){ //find it
                    count++;
                }
            }
            left++;
        }
        return count;
    }

    public static void main(String[] args){
        Question3 test = new Question3();
        test.patternCount("bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32");
    }

}

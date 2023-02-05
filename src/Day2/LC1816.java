package Day2;

//Input: s = "Hello how are you Contestant", k = 4
//        Output: "Hello how are you"
public class LC1816 {
    public String truncateSentence(String s, int k) {
//       String s = "Hello how are you Contestant";
//       int k = 4;
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            stringBuilder.append(words[i]).append(" ");
        }

        stringBuilder.append(words[k - 1]);
        return stringBuilder.toString();
    }
}

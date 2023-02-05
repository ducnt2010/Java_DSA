package Day2;

public class LC387 {
    public static int firstUniqChar(String s) {
        int[] alphabet = new int['z' - 'a' + 1];
        // bắt đầu từ 'a'  -> index = 0 -> 'a'-'a'
        // index b: 'b' - 'a' = 1
        // index of c: 'c'-'a' = 2
        // két thúc tại 'z' -> index = 25
        // baccde
        // a[0] = 1 //a
        // a[1] = 1 //b
        // leetcode
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            System.out.println("character= "+character);
            System.out.println("index= "+(character - 'a'));

            alphabet[character - 'a']++;  // character-'a' -> index tuong ung voi character

            System.out.println("số lần xuất hiện của "+character
                    + " - index: "+  (character - 'a')
                    + " là "+ alphabet[character - 'a']);

        }// dem duoc so lan xuat hien cua tat ca cac ki tu trong s
        // baccde
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i); //b
            if (alphabet[character - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        firstUniqChar("leetcode");

        // 9, 1, 2,2, 3, 4,
    }
}

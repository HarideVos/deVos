package LeetCode9;

public class ReverseWords {

        public static String reverseWords(String s) {

            String[] str = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = str.length - 1; i >= 0; i--){
                if(str[i] != ""){
                    sb.append(str[i]); // add word
                    sb.append(" "); // add space after that word
                }
            }
            sb.setLength(sb.length() - 1); //delete last space by reducing size
            return sb.toString();
        }
        String result = reverseWords("Hello World");


}

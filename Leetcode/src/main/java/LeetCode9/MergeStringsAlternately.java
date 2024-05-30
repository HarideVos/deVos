package LeetCode9;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        int j = 0;
        for (;i<word1.length() && j < word2.length() ;i++, j++){
            s.append(word1.charAt(i));
            s.append(word2.charAt(j));
        }
        if(i<word1.length()){
            s.append(word1.substring(i));
        }
        if(j < word2.length()){
            s.append(word2.substring(j));
        }
        return s.toString();
    }
}
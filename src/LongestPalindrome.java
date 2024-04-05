public class LongestPalindrome {
    public static void main(String[] args) {
        Solution mais = new Solution();

        int prueba = mais.longestPalindrome("fbb", "eba");

        System.out.println(prueba);
    }
}

class Solution {
    public int longestPalindrome(String word1, String word2) {

        if(Share(word1, word2)){
            word1 = sort(word1);
            word2 = invert(sort(word2));

            word1 = removeDuplicates(word1);
            word2 = removeDuplicates(word2);

            String result = word1 + word2;

            result = removeDuplicates(result);

            if(isPalindrome(result)){
                result = word2 + word1;

                while(isPalindrome(result)){
                    result = result.substring(1, result.length()-1);
                }

            }

            System.out.println(result);
            return result.length();

        }else{
            return 0;
        }
    }

    public boolean isPalindrome(String set){
        boolean result = true;
        for(int i = 0; i < set.length()/2; i++){
            if(set.charAt(i) != set.charAt(set.length() - 1 - i)){
                result = false;
                break;
            }
        }

        return !result;
    }

    public boolean Share(String word1, String word2){
        boolean result = false;
        for(int x = 0; x < word1.length(); x++){
            if(word2.contains(String.valueOf(word1.charAt(x)))){
                result = true;
                break;
            }
        }
        return result;
    }

    public String sort(String set){
        StringBuilder base = new StringBuilder(set);
        StringBuilder result = new StringBuilder();

        while(result.length() < set.length()){
            char minimum = Character.MAX_VALUE;
            int index = 0;
            for(int i = 0; i < base.length(); i++){
                if(base.charAt(i) < minimum){
                    minimum = base.charAt(i);
                    index = i;
                }
            }
            result.append(minimum);
            base.delete(index, index+1);
        }

        return result.toString();
    }

    public String invert(String set){
        StringBuilder result = new StringBuilder();
        for(int i = set.length() - 1; i >= 0; i--){
            result.append(set.charAt(i));
        }

        return result.toString();
    }

    public String removeDuplicates(String set){
        StringBuilder result = new StringBuilder(set);
        for(int i = 0; i < result.length() - 1; i++){
            if(result.charAt(i) == result.charAt(i+1)){
                result.delete(i, i+1);
                i--;
            }
        }

        return result.toString();
    }
}

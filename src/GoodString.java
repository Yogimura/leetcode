public class GoodString {
    public static void main(String[] args) {
        Solution1 example = new Solution1();

        System.out.println(example.makeGood("s"));
    }
}

class Solution1 {
    public String makeGood(String s){
        String base = s;
        while(validate(base)[0] != -1){
            int[] indexs = validate(base);
            base = base.substring(0, indexs[0]) + base.substring(indexs[1]+1);
        }
        return base;

    }

    public int[] validate(String s){
        int[] result = {-1, -1};
        char[] base = s.toCharArray();
        for(int i = 0; i <= base.length - 2;i++){
            char Perror = base[i];
            char Serror = base[i+1];
            boolean pass1 = Character.isUpperCase(Perror) && Character.isLowerCase(Serror);
            boolean pass2 = Character.isUpperCase(Serror) && Character.isLowerCase(Perror);

            if(pass1){
                if(Serror == Character.toLowerCase(Perror)){
                    result[0] = i;
                    result[1] = i+1;
                    break;
                }
            }

            if(pass2){
                if(Perror == Character.toLowerCase(Serror)){
                    result[0] = i;
                    result[1] = i+1;
                    break;
                }
            }
        }

        return result;
    }
}
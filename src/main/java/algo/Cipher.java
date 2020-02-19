package algo;

public class Cipher {

    /**
     * @param sentence, eg : "tacos"
     * @param shift,    eg : 3
     * @return encrypted sentence, eg : "wdfrv"
     */
    public static String caesar(String sentence, int shift) {

        if(shift > 26){
            shift = shift % 26;
        }
        else if(shift < 0){
            shift = (shift % 26) + 26;
        }
        String result = "";
        for(int i = 0; i < sentence.length(); i++){

            char ch = sentence.charAt(i);

            if(Character.isLetter(ch)){
                    char c = (char)(ch + shift);
                    if(c > 'z'){
                        result += (char)(ch - (26 - shift));
                    }
                    else {
                        result += c;
                    }
            }
            else {
                result += ch;
            }
        }
        return result;
    }
}

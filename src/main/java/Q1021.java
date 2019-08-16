import org.junit.Assert;
import org.junit.Test;

public class Q1021 {

    // https://leetcode.com/problems/remove-outermost-parentheses/submissions/

    public static String removeOuterParentheses(String S) {
        if(S == null || S.length() == 0) return S;

        StringBuilder sb = new StringBuilder();
        int open = 0;
        int x = 0;


        for(char ch: S.toCharArray()){
            open += (ch == '(') ? 1 : -1;
            if(open == 0){
                sb.deleteCharAt(x);
                x = sb.length();
            }else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }


    @Test
    public void positiveTest1(){
        final String input = "(()())(())";
        final String expectedOutput  = "()()()";
        Assert.assertEquals(expectedOutput, removeOuterParentheses(input));
    }

    @Test
    public void positiveTest2(){
        final String input = "(()())(())(()(()))";
        final String expectedOutput  = "()()()()(())";
        Assert.assertEquals(expectedOutput, removeOuterParentheses(input));
    }

}

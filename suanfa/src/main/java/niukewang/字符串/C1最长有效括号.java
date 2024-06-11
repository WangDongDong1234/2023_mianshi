package niukewang.字符串;

import java.util.Stack;

/**
 * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
 * 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
 * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
 * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/longest-valid-parentheses/solutions/314683/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class C1最长有效括号 {
    public static int longestValidParentheses(String s) {
        char[] chars=s.toCharArray();
        Stack<Integer> stack=new Stack();
        stack.push(-1);
        int max=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    // 此处和 stack.push(-1); 用意是一样的。
                    stack.push(i);
                }else{
                    max=Math.max(max,i-stack.peek());
                }
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int max =longestValidParentheses(")()())");
        System.out.println(max);
    }
}

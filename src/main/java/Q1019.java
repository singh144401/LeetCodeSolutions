import basic.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class Q1019 {

//    https://leetcode.com/problems/next-greater-node-in-linked-list/

    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> indexStack = new Stack();

        int[] res = new int[getSize(head)];
        Arrays.fill(res,0);
        int x = 0;

        while(head!=null){
            if(!stack.isEmpty() && stack.peek() < head.val) {
                int currMax = head.val;
                while( !stack.isEmpty() && stack.peek() < currMax) {
                    res[indexStack.pop()] = currMax;
                    stack.pop();
                }
            }

            indexStack.push(x++);
            stack.push(head.val);
            head = head.next;
        }

        return res;
    }


    public int getSize(ListNode head){
        int size =0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}

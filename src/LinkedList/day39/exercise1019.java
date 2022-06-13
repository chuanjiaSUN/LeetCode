package LinkedList.day39;

import javax.xml.soap.Node;
import java.sql.Statement;
import java.util.*;
import java.util.function.Function;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-14 11:29
 */
public class exercise1019 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

        @Override
        public String toString() {
            return "prepareAutumn.ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    //法1
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return new int[]{};
        int length = 0;
        ListNode cur = head;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        int[] ans = new int[length];
        cur = head;
        for(int i = 0;i <length - 1; i++)
        {
            ListNode next = cur.next;
            for(int j = i + 1; j < length; j++)
            {
                if(next.val > cur.val)
                {
                    ans[i] = next.val;
                    break;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return ans;
    }

    //法2 栈
    public int[] nextLargerNodes1(ListNode head)
    {
        if(head == null) return new int[]{};
        Deque<Integer> stack = new LinkedList<>();//栈中存元素下标
        List<Integer> list = new ArrayList<>();
        while ( head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            while ( !stack.isEmpty() && list.get(stack.peek()) < list.get(i))
            {
                int index = stack.pop();
                ans[index] = list.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
    //法3 从后往前，栈剪枝
    public int[] nextLargerNodes2(ListNode head)
    {
        List<Integer> list = new ArrayList<>();
        while (head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for(int i = ans.length - 1; i >=0; i--)
        {
            int j = i + 1;
            int num = 0;
            if( j < ans.length)
            {
                num = list.get(j);
            }
            while ( j < ans.length)
            {
                if( num > list.get(i))
                {
                    ans[i] = num;
                    break;
                }else if(num == 0){
                    break;
                }else{
                    num = ans[j++];
                }
            }
        }
        return ans;
    }
    //栈
    public int[] nextLargerNodes3(ListNode head)
    {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        for(ListNode node = head; node != null; node = node.next)
        {
            while (!stack.isEmpty() && node.val > list.get(stack.peek()))
            {
                list.set(stack.pop(), node.val);
            }
            stack.push(list.size());//存下标
            list.add(node.val);
        }
        for (int i : stack)
        {
            list.set( i, 0);
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }
    int[] fuck;
    //递归
    public int[] nextLargerNodes4(ListNode head)
    {
        calNode(head, 0,new Stack<Integer>());
        return fuck;
    }

    private void calNode(ListNode node, int index, Stack<Integer> stack) {
        if(node == null)
        {
            fuck = new int[index];//初始化数组大小
            return;
        }
        calNode(node.next, index + 1, stack);//递归从后往前返回
        while ( !stack.isEmpty() && stack.peek() <= node.val)
        {
            stack.pop();
        }
        fuck[index] = stack.isEmpty() ? 0 : stack.peek();
        stack.push(node.val);//递归返回最近的值入栈，作为栈顶
    }
}

/*
面试题30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 
示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
 
提示：
各函数的调用总次数不超过 20000 次
*/

//方法想到了，单纯记录一下怎么改造一个现有的数据结构。
class MinStack {
    //如何改造一个现有的栈结构
    public class Node{
        int val;
        int min;
        public Node(int val,int min){
            this.val=val;
            this.min=min;
        }
    }
    Stack <Node> stack=new Stack<Node>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        int min=0;
        if(stack.isEmpty())
            min=x;
        else
            {
                min=Math.min(stack.peek().min,x);
            }
        Node node=new Node(x,min);
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int min() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
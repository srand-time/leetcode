/*
������30. ����min������ջ
����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min �����ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
 
ʾ��:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> ���� -3.
minStack.pop();
minStack.top();      --> ���� 0.
minStack.min();   --> ���� -2.
 
��ʾ��
�������ĵ����ܴ��������� 20000 ��
*/

//�����뵽�ˣ�������¼һ����ô����һ�����е����ݽṹ��
class MinStack {
    //��θ���һ�����е�ջ�ṹ
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
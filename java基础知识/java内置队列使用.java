package queue;

import java.util.LinkedList;
import java.util.Queue;

//ע��java��size����Ҫ�����ģ��������á�
//����������LinkedList<Integer> q1 = new LinkedList();���õĲ������࣬����removeLast
//"static void main" must be defined in a public class.
//����̬void main�������ڹ������ж��塣
public class Main3 {
 public static void main(String[] args) {
     // 1. Initialize a queue.
     //1.��ʼ��һ�����С�
     Queue<Integer> q = new LinkedList();
     // 2. Get the first element - return null if queue is empty.
     //2.��ȡ��һ��Ԫ�ء����������Ϊ�գ�����null��
     System.out.println("The first element is: " + q.peek());
     // 3. Push new element.
     //3. ������Ԫ�ء�
     q.offer(5);
     q.offer(13);
     q.offer(8);
     q.offer(6);
     // 4. Pop an element.
     //4. ������ɾ���ö��е�ͷ������˶���Ϊ�գ��򷵻�{@code null}��
     int t=q.poll();
     System.out.println(t);
     // 5. Get the first element.
     //5. �õ���һ��Ԫ�ء�
     System.out.println("The first element is: " + q.peek());
     // 7. Get the size of the queue.
     //��ȡ���еĴ�С��
     System.out.println("The size is: " + q.size());
 }
}

//����https://www.cnblogs.com/zsh-blogs/p/9975806.html
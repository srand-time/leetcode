/*
����һ������ nums �ͻ������ڵĴ�С k�����ҳ����л�������������ֵ��

ʾ��:

����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
���: [3,3,5,5,6,7] 
����: 

  �������ڵ�λ��                ���ֵ
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 

��ʾ��

����Լ��� k ������Ч�ģ����������鲻Ϊ�յ�����£�1 �� k �� ��������Ĵ�С

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/





/*
���ǿ���ʹ��˫����У������ݽṹ���Դ������Գ���ʱ��ѹ��/����Ԫ�ء�
�洢˫����е������ȴ洢Ԫ�ظ����㣬��Ϊ���߶��������������ʹ�á�
�㷨
�㷨�ǳ�ֱ���˵���


����ǰ k ��Ԫ�أ���ʼ��˫����С�


�����������顣��ÿһ�� :
����˫����� :
  - ֻ������ǰ�����������е�Ԫ�ص�������

  - �Ƴ��ȵ�ǰԪ��С������Ԫ�أ����ǲ����������ġ�




����ǰԪ����ӵ�˫������С�
�� deque[0] ��ӵ�����С�
����������顣

���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
*/

class Solution {
  ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
  int [] nums;

  public void clean_deque(int i, int k) {
    // remove indexes of elements not from sliding window
    if (!deq.isEmpty() && deq.getFirst() == i - k)
      deq.removeFirst();

    // remove from deq indexes of all elements 
    // which are smaller than current element nums[i]
    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;

    // init deque and output
    this.nums = nums;
    int max_idx = 0;
    for (int i = 0; i < k; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      // compute max in nums[:k]
      if (nums[i] > nums[max_idx]) max_idx = i;
    }
    int [] output = new int[n - k + 1];
    output[0] = nums[max_idx];

    // build output
    for (int i  = k; i < n; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      output[i - k + 1] = nums[deq.getFirst()];
    }
    return output;
  }
}

���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
/*
����һ��������������飬�ҵ���������������еĳ��ȡ�

ʾ��:

����: [10,9,2,5,3,7,101,18]
���: 4 
����: ��������������� [2,3,7,101]�����ĳ����� 4��

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/longest-increasing-subsequence
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/

/*
����һ���򵥵�̰�ģ��������Ҫʹ���������о����ܵĳ�����������Ҫ�����������þ����������������ϣ��ÿ�������������������ϵ��Ǹ��������ܵ�С��
���������̰��˼·������ά��һ������ d[i] ����ʾ����Ϊ i ������������е�ĩβԪ�ص���Сֵ���� len ��¼Ŀǰ����������еĳ��ȣ���ʼʱ len Ϊ 1��d[1]=nums[0]
�ټ��϶��ֲ���
���ߣ�LeetCode-Solution
���ӣ�https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
*/

//û���nlogn���㷨��ֻ�����n^2�Ķ��档����������⡣
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int i=0;i<nums.length;i++) {
            int idx = Arrays.binarySearch(res, 0, len, nums[i]);
            /*�ܽ᣺binarySearch()�����ķ���ֵΪ��1������ҵ��ؼ��֣��򷵻�ֵΪ�ؼ����������е�λ����������������0��ʼ2�����û���ҵ��ؼ��֣�����ֵΪ���Ĳ����ֵ����ν�����ֵ���ǵ�һ���ȹؼ��ִ��Ԫ���������е�λ���������������λ��������1��ʼ��
            */
            if(idx<0)
                idx=-idx-1; 
            res[idx] = nums[i];
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
}
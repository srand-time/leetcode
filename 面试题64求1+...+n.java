/*
�� 1+2+...+n ��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C���� 

ʾ�� 1��

����: n = 3
���: 6


ʾ�� 2��

����: n = 9
���: 45


 

���ƣ�


	1 <= n <= 10000

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/qiu-12n-lcof
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/


class Solution {
    public int sumNums(int n) {
        int sum = n;
    boolean ans = (n > 0) && ((sum += sumNums(n - 1)) > 0);
    return sum;
    }
}
//ֱ�ӳ�����⡣��֪���ݹ���ôͣ��
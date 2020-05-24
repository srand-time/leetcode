/*
42. ����ˮ�Ѷ�

���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��

ʾ��:

����: [0,1,0,2,1,0,1,3,2,1,2,1]
���: 6

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/trapping-rain-water
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/

class Solution {
    public int trap(int[] height) {
        int i=0;
        int len=height.length;
        if(height.length==0)
            return 0;
        int []left=new int [len];
        int []right=new int [len];
        //left[i]����i������˸߶ȵ����ֵ
        //right[i]����i�����Ҷ˸߶ȵ����ֵ
        int res=0;
        left[0]=height[0];
        for(i=1;i<len;i++)
            left[i]=Math.max(left[i-1],height[i]);
        
        right[len-1]=height[len-1];
        for(i=len-2;i>=0;i--)
            right[i]=Math.max(right[i+1],height[i]);

        for(i=0;i<len;i++)
            res=res+Math.min(right[i],left[i])-height[i];
            //��ǰλ�ö�������ˮ�Ĺ���ֵΪ
            //���Ҷ˵Ľ�С�߶ȼ�ȥ��ǰ�߶�
        return res;
    }
}
/*
42. 接雨水难度

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class Solution {
    public int trap(int[] height) {
        int i=0;
        int len=height.length;
        if(height.length==0)
            return 0;
        int []left=new int [len];
        int []right=new int [len];
        //left[i]代表i到最左端高度的最大值
        //right[i]代表i到最右端高度的最大值
        int res=0;
        left[0]=height[0];
        for(i=1;i<len;i++)
            left[i]=Math.max(left[i-1],height[i]);
        
        right[len-1]=height[len-1];
        for(i=len-2;i>=0;i--)
            right[i]=Math.max(right[i+1],height[i]);

        for(i=0;i<len;i++)
            res=res+Math.min(right[i],left[i])-height[i];
            //当前位置对所接雨水的贡献值为
            //左右端的较小高度减去当前高度
        return res;
    }
}
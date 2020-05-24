/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。


说明:

假设你总是可以到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/




//来自高赞题解
//贪心算法
class Solution {
    public int jump(int[] nums) {
       
       int maxlen=0;
        //某一步下能跳到的最大距离
        
        int steps=0;
        //跳了多少步    
        
        int i;
        //i到maxlen其实就是第step步的跳跃范围
        //因为每次至少跳一步，所以最小值是i
        //而maxlen需要实时f更新
        
        int end=0;
        //记录这一步能跳到的最远距离
        
        for(i=0;i<nums.length-1;i++)
        {
            maxlen=Math.max(i+nums[i],maxlen);
            if(i==end)
            //把这一步能跳到的所有位置都遍历，得到下一步能跳到的最远位置
            {
                steps++;
                end=maxlen;
            }
        }
        return steps;
    }
}
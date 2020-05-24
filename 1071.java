/*
对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。

返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。

 

示例 1：

输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"


示例 2：

输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"


示例 3：

输入：str1 = "LEET", str2 = "CODE"
输出：""

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

/*
    多从数学的角度思考问题，只要(str1+str2).equals(str2+str1)不成立就可以直接返回""了。
    之后也只用返回gcd(len1,len2)即可。
*/
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1,len2;
        len1=str1.length();len2=str2.length();
        int i,j,k;
        if(len1==0||len2==0)
            return "";
        if(!(str1+str2).equals(str2+str1))
            return "";
        i=len1;j=len2;
        k=GCD(i,j);//k为最大公约数
        return str1.substring(0,k);
    }

    public int GCD(int m,int n)
    {
        int result=0;
        int t;
        if(m<n){t=n;n=m;m=t;}
        while(n!=0)
        {
            result=m%n;
            m=n;
            n=result;
        }
        return m;
    }
}
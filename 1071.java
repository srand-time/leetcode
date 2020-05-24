/*
�����ַ��� S �� T��ֻ���� S = T + ... + T��T ���������� 1 �λ��Σ�ʱ�����ǲ��϶� ��T �ܳ��� S����

������ַ��� X��Ҫ������ X �ܳ��� str1 �� X �ܳ��� str2��

 

ʾ�� 1��

���룺str1 = "ABCABC", str2 = "ABC"
�����"ABC"


ʾ�� 2��

���룺str1 = "ABABAB", str2 = "ABAB"
�����"AB"


ʾ�� 3��

���룺str1 = "LEET", str2 = "CODE"
�����""

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������

*/

/*
    �����ѧ�ĽǶ�˼�����⣬ֻҪ(str1+str2).equals(str2+str1)�������Ϳ���ֱ�ӷ���""�ˡ�
    ֮��Ҳֻ�÷���gcd(len1,len2)���ɡ�
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
        k=GCD(i,j);//kΪ���Լ��
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
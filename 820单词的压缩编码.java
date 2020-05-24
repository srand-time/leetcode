/*
给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

 

示例：

输入: words = ["time", "me", "bell"]
输出: 10
说明: S = "time#bell#" ， indexes = [0, 2, 5] 。


 

提示：


	1 <= words.length <= 2000
	1 <= words[i].length <= 7
	每个单词都是小写字母 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/short-encoding-of-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

//字典树的数据结构的使用
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int i,j,k;
        trienode root=new trienode('0');
        for(i=0;i<words.length;i++)//遍历所有字符串
            {
                String str=reverse1(words[i]);
                for(j=0;j<words[i].length();j++)
                {
                    root.insert(root,str);
                }
            }

        //统计返回值(如果想要更快可以在插入的时候一并统计，但这样插入的时候就一定要按照从长到短的次序来插入，
        //不过效率确实有所提高。)
        int res=count(root,0);
        return res;
    }

    public int count(trienode node,int ceng)
    {
        int i;
        int res=0;
        int flag=0;
        for(i=0;i<26;i++)
        {
            if(node.children[i]!=null)
                res=res+count(node.children[i],ceng+1);
            else
                flag++;
        }   
        if(flag==26)
            return ceng+1;
        return res;
    }

    public String reverse1(String str) //反转字符串
    {
    return new StringBuilder(str).reverse().toString();
    }
}

//采用字典树的数据结构
class trienode
{
    char val;
    trienode []children=new trienode[26];
    public trienode(char val)
    {
        this.val=val;
    }
    public void insert(trienode root,String s)
    {
        trienode now;
        now=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(now.children[c-'a']==null)
            {
                now.children[c-'a']=new trienode(c);
            }
            now=now.children[c-'a'];
        }
    }
}
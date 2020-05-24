/*
����һ�������б����ǽ�����б�����һ�������ַ��� S ��һ�������б� A��

���磬�������б��� ["time", "me", "bell"]�����ǾͿ��Խ����ʾΪ S = "time#bell#" �� indexes = [0, 2, 5]��

����ÿһ�����������ǿ���ͨ�����ַ��� S ��������λ�ÿ�ʼ��ȡ�ַ�����ֱ�� "#" ���������ָ�����֮ǰ�ĵ����б�

��ô�ɹ��Ը��������б���б������С�ַ��������Ƕ����أ�

 

ʾ����

����: words = ["time", "me", "bell"]
���: 10
˵��: S = "time#bell#" �� indexes = [0, 2, 5] ��


 

��ʾ��


	1 <= words.length <= 2000
	1 <= words[i].length <= 7
	ÿ�����ʶ���Сд��ĸ ��

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/short-encoding-of-words
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/

//�ֵ��������ݽṹ��ʹ��
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int i,j,k;
        trienode root=new trienode('0');
        for(i=0;i<words.length;i++)//���������ַ���
            {
                String str=reverse1(words[i]);
                for(j=0;j<words[i].length();j++)
                {
                    root.insert(root,str);
                }
            }

        //ͳ�Ʒ���ֵ(�����Ҫ��������ڲ����ʱ��һ��ͳ�ƣ������������ʱ���һ��Ҫ���մӳ����̵Ĵ��������룬
        //����Ч��ȷʵ������ߡ�)
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

    public String reverse1(String str) //��ת�ַ���
    {
    return new StringBuilder(str).reverse().toString();
    }
}

//�����ֵ��������ݽṹ
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
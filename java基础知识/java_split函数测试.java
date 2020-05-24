/*
1、如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");
2、如果用“|”作为分隔的话,必须是如下写法,String.split("\\|"),这样才能正确的分隔开,不能用String.split("|");
“.”和“|”都是转义字符,必须得加"\\";
3、如果在一个字符串中有多个分隔符,可以用“|”作为连字符,比如,“acount=? and uu =? or n=?”,把三个都分隔出来,可以用String.split("and|or");
使用String.split方法分隔字符串时,分隔符如果用到一些特殊字符,可能会得不到我们预期的结果。
*/

public class test{
	public static void main(String args[])
	{
		String str1 = "ab,cc,sssd,ert,,,eed";

		String[] str_array = str1.split(",");

		print(str_array);
		/*
		运行结果:str_array size:7 
		ab : 2
		cc : 2
		sssd : 4
		ert : 3
		: 0
		: 0
		eed : 3
		可以把一个分隔符看成一次换行，
		数组长一共会有分隔符个数+1那么长
		*/
	}
	public static void print(String[] str_array){		
		System.out.println("str_array size:" + str_array.length);		
		for(String str : str_array){			
		System.out.println(str + " : " + str.length());		
		}	
	}
}
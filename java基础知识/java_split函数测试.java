/*
1������á�.����Ϊ�ָ��Ļ�,����������д��,String.split("\\."),����������ȷ�ķָ���,������String.split(".");
2������á�|����Ϊ�ָ��Ļ�,����������д��,String.split("\\|"),����������ȷ�ķָ���,������String.split("|");
��.���͡�|������ת���ַ�,����ü�"\\";
3�������һ���ַ������ж���ָ���,�����á�|����Ϊ���ַ�,����,��acount=? and uu =? or n=?��,���������ָ�����,������String.split("and|or");
ʹ��String.split�����ָ��ַ���ʱ,�ָ�������õ�һЩ�����ַ�,���ܻ�ò�������Ԥ�ڵĽ����
*/

public class test{
	public static void main(String args[])
	{
		String str1 = "ab,cc,sssd,ert,,,eed";

		String[] str_array = str1.split(",");

		print(str_array);
		/*
		���н��:str_array size:7 
		ab : 2
		cc : 2
		sssd : 4
		ert : 3
		: 0
		: 0
		eed : 3
		���԰�һ���ָ�������һ�λ��У�
		���鳤һ�����зָ�������+1��ô��
		*/
	}
	public static void print(String[] str_array){		
		System.out.println("str_array size:" + str_array.length);		
		for(String str : str_array){			
		System.out.println(str + " : " + str.length());		
		}	
	}
}

package cn.day06.demo04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class java {
    public static void main(String[] args) {
        List<List<Integer>>list=new LinkedList<>();
        List<Integer>list1=new ArrayList<Integer>();
        list1.add(50);
        list1.add(150);
        list1.add(250);
        list.add(list1);
        System.out.println(list);
    }
}
/*
��������������������������������
��Ȩ����������ΪCSDN����������Сˬ����ԭ�����£���ѭ CC 4.0 BY-SA ��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45457983/java/article/details/104113894
*/

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
————————————————
版权声明：本文为CSDN博主「爱的小爽」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45457983/java/article/details/104113894
*/
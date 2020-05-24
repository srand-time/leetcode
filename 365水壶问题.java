/*
�����������ֱ�Ϊ x�� �� y�� ��ˮ���Լ����޶��ˮ�����ж��ܷ�ͨ��ʹ��������ˮ�����Ӷ����Եõ�ǡ�� z�� ��ˮ��
������ԣ������������ˮ���е�һ��������ʢ��ȡ�õ� z�� ˮ��
������
װ������һ��ˮ��
�������һ��ˮ��
��һ��ˮ��������һ��ˮ����ˮ��ֱ��װ�����ߵ���
ʾ�� 1: (From the famous "Die Hard" example)
����: x = 3, y = 5, z = 4
���: True
ʾ�� 2:
����: x = 2, y = 6, z = 5
���: False
*/




class Solution {
//�������
//�벻����ѧ��
//ÿ�εı仯��Ϊx��y
//z=ax+by
//ֻҪzΪx��y�����Լ���ı����Ϳ��ԡ�

public boolean canMeasureWater(int x, int y, int z) {
    if (z == 0) return true;
    if (x + y < z) return false;

    int big = Math.max(x, y);
    int small = x + y - big;

    if (small == 0) return big == z;


    while (big % small != 0) {
        int temp = small;
        small = big % small;
        big = temp;
    }
    return z % small == 0;
    }
}
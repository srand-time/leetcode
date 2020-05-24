/*
����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�

ʾ��:

����: [1,2,3]
���:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/permutations
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/



//���Ը������
//���ݷ�
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        //���ʹ�����ЩԪ��
        
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        //res���ʽ��,nums�������������
        //tmp���Խ��з��ʵ����飬visited���ڷ��ʵ�����
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
        //�����������з��ʣ������ʵ��˵ײ�
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            //����Ѿ����ʹ��˾Ͳ��ٷ���
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
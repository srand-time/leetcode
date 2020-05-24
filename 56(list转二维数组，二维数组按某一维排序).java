class Solution {
    public int[][] merge(int[][] intervals) {
        //对所有区间按照起始值排序
        Arrays.sort(intervals,(int []o1,int []o2)->o1[0]-o2[0]);
        int i,j;
        List<int []>list=new LinkedList<>();
        if(intervals.length==0)
            return new int [0][0];
        for(i=0;i<intervals.length-1;i++)
        {
            if(intervals[i][1]>=intervals[i+1][0])
            {
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=Math.max(intervals[i][1],intervals[i+1][1]);
            }
            else
            {
                list.add(intervals[i]);
            }
        }
        list.add(intervals[i]);
        return list.toArray(new int [list.size()][2]);
    }
}
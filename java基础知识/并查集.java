public class Unionfind{
    private int []parent;
    public Unionfind(int n){
        //相当于初始化了n个集合
        this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
    }
    public int root(int x){
        //查找某个元素位于哪一个集合中
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public boolean isConnected(int x,int y){
        //判断两个元素是否处于一个集合之中
        return root(x)==root(y);
    }
    public void union(int p,int q){
        //合并两个集合
        if(isConnected(p, q)){
            return;
        }
        parent[root(p)]=root(q);
    }
}

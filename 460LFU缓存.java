//���Ḵ�Ӷ�1�ģ�ֱ�ӿ������
class LFUCache {
    Map<Integer, Node> cache;  // �洢���������
    Map<Integer, LinkedHashSet<Node>> freqMap; // �洢ÿ��Ƶ�ζ�Ӧ��˫������
    int size;
    int capacity;//��������
    int min; // �洢��ǰ��СƵ��

    public LFUCache(int capacity) {
        cache = new HashMap<> (capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);//���µ�ǰ���Ƶ�ʣ����ҿ��ܻ�������������Ӱ��
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } 
        //������nodeʱ
        else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;     
        }
    }

    void freqInc(Node node) {
        // ��ԭfreq��Ӧ���������Ƴ�, ������min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) { 
            min = freq + 1;
        }
        // ������freq��Ӧ������
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        } 
        set.add(node); 
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;//������Ƶ��

    public Node() {}
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
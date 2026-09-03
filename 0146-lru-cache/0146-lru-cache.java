class LRUCache {

    class Node
    {
        int key,val;
        Node next,prev;

        Node(int k,int v)
        {
            this.key=k;
            this.val=v;
        }
    }

    int capacity;
    HashMap<Integer,Node> map;
    Node head,tail;
    public LRUCache(int capacity) 
    {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);

        head.next=tail;
        tail.prev=head;
    }

    public void remove(Node a)
    {
        a.prev.next=a.next;
        a.next.prev=a.prev;
    }

    public void insert(Node a)
    {
        a.next=head.next;
        head.next=a;
        a.prev=head;
        a.next.prev=a;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        Node a=map.get(key);
        
        remove(a);
        insert(a);

        return a.val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node a;
        if(map.containsKey(key))
        {
            a=map.get(key);

            a.val=value;

            remove(a);
            insert(a);
        }
        else
        {
            a=new Node(key,value);
            insert(a);
            map.put(key,a);
        }
  
        if(map.size()>capacity)
        {
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
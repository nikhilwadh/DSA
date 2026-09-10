class Solution {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> l=new ArrayList<>();

        for(int num : nums) {
            l.add(num);
        }

        for(int i=l.size()/2-1;i>=0;i--) heapify(l,l.size(),i);
        int max=-1;
        while(k>0)
        {
            max=l.get(0);
            l.set(0,l.get(l.size()-1));
            l.remove(l.size()-1);

            heapify(l,l.size(),0);
            k--;
        }
        return max;
    }
    
    public void heapify(ArrayList<Integer> l, int n, int i)
    {
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;

        if(left<n && l.get(largest)<l.get(left))
        {
            largest=left;
        }
        if(right<n && l.get(largest)<l.get(right))
        {
            largest=right;
        }

        if(largest!=i)
        {
            int temp=l.get(i);
            l.set(i,l.get(largest));
            l.set(largest,temp);

            heapify(l,n,largest);
        }
    }
}
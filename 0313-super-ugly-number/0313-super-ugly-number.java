class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k=primes.length;
        long arr[]=new long[n];
        arr[0]=1;
        int ptr[]=new int[k];

        for(int i=1;i<n;i++)
        {
            long next=Long.MAX_VALUE;

            for(int j=0;j<k;j++)
            {
                next=Math.min(next,(long)arr[ptr[j]]*primes[j]);
            }
            arr[i]=next;

            for(int j=0;j<k;j++)
            {
                if(arr[ptr[j]]*primes[j] == next)
                {
                    ptr[j]++;
                }
            }
        }
        return (int)arr[n-1];
    }
}
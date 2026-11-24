class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int max=-1;
        for(int i=0;i<piles.length;i++)
        {
            if(max<piles[i])
            {
                max=piles[i];
            }
        }

        int b=1,e=max;
        while(b<=e)
        {
            int mid=e+((b-e)/2);
            int count=0;
            for(int i=0;i<piles.length;i++)
            {
                if(count>h)
                {
                    break;
                }
                count += (piles[i] + mid - 1) / mid;
            }
            if(count>h)
            {
                b=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        return b;
    }
}
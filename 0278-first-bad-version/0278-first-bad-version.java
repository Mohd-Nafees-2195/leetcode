/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int l=1,h=n;
        while(l<h)
        {
            int mid=l+(h-l)/2;
            if(!isBadVersion(mid))
                l=mid+1;
            else
            {
                h=mid-1;
                if(isBadVersion(mid-1)!=true)
                    return mid;
                    
            }
        }
        return l;
    }
}
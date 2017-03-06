class Solution{
public:
	int getkth(int s[], int m, int l[], int n, int k){
		//let m<=n
		if(m > n)
			return getkth(l, n, s, m, k);
		if(m == 0)
			return l[k - 1];
		if(k == 1)
			return min(s[0], l[0]);

		int i = min(m, k/2), j = min(n, k/2);
		if(s[i-1] > l[j -1])
			return getkth(s, m, l+j, n-j, k-j);
		else 
			return getkth(s+i, m-i, l, n k-i);
		return 0;
	}
	double findMedianSortedArrays(int A[], int m, int B[],int n)
	{
		int l = (m+n+1) >> 1;
		int r = (m+n+2) >> 1;
		return (getkth(A, m, B, n, l) + getkth(A, m, B, n, r)) / 2.0
	}
}

/*The key point of this problem is to ignore half part of A and B each step recursively by comparing the median of remaining A and B:

if (aMid < bMid) Keep [aRight + bLeft]    
else Keep [bRight + aLeft]
As the following: time=O(log(m + n))
*/
public double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
	if (aStart > A.length - 1) return B[bStart + k - 1];            
	if (bStart > B.length - 1) return A[aStart + k - 1];                
	if (k == 1) return Math.min(A[aStart], B[bStart]);
	
	int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
	if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
	if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
	
	if (aMid < bMid) 
	    return getkth(A, aStart + k/2, B, bStart, k/2);// Check: aRight + bLeft 
	else 
	    return getkth(A, aStart,  B, bStart + k/2, k/2);// Check: bRight + aLeft
}

public class MedianofTwoSortedArrays2 {
    //先来一个蠢的，实现功能。其实效率还是可以的嘛，只不过不符合算法要求，时间复杂度在于排序的 n*log(n)
    public static double findMedianLow(int A[], int B[]) {
        int[] sumArray = ArrayUtils.addAll(A, B);
        Arrays.sort(sumArray);
        int length = sumArray.length;
        if (length % 2 == 0) {
            double num1 = sumArray[length / 2];
            double num2 = sumArray[length / 2 - 1];
            return (num1 + num2) / 2;
        } else {
            return sumArray[length / 2];
        }
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        //长度为积数取中间，为偶数去中间两个的平均值
        if ((total & 0x01) != 0) {
            return findMedian(A, m, B, n, total / 2 + 1);
        } else {
            return (findMedian(A, m, B, n, total / 2) + findMedian(A, m, B, n,total / 2 + 1)) / 2.0;
        }
    }

    //二分法，每次都能去除掉一部分范围外数据。需要注意每次去除数据都会改变数组的结构，所以需要特殊处理临界值
    private static double findMedian(int A[], int m, int B[], int n, int target) {
        if (m == 0) {
            return B[target - 1];
        } else if (n == 0) {
            return A[target - 1];
        } else if (target == 1) {
            return A[0] < B[0] ? A[0] : B[0];
        }
        int temp = target / 2;
        if (Math.min(m, n) < temp) {
            temp = Math.min(m, n);
        }
        if (A[temp - 1] > B[temp - 1]) {
            return findMedian(A, m, Arrays.copyOfRange(B, temp, n), n - temp, target - temp);
        } else if (A[temp - 1] < B[temp - 1]) {
            return findMedian(Arrays.copyOfRange(A, temp, m), m - temp, B, n, target - temp);
        } else {
            return A[temp - 1];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10000];
        int[] b = new int[20000];
        for (int i = 0; i < 10000; i++) {
            a[i] = i + 1;
        }
        for (int i = 10000; i < 30000; i++) {
            b[(i - 10000)] = i + 1;
        }
        long nowTime = System.currentTimeMillis();
        System.out.println(MedianofTwoSortedArrays2.findMedianLow(a, b));
        System.out.println(System.currentTimeMillis() - nowTime);
        long nowTime1 = System.currentTimeMillis();
        System.out.println(MedianofTwoSortedArrays2.findMedianSortedArrays(a, b));
        System.out.println(System.currentTimeMillis() - nowTime1);
    }
}


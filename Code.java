package misc;

public class main_misc2 {

	public static void main(String[] args) {
		// 
		int [] v = {3,2,-4,5};
		int [] l = {0,-2,4,-7};
		System.out.println(min_time(v,l));

	}
	private static void swap(int[]v,int i,int j) {
		//
		int d = v[j];
		v[j] = v[i];
		v[i] = d;
	}
	private static void quickSort(int[]v,int strt,int end) {
		//
		if(strt >= end) {
			return;
		}
		int p = v[end];
		int l = strt;
		int r = end;
		while(l < r) {
			while(v[l] <= p && l < r) {
				l++;
			}
			while(v[l] >= p && l < r) {
				r--;
			}
			swap(v,l,r);
		}
		if(v[l] >= v[end]) {
			swap(v,l,end);
		}
		else {
			l = end;
		}
		quickSort(v,strt,l-1);
		quickSort(v,l+1,end);
	}
	private static int dist(int i,int j) {
		int a = i;
		int b = j;
		if(a < 0) {
			a = -a;
		}
		if(b < 0) {
			b = -b;
		}
		if(a >= b) {
			return a-b;
		}
		return b-a;
	}
	private static int min_time(int[]v,int[]l) {
		//
		quickSort(v,0,v.length-1);
		quickSort(l,0,l.length-1);
		int max = 0;
		for(int i = 0;i < v.length;i++) {
			//
			int d = dist(v[i],l[i]);
			if(max <= d) {
				max = d;
			}
		}
		return max;
	}

}

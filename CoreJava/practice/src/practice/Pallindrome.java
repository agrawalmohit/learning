package practice;

public class Pallindrome {
	
	public static void main(String[] args) {
		System.out.println(isPallindrome(123));
		System.out.println(isPallindrome(121));
		System.out.println(isPallindrome(123454321));
		System.out.println(isPallindrome(-121));
		System.out.println(isPallindrome(100));
		System.out.println(isPallindrome(1));
		System.out.println(isPallindrome(0));
		System.out.println(isPallindrome(11));
		System.out.println(isPallindrome(12));
		System.out.println(isPallindrome(101));
	}

	public static boolean isPallindrome(int x) {
		System.out.print(x);
		if(x<0 || (x!=0 && x%10==0)){
            return false;
        }
        int orig = x;
		int temp = 0;
		while(x>temp) {
            orig = x;
			temp = (temp*10) + (x%10);
			x = x/10;
			//System.out.println(x+":"+temp+":"+orig);
		}
		return (orig==temp)?true:(x==temp);
	}
}

package yong.du.leetcode;

public class ReverseIntegerTest {
 
	 public static void main(String[] args){	 
		 ReverseInteger rInt = new  ReverseInteger();
		 System.out.println("Use string builder to do reverse"+ rInt.reverse(-123)); 
		 
		 ReverseInteger2 rInt2 = new  ReverseInteger2();
		 System.out.println("Use math mod and divide to do reverse" +rInt2.reverse(-123)); 
	 }
}
class ReverseInteger{
	public int reverse(int x) {
        boolean isNative;
        isNative  =  (x<0)?true:false;
        x = isNative ? -x:x;
        StringBuilder input1 = new StringBuilder();
        int y = Integer.parseInt(input1.append(x).reverse().toString());
        y = isNative ? -y:y;
        if(y > Integer.MAX_VALUE) return 0;
        return y;
    }
	
	
	
}


class ReverseInteger2{
	public int reverse(int x) {
        int result = 0;
		while(x!=0) {
        	result *=10 ;
        	result += (x%10);
        	x/=10;
        	}
		if(result > Integer.MAX_VALUE) return 0;
        return result;
    }
       
 }


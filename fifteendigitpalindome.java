/*
 * Google made GlassdoorÕs list of oddball questions with this one: ÒHow many cows are in Canada? 
 * Salesforce made the list, asking, ÒIf you could be anyone else, who would it be?Ó
 * Now, though, Rocket Fuel has kicked it up a notch, with a recruiting billboard along heavily traveled Rt. 101, the ValleyÕs main artery. It lists the companyÕs Internet address with an X. To get to page X, you need to solve this puzzle:
 * X=The largest 15 digit perfect square palindrome.
 * http://www.ere.net/2013/05/21/a-win-win-way-to-recruit-in-silicon-valley/
 * Answer: 900075181570009
 */
public class fifteendigitpalindome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = 100000000l;
		String startSquared;
		boolean is = false;
		for( ; start > 1000000l;start--){
			startSquared = (start * start) + "";
			is = isPalindome(startSquared, startSquared.length());
			if(is == true){
				System.out.println(start + "  is the answer "+ startSquared);
			}else{
				if(start/10000 == 0){
					System.out.println("Looked at "+ start);
				}
			}
		}
	}
	
	private static boolean isPalindome(String number, int digits){
		
		if(number.charAt(0) != number.charAt(digits-1)){
			return false;
		}
		if(number.charAt(1) != number.charAt(digits-2)){
			return false;
		}
		if(number.charAt(2) != number.charAt(digits-3)){
			return false;
		}
		if(number.charAt(3) != number.charAt(digits-4)){
			return false;
		}
		if(number.charAt(4) != number.charAt(digits-5)){
			return false;
		}
		if(number.charAt(5) != number.charAt(digits-6)){
			return false;
		}
		if(number.charAt(6) != number.charAt(digits-7)){
			return false;
		}
		
		return true;
	}
	
	private static void printpalindomes(){
		for(long i = 999999999999999l; i > 99999999999999l; i--){
			if(isPalindome( i+"", 15) == true){
				System.out.println(i);
			}
		}
	}
	
}

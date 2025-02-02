

public class StringProcessor {

	public String reverseString(String str) {
		StringBuilder sb=new StringBuilder();
		for(int i=str.length()-1;i>=0;i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public int countOccurance(String text,String sub) {
		int count=0;
		for(int i=0;i<=text.length()-sub.length();i++) {
			if(text.substring(i, i+sub.length()).equals(sub)) {
				count++;
			}
		}
		return count;
	}

	public String splitAndCapitalize(String str) {
		String[] s=str.split("[ ]+");
		for(int i=0;i<s.length;i++) {
			StringBuilder sb=new StringBuilder(s[i]);
			sb.replace(0, 1, Character.toUpperCase(s[i].charAt(0))+"");
			s[i]=sb.toString();
		}
		StringBuilder sb=new StringBuilder();
		for(String a:s) {
			sb.append(a+" ");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		StringProcessor sp=new StringProcessor();
		System.out.println(sp.reverseString("halo"));
		System.out.println(sp.countOccurance("op is op because it is op", "op"));
		System.out.println(sp.splitAndCapitalize("Hello   world"));
	}
}
	

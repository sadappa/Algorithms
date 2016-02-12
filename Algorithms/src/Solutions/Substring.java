package Solutions;

public class Substring {
	
	public static int subString(String s, String t) {
		
		if (s == null || s.length() == 0)
			return 0;
		
		if (t == null || t.length() == 0)
				return 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(i + t.length() > s.length())
				return -1;
			int m = i;
			for(int j = 0 ; j < t.length(); j++) {
				if(s.charAt(i) != t.charAt(j)) {
					break;
				} else {
					if(j == t.length() -1)
						return i;
					m++;
				}
			}
		}
		return -1;
	}

}

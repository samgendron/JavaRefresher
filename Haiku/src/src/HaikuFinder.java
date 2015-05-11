package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class HaikuFinder {

	
		public static void main(String[] args) throws IOException {
		String word;
		String line1 = null;
		String line2 = null;
		String line3 = null;
		
		String currentLine;
		
		int syllableCount = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("fileName.txt"));

		
		while((currentLine = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(currentLine, " ");
		
			while(st.hasMoreTokens()) {
				word = st.nextToken();
				line1= word;
				syllableCount = syllableCount + countSyllables(word);
			
				if(syllableCount==5) {
					
					while(st.hasMoreTokens()==true) {
						int sCount2= 0;
						String word2 = st.nextToken();
						sCount2 = sCount2 + countSyllables(word2);
						line2 = line2+ word;
						if(sCount2==7) {
							while(st.hasMoreTokens()) {
							int sCount3 = 0;
							sCount3 = sCount3 + countSyllables(st.nextToken());
							line3 = line3 + word;
							if(sCount3==5) {
								System.out.println(line1 +"\n"+ line2+"\n"+ line3);
							}
							}
						}
					}
				}
				
			}
			
		
	}
}
		
		
		
		
		public static int countSyllables(String word) {
		    int count = 0;
		    word = word.toLowerCase();
		    for (int i = 0; i < word.length(); i++) {
		        if (word.charAt(i) == '\"' || word.charAt(i) == '\'' || word.charAt(i) == '-' || word.charAt(i) == ',' || word.charAt(i) == ')' || word.charAt(i) == '(') {
		            word = word.substring(0,i)+word.substring(i+1, word.length());
		        }
		    }
		    boolean isPrevVowel = false;
		    for (int j = 0; j < word.length(); j++) {
		        if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
		            if (isVowel(word.charAt(j)) && !((word.charAt(j) == 'e') && (j == word.length()-1))) {
		                if (isPrevVowel == false) {
		                    count++;
		                    isPrevVowel = true;
		                }
		            } else {
		                isPrevVowel = false;
		            }
		        } else {
		            count++;
		            break;
		        }
		    }
		    return count;
		}
		
		
		public static boolean isVowel(char c) {
	        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	            return true;
	        } else {
	            return false;
	        }
	    }
}
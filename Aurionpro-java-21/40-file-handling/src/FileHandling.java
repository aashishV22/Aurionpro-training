import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling 
{
	public static void main(String[] args) 
	{
		BufferedReader br=null;
		int characterCount=0;
		int wordCount=0;
		int lineCount=0;
		try
		{
			br=new BufferedReader(new FileReader("D:\\Aurionpro-java-21\\40-file-handling\\src\\one.txt"));
			String line=br.readLine();
			while (line != null) {
				lineCount++;
				String[] words = line.split(",");
				wordCount = wordCount + words.length;

				for (String word : words) {
					System.out.println(word+" "+word.getClass());
					if(word=="1") {
						System.out.println("true");
						int regionCode=Integer.parseInt(word);
						System.out.println(regionCode);
					}
					characterCount = characterCount + word.length();
				}

				line = br.readLine();
		}
			System.out.println("Number Of Chars In A File : " + characterCount);

			System.out.println("Number Of Words In A File : " + wordCount);

			System.out.println("Number Of Lines In A File : " + lineCount);
			
	}catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
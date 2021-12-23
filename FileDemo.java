import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
class FileDemo{
	public static void main(String[] args){
		try{
			File fptr=new File("sample.txt");	
			Scanner reader=new Scanner(fptr);
			HashMap<String,Integer> map=new HashMap<String,Integer>();
			int wordCount=0,charCount=0,spaceCount=0;
			while(reader.hasNextLine()){
				String line=reader.nextLine();
				String[] words=line.split(" ");
				for(int i=0;i<words.length;i++){
					if(map.containsKey(words[i])){
						int count=map.get(words[i]);
						map.replace(words[i],count+1);
					}
					else{
						map.put(words[i],1);
					}
				}
				charCount+=line.length();
				wordCount+=words.length;
				spaceCount+=words.length-1;
			}
			System.out.println("number of words :"+wordCount);
			System.out.println("number of Characters :"+charCount);
			System.out.println("number of unique words :"+map.size());
			System.out.println("number of times each word occured :");
			for(Map.Entry m : map.entrySet()){    
    			System.out.println(m.getKey()+" : "+m.getValue());    
   			}
			System.out.println("number of spaces :"+spaceCount);
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Error occured while opening the file");
		}
	}
}

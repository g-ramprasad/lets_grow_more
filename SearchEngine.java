import java.util.*;
import java.io.*;

public class SearchEngine{
	public static void main(String[] args){
		Hashtable<String, ArrayList<String> > ht = new Hashtable<String, ArrayList<String> >();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the filename that you want to Search values for.");
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(kb.nextLine()));
			System.out.println("The file was read. Processing information, please wait...");

			while(br.ready()){
				String line = br.readLine();
				String[] result = line.split("\\s");

				for(int i = 0; i < result.length; i++){
					if(!ht.containsKey(result[i])){
						ArrayList<String> temp = new ArrayList<String>(1);
						temp.add(line);
						ht.put(result[i], temp);//assigns a key to anonymous ArrayList that stores the value
					}
					else{
						ArrayList<String> temp = (ArrayList<String>)ht.get(result[i]);
						temp.add(line);                                           
					}
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(1);
		}
		System.out.println(ht);
		do{
			System.out.println("Enter a key to search for the value it is associated with.\n");
			System.out.println(ht.get(kb.nextLine()));
			System.out.println("\nKeep searching? Enter any key to continue, or type <NO> to end the process");
		}while(!kb.nextLine().equalsIgnoreCase("<NO>"));
		try{
			br.close();
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(1);
		}
	}
}

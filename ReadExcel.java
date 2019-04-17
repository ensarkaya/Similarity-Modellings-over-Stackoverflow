package webscale;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class ReadExcel {
	public static void main(String[] args) throws IOException {

		ArrayList<String> lines = new ArrayList<String>();
		Hashtable<String, ArrayList<Integer>> table = new Hashtable<String, ArrayList<Integer>>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("1k.txt"), "UTF-16"));
		String line = reader.readLine();

		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		for (int i = 0; i < lines.size(); i++) {
			// System.out.println(lines.get(i));
			String CSV = lines.get(i);
			String[] tokens = CSV.split(",");
			StringTokenizer st1 = new StringTokenizer(tokens[1]);
			for (int j = 1; st1.hasMoreTokens(); j++){
				String key = st1.nextToken();
				key = key.toLowerCase();
				//key = "a=b.z/";
				for(int k = 0; k < key.length(); k++){
					if(!((key.charAt(k) >= 'a' && key.charAt(k) <= 'z') || (key.charAt(k) >= '0' && key.charAt(k) <= '9'))){
						key = key.substring(0, k) + key.substring(k+1);
						k--;
					}
				}
				//System.out.println(key);
				//break;
				// System.out.println("Token "+j+": "+st1.nextToken());
				if (!(table.containsKey(key))) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(Integer.parseInt(tokens[0]));
					table.put(key,list);
				}
				else{
					ArrayList<Integer> alist = table.get(key);
					alist.add(Integer.parseInt(tokens[0]));
				}
			}
		}
		System.out.println(table);
	}
}
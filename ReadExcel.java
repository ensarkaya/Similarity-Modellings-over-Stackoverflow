package webscale;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ReadExcel {
	public static void main(String[] args) throws IOException {

		ArrayList<String> lines = new ArrayList<String>();
		Hashtable<String, ArrayList<Integer>> table = new Hashtable<String, ArrayList<Integer>>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("250k.txt"), "UTF-16"));
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
				if (key.compareTo("c++") == 0 || key.compareTo("C++") == 0){
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
				else{
					key = key.toLowerCase();
					for(int k = 0; k < key.length(); k++){
						if(!((key.charAt(k) >= 'a' && key.charAt(k) <= 'z') || (key.charAt(k) >= '0' && key.charAt(k) <= '9' || key.charAt(k) == '#'))){
							key = key.substring(0, k) + key.substring(k+1);
							k--;
						}
					}
					if (!(table.containsKey(key))) {
						if (key.compareTo(" ") == 0 || key.compareTo("") == 0 || key.length() == 1){
							//DO NOTHING
						}else{
							ArrayList<Integer> list = new ArrayList<>();
							list.add(Integer.parseInt(tokens[0]));
							table.put(key,list);
						}
					}
					else{
						ArrayList<Integer> alist = table.get(key);
						alist.add(Integer.parseInt(tokens[0]));
					}
				}
			}
		}
		    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		    Iterator<String> itr = table.keySet().iterator();
		    while(itr.hasNext())
	        {
	            String key = itr.next();
	            ArrayList<Integer> mappedValue = table.get(key);
	            writer.write(key + " = " + mappedValue + "\n");
	        }
		    writer.close();
	}
}
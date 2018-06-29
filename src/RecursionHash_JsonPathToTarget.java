import java.io.*;
import java.util.*;

public class RecursionHash_JsonPathToTarget {
  public static void main(String[] args) {
    HashMap<String, Object> json = new HashMap<String, Object>();
    json.put("name", "Lucy");
    json.put("nickname", "Lucy");
    json.put("gender", "female");
    
    HashMap<String, Object> address1 = new HashMap<String, Object>();
    address1.put("street", "Baker St");
    address1.put("city", "London");
    address1.put("country", "GB");
    json.put("address1", address1);
    
    HashMap<String, Object> address2= new HashMap<String, Object>();
    address2.put("street", "Sherlock St");
    address2.put("city", "Sheffield");
    address2.put("country", "GB");
    json.put("address2", address2);

    HashMap<String, Object> contact= new HashMap<String, Object>();
    contact.put("homeNumber", 1234567890);
    contact.put("cellNumber", 987654321);
    json.put("contact", contact);
    
    System.out.println(json);

    System.out.println(printPaths(json, "Lucy"));
    System.out.println(printPaths(json, "GB"));
    System.out.println(printPaths(json, 1234567890));
  }
			  
  @SuppressWarnings("unchecked")
  public static ArrayList<ArrayList<String>> printPaths(HashMap<String, Object> data, Object searchWord) {
	  ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	  
	  for(Map.Entry<String, Object> entry: data.entrySet()) {
		  if(entry.getValue().equals(searchWord)) {
			  ArrayList<String> res = new ArrayList<String>();
			  res.add(entry.getKey());
			  results.add(res);
		  }
		  
		  if(entry.getValue() instanceof Map) {
			  ArrayList<String> inner = new ArrayList<String>();
			  inner.add(0, entry.getKey());
			  
			  ArrayList<ArrayList<String>> res = printPaths((HashMap<String, Object>) entry.getValue(), searchWord);

			  for(ArrayList<String> key: res) {
				  inner.addAll(key);
				  results.add(inner);
			  }
		  }
	  }
	  
	  return results;
  }
}

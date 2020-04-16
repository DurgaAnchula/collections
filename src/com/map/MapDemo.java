package com.map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class MapDemo {

	public static void main(String[] args) throws IOException {

		File f1=new File("E:\\cts\\rivisionhandson-master\\vehicle.txt");
		FileReader f=new FileReader(f1);
		BufferedReader br=new BufferedReader(f);
		List<String> list=new ArrayList<String>();
           String data=null;
		    while((data=br.readLine())!=null)
		    {
		    	list.add(data);
		    }
		    Map<String,Integer> map=new HashMap<String,Integer>();
		    Iterator<String> it=list.iterator();
		    while(it.hasNext())
		    {
		    	String vehicle=it.next();
		    	map.put(vehicle,Collections.frequency(list,vehicle));
		    }
		    Set<Map.Entry<String,Integer>> set=map.entrySet();
		    Iterator<Map.Entry<String,Integer>> it1= set.iterator();
		    while(it1.hasNext())
		    {
		    	Map.Entry<String,Integer> map1=it1.next();
		    	System.out.println(map1.getKey() + "->"+map1.getValue());
		    }
	}

}

package com.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapDemo1 {

		public static Map<Project, Employee> loadProjects() throws ParseException {

		
		     Employee e1 = new Employee(1, "durga",23000.00,"durga@gmail.com");
		     Employee e2 = new Employee(2, "suanina",21000.00,"sunny@gmail.com");
		     Employee e3 = new Employee(3, "Bhanu",22000.00,"bhanu@gmail.com");
		     Employee e4 = new Employee(4, "keerthi",20000.00,"keerthi@gmail.com");
		     Employee e5 = new Employee(5, "chandhana",20000.00,"chandhu@gmail.com");
		     Employee e6 = new Employee(6, "latha",20000.00,"latha@gmail.com");
		     Employee e7 = new Employee(7, "harsha",20000.00,"harsha@gmail.com");
		     Employee e8 = new Employee(8, "prasanna",20000.00,"prasanna@gmail.com");
		     Employee e9 = new Employee(9, "mounika",20000.00,"mouni@gmail.com");
		     Employee e10 = new Employee(10, "alekya",20000.00,"alekya@gmail.com");

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date startdate = sdf.parse("12-12-2019");
				Date enddate = sdf.parse("30-04-2020");

		     
				Project p1 = new Project(101, "Java", startdate, enddate);
				Project p2 = new Project(103, "Android", sdf.parse("12-10-2019"), sdf.parse("04-04-2020"));
				Project p3 = new Project(104, "SAP", sdf.parse("01-01-2020"), sdf.parse("04-04-2020"));
				Project p4 = new Project(106, "AWS", sdf.parse("12-10-2019"), sdf.parse("04-05-2020"));
				Project p5 = new Project(105, "Datawarehouse", sdf.parse("10-10-2019"), sdf.parse("28-02-2020"));
				Project p6 = new Project(108, "IOT", sdf.parse("02-01-2020"), sdf.parse("30-04-2020"));
				Project p7 = new Project(109, "React js", sdf.parse("12-10-2019"), sdf.parse("04-05-2020"));
				Project p8 = new Project(107, "Angular js", sdf.parse("12-12-2019"), sdf.parse("30-03-2020"));
				Project p9 = new Project(102, "AI", sdf.parse("12-02-2020"), sdf.parse("31-06-2020"));
				Project p10 = new Project(110, "Machine Learning", sdf.parse("12-10-2019"), sdf.parse("04-07-2020"));
   
			 Map<Project,Employee> empMap = new TreeMap<Project,Employee>();
		      
		      empMap.put(p1,e1);
		      empMap.put(p2,e2);
		      empMap.put(p3,e3);
		      empMap.put(p4,e4);
		      empMap.put(p5,e5);
		      empMap.put(p6,e6);
		      empMap.put(p7,e7);
		      empMap.put(p8,e8);
		      empMap.put(p9,e9);
		      empMap.put(p10,e10);
				return empMap;
		}
		
		public static void displayByProjectId(Map<Project, Employee> map) {
			 SortedMap<Project,Employee>  sortedMap = new TreeMap<Project, Employee>(map);
			
			 sortedMap.entrySet().stream().forEach(t->System.out.println(t));
			
			
				}

		public static void displayByProjectDomain(Map<Project, Employee> map) {
			Comparator<Project> projectDomainComaprator = new Comparator<Project>() {

				@Override
				public int compare(Project o1, Project o2) {
					// TODO Auto-generated method stub
					return o1.getDomain().compareTo(o2.getDomain());
				}
			};
			map.entrySet().stream().sorted(Map.Entry.comparingByKey(projectDomainComaprator)).forEach(t -> System.out.println(t));
			
			
		}

		
public static void main(String args[]) throws ParseException {
	Map<Project, Employee> map = loadProjects();
	displayByProjectId(map);
	System.out.println("***************");
	displayByProjectDomain(map);
}

	}



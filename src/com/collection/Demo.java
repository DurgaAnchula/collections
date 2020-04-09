package com.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Demo {
	public static List<Customer> allCustomers() throws IOException
	{
		File f1=new File("E:\\cts\\rivisionhandson-master\\customer.txt");
		FileReader f=new FileReader(f1);
		BufferedReader br=new BufferedReader(f);
			List<Customer> l1=new ArrayList();
           String list;
		    while((list=br.readLine())!=null)
		    {
		    	String str[]=list.split(",");
		    	Customer c=new Customer();
		    	c.setCustId(Integer.parseInt(str[0]));
		    	c.setCustName(str[1]);
		    	c.setEmail(str[2]);
		    	c.setMobile(str[3]);
		    	SimpleDateFormat s=new SimpleDateFormat("dd-mm-yyyy");
		    	String date=str[4];
		    	Date d=null;
		    	try
		    	{
		    		d=s.parse(date);
		    	}catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	c.setDob(d);
		    	Address a=new Address();
		    	a.setCity(str[5]);
		    	a.setState(str[6]);
		    	a.setCountry(str[7]);
				c.setAddress(a);
				l1.add(c);
			}
		    return l1;
		}
	
		public static int calculateage(Date dob) throws IOException {
			int age=2020-(dob.getYear()+1900);
			return age;
		}
	public static void DisplayAll() throws IOException 
	{
		List<Customer> list=allCustomers();
		for(Customer c1:list) {
			System.out.println(c1);
		}

	}
	public static void displaybyage(int age) throws IOException
	{
		List<Customer> list=allCustomers();
		List<Customer> l2=new ArrayList();
		for(Customer cust:list) {
			int age1=calculateage(cust.getDob());
			if(age1<age) {
				l2.add(cust);
			}
			
		}
		
		for(Customer c:l2) {
			System.out.println(c);
		}
	
	}
	public static void displaybycity(String city) throws IOException
	{
		List<Customer> list=allCustomers();
		
		for(Customer cus:list) {
			if(cus.getAddress().getCity().equalsIgnoreCase(city)) {
				System.out.println(cus);
		}
			
		}

	}
	
public static void main(String[] args) throws IOException
{
	Scanner sc = new Scanner(System.in);
	while(true)
	{
	System.out.println("Select \n 1.Display all customers \n 2.Display by Age \n 3. Display by city\n 4. Exit");
	
	int option= sc.nextInt();
	switch(option)
	{
	case 1:
	{
		
		DisplayAll();
		break;
	}
	case 2:
	{
		System.out.println("Enter age");
		int age = sc.nextInt();
		displaybyage(age);
		break;
	}
	case 3:
	{
		
		System.out.println("Enter city name");
		String name=sc.next();
		displaybycity(name);
		break;
		
	}
	case 4:
	{
		
		System.out.println("Exit");
		System.exit(0);
		
	}
	}
	
}
}
}
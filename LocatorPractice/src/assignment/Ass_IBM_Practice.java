package assignment;

import java.util.Scanner;

public class Ass_IBM_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.out.println("Enter String");
		    Scanner sc=new Scanner(System.in);
		    String str=sc.next();
		    System.out.println(fundtioncond(str));
	}
	public static boolean checkvowel(char c)
	{
	    //char c[]= {'a','e','i','o','u'};
		c=Character.toLowerCase(c);
	    if(c=='a' || c=='e'|| c=='i' || c=='o'||c=='u')
	    	return true;
		return false;
	}
	public static String fundtioncond(String str)
	{
		if(checkvowel(str.charAt(0)))
				{
			return str+"ay";
				}
		else
		{
			int pos=-1;
			for (int i=0;i<str.length();i++)
			{
				if(checkvowel(str.charAt(i)))
				{
					pos=i;
					break;
				}
			}
			if(pos==-1)
			{
				return str;
			}
			String start=str.substring(0,pos);
			String end=str.substring(pos);
			return end+start+"ay";
		}
			
	}

}

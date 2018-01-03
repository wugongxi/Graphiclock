package com.example.wu.graphiclock.util;


public class StringUtil
{

	public static boolean isNotEmpty(String s)
	{
		return s != null && !"".equals(s.trim());
	}


	public static boolean isEmpty(String s)
	{
		return s == null || "".equals(s.trim());
	}
	

	public static String format(String src,Object... objects)
	{
		int k = 0;
		for(Object obj : objects)
		{
			src = src.replace("{" + k + "}", obj.toString());
			k++;
		}
		return src;
	}
}

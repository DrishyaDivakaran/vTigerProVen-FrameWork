package com.vtiger.genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaLibrary {
	
	public int randomNumbers() {
		Random ran=new Random();
		int random=ran.nextInt(100);
		return random;		
	}
	
	public String generateDate() {
		Date dt=new Date();
		String genDate = dt.toString();
		String[] split = genDate.split(" ");
		String day=split[2];
		String mon=split[1];
		String year=split[5];
		String dateFormat = day+" "+mon+" "+year;
		return dateFormat;
	}

}

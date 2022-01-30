package com.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLibrary {
	
	public String readProperty(String userInputData) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.commonPath);
		Properties p=new Properties();
		p.load(fis);
		
		String userOutput=p.getProperty(userInputData);
		return userOutput;
	}

}

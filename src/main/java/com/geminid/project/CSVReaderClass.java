package com.geminid.project;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReaderClass {

	public static void main(String[] args) throws IOException 
	{
		 Reader reader = Files.newBufferedReader(Paths.get("Resource/Data.csv"));
		 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
				  .withFirstRecordAsHeader()
                 .withIgnoreHeaderCase()
                 .withTrim());
    
         for (CSVRecord csvRecord : csvParser) {
             // Accessing values by the names assigned to each column
             String name = csvRecord.get("driverPath");
             String email = csvRecord.get("baseUrl");
             String phone = csvRecord.get("email");
             String country = csvRecord.get("pass");

             System.out.println("Record No - " + csvRecord.getRecordNumber());
             System.out.println("---------------");
             System.out.println("Name : " + name);
             System.out.println("Email : " + email);
             System.out.println("Phone : " + phone);
             System.out.println("Country : " + country);
             System.out.println("---------------\n\n");
         }
     }
	

}

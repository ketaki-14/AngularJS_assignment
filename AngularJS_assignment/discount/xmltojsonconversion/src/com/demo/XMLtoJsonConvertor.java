package com.demo;
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.InputStream; 
import java.net.URL; 
import net.sf.json.JSON; 

import net.sf.json.xml.XMLSerializer; 
import org.apache.commons.io.IOUtils; 
import org.json.JSONException; 
import org.json.XML;  

public class XMLtoJsonConvertor 
{ 
    private URL url = null; 
    private InputStream inputStream = null;     
    public void getXMLfromJson() throws JSONException, IOException 
    { 
        try 
        { 
            url = XMLtoJsonConvertor.class.getClassLoader().getResource("new.xml"); 
         
            InputStream inputStream = url.openStream(); 
            String xml = IOUtils.toString(inputStream); 
            org.json.JSONObject objJson = XML.toJSONObject(xml); 

            try (FileWriter file = new FileWriter("C:/Users/A674562/Documents/My Received Files/apache-tomcat-7.0.79-windows-x86/apache-tomcat-7.0.79/webapps/ROOT/discount/lang/data.json")) 
            { 
                file.write(objJson.toString()); 
                System.out.println("Successfully Copied JSON Object to File..."); 
                System.out.println("JSON data : " + objJson); 
            
            } 
            catch(Exception e) 
            { 
                e.printStackTrace(); 
            } 
        } 
            finally 
            { 
                try 
                { 
                        if (inputStream != null) 
                        { 
                                inputStream.close(); 
                        } 
                        url = null; 
                } 
                catch (IOException ex) 
                { 
                        
                } 
            } 
        
    } 
    
    public static void main(String[] args) throws JSONException, IOException 
    { 
        new XMLtoJsonConvertor().getXMLfromJson(); 
    } 
    
} 


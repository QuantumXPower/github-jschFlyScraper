/**
 * 
 */
package com.packtpub.JavaScraping.SFScraping;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import java.net.*;
import java.io.*;
/**
 * @author: Ernest K. Antwi
 * Email: LordXEunit@gmail.com
 * Summary: ScheduleFlyScraper class is my attempt to be extract my former coworkers names, mobile, and email from an online sceduling system called
 *          Schedulefly.com.
 *
 */
public class ScheduleFlyScraper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			scrapeTopic();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void scrapeTopic() throws Exception
	{
		String html = getFile("/home/batmanreborn/Downloads/WebCrawl The Row/view-source app.schedulefly.com emp_list.aspx.html");
		Document doc = Jsoup.parse(html);
		for (Element table : doc.select("table[cellpadding = 3]")) 
		{
	        for (Element row : table.select("tr")) 
	        {
	            Elements tds = row.select("td");
	            if (tds.size() > 6) 
	            {
	                System.out.println(tds.get(0).text() + ":" + tds.get(1).text());
	            }
	        }
	    }
		
	}
	public static String getFile(String path) throws Exception{
			
		String content="", line = "";
		try{
			
			FileReader fromFile=new FileReader(path);
			BufferedReader br= new BufferedReader(fromFile);
			while(( line = br.readLine())!=null)
		    {
		           content=content + line;
		    } 
			br.close();
		    
		}
		catch(Exception error)
		{
		    System.out.println("The path was malformed!");
		    return "";
		}
		
		return content;
	}
	
}

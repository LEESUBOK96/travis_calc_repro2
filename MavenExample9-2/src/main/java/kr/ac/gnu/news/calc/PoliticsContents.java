package kr.ac.gnu.news.calc;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.List;

 

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.Connection;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import org.jsoup.*;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

public class PoliticsContents
{
	
    public static void main( String[] args )
    {
	      String[] newscontentsFilt = new String[100];
	      BufferedReader br = null;
	      try {
	         String[] newscontents = new String[100];   
	         int i = 0;
	         br = new BufferedReader(new FileReader("C:/Users/USER/text/politics change Url.txt"));
	         String line = "";
	         while((line = br.readLine()) != null){
	            newscontents[i]=line;
	            i++;
	         }
	         for (int j=0; j<=19; j++){
	            newscontentsFilt[j]=newscontents[j];
	         }

	         PrintWriter Contents = new PrintWriter("C:/Users/USER/text/politics Contents.txt");
	         PrintWriter ContentsChange = new PrintWriter("C:/Users/USER/text/politics change Contents.txt");
	         for(int k=0; k<=19; k++) {
	            String URL = newscontentsFilt[k];
	            Document doc =Jsoup.connect(URL).get();
	            Elements elements = doc.select("div#realArtcContents");
	            String ele = elements.text();
	            Contents.println(ele);
	            ContentsChange.println(ele);
	         }
	         Contents.close();
	         ContentsChange.close();
	         System.out.println("done");
	      }
	      catch(IOException e) {
	                  e.printStackTrace(); //travis ci    
	      }
    }
}

package kr.ac.gnu.news.calc;

import java.io.IOException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import java.util.List;

import java.util.ArrayList;

import java.io.PrintWriter;

public class PoliticsTitle 
{
	private static String URL = "https://news.nate.com/recent?mid=n0101";
    public static void main( String[] args )
    {
	      String[] newsTitle = new String[50];//정보를 가져와서 쓰는 저장소
	      List<String> newsTitleList = new ArrayList<String>(); //중복되는 기사를 제거하기 위한 저장소
	      String[] newsUrl = new String[50];
	      List<String> newsUrlList = new ArrayList<String>();

	      try {
	         Document doc =Jsoup.connect(URL).get();
	         Elements elements = doc.select(".mlt01");
	         int i = 0;
	         for(Element e : elements) {
	            String title = e.select("strong").text();
	            String url = e.getElementsByAttribute("href").attr("href");
	            newsTitle[i]=title;
	            newsUrl[i]="http:"+url;
	            i++;
	         }
	         //nate에서의 정보를 가져와 순서대로 newsTitle에 저장

	         for(int j=0; j<=19; j++) {
	            if(!newsTitleList.contains(newsTitle[j]))   {
	               newsTitleList.add(newsTitle[j]);
	               newsUrlList.add(newsUrl[j]);
	               
	            }
	         }
	         //받아온 기사 제목들을 리스트에 저장하고 이때까지 리스트에 저장한 것 중 같은 것이 없으면 newsTitle1에 저장

	         PrintWriter Title = new PrintWriter("C:/Users/USER/text/politics title.txt");
	         PrintWriter TitleChange = new PrintWriter("C:/Users/USER/text/politics change title.txt");
	         PrintWriter Url = new PrintWriter("C:/Users/USER/text/politics Url.txt");
	         PrintWriter UrlChange = new PrintWriter("C:/Users/USER/text/politics change Url.txt");
	         
	         for(int j=0; j<newsTitleList.size(); j++) {
	            Title.println(newsTitleList.get(j));
	            TitleChange.println(newsTitleList.get(j));
	            Url.println(newsUrlList.get(j));
	            UrlChange.println(newsUrlList.get(j));
	         }
	         Title.close();
	         TitleChange.close();
	         Url.close();
	         UrlChange.close();
	      }
	      catch(IOException e)
	      {
	         e.printStackTrace();
	      }
    }
}

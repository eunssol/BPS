package api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// ijK9HqsiMGmCgRLbSE1u
// oV8pYmqIdC
public class NaverApi {

	public static void main(String[] args) {
		 
		        String clientId = "ijK9HqsiMGmCgRLbSE1u"; //애플리케이션 클라이언트 아이디값"
		        String clientSecret = "oV8pYmqIdC"; //애플리케이션 클라이언트 시크릿값"


		        String text = null;
		        try {
		            text = URLEncoder.encode("조국", "UTF-8");
		        } catch (UnsupportedEncodingException e) {
		            throw new RuntimeException("검색어 인코딩 실패",e);
		        }


		        String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text ;    // json 결과
		        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
		        URL url =null;
		        URLConnection urlCon = null;
		        try {
		        	url=new URL(apiURL);
		        	urlCon = url.openConnection();
		        	urlCon.setRequestProperty("X-Naver-Client-Id", clientId);
		        	urlCon.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		        	
		        	InputStream is =urlCon.getInputStream();
		        	BufferedReader br = new BufferedReader(new InputStreamReader(is));
		        	StringBuffer sb = new StringBuffer();
		        	String line ="";
		        	while((line=br.readLine()) != null) {
		        		sb.append(line);
		        	}
		        	//System.out.println(sb.toString());
		        	
		        	//파싱
		        	//JSONObject: 객체 , JSONArray: 배열
		        	//파싱객체 생성
		        	JSONParser parser = new JSONParser();
		        	//json 응답 문자열 파싱
		        	JSONObject obj = (JSONObject)parser.parse(sb.toString());
		        	System.out.println(obj.get("total"));
		        	//배열객체로 생성
		        	JSONArray jarr = (JSONArray)obj.get("items");
		        	System.out.println("목록 갯수:"+jarr.size());
		        	//배열 반복
		        	for(int i=0; i<jarr.size();i++) {
		        		JSONObject data = (JSONObject)jarr.get(i);
		        		System.out.println(data.get("title")+"\t"+data.get("link")+"\t"+ data.get("price")+"\t"+ data.get("image"));
		        	}
		        }catch (Exception e) {
		        	System.out.println(e);
					
				}

		        
		

	}
}



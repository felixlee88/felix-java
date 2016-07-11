import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://news.naver.com/main/list.nhn?mode=LPOD&mid=sec&sid1=001&sid2=140&oid=001&isYeonhapFlash=Y&aid=0008532019"); //web browser 없어도 url을 통해서 페이지 접속하여 html 태그를 받음.
		InputStream is = url.openStream();  
		int readValue = -1; 
		//1byte씩 읽어서 (char)로 출력 :
		//네이버 페이지는 euc-kr로 응답 한글 1자는 2byte로 전송
		//2byte를 1byte씩 받아와서 한글깨짐, Why?? Java 는  Unicode 기반.
		/*while ((readValue = is.read()) != -1) {
			System.out.print((char)readValue);
		}*/
		
		//1char씩(UTF-8) 읽어서 (char)로 출력: 한글깨짐 발생.
		/*Reader r =  new InputStreamReader(is);
		while ((readValue = r.read()) != -1) {
			System.out.print((char)readValue);
		}*/
		
		//1char(EUC-KR)씩 읽어서 (char)로 출력 : 한글깨짐 발생하지 않음.
		Reader r =  new InputStreamReader(is, "EUC-KR");
		while ((readValue = r.read()) != -1) {
			System.out.print((char)readValue);
		}
	}
}

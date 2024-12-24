package test.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass01 {
	public static void main(String[] args) {
        try {
            // 요청 보낼 URL 설정
            URL url = new URL("https://acornacademy.co.kr"); // 예제 URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // HTTP 요청 메서드 설정
            connection.setRequestMethod("GET");

            // 헤더 설정 (필요에 따라 추가)
            connection.setRequestProperty("Accept", "application/json");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            //응답한 문자열을 누적시킬 객체 
            StringBuilder response = new StringBuilder();
            //만일 정상적인 응답이라면 
            if (responseCode == HttpURLConnection.HTTP_OK) {
            	//응답하는 내용을 읽어들일 객체 
            	BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));           
                //반복문 돌면서
            	while (true) {
                	//한줄씩 읽어들이고 
                	String line=br.readLine();
                	//만일 다 읽었다면 
                	if(line==null) {
                		break; //반복문 탈출
                	}
                	//읽은 문자열 한줄을 누적시킨다.
                    response.append(line+"\r\n");
                }
               
            } else {
                System.out.println("Request failed. Response Code: " + responseCode);
            }
            //누적된 문자열을 출력하기 
            System.out.println(response.toString());
            
            // 연결 해제
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("종료 합니다");
	}
}
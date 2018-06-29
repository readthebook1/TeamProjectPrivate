<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
  </head>
  <body>
  <%
    String clientId = "Gq6yEGwFqkB9pHnvlf6E";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "GPb0l9WxBS";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    System.out.println("aaa");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http://localhost:8080/TestProject/main.sms", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      int temp = 0;
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
        if(temp == 1){
        	access_token = inputLine;
        }
        temp++;
      }
      br.close();
      System.out.println("22");
      if(responseCode==200) {
        out.println(res.toString());
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    String str = access_token.replace("access_token","");
    access_token = str.replace(":","");
    str = access_token.replace("\"","");
    access_token = str.replace(",","");
    
    String token = access_token;// 네이버 로그인 접근 토큰;
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            String resStr = "[";
            while ((inputLine = br.readLine()) != null) {
                resStr += inputLine;
            }
            resStr += "]";
    
            String temp = resStr.replace("responseCode=200", "");
            br.close();
    
           /*  JSONArray json = JSONArray.fromObject(temp);
            JSONObject jObj = json.getJSONObject(0);
            String respon = "["+jObj.getString("response")+"]";
    		    JSONArray responjson = JSONArray.fromObject(respon);
            JSONObject responjsonObj = responjson.getJSONObject(0);
            String nickname 		= responjsonObj.getString("nickname");
            String enc_id 			= responjsonObj.getString("enc_id");
            String profile_image 	= responjsonObj.getString("profile_image");
            String age 				= responjsonObj.getString("age");
            String gender 			= responjsonObj.getString("gender");
            String id 				= responjsonObj.getString("id");
            String name 			= responjsonObj.getString("name");
            String email 			= responjsonObj.getString("email");
            String birthday 		= responjsonObj.getString("birthday"); */
          /*   String loginId 			= email.replace("@naver.com", "");
            System.out.println("===========");
            System.out.println("nickname 	:"+nickname 	);
            System.out.println("enc_id 		:"+enc_id 		);
            System.out.println("profile_image:"+profile_image);
            System.out.println("age 			:"+age 			);
            System.out.println("gender 		:"+gender 		);
            System.out.println("id 			:"+id 			);
            System.out.println("name 		:"+name 		);
            System.out.println("email 		:"+email 		);
            System.out.println("birthday 	:"+birthday 	);
            System.out.println("loginId 		:"+loginId 		);
            out.println(json); */
    
        } catch (Exception e) {
            System.out.println(e);
        }
  %>
  </body>
</html>
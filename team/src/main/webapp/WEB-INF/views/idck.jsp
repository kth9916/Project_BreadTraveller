<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.proj.team.*" %>

<% 
  //id는 사용자가 회원가입을 하기위해서 입력한 아이디
  String data = String.valueOf(request.getAttribute("data"));
  
  
  out.println(data);//처리 결과를 reg.js로 리턴
 %>

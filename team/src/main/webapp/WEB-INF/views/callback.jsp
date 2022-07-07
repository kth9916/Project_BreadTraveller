<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 네이버아디디로로그인 Callback페이지 처리 Script -->
<script type="text/javascript">
var naver_id_login = new naver_id_login("aa", "http://localhost:9392/team/callback");
// 접근 토큰 값 출력
alert(naver_id_login.oauthParams.access_token);
// 네이버 사용자 프로필 조회
naver_id_login.get_naver_userprofile("naverSignInCallback()");
// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
function naverSignInCallback() {
  alert(naver_id_login.getProfileData('email'));
  alert(naver_id_login.getProfileData('nickname'));
  alert(naver_id_login.getProfileData('gender'));
  alert(naver_id_login.getProfileData('birthday'));
  alert(naver_id_login.getProfileData('id'));
  alert(naver_id_login.getProfileData('mobile'));
  alert(naver_id_login.getProfileData('name'));
  /*u_num은 자동증가컬럼,
  u_id 이메일로
  u_pass는 입력할 필요가없고
  u_email에는 이메일 넣고
  phone는 넣게
  birth는 birthday넣고
  u_name은 name값
  question, answer은 새로설정만하게?
  
  */
}

</script>

</body>

</html>
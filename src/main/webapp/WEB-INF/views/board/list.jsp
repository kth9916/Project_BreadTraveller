<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href ="<c:url value="/resources/css/board/list.css"></c:url>" rel ='stylesheet'/>
<title>자유게시판</title>
</head>
<body>
	<%@ include file="../nav.jsp" %>
<noticeboard>
  <titletag>
    <h2 style="text-align: center;
      background-color: #D3D3D3;
      line-height: 60px;
      border-radius: 20%;
      width: 190px;
      height: 70px;
      margin: 10px 8px;">Community</h2>
  </titletag>

  <homepagetag>
    자유게시판
    <writter_button>
      <button id = "writter-button">
        글쓰기
        </button>
    </writter_button>
  </homepagetag>
  <boardsname>
    <boardnumtag>
      No. &nbsp;ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ&nbsp;
    </boardnumtag>
    <boardnametag>
      Name &nbsp;ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ&nbsp;
    </boardnametag>
    <boardvaluetag>
      Value &nbsp;ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ&nbsp;
    </boardvaluetag>
  </boardsname>


  <hr>
  <boardline>
  <numline>
    <div class="contents">
            <ul class="tabmenu">
                    <div class="notice">
                        <ul>
                            <li><a href="#">1
                            
                        </ul>
                    </div>
                </li>
                
            </ul> 
        
        </div>  
    </div>   
    <div id="layer"> 
        <div class="layer_up">
            <div class="uptitle">황금시대를 영원히</div>
        <div class="upbody">
        가나다라마바사아자차카타파하1234567890abcbefghijklnmop
        
		<br>
    <br>
    <br>  
		<button class="button b">수정</button>
		<button class="button b">삭제</button>
		<button class="button">댓글 보기/닫기</button>
		<button class="button c">댓글 쓰기</button>

        </div>
        <div class="btn">닫기</div>
        </div>
    </div> 

    
    <div id="parent1"></div>
  </numline>
</boardline>



</noticeboard>
<script src ="<c:url value="/resources/js/board/jquery-1.12.3.js"></c:url>"></script>
<script src ="<c:url value="/resources/js/board/script.js"></c:url>"></script>
</body>
</html>
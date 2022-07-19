<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
</head>
<script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx51365b973fc14a1990eeb179b36326df"></script>
<body onload="initTmap();">
<script type="text/javascript">

    function initTmap(){
        // map 생성
        // Tmapv2.Map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
        var map = new Tmapv2.Map("map_div", { // 지도가 생성될 div
            width : "100%", // 지도의 넓이
            height : "400px" // 지도의 높이
        });
    };



    function resOpenPopup(param){ //출발지 팝업
            var pop = window.open("/team/tour/popup/"+param, "resPopup", "width=1100,height=900, scrollbars=yes, resizable=yes");
            pop.focus();
    }

    function setList(a,b,c,d){
        console.log(a);
        console.log(b);
        console.log(c);
        console.log(d);
    }





</script>


    <h2>투어 등록</h2>
    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="no" value="${TourDto.no}">

        <input name="title" type="text" value="<c:out value="${TourDto.title}"/> " placeholder="  제목을 입력해 주세요."><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요."></textarea><br>
        <div class="text-center">
            <a href="javascript:void(0);" onclick="resOpenPopup('s');return false;" >출발지</a>
        </div>
        <div>
            <span>출발지</span>
            <span></span>
            <input type = "text" id="start_name" value="">
            <input type = "hidden" id="start_id" value="">
            <input type = "hidden" id="start_ny" value="">
            <input type = "hidden" id="start_nx" value="">
        </div>
        <div>
            <a href="javascript:void(0);" onclick="resOpenPopup('w');return false;" class="btn btn-dark btn-lg">중간지점</a>
        </div>
        <div class="text-center">
            <a href="javascript:void(0);" onclick="resOpenPopup('e');return false;" class="btn btn-dark btn-lg">도착지</a>
        </div>
            <input type = "text" id="end_name" value="">
            <input type = "hidden" id="end_id" value="">
            <input type = "hidden" id="end_ny" value="">
            <input type = "hidden" id="end_nx" value="">

    </form>

    <div id="map_div">

    </div>


</body>
</html>

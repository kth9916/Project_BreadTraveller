<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>simpleMap</title>
    <script	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx51365b973fc14a1990eeb179b36326df"></script>
    <script type="text/javascript">
        var options = {
            enableHighAccuracy: true,
            timeout: 5000,
            maximumAge: 0
        };
        var lat=0;
        var lon=0;
        function success(pos) {
            var crd = pos.coords;
            <!--내위치 출력 가능-->
            console.log('Your current position is:');
            console.log(`Latitude : ${'${crd.latitude}'}`);
            console.log(`Longitude: ${'${crd.longitude}'}`);
            console.log(`More or less ${'${crd.accuracy}'} meters.`);
            lat = pos.coords.latitude;
            lon = pos.coords.longitude;
        }
        function error(err) {
            console.warn(`ERROR(${'${err.code}'}): ${'${err.message}'}`);
        }
        navigator.geolocation.getCurrentPosition(success, error, options);
        var map;
        var marker_s, marekr_e, waypoint;
        var resultMarkerArr = [];
        //경로그림정보
        var drawInfoArr = [];
        var resultInfoArr = [];


        function initTmap(){
            resultMarkerArr = [];
            // 1. 지도 띄우기
            map = new Tmapv2.Map("map_div", {
                center: new Tmapv2.LatLng(35.1748309, 126.91227115), //루트들의 중앙 위치>> 알고리즘 구현하기
                width : "100%",
                height : "400px",
                zoom : 14,
                zoomControl : true,
                scrollwheel : true
            });
            // 2. 시작, 도착 심볼찍기
            // 시작
            marker_s = new Tmapv2.Marker({
                position : new Tmapv2.LatLng(${start.lat}, ${start.lon}),
                icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_s.png",
                iconSize : new Tmapv2.Size(24, 38),
                map:map
            });
            resultMarkerArr.push(marker_s);
            // 도착
            marker_e = new Tmapv2.Marker({
                position : new Tmapv2.LatLng(${end.lat}, ${end.lon}),
                icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_e.png",
                iconSize : new Tmapv2.Size(24, 38),
                map:map
            });
            resultMarkerArr.push(marker_e);
            // 3. 경유지 심볼 찍기
            <c:forEach items="${lonArr}" var="lon" varStatus="status">
            marker = new Tmapv2.Marker({
                position : new Tmapv2.LatLng(${latArr[status.index]}, ${lon}),
                icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_1.png",
                iconSize : new Tmapv2.Size(24, 38),
                map:map
            });
            resultMarkerArr.push(marker);
            </c:forEach>

            // 4. 경로탐색 API 사용요청
            var routeLayer;
            $("#btn_select").click(function(){
                var searchOption = $("#selectLevel").val();
                var headers = {};
                headers["appKey"]="l7xx51365b973fc14a1990eeb179b36326df";
                headers["Content-Type"]="application/json";
                var param = JSON.stringify({
                    "startName" : "출발지",
                    "startX" : "${start.lon}",
                    "startY" :  "${start.lat}",
                    "startTime" : "201708081103",
                    "endName" : "도착지",
                    "endX" : "${end.lon}",
                    "endY" : "${end.lat}",
                    "viaPoints" :
                        [
                            <c:forEach items="${lonArr}" var="lon" varStatus="status">
                            {
                                "viaPointId" : "test01",
                                "viaPointName" : "name01",
                                "viaX" : "${lon}" ,
                                "viaY" : "${latArr[status.index]}"
                            },
                            </c:forEach>
                        ],
                    "reqCoordType" : "WGS84GEO",
                    "resCoordType" : "EPSG3857",
                    "searchOption": searchOption
                });
                $.ajax({
                    method:"POST",
                    url:"https://apis.openapi.sk.com/tmap/routes/routeSequential30?version=1&format=json",//
                    headers : headers,
                    async:false,
                    data:param,
                    success:function(response){
                        var resultData = response.properties;
                        var resultFeatures = response.features;
                        // 결과 출력
                        var tDistance = "총 거리 : " + (resultData.totalDistance/1000).toFixed(1) + "km,  ";
                        var tTime = "총 시간 : " + (resultData.totalTime/60).toFixed(0) + "분,  ";
                        var tFare = "총 요금 : " + resultData.totalFare + "원";
                        $("#result").text(tDistance+tTime+tFare);
                        //기존  라인 초기화
                        if(resultInfoArr.length>0){
                            for(var i in resultInfoArr){
                                resultInfoArr[i].setMap(null);
                            }
                            resultInfoArr=[];
                        }
                        for(var i in resultFeatures) {
                            var geometry = resultFeatures[i].geometry;
                            var properties = resultFeatures[i].properties;
                            var polyline_;
                            drawInfoArr = [];
                            if(geometry.type == "LineString") {
                                for(var j in geometry.coordinates){
                                    // 경로들의 결과값(구간)들을 포인트 객체로 변환
                                    var latlng = new Tmapv2.Point(geometry.coordinates[j][0], geometry.coordinates[j][1]);
                                    // 포인트 객체를 받아 좌표값으로 변환
                                    var convertPoint = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(latlng);
                                    // 포인트객체의 정보로 좌표값 변환 객체로 저장
                                    var convertChange = new Tmapv2.LatLng(convertPoint._lat, convertPoint._lng);
                                    drawInfoArr.push(convertChange);
                                }
                                polyline_ = new Tmapv2.Polyline({
                                    path : drawInfoArr,
                                    strokeColor : "#FF0000",
                                    strokeWeight: 6,
                                    map : map
                                });
                                resultInfoArr.push(polyline_);
                            }else{
                                var markerImg = "";
                                var size = "";			//아이콘 크기 설정합니다.
                                if(properties.pointType == "S"){	//출발지 마커
                                    markerImg = "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_s.png";
                                    size = new Tmapv2.Size(24, 38);
                                }else if(properties.pointType == "E"){	//도착지 마커
                                    markerImg = "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_e.png";
                                    size = new Tmapv2.Size(24, 38);
                                }else{	//각 포인트 마커
                                    markerImg = "http://topopen.tmap.co.kr/imgs/point.png";
                                    size = new Tmapv2.Size(8, 8);
                                }
                                // 경로들의 결과값들을 포인트 객체로 변환
                                var latlon = new Tmapv2.Point(geometry.coordinates[0], geometry.coordinates[1]);
                                // 포인트 객체를 받아 좌표값으로 다시 변환
                                var convertPoint = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(latlon);
                                marker_p = new Tmapv2.Marker({
                                    position: new Tmapv2.LatLng(convertPoint._lat, convertPoint._lng),
                                    icon : markerImg,
                                    iconSize : size,
                                    map:map
                                });
                                resultMarkerArr.push(marker_p);
                            }
                        }
                    },
                    error:function(request,status,error){
                        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                    }
                });
            });
        }
        function addComma(num) {
            var regexp = /\B(?=(\d{3})+(?!\d))/g;
            return num.toString().replace(regexp, ',');
        }
    </script>
</head>
<body onload="initTmap()">
<p id="result"></p>
<select id="selectLevel">
    <option value="0" selected="selected">교통최적+추천</option>
    <option value="1" >교통최적+무료우선</option>
    <option value="2" >교통최적+최소시간</option>
    <option value="3" >교통최적+초보</option>
</select>
<button id="btn_select">적용하기</button>
<p>start lat : ${start.lat}</p>
<p>start lon : ${start.lon}</p>
<p>end lat : ${end.lat}</p>
<p>start lon : ${end.lon}</p>
<p>way : ${way}</p>



<table>
    <tr>
        <th class="no">번호</th>
        <th class="storeName">가게이름</th>
        <th class="address">주소</th>
        <th class="regdate">주요메뉴</th>
        <!--주요 메뉴의 경우 c태그 이용해서 해당 번호에 맞는 메뉴로 값나오게 처리할예정-->
        <th class="regdate">가게 좋아요 수</th>
    </tr>
    <c:forEach items="${wayStore}" var="waytour">
        <tr>
            <td>${waytour.id}</td>
            <td>${waytour.storeName}</td>
            <td>${waytour.address}</td>
            <td>${waytour.mainMenu}</td>
            <td>${waytour.good}</td>
        </tr>
    </c:forEach>
</table>
<div id="map_wrap" class="map_wrap">
    <div id="map_div"></div>
</div>

</body>
<script>
</script>
</html>

//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches
var code = "";
var inputCode ="";   
var u_address ="";
let regck = true;
let idck = false;

$("#button1").click(function(){
  checkIt1();
  if(regck){
	
	  if(animating) return false;
	  animating = true;
	  
	  current_fs = $(this).parent();
	  next_fs = $(this).parent().next();
	  
	  //activate next step on progressbar using the index of next_fs
	  $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	  
	  //show the next fieldset
	  next_fs.show(); 
	  //hide the current fieldset with style
	  current_fs.animate({opacity: 0}, {
	    step: function(now, mx) {
	      //as the opacity of current_fs reduces to 0 - stored in "now"
	      //1. scale current_fs down to 80%
	      scale = 1 - (1 - now) * 0.2;
	      //2. bring next_fs from the right(50%)
	      left = (now * 50)+"%";
	      //3. increase opacity of next_fs to 1 as it moves in
	      opacity = 1 - now;
	      current_fs.css({
	        'transform': 'scale('+scale+')',
	        'position': 'absolute'
	      });
	      next_fs.css({'left': left, 'opacity': opacity});
	    }, 
	    duration: 800, 
	    complete: function(){
	      current_fs.hide();
	      animating = false;
	    }, 
	    //this comes from the custom easing plugin
	    easing: 'easeInOutBack'
	  });
  }
});

$("#button2").click(function(){
  checkIt2();
  if(regck){
	  if(animating) return false;
	  animating = true;
	  
	  current_fs = $(this).parent();
	  next_fs = $(this).parent().next();
	  
	  //activate next step on progressbar using the index of next_fs
	  $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	  
	  //show the next fieldset
	  next_fs.show(); 
	  //hide the current fieldset with style
	  current_fs.animate({opacity: 0}, {
	    step: function(now, mx) {
	      //as the opacity of current_fs reduces to 0 - stored in "now"
	      //1. scale current_fs down to 80%
	      scale = 1 - (1 - now) * 0.2;
	      //2. bring next_fs from the right(50%)
	      left = (now * 50)+"%";
	      //3. increase opacity of next_fs to 1 as it moves in
	      opacity = 1 - now;
	      current_fs.css({
	        'transform': 'scale('+scale+')',
	        'position': 'absolute'
	      });
	      next_fs.css({'left': left, 'opacity': opacity});
	    }, 
	    duration: 800, 
	    complete: function(){
	      current_fs.hide();
	      animating = false;
	    }, 
	    //this comes from the custom easing plugin
	    easing: 'easeInOutBack'
	  });
  }
});

$(".previous").click(function(){
	
  if(animating) return false;
  animating = true;
  
  current_fs = $(this).parent();
  previous_fs = $(this).parent().prev();
  
  //de-activate current step on progressbar
  $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
  
  //show the previous fieldset
  previous_fs.show(); 
  //hide the current fieldset with style
  current_fs.animate({opacity: 0}, {
    step: function(now, mx) {
      //as the opacity of current_fs reduces to 0 - stored in "now"
      //1. scale previous_fs from 80% to 100%
      scale = 0.8 + (1 - now) * 0.2;
      //2. take current_fs to the right(50%) - from 0%
      left = ((1-now) * 50)+"%";
      //3. increase opacity of previous_fs to 1 as it moves in
      opacity = 1 - now;
      current_fs.css({'left': left});
      previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
    }, 
    duration: 800, 
    complete: function(){
      current_fs.hide();
      animating = false;
    }, 
    //this comes from the custom easing plugin
    easing: 'easeInOutBack'
  });
});


$(".submit").click(function(){
	
	if(regck){
		
		alert("회원가입에 성공했습니다.");
	
		u_address =	$("#address").val()+" "+$("#detailAddress").val() +" "+$("#extraAddress").val();
	    
		$('input[name=u_address]').attr('value',u_address);
		
		
		$('#msform').submit();
	}
	
})


/*인증번호 이메일 전송*/
$(".email3").click(function(){
	
	var email = $(".mail_input").val(); //입력한 이메일
	var ckBox = $(".mail_check_input"); //인증번호 입력란
	var boxWrap = $(".mail_check_input_box"); //인증번호 입련란 박스
	
	$.ajax({
		
		type:"GET",
		url:"mailCheck?email=" + email,
		success:function(data){
			
			//console.log("data : "+ data);
			ckBox.attr("disabled",false);
			boxWrap.attr("id", "mail_check_input_box_true");
			code = data;
		}
	});
});
 
 //인증번호 비교
$(".mail_check_input").blur(function(){
	inputCode = $(".mail_check_input").val();        // 입력코드    
    var checkResult = $("#mail_check_input_box_warn");    // 비교 결과  
	
	if(inputCode == code){                            // 일치할 경우
        checkResult.html("인증번호가 일치합니다.");
        checkResult.attr("class", "correct");        
    } else {                                            // 일치하지 않을 경우
        checkResult.html("인증번호를 다시 확인해주세요.");
        checkResult.attr("class", "incorrect");
    }    
});

function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postcode").value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
    
//[ID중복확인]버튼을 클릭하면 자동실행
	//입력한 아이디 값을 갖고 confirmId.jsp페이지 실행
	$(".idck").click(function(){
	  if($("#u_id").val()){
		//아이디를 입력하고 [ID중복확인]버튼을 클릭한 경우
		let u_id = {u_id:$("#u_id").val()};
		
	    $.ajax({
	    	type:"POST",//요청방식
	    	url:"ckid",//요청페이지
	    	data: u_id,
	    	dataType:"json",
	    	success:function(data){//요청페이지 처리에 성공시
	    		if(data == 1){//사용할 수 없는 아이디
	    			alert("사용할 수 없는 아이디");
	    	    	$("#u_id").val("");
	    	    	$("#u_id").focus();
	    	    	return false;
	    	     }else if(data == 0)//사용할 수 있는 아이디
	    	  	    idck = true;	    	  	    
	    	  	    //alert(idck);
	    	  	    alert("사용할 수 있는 아이디");
	    	  	    
	 	    }
	    });
	  }else{//아이디를 입력하지 않고 [ID중복확인]버튼을 클릭한 경우
		  alert("사용할 아이디를 입력");
		  $("#u_id").focus();
	  }
	});

function checkIt1() {
	regck = true;
	 if(!$("#u_name").val()) {//이름을 입력하지 않으면 수행
        alert("사용자 이름을 입력하세요");
        $("#u_name").focus();
        regck = false;
        return false;
    }
    
    if(!$("#u_id").val()) {//아이디를 입력하지 않으면 수행
        alert("아이디를 입력하세요");
        $("#u_id").focus();
        regck = false;
        return false;//사용자가 서비스를 요청한 시점으로 돌아감
    }
    
    if(!$("#u_pass").val()) {//비밀번호를 입력하지 않으면 수행
        alert("비밀번호를 입력하세요");
        $("#u_pass").focus();
        regck = false;
        return false;
    }
    var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*?[#?!@$%^&*-]).{6,16}$/;
    
    if(!pwdCheck.test(u_pass.value)) {//비밀번호가 문자/숫자 6~16자가 아닐경우 수행
        alert("6~16자 특수문자+숫자+문자 입력");
        u_pass.focus();
        regck = false;
        return false;
    }
    //비밀번호와 재입력비밀번호가 같지않으면 수행
    if($("#u_pass").val() != $("#cpass").val()){
        alert("비밀번호를 동일하게 입력하세요");
        $("#cpass").focus();
        regck = false;
        return false;
    }
    
    if(idck == false){
		alert("아이디 중복체크를 해주세요");
        regck = false;
        idck = false;
        return false;
	}
    
}	

function checkIt2() {
	
	regck = true;
    if(!$("#u_nick").val()) {
        alert("닉네임을 입력해 주세요.")
        $("#u_nick").focus();
        regck = false;
        return false;
    }
    
    if(!$("#u_birth").val()) {//전화번호를 입력하지 않으면 수행
        alert("생일을 입력해 주세요.");
        $("#u_birth").focus();
        regck = false;
        return false;
    }  
    
    if(!$("#u_phone").val()) {//전화번호를 입력하지 않으면 수행
        alert("전화번호를 입력하세요");
        $("#u_phone").focus();
        regck = false;
        return false;
    }  
    if(!$("#u_email").val()) {//이메일를 입력하지 않으면 수행
        alert("이메일을 입력하세요");
        $("#u_email").focus();
        regck = false;
        return false;
    }  
    
    if(!$("#mailck").val()) {//인증번호 입력하지 않거나 
        alert("인증번호를 입력하세요.");
        $("#mailck").focus();
        regck = false;
        return false;
    }  
    
    if(inputCode != code) {//인증번호 값이 다르면
        alert("인증번호를 다시 입력해주세요.");
        $("#mailck").focus();
        regck = false;
        return false;
    }
    if(!$("#question").val()) {//인증번호 값이 다르면
        alert("질문을 입력해주세요.");
        $("#question").focus();
        regck = false;
        return false;
    }
    if(!$("#answer").val()) {//인증번호 값이 다르면
        alert("답변을 입력해주세요.");
        $("#answer").focus();
        regck = false;
        return false;
    }
}	
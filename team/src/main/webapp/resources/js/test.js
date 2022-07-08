
//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches
var code = "";
var inputCode ="";   
var u_address ="";
let regck = true;
let idck = false;

$(".submit").click(function(){
	
	if(regck){
		
		alert("회원가입에 성공했습니다.");
	
		u_address =	$("#address").val()+" "+$("#detailAddress").val() +" "+$("#extraAddress").val();
	    
		$('input[name=u_address]').attr('value',u_address);
		
		
		$('#msform').submit();
	}
	
})



function checkIt() {
	
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
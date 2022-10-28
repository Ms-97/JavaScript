<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보통 입력화면은 GET방식으로</title>
<link rel="shortcut icon" href="http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040004/10/01/0400041001_19697_02425.gif" type="image/x-icon">
<!-- CDN으로 제공되는 건 CDN으로 편하게 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<form action="" id="myForm" >
		이름<input type="text" name="namName" value="곽금규"><br>
		등급<input type="text" name="namGrade" value="경력자"><br>
		전화<input type="text" name="namTel" value="010-2424-8282"><br>
		등록<input type="submit"  value ="뜽록" id="btn">
		수정<input type="button"  value ="수정" id="btnUp">
		<!-- submit에는 onclick을 사용하지 않음! -->
    </form>
<script>
	var header = '${_csrf.headerName}';
    var token =  '${_csrf.token}';

    $("#btnUp").on("click",()=>{
		$.ajax({
			type:"put",  // RESTFUL에서 일반적으로 PUT은 UPDATE 수정에 사용
			url:"/sample/hyerim/update",
			data:$("#myForm").serialize(),    // 넘길 데이타
			dataType:"text", // 보통 받아온 데이터에 JSON.parse를 할지 안할지 여부
			beforeSend:(xhr)=>{ // 시큐리티 사용시 토근을 헤더에 담는데 사용
				xhr.setRequestHeader(header, token);
			},
			success:(rslt)=>{
				console.log("너머온값",rslt); // 요게 있어야 항상 디버깅이 편함
			},
			error:(request,status,error)=>{
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
    });

    
    
    $("#myForm").on("submit",()=>{
		event.preventDefault();  // form 전송 안되겡

		/*  인코딩메소드           디코딩메소드
		   escape                 unescape          어쭈 옛날꺼
		   encodeURI              decodeURI         몇년전 옛날꺼
		   encodeURIComponent     decodeURIComponent 최근꺼
		*/
		alert(decodeURIComponent($("#myForm").serialize())); // 항상 궁금하면 찍어 봄
		$.ajax({
			type:"post",
			url:"/sample/hyerim/insert",
			data:$("#myForm").serialize(),    // 넘길 데이타
			dataType:"text", // 보통 받아온 데이터에 JSON.parse를 할지 안할지 여부
			beforeSend:(xhr)=>{ // 시큐리티 사용시 토근을 헤더에 담는데 사용
				xhr.setRequestHeader(header, token);
			},
			success:(rslt)=>{
				console.log("너머온값",rslt); // 요게 있어야 항상 디버깅이 편함
			},
			error:(request,status,error)=>{
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
    })
    
    
     /* ajax는 이미 추상화를 해버린 jquery ajax를 쓰면 일관성이 있어서 편함    
	const cForm = document.querySelector("#myForm");
	cForm.addEventListener("submit",()=>{
		event.preventDefault();  
		var v_ajax = new XMLHttpRequest(); 
        v_ajax.open("post","/sample/hyerim/insert",true);
		//일반 post방식일 때 아래 줄이 필요
		v_ajax.setRequestHeader("content-type","application/x-www-form-urlencoded")
    	v_ajax.setRequestHeader(header, token);
		
		v_ajax.onreadystatechange = ()=>{
        	if(v_ajax.readyState == 4 && v_ajax.status == 200){  
               console.log(v_ajax.responseText)               
        	}
    	}
    	v_ajax.send();
	});
	*/

</script>
</body>
</html>
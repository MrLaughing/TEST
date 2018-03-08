<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var message={title:"",content:null,sender:"金证"};
	try{
		if(message){
			if(!message.title){
				alert(message.title);
			}
			if(!message.content){
				alert(message.content);
			}
			if(message.sender){
				alert(message.sender);
			}
		}else{
			alert(message);
		}
	}catch (e) {
		alert(E);
	}
</script>
</head>
<body>

</body>
</html>
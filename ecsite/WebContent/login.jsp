<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="Content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <meta http-equiv="imagetoolbar" content="no"/>
  <meta name="description" content=""/>
  <meta name="keywords" content=""/>
  <title>Login画面</title>

  <style type="text/css">
  /* ========TAG LAYOUT======== */

    body{
      margin:0;
      padding:0;
      line-height:1.6;
      letter-spacing:1px;
      font-family:Verbana,Helvetica,sans-serif;
      font-size:12px;
      color:#333;
      background:#fff;
    }

    table{
      text-align:center;
      margin:0 auto;
    }

  /* ========ID LAYOUT======== */

    #top{
      width:780px;
      margin:30px auto;
      border:1px solid #333;
    }

    #header{
      width:100%;
      height:80px;
      background-color:black;
    }

    #main{
      width:100%;
      height:500px;
      text-align:center;
    }

    #footer{
      width:100%;
      height:80px;
      background-color:black;
      clear:both;
    }

    #text-link{
      display:inline-block;
      text-align:right;
    }

    .field{
      margin:10px;
    }

    .uerror,.perror{
      color:red;
    }

  </style>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <script type="text/javascript">

  $(function(){


	  //"未入力"の表示と隠蔽

	  if($("#user").val()!=""){
		  $(".uerror").hide();
	  }
	  if($("#pass").val()!=""){
		  $(".perror").hide();
	  }

	  $("#user").on("input",function(){
		  if($(this).val()!=""){
			  $(".uerror").hide();
		  }else{
			  $(".uerror").show();
		  }
	  })

	  $("#pass").on("input",function(){
		  if($(this).val()!=""){
			  $(".perror").hide();
		  }else{
			  $(".perror").show();
		  }
	  })


	  //submitボタンの有効・無効

	  if($("#user").val()!="" && $("#pass").val()!=""){
		  $(".submit").prop("disabled",false);
	  }else{
		  $(".submit").prop("disabled",true);
	  }


	  $("#user").on("input",function(){
			  if($("#user").val()!="" && $("#pass").val()!=""){
				  $(".submit").prop("disabled",false);
			  }else{
				  $(".submit").prop("disabled",true);
			  }
	  })

	  $("#pass").on("input",function(){
			  if($("#user").val()!="" && $("#pass").val()!=""){
				  $(".submit").prop("disabled",false);
			  }else{
				  $(".submit").prop("disabled",true);
			  }
	  })


	  //入力フォームの色

	  $("#user").focusin(function(e){
		  $(this).css("background-color","#ffc");
	  })
	  $("#user").focusout(function(e){
		  if($(this).val()!=""){
			  $(this).css("background-color","");
		  }else{
			  $(this).css("background-color","mistyrose");
		  }
	  })

	  $("#pass").focusin(function(e){
		  $(this).css("background-color","#ffc");
	  })
	  $("#pass").focusout(function(e){
		  if($(this).val()!=""){
			  $(this).css("background-color","");
		  }else{
			  $(this).css("background-color","mistyrose");
		  }
	  })


  })

  </script>

</head>

<body>

  <div id="header">
    <div id="pr">
    </div>
  </div>

  <div id="main">
    <div id="top">
      <p>Login</p>
    </div>
    <div>
      <h3>商品を購入する際にはログインをお願いします。</h3>
      <s:form action="LoginAction">



        <div class="field">

        <input type="text" name="loginUserId" id="user" placeholder="ログインID"/>
        <label class="uerror">未入力</label>

        </div>

        <div class="field">

        <input type="password" name="loginPassword" id="pass" placeholder="パスワード"/>
        <label class="perror">未入力</label>

        </div>

        <s:submit value="ログイン" class="submit"/>


      </s:form>
      <br/>
      <div id="text-link">
       <p>新規ユーザー登録は
         <a href='<s:url action="UserCreateAction"/>'>こちら</a></p>
       <p>Homeへ戻る場合は
         <a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
      </div>
    </div>

  </div>

  <div id="footer">
    <div id="pr">
    </div>
  </div>

</body>
</html>
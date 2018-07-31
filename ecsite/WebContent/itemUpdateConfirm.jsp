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

  <title>ItemUpdateConfirm画面</title>

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

  </style>

</head>
<body>

  <div id="header">
    <div id="pr">
    </div>
  </div>

  <div id="main">
    <div id="top">
      <p>確認画面</p>
    </div>
    <div>
      <h3>変更前</h3>
        <table>
          <tr id="box">
            <td>
              <label>商品名:</label>
            </td>
            <td>
              <s:property value="session.item_name" escape="false"/>
            </td>
          </tr>
          <tr id="box">
            <td>
              <label>値段:</label>
            </td>
            <td>
              <s:property value="session.item_price" escape="false"/>
            </td>
          </tr>
          <tr id="box">
            <td>
              <label>在庫:</label>
            </td>
            <td>
              <s:property value="session.item_stock" escape="false"/>
            </td>
          </tr>
        </table>
      <h3>変更後</h3>
        <table>
        <s:form action="ItemUpdateCompleteAction">
          <tr id="box">
            <td>
              <label>商品名:</label>
            </td>
            <td>
              <s:property value="itemName" escape="false"/>
            </td>
          </tr>
          <tr id="box">
            <td>
              <label>値段:</label>
            </td>
            <td>
              <s:property value="itemPrice" escape="false"/>
            </td>
          </tr>
          <tr id="box">
            <td>
              <label>在庫:</label>
            </td>
            <td>
              <s:property value="itemStock" escape="false"/>
            </td>
          </tr>
          <tr>
            <td>
            <input type="hidden" name="itemName" value='<s:property value="itemName"/>'>
            <input type="hidden" name="itemPrice" value='<s:property value="itemPrice"/>'>
            <input type="hidden" name="itemStock" value='<s:property value="itemStock"/>'>
            <s:submit value="完了"/>
            </td>
          </tr>
        </s:form>
        </table>
    </div>
    <p><a href='<s:url action="ItemUpdateFormAction"/>'>戻る</a></p>
  </div>


  <div id="footer">
    <div id="pr">
    </div>"
  </div>

</body>
</html>
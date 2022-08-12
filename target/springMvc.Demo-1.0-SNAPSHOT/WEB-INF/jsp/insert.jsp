<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script type="text/javascript" src="/resources/js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
  <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style type="text/css">
    th {
      background-color : darkcyan;
    }
    td {
      background-color : #ffeeba;
    }
  </style>
  <title>新增</title>
  <script type="text/javascript">
    $(document).ready(function () {
      //your code here
      CKEDITOR.replace( 'announcement', {
        width : 1000
      });
    });

    function processAddSave() {
      if ($("#title").val() == '') {
        alert("標題為必輸!!");
        return;
      } else if ($("#announcer").val() == '') {
        alert("公布者為必輸!!");
        return;
      }
      $("#AddForm").submit();
    }

    function processBack() {
      window.history.back();
    }
  </script>
</head>
<body>
  <div class="col-sm, badge-primary">新增公布訊息</div>
  <table table width="100%" border="1">
    <form id="AddForm" action="/productlist/addSave">
      <tr>
        <th><span style="color:red;">*</span>標題</th>
          <td colspan="3">
            <input type="text" id="title" name="title"/>
          </td>
      </tr>
      <tr>
        <th>發佈日期</th>
        <td>
          <input class="Wdate" type="text" id="releasedate" name="releasedate" onFocus="WdatePicker({dateFmt:'yyyMMdd'})"/>
        </td>
        <th>截止日期</th>
        <td>
          <input class="Wdate" type="text" id="deadlinedate" name="deadlinedate" onFocus="WdatePicker({dateFmt:'yyyMMdd'})"/>
        </td>
      </tr>
      <tr>
        <th><span style="color:red;">*</span>公布者</th>
        <td colspan="3">
          <input type="text" id="announcer" name="announcer"/>
        </td>
      </tr>
      <tr>
        <th>公布內容</th>
        <td colspan="3">
          <textarea id="announcement" name="announcement"></textarea>
        </td>
      </tr>
    </form>
  </table>
  <br>
  <div class="row justify-content-md-center">
    <input type="button" class="btn btn-outline-secondary" value="儲存" onclick="processAddSave()">
    <input type="button" class="btn btn-outline-secondary" value="返回" onclick="processBack()">
  </div>
</body>
</html>

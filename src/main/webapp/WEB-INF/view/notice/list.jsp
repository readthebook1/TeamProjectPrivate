<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록보기</title>
</head>
<body>
<table>
	<tr><td colspan="5" align="center">
		<form action="list.sms" method="post" name="sdearchform" onsubmit="return list(1)">
			<label for="notice_txt">공지사항 검색</label>
			<input type="hidden" name="pageNum" value="1">
			<select name="searchType" id="searchType">
				<option value="">선택하세요</option>
				<option value="subject">제목</option>
				<option value="name">글쓴이</option>
				<option value="content">내용</option>
			</select>&nbsp;
		<script type="text/javascript">
			if('${param.searchType}' != ''){
				document.getElememntById("searchType").value='${param.searchType}'
			}
		</script>
<input type="text" name="searchContent" value="${param.searchContent}">
<input type="submit" value="검색">
		</form></td></tr>

<tr class="tr_active" data-id="87">
	                        <td class="subject">공지사항</td>
	                        <td class="td_question">
	                            <a class="p_view_detail" href="javascript:void(0);">
	                                <p class="p_question">[추천키워드] 테마별로 공간을 쉽게 찾아보세요. </p>
	                                <span class="date">2016-05-20</span>
	                                <i class="sp_icon ico_view_detail">상세보기</i>
	                            </a>
	                        </td>
	                    </tr>
<tr class="tr_view tr_active" data-id="87">
  <td colspan="2">
    <div class="view_box">
      <div class="p_answer">
      <span class="date">2016-05-20</span>
      <p>
      <span style="font-size: 12pt;">﻿안녕하세요. 스페이스클라우드 운영팀 입니다.&nbsp;</span>&nbsp;</p>
      <p>
      <span style="font-size: 12pt;">오늘 스페이스클라우드 (PC)에 새로운 기능이 추가 되었어요.&nbsp;</span></p><p><span style="font-size: 12pt;">&nbsp;</span></p><p><span style="font-size: 12pt; color: rgb(120, 32, 185);"><b>바로 #추천키워드 인데요.&nbsp;</b></span></p><p><span style="font-size: 12pt;">모바일에서는 이미 구현되어 편리하게 사용된 기능 입니다.&nbsp;</span></p><p><span style="font-size: 12pt; line-height: 20px;">#추천키워드는 스페이스클라우드에 등록된 2000여개의</span></p><p><span style="font-size: 12pt; line-height: 20px;">공간 정보 및 예약 서비스를 보다 쉽게 찾을 수 있도록</span></p><p><span style="font-size: 12pt; line-height: 20px;">테마별 큐레이션 된 정보를 제공하는 기능 입니다.&nbsp;</span></p><p><span style="font-size: 13.3333px; line-height: 20px;">&nbsp;</span></p><p><span style="font-size: 12pt; line-height: 20px;">앞으로도 스페이스클라우드를 통해서 빠르고, 쉽고, 편리하게</span></p><p><span style="font-size: 12pt; line-height: 20px;">필요하신 공간을 찾으실 수 있도록 계속해서 발전시켜 갈게요.&nbsp;</span></p><p><span style="font-size: 12pt; line-height: 20px;">&nbsp;</span></p><p><span style="font-size: 12pt; line-height: 20px;">감사합니다.&nbsp;</span></p><p><span style="font-size: 13.3333px; line-height: 20px;">&nbsp;</span></p><p><span style="font-size: 13.3333px; line-height: 20px;"><br style="clear:both;">&nbsp;</span>
      </p>
      </div>
  </div>
  </td>
</tr>
</table>


</body>
</html>
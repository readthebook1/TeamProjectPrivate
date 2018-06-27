<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%-- /WebContent/WEB-INF/view/exception.jsp --%>
<%-- isErrorPage="true" : 여기 에러페이지 나야 나 나야 나 --%>
<%-- exception 객체가 있을 때에 이 페이지로 이동되며, 해당 exception 객체가 전달 됨. --%>
<script type="text/javascript">
	alert('${exception.message}');
	location.href="${exception.url}";
</script>
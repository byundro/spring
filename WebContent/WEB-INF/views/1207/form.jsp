<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <form method="post" action="/spring/file/upload.do" enctype="multipart/form-data">
    	id : <input type="text" name="id" /> <br />
    	파일 : <input type="file" name="save" /> <br />
    		<input type="submit" value="전송" />
    </form>
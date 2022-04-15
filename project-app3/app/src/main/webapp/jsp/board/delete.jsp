<%@page import="com.eomcs.mylist.domain.Member"%>
<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="com.eomcs.mylist.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Board board = new Board();
board.setNo(Integer.parseInt(request.getParameter("no")));

Member loginUser = (Member) session.getAttribute("loginUser");
board.setWriter(loginUser);

BoardService boardService = (BoardService) application.getAttribute("boardService");
boardService.delete(board);

response.sendRedirect("list.jsp");
%>
 
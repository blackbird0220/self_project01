package org.gangseo.ctrl.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gangseo.dao.NoticeDAO;
import org.gangseo.dto.Notice;


@WebServlet("/NotiList.do")
public class NoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeListCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		NoticeDAO dao = new NoticeDAO();
		List<Notice> notiList = new ArrayList<>();
		notiList = dao.getNoticeList();
		request.setAttribute("notiList", notiList);		
		RequestDispatcher view = request.getRequestDispatcher("/notice/noticeList.jsp");
		view.forward(request, response);
	}

}
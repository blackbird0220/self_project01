package org.gangseo.ctrl.notice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gangseo.dao.NoticeDAO;
import org.gangseo.dto.Notice;


@WebServlet("/NotiIns.do")
public class InsNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsNoticeCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Notice noti = new Notice();
		//String title = request.getParameter("title");
		//String content = request.getParameter("content");

		noti.setTitle(request.getParameter("title"));
		noti.setContent(request.getParameter("conctent"));
		
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.insNotice(noti);
				
		if(cnt >0) {
				System.out.println("공지사항 추가 성공~");
		} else {
			 	System.out.println("공지사항 추가 실패~");
		}
				
		/*
		List<Notice> notiList = new ArrayList<>();
		notList = dao.getNoticeList();
		request.setAttribute("notiList", notiList);
		RequestDispatcher view = request.getRequestDispatcher("/notice/noticeList.jsp");
		view.forward(request, response);
		  */
		ServletContext application = request.getServletContext();
		String home = application.getContextPath();
		if(cnt>0) {
			response.sendRedirect(home+"/NotiList.do");
		} else { 
				response.sendRedirect(home+"/notice/noti_ins.jsp");
		}
	}
}


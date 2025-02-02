package org.gangseo.ctrl.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gangseo.dao.NoticeDAO;
import org.gangseo.dto.Notice;


@WebServlet("/EditNotice.do")
public class EditNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditNoticeCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("sid");
		
		if(!loginId.equals("admin")) {
			response.sendRedirect("/NotiList.do");
		}
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDAO dao = new NoticeDAO();
		Notice noti = dao.getNotice2(no);
		
		request.setAttribute("noti", noti);
		RequestDispatcher view = request.getRequestDispatcher("/notice/editNotice.jsp");
		view.forward(request, response);
	}

}
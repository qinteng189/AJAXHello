package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUserDAO;
import util.Factory;

public class AJAXServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//先设置请求和响应的字符编码值
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//解析url
		String uri= request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		IUserDAO dao=(IUserDAO)Factory.getInstance("IUserDAO");
		PrintWriter pw=null;
		if("/vaildUsername".equals(action)){
			System.out.println("登录验证");
			String username=request.getParameter("username");
			boolean flag=dao.searchUsername(username);
			pw=response.getWriter();
			pw.write(String.valueOf(flag));
			pw.flush();
			if(pw!=null)
			pw.close();
		}else if("/vaildPassword".equals(action)){
			System.out.println("密码验证");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String correct=dao.searchPassword(username);
			pw=response.getWriter();
			if(correct.equals(password)){
				//密码正确
				pw.write("true");
			}else{
				//密码错误
				pw.write("flase");
			}
		}
	}
	
}

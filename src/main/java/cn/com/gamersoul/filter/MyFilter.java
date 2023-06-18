package cn.com.gamersoul.filter;


import cn.com.gamersoul.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = {"/user_info.html","/shopping_car.html","/userinforedact.html"})
public class MyFilter implements Filter {
    public void destroy() {//销毁时执行
    }
    //当请求某个被拦截的资源时执行
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断是否登录
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //得到会话对象
        HttpSession session = request.getSession();
        //获取登录成功时保存的用户对象
        User u = (User) session.getAttribute("u");
        if (u!=null){//代表登录过
            chain.doFilter(req, resp);//允许访问资源
        }else{//代表没有登录过
            //告诉客户端 重定向到登录页面
            response.sendRedirect("/login.html");
        }
    }
    //初始化时执行
    public void init(FilterConfig config) throws ServletException {

    }

}

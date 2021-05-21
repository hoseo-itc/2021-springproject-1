package itc.hoseo.springproject;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().equals("/login")) return true;

        HttpSession session = request.getSession(true);

        if(session.getAttribute("user") == null)response.sendRedirect("/login");

        return true;
    }
}

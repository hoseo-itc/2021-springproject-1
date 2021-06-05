package itc.hoseo.springproject;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
//        if(request.getRequestURI().equals("/login")) return true;
//        AntPathMatcher pathMatcher = new AntPathMatcher();
//        if(pathMatcher.match("/login/*",request.getRequestURI()))return true;
//        if(pathMatcher.match("/images/*",request.getRequestURI()))return true;
//        if(pathMatcher.match("/css/*",request.getRequestURI()))return true;
//        if(pathMatcher.match("/js/*",request.getRequestURI()))return true;
//
//        HttpSession session = request.getSession(true);
//
//        return true;
    }
}

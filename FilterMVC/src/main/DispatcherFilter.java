package main;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "DispatcherFilter", urlPatterns = "*.action")
public class DispatcherFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        //请求路径：/main/product-input.action
        String url = request.getServletPath();
        System.out.println("url: " + url);

        //上下文路径：/main
        String contextPath = request.getContextPath();
        System.out.println("contextPath: " + contextPath);

        //截取之后的路径：/product-input.action
        url = url.substring(contextPath.length());
        System.out.println("url: " + url);

        //替换之后的路径：product-input.action
        if (url.startsWith("/")) {
            url = url.replace("/", "");
        }

        //进行路径匹配
        switch (url) {
            case "product-input.action":
                request.getRequestDispatcher("/input.jsp").forward(request, response);
                return;
            case "product-save.action":
                //1.获取数据
                String username = request.getParameter("username");
                //2.执行保存操作
                //3.保存之后的操作
                return;
        }

        chain.doFilter(request, response);
    }
}

package com.middleware.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 拦截�?
 *
 */
public class Authority  implements Filter {

	protected FilterConfig filterConfig;  
    protected String FilteredIP;  
    /** 
     * 初始�? 
     */  
    @Override  
    public void init(FilterConfig conf) throws ServletException {  
        this.filterConfig = conf;//过滤器初始化  
        FilteredIP = conf.getInitParameter("FilteredIP");//获取被过滤的Ip  
        if (FilteredIP==null) {  
            FilteredIP="";  
        }  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
//        response.setContentType("text/html");  
//        response.setCharacterEncoding("utf-8");//设置编码格式  
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");//定义错误转向页面  
//        //读出本地Ip  
//        String remoteIP = request.getRemoteAddr(); 
//        System.out.println(FilteredIP);
//        PrintWriter out = response.getWriter();  
//        //允许访问的IP 
//        if (!remoteIP.equals(FilteredIP)) {  
//        	out.print("{errcode:1,msg:'access denied'}");
//        	System.out.println("1");
//            dispatcher.forward(request, response);
//        }else {  
//        	out.print("{errcode:1,msg:'access denied'}"); 
//        	System.out.println("0");
//            chain.doFilter(request, response);  
//        }  
    	//TODO IP权限过滤未完�?
        chain.doFilter(request, response);  
    }  
      
    @Override  
    public void destroy() {  
        this.filterConfig = null;  
    }  

}

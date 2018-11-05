package com.middleware.config;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
 
/**
 * 自定义增强类
 * @author  继承HttpServletRequestWrapper相当于实现了HttpServletRequest
 *         HttpServletRequestWrapper类，它本身实现了所有HttpServletRequest的方法
 *         继承它之后，需要修改的方法MyRequest可以自己定义，不需要修改的方法，直接使用父类的方法
 *
 *         第一步：总结：继承HttpServletRequestWrapper，为了偷懒，
 *         不用自己去实现所有HttpServletRequest的方法 第二步：使用构造函数将原来的request对象保存到当前自定义对象中
 *         第三步：针对要修改的方法，进行增强 第四步：定义一个flag标记，防止编码重复执行
 */
public class MyRequest extends HttpServletRequestWrapper {
 
    // 定义了一个成员变量，用来保存构造函数传入的requset对象
    private HttpServletRequest request = null;
 
    // 定义一个标记，用来标注：当前requset中，请求参数，是否已经编码过了
    private boolean flag = false;
 
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
 
    }
 
    // 总需求：对request对象的获取数据的方法，进行增强（统一编码）
 
    @Override
    public Map<String, String[]> getParameterMap() {
        // 获得请求方式request.getMethod()方法
        String method = this.request.getMethod();
        // post请求
        if ("post".equalsIgnoreCase(method)) {
            // 设置编码格式
            try {
                request.setCharacterEncoding("utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Map<String, String[]> map = this.request.getParameterMap();
            return map;
 
        } else if ("get".equalsIgnoreCase(method)) {
            // get请求
            // 分析：get请求需要对每一个参数都进行转换，因此需要对map中的每个元素进行遍历
            // 首先获得map集合
            Map<String, String[]> map = this.request.getParameterMap();
 
            //第一次获取请求参数，flag==false，执行后面的额乱码处理动作
            //第二次获取请求参数的时候，flag==true，不执行后面的处理，直接返回已经编码过的map集合
            if (flag) {
                return map;
            }
            if (map == null) {
                return super.getParameterMap();
            } else {
                // 然后获得map集合的key
                Set<String> key = map.keySet();
                // 通过key将map中的元素取出来
                for (String string : key) {
                    String[] value = map.get(string);
                    // 接下来需要将String中的每一个都进行遍历，转换参数
                    for (int i = 0; i < value.length; i++) {
                        try {
                            String string2 = new String(
                                    value[i].getBytes("iso-8859-1"), "utf-8");
                            value[i] = string2;
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                flag = true;
                return map;
            }
        } else {
            //位置请求方式，自定义对象处理不了，使用父类的方法处理
            return super.getParameterMap();
        }
    }
 
    @Override
    public String[] getParameterValues(String name) {
        // 通过map集合获取参数
        Map<String, String[]> map = this.getParameterMap();
        if (map == null) {
            return super.getParameterValues(name);
        } else {
            String[] strings = map.get(name);
            return strings;
        }
    }
 
    @Override
    public String getParameter(String name) {
        // 通过values获取参数
        String[] values = this.getParameterValues(name);
        if (values == null) {
            return super.getParameter(name);
        } else {
            return values[0];
        }
    }
 
}
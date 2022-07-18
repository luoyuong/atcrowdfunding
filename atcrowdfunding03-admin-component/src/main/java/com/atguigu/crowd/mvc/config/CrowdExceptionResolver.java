package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.util.CowdUtils;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hy
 * @create 2022-07-18 10:27
 * @Description
 */
@ControllerAdvice
public class CrowdExceptionResolver {

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNopointException(NullPointerException exception,
                                                HttpServletRequest request,
                                                HttpServletResponse response) throws IOException {

        String viewname = "system-error";

        return resolveException(viewname,exception,request,response);
    }

    /**
     * 通用的解析器
     * @param viewname
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    private ModelAndView resolveException(String viewname,
                                          Exception exception,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws IOException {
        //1.判断请求的数据类型
        boolean judgeReqeustType = CowdUtils.judgeReqeustType(request);

        //2.如果是json类型
        if(judgeReqeustType){
            //3.创建resultEntity对象
            ResultEntity<Object> resultEntity = ResultEntity.fiedWithNoData(exception.getMessage());

            //4.创建Gson对象
            Gson gson = new Gson();

            //5.转换为json
            String exceptionJson = gson.toJson(resultEntity);

            //6.将json作为响应体返回给浏览器
            response.getWriter().write(exceptionJson);

            return null;
        }

        //7.如果不是ajax请求

        //8.创建modelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        //9.添加异常信息
        modelAndView.addObject("exception",exception);

        //10.设置异常页面
        modelAndView.setViewName(viewname);

        return modelAndView;


    }

}

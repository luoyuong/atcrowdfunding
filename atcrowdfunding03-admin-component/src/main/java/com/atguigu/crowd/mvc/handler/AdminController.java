package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.mysql.jdbc.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author hy
 * @create 2022-07-17 16:02
 * @Description
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/send/array/one.html")
    public String sendAjaxOne(@RequestParam("array[]")List<String> list){

        list.forEach(System.out::println);

        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/send/array/two.html")
    public String sendAjaxTwo(TestParam testParam){

        List<Integer> array = testParam.getArray();

        array.forEach(System.out::println);

        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/send/array/three.html")
    public String sendAjaxThree(@RequestBody List<Integer> array){

        Logger logger = LoggerFactory.getLogger(AdminController.class);

        for(Integer num:array){
            logger.info(num.toString());
        }

        return "success";
    }

    @RequestMapping("/getall")
    public String getAll(ModelMap mv){

        int i = 10/0;

        List<Admin> list = adminService.getAll();
        mv.addAttribute("list",list);
        Logger logger = LoggerFactory.getLogger(AdminController.class);
        logger.error("到这里了");
        logger.error(Arrays.toString(list.toArray()));
        return "target";
    }
}

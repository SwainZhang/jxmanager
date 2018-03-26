package com.emery.test.controller.basicinfo.factory;

import com.alibaba.fastjson.JSON;
import com.emery.test.controller.BaseController;
import com.emery.test.domain.Factory;
import com.emery.test.service.impl.FactoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by emery on 2018/3/24.
 */

@Controller
@RequestMapping("/basicinfo/factory")
public class FactoryController extends BaseController {
    @Autowired
    FactoryServiceImpl mFactoryService;

    @RequestMapping("/list.action")
    public String list(Factory factory, Model model){
        List<Factory> factories = mFactoryService.find(factory);
        model.addAttribute("dataList",factories);

        return "/basicinfo/factory/jFactory.jsp";
    }
    @RequestMapping("/listStr.action")
    public void list(Factory factory, HttpServletResponse response){
        List<Factory> factories = mFactoryService.find(factory);
        try {
            String s = JSON.toJSONString(factories);
            response.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转向新增页面
     * @return
     */
    @RequestMapping("/tocreate.action")
    public String toCreate(){
        return "/basicinfo/factory/jFactoryCreate.jsp";
    }

    /**
     * 新增
     * @param factory
     * @return
     */
    @RequestMapping("/insert.action")
    public String insert(Factory factory){
        mFactoryService.insert(factory);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 转向修改页面
     * @return
     */
    @RequestMapping("/toupdate.action")
    public String toUpdate(String id,Model model){
        Factory factory = mFactoryService.get(id);
        model.addAttribute("obj",factory);
        return "/basicinfo/factory/jFactoryUpdate.jsp";
    }
    @RequestMapping("/update.action")
    public String update(Factory factory){
        mFactoryService.update(factory);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * delete 一条
     * @param id
     * @return
     */
    public String delete(String id){
        mFactoryService.delete(id);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 多条删除
     */
    public String delete(String[] ids){
        mFactoryService.delete(ids);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 转到查看页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toview.action")
    public String toView(String id,Model model){
        Factory factory = mFactoryService.get(id);
        model.addAttribute("obj",factory);
        return "/basicinfo/factory/jFactoryView.jsp";
    }

    @RequestMapping("/enablestates.action")
    public String start(String[] ids){
        this.changeState(ids, 1);
        return "redirect:/basicinfo/factory/list.action";
    }

    @RequestMapping("/disablestates.action")
    public String disable(String[] ids){
        this.changeState(ids, 0);
        return "redirect:/basicinfo/factory/list.action";
    }

    private void changeState(String[] ids, int value) {
        Map<String, Object> map = new HashMap();
        map.put("state", value);
        map.put("ids", ids);
        mFactoryService.changeState(map);
    }
}

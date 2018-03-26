package com.emery.test.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by emery on 2018/3/24.
 */
public abstract class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataFormat.setLenient(true);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dataFormat,true));
    }
}

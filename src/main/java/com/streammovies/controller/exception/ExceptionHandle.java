package com.streammovies.controller.exception;

import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;


@PropertySource("classpath:messages.properties")
@ControllerAdvice
public class ExceptionHandle {

    @Autowired
    private Environment environment;

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView noHandleFound(){
        ModelAndView modelAndView = new ModelAndView(View.EXCEPTION);
        modelAndView.addObject("message",
                environment.getProperty("exception.message.no_handle_found"));
        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView nullPointer(){
        ModelAndView modelAndView = new ModelAndView(View.EXCEPTION);
        modelAndView.addObject("message",
                environment.getProperty("exception.message.null_pointer"));
        return modelAndView;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView illegalArguement(){
        ModelAndView modelAndView = new ModelAndView(View.EXCEPTION);
        modelAndView.addObject("message",
                environment.getProperty("exception.message.illegal_arguement"));
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(){
        ModelAndView modelAndView = new ModelAndView(View.EXCEPTION);
        modelAndView.addObject("message",
                environment.getProperty("exception.message.common"));
        return modelAndView;
    }


}

package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class CommentService { // business logic

    private  final CommentRepository commentRepository; // for loosing couple we use Interface, implementation can change

    private  final CommentNotificationProxy commentNotificationProxy;// for loosing couple we use Interface

    private final AppConfigData appConfigData; // add all the var from AppConfigData class by using Injection

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
    }

    public void publishComment(Comment comment){

        // save in the DB
        commentRepository.storeComment(comment);

        // Send email
        commentNotificationProxy.sendComment(comment);




    }

    public void printConfigData(){ // add all the var from AppConfigData class by using Injection
        System.out.println(appConfigData.getUsername());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());
    }






}


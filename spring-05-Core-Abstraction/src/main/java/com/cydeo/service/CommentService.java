package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.proxy.EmailCommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;

public class CommentService { // business logic

    private CommentRepository commentRepository; // for loosing couple we use Interface, implementation can change

    private CommentNotificationProxy commentNotificationProxy;// for loosing couple we use Interface

    public void publishComment(Comment comment){

        // save in the DB
        commentRepository.storeComment(comment);

        // Send email
        commentNotificationProxy.sendComment(comment);


    }

}


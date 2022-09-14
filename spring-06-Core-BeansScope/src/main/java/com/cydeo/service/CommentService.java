package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService { // business logic

    private  final CommentRepository commentRepository; // for loosing couple we use Interface, implementation can change

    private  final CommentNotificationProxy commentNotificationProxy;// for loosing couple we use Interface

    public CommentService(CommentRepository commentRepository,@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        // save in the DB
        commentRepository.storeComment(comment);

        // Send email
        commentNotificationProxy.sendComment(comment);


    }

}


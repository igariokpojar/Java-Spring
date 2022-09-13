package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxy { // we can not create Object from interfaces

    void sendComment(Comment comment);
}

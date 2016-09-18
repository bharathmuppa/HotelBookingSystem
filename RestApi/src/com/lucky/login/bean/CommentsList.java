package com.lucky.login.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentsList {
ArrayList<PostComment> postComments=new ArrayList<PostComment>();

public ArrayList<PostComment> getPostComments() {
	return postComments;
}

public void setPostComments(ArrayList<PostComment> postComments) {
	this.postComments = postComments;
}

@Override
public String toString() {
	return "CommentsList [postComments=" + postComments + "]";
}

}

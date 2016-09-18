package com.lucky.login.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PostStatus {
	private boolean status;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean b) {
		this.status = b;
	}

	@Override
	public String toString() {
		return "PostStatus [status=" + status + "]";
	}
	
}

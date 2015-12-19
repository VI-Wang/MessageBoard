package com.vi.domain;


import java.util.Set;

public class Users {
	private Integer userId;
	private String userName;
	private String password;
	//一个用户可以发送多条消息也可以接受多条消息
	private Set<Message> sendMessages;
	private Set<Message> getMessages;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Message> getSendMessages() {
		return sendMessages;
	}
	public void setSendMessages(Set<Message> sendMessages) {
		this.sendMessages = sendMessages;
	}
	public Set<Message> getGetMessages() {
		return getMessages;
	}
	public void setGetMessages(Set<Message> getMessages) {
		this.getMessages = getMessages;
	}
}

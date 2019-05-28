package com.lharo.g4g.Games4Gamers.util;

public class Mail {
	private String subject;
	private String[] receivers;
	private String msg;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String[] getReceivers() {
		return receivers;
	}
	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}

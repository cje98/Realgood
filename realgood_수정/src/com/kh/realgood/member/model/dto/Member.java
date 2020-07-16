package com.kh.realgood.member.model.dto;

import java.sql.Date;

public class Member {
	private String id;
	private String pwd;
	private String mame;
	private String juminFront;
	private String juminRear;
	private char gender;
	private String gradeName;
	private String tel;
	private Date enrollDate;
	private String nickName;
	private String emailReceive;
	private String smsReceive;
	
	public Member(String id, String pwd, String mame, String juminFront, String juminRear, char gender,
			String gradeName, String tel, Date enrollDate, String nickName, String emailReceive, String smsReceive) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.mame = mame;
		this.juminFront = juminFront;
		this.juminRear = juminRear;
		this.gender = gender;
		this.gradeName = gradeName;
		this.tel = tel;
		this.enrollDate = enrollDate;
		this.nickName = nickName;
	}
	
	public Member(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	

	public Member(String id, String pwd, String mame, String juminFront, String juminRear, char gender, String tel,
			String nickName ,String emailReceive, String smsReceive) {
		super();
		this.id = id;
		this.mame = mame;
		this.juminFront = juminFront;
		this.juminRear = juminRear;
		this.gender = gender;
		this.tel = tel;
		this.nickName = nickName;
		this.emailReceive = emailReceive;
		this.smsReceive = smsReceive;
	}

	public Member(String id, String mame, String juminFront, String juminRear, char gender, String gradeName,
			String tel, Date enrollDate, String nickName) {
		super();
		this.id = id;
		this.mame = mame;
		this.juminFront = juminFront;
		this.juminRear = juminRear;
		this.gender = gender;
		this.gradeName = gradeName;
		this.tel = tel;
		this.enrollDate = enrollDate;
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMame() {
		return mame;
	}
	public void setMame(String mame) {
		this.mame = mame;
	}
	public String getJuminFront() {
		return juminFront;
	}
	public void setJuminFront(String juminFront) {
		this.juminFront = juminFront;
	}
	public String getJuminRear() {
		return juminRear;
	}
	public void setJuminRear(String juminRear) {
		this.juminRear = juminRear;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmailReceive( ) {
		return emailReceive;
	}
	public void emailReceive(String emailReceive) {
		this.emailReceive = emailReceive;
	}
	
	public String getSmsReceive( ) {
		return smsReceive;
	}
	public void smsReceive(String smsReceive) {
		this.smsReceive = smsReceive;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", mame=" + mame + ", juminFront=" + juminFront + ", juminRear="
				+ juminRear + ", gender=" + gender + ", gradeName=" + gradeName + ", tel=" + tel + ", enrollDate="
				+ enrollDate + ", nickName=" + nickName + "]";
	}
	
	
}

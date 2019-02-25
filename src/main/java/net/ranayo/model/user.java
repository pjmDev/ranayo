package net.ranayo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user {
	@Id
	private String usEmail; // 아이디 겸 이메일
	private String usPasswd; // 비밀번호
	private String usNickname; // 닉네임
	private Date usJoindt; // 가입날자
	private String usJoinip; // 가입할때 ip
	private Date usUpdt; // 아이디 최종 수정날
	private String usUpip; // 아이디 최종 수정 아이피
	private String usState; // 가입상태 ( 탈퇴, 신고차단, 정상 )
	private int usAuth; // 해당 유저 권한
	
	
	public String getUsEmail() {
		return usEmail;
	}
	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}
	public String getUsPasswd() {
		return usPasswd;
	}
	public void setUsPasswd(String usPasswd) {
		this.usPasswd = usPasswd;
	}
	public String getUsNickname() {
		return usNickname;
	}
	public void setUsNickname(String usNickname) {
		this.usNickname = usNickname;
	}
	public Date getUsJoindt() {
		return usJoindt;
	}
	public void setUsJoindt(Date usJoindt) {
		this.usJoindt = usJoindt;
	}
	public String getUsJoinip() {
		return usJoinip;
	}
	public void setUsJoinip(String usJoinip) {
		this.usJoinip = usJoinip;
	}
	public Date getUsUpdt() {
		return usUpdt;
	}
	public void setUsUpdt(Date usUpdt) {
		this.usUpdt = usUpdt;
	}
	public String getUsUpip() {
		return usUpip;
	}
	public void setUsUpip(String usUpip) {
		this.usUpip = usUpip;
	}
	public String getUsState() {
		return usState;
	}
	public void setUsState(String usState) {
		this.usState = usState;
	}
	public int getUsAuth() {
		return usAuth;
	}
	public void setUsAuth(int usAuth) {
		this.usAuth = usAuth;
	}

	
}

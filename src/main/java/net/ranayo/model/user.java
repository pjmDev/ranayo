package net.ranayo.model;

import java.net.InetAddress;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "tb_user")
@ToString
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="usnum", unique = true)
	private long usNum;
	@Column(name="usemail", unique = true, nullable = false)
	private String usEmail; // 아이디 겸 이메일
	@Column(name="uspasswd", nullable = false)
	private String usPasswd; // 비밀번호
	@Column(name="usnickname", unique = true, nullable = false)
	private String usNickname; // 닉네임
	@Column(name="usjoindt")
	private Date usJoindt; // 가입날자
	@Column(name="usjoinip")
	private String usJoinip; // 가입할때 ip
	@Column(name="usupdt")
	private Date usUpdt; // 아이디 최종 수정날
	@Column(name="usupip")
	private String usUpip; // 아이디 최종 수정 아이피
	@Column(name="usauth")
	private int usAuth; // 해당 유저 권한
	@Column(name="usstate")
	private String usState; // 가입상태 ( 탈퇴 : T, 신고차단 : G, 정상 : S)
	
	public long getUsNum() {
		return usNum;
	}
	public void setUsNum(long usNum) {
		this.usNum = usNum;
	}
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
		InetAddress local;
		try {
		    local = InetAddress.getLocalHost();
		    String ip = local.getHostAddress();
		    this.usJoinip = ip;
		} catch (Exception e) {
		    e.printStackTrace();
		}
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
	public int getUsAuth() {
		return usAuth;
	}
	public void setUsAuth(int usAuth) {
		if((Integer)usAuth == null) {
			usAuth = 70;
		}
		this.usAuth = usAuth;
	}
	public String getUsState() {
		return usState;
	}
	public void setUsState(String usState) {
		if(usState == null) {
			usState = "S";
		}
		this.usState = usState;
	} 


	
}

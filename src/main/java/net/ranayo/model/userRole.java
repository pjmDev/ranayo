package net.ranayo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_role")
public class userRole {
	@Id
    @Column(name = "uremail")
    private String urEmail;

	@Column(name = "urrole")
    private String urRole;

	public String getUremail() {
		return urEmail;
	}

	public void setUremail(String uremail) {
		this.urEmail = uremail;
	}

	public String getUrrole() {
		return urRole;
	}

	public void setUrrole(String urrole) {
		this.urRole = urrole;
	}
	
}
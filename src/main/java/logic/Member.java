package logic;

import java.util.Date;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String mob; 
	private Date regDate;
	private Integer memType;
	private String hostName; 
	private Integer hostRegNo;
	private String address;
	private String accountNo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getMemType() {
		return memType;
	}
	public void setMemType(Integer memType) {
		this.memType = memType;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Integer getHostRegNo() {
		return hostRegNo;
	}
	public void setHostRegNo(Integer hostRegNo) {
		this.hostRegNo = hostRegNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", mob=" + mob + ", regDate="
				+ regDate + ", memType=" + memType + ", hostName=" + hostName + ", hostRegNo=" + hostRegNo
				+ ", address=" + address + ", accountNo=" + accountNo + "]";
	}
}

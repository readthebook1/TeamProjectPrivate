package logic;

import java.util.Date;

public class Reserve {
	private Integer reNo;
	private String id;
	private Integer sRNo;
	private Date reDate;
	private Date regDate;
	private Integer totPrice;
	private Integer reCnt;
	private Integer reStat;
	/* 	reStat : 예약/구매 상태
	 *  	0 : 예약&결제대기
	 *   	1 : 결제완료
	 *   	2 : 취소&환불대기
	 *   	3 : 환불완료
	 */
	
	
	public Integer getReNo() {
		return reNo;
	}
	public void setReNo(Integer reNo) {
		this.reNo = reNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getsRNo() {
		return sRNo;
	}
	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(Integer totPrice) {
		this.totPrice = totPrice;
	}
	public Integer getReCnt() {
		return reCnt;
	}
	public void setReCnt(Integer reCnt) {
		this.reCnt = reCnt;
	}
	public Integer getReStat() {
		return reStat;
	}
	public void setReStat(Integer reStat) {
		this.reStat = reStat;
	}
	
	@Override
	public String toString() {
		return "Reserve [reNo=" + reNo + ", id=" + id + ", sRNo=" + sRNo + ", reDate=" + reDate + ", regDate=" + regDate
				+ ", totPrice=" + totPrice + ", reCnt=" + reCnt + ", reStat=" + reStat + "]";
	}
}

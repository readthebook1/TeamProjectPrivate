package logic;

import java.util.Date;

public class Reserve {
	private Integer reNo;			// 예약관리번호
	private String id;				// 예약자ID
	private Integer sRNo;			// Room번호
	private Date reDate;			// 예약 일자
	private Date regDate;			// 예약 관리 일자
	private Integer totPrice;		// 금액
	private Integer reCnt;			// 수량
	private Integer reStat;			// 예약 구매 상태
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
	public Integer getSrNo() {
		return sRNo;
	}
	public void setSrNo(Integer sRNo) {
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

package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Board {
	private Integer bNo;
	private Integer sNo;
	
	@NotEmpty(message = "내용을 입력하세요.")
	private String id;
	private String email;
	
	@NotEmpty(message = "내용을 입력하세요.")
	private String content;
	
	private String qType;
	private Date regDate;
	private Integer ref;
	private Integer refLevel;
	private Integer score;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private MultipartFile img1File;
	private MultipartFile img2File;
	private MultipartFile img3File;
	private MultipartFile img4File;
	private Integer kind;
	
	public Integer getbNo() {
		return bNo;
	}
	public void setbNo(Integer bNo) {
		this.bNo = bNo;
	}
	public Integer getsNo() {
		return sNo;
	}
	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getqType() {
		return qType;
	}
	public void setqType(String qType) {
		this.qType = qType;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		this.ref = ref;
	}
	public Integer getRefLevel() {
		return refLevel;
	}
	public void setRefLevel(Integer refLevel) {
		this.refLevel = refLevel;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public MultipartFile getImg1File() {
		return img1File;
	}
	public void setImg1File(MultipartFile img1File) {
		this.img1File = img1File;
	}
	public MultipartFile getImg2File() {
		return img2File;
	}
	public void setImg2File(MultipartFile img2File) {
		this.img2File = img2File;
	}
	public MultipartFile getImg3File() {
		return img3File;
	}
	public void setImg3File(MultipartFile img3File) {
		this.img3File = img3File;
	}
	public MultipartFile getImg4File() {
		return img4File;
	}
	public void setImg4File(MultipartFile img4File) {
		this.img4File = img4File;
	}
	public Integer getKind() {
		return kind;
	}
	public void setKind(Integer kind) {
		this.kind = kind;
	}
	
	@Override
	public String toString() {
		return "Board1 [bNo=" + bNo + ", sNo=" + sNo + ", id=" + id + ", email=" + email + ", content=" + content
				+ ", qType=" + qType + ", regDate=" + regDate + ", ref=" + ref + ", refLevel=" + refLevel + ", score="
				+ score + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", img1File="
				+ img1File + ", img2File=" + img2File + ", img3File=" + img3File + ", img4File=" + img4File + ", kind="
				+ kind + "]";
	}
}

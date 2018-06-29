package logic;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import dao.MemberDao;
import dao.ReserveDao;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private MemberDao memDao;
	@Autowired
	private BoardDao boDao;
	@Autowired
	private ReserveDao reDao;

	@Override
	public Member getMember(String id) {
		return memDao.select(id);
	}

	@Override
	public int boardcount(String searchType, String searchContent) {
		return boDao.count(searchType, searchContent);
	}

	@Override
	public List<Board> boardList(String searchType, String searchContent, Integer pageNum, int limit) {
		return boDao.list(searchType, searchContent, pageNum, limit);
	}

	@Override // 게시글 작성할 때 호출
	public void boardWrite(Board board, HttpServletRequest request) {
		
		if (board.getImg1File() != null && !board.getImg1File().isEmpty()) { // img1 파일이 있을 경우
			String img = uploadImgCreate(board.getImg1File(),request);	// 사진을 업로드하고 업로드한 파일명을 리턴값으로 받아옴.
			if(img != null) board.setImg1(img); // 받아온 리턴값이 null이 아닌 경우 Board 객체에 사진 이름을 저장
		}
		
		if (board.getImg2File() != null && !board.getImg2File().isEmpty()) { // img2 파일이 있을 경우
			String img = uploadImgCreate(board.getImg2File(),request);
			if(img != null) board.setImg2(img);
		}
		
		if (board.getImg3File() != null && !board.getImg3File().isEmpty()) { // img3 파일이 있을 경우
			String img = uploadImgCreate(board.getImg3File(),request);
			if(img != null) board.setImg3(img);
		}
		
		if (board.getImg4File() != null && !board.getImg4File().isEmpty()) { // img4 파일이 있을 경우
			String img = uploadImgCreate(board.getImg1File(),request);
			if(img != null) board.setImg1(img);
		}
		// 파일 업로드 과정 끝
		System.out.println(boDao.hashCode());
		int num = boDao.maxNum();
		
		board.setbNo(++num);
		board.setRef(num);
		board.setRefLevel(0);

		boDao.insert(board);

	}

	@Override
	public Board getBoard(int num) {
		return boDao.getBoard(num);
	}

	@Override
	public void boardReply(Board board) {
		// TODO Auto-generated method stub

	}

	@Override // 게시글 수정할 때 호출
	public void boardUpdate(Board board, HttpServletRequest request) {	
		
		if (board.getImg1File() != null && !board.getImg1File().isEmpty()) { // img1 파일이 있을 경우
			String img = uploadImgCreate(board.getImg1File(),request);	// 사진을 업로드하고 업로드한 파일명을 리턴값으로 받아옴.
			if(img != null) board.setImg1(img); // 받아온 리턴값이 null이 아닌 경우 Board 객체에 사진 이름을 저장
		}
		
		if (board.getImg2File() != null && !board.getImg2File().isEmpty()) { // img2 파일이 있을 경우
			String img = uploadImgCreate(board.getImg2File(),request);
			if(img != null) board.setImg2(img);
		}
		
		if (board.getImg3File() != null && !board.getImg3File().isEmpty()) { // img3 파일이 있을 경우
			String img = uploadImgCreate(board.getImg3File(),request);
			if(img != null) board.setImg3(img);
		}
		
		if (board.getImg4File() != null && !board.getImg4File().isEmpty()) { // img4 파일이 있을 경우
			String img = uploadImgCreate(board.getImg1File(),request);
			if(img != null) board.setImg1(img);
		}
		
		boDao.update(board);

	}

	@Override
	public void boardDelete(Integer num) {
		boDao.delete(num);
	}

	@Override
	public void updateReadCnt(Integer num) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Reserve getReserve(Integer reNo) {
		return reDao.getReserve(reNo);
	}
	

	@Override
	public List<Reserve> getReserveList(String id) {
		return reDao.getReserveList(id);
	}
	
	@Override
	public int reserveCount(String id, String searchType, String searchContent) {
		return reDao.count(searchType, searchContent);
	}

	@Override
	public List<Reserve> selectReserveList(String id, String searchType, String searchContent, Integer pageNum, int limit) {
		return reDao.list(id, searchType, searchContent, pageNum, limit);
	}
	
	@Override
	public void reserveInsert(Reserve reserve) {
		reserve.setReNo(reserve.getSrNo() + (int)new Date().getTime());
		reDao.insert(reserve);
	}

	private String uploadImgCreate(MultipartFile picture, HttpServletRequest request) { // 리뷰게시판에 이미지 등록시 사용하는 메서드

		Date date = new Date();

		try {
			
			String uploadPath = request.getServletContext().getRealPath("/") + "/picture/"; // 업로드 경로 설정
			String orgFile = date.getTime() + picture.getOriginalFilename(); // 파일 이름(파일명 + 업로드 시간) 설정
			picture.transferTo(new File(uploadPath + orgFile)); // new File(uploadPath + orgFile) : 파일 객체 설정
			
			return orgFile; // 저장된 파일 이름을 리턴
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} // uploadImgCreate()메서드의 끝

} // ProjectServiceImpl 클래스의 끝

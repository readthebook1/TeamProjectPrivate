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

	@Override // 寃���湲� ���깊�� �� �몄�
	public void boardWrite(Board board, HttpServletRequest request) {
		
		if (board.getImg1File() != null && !board.getImg1File().isEmpty()) { // img1 ���쇱�� ���� 寃쎌��
			String img = uploadImgCreate(board.getImg1File(),request);	// �ъ��� ��濡�����怨� ��濡����� ���쇰��� 由ы�닿��쇰� 諛�����.
			if(img != null) board.setImg1(img); // 諛����� 由ы�닿��� null�� ���� 寃쎌�� Board 媛�泥댁�� �ъ� �대��� ����
		}
		
		if (board.getImg2File() != null && !board.getImg2File().isEmpty()) { // img2 ���쇱�� ���� 寃쎌��
			String img = uploadImgCreate(board.getImg2File(),request);
			if(img != null) board.setImg2(img);
		}
		
		if (board.getImg3File() != null && !board.getImg3File().isEmpty()) { // img3 ���쇱�� ���� 寃쎌��
			String img = uploadImgCreate(board.getImg3File(),request);
			if(img != null) board.setImg3(img);
		}
		
		if (board.getImg4File() != null && !board.getImg4File().isEmpty()) { // img4 ���쇱�� ���� 寃쎌��
			String img = uploadImgCreate(board.getImg1File(),request);
			if(img != null) board.setImg1(img);
		}
		// ���� ��濡��� 怨쇱�� ��
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

	@Override // 寃���湲� ������ �� �몄�
	public void boardUpdate(Board board, HttpServletRequest request) {	
		
		if (board.getImg1File() != null && !board.getImg1File().isEmpty()) { // img1 ���쇱�� ���� 寃쎌��
			String img = uploadImgCreate(board.getImg1File(),request);	// �ъ��� ��濡�����怨� ��濡����� ���쇰��� 由ы�닿��쇰� 諛�����.
			if(img != null) board.setImg1(img); // 諛����� 由ы�닿��� null�� ���� 寃쎌�� Board 媛�泥댁�� �ъ� �대��� ����
		}
		
		if (board.getImg2File() != null && !board.getImg2File().isEmpty()) { // img2 ���쇱�� ���� 寃쎌��
			String img = uploadImgCreate(board.getImg2File(),request);
			if(img != null) board.setImg2(img);
		}
		
		if (board.getImg3File() != null && !board.getImg3File().isEmpty()) { // img3 ���쇱�� ���� 寃쎌��
			String img = uploadImgCreate(board.getImg3File(),request);
			if(img != null) board.setImg3(img);
		}
		
		if (board.getImg4File() != null && !board.getImg4File().isEmpty()) { // img4 ���쇱�� ���� 寃쎌��
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
		return 0;
	}

	@Override
	public List<Reserve> selectReserveList(String id, String searchType, String searchContent, Integer pageNum, int limit) {
		return null;
	}

	private String uploadImgCreate(MultipartFile picture, HttpServletRequest request) { // 由щ럭寃������� �대�몄� �깅��� �ъ�⑺���� 硫�����

		Date date = new Date();

		try {
			
			String uploadPath = request.getServletContext().getRealPath("/") + "/picture/"; // ��濡��� 寃쎈� �ㅼ��
			String orgFile = date.getTime() + picture.getOriginalFilename(); // ���� �대�(���쇰� + ��濡��� ��媛�) �ㅼ��
			picture.transferTo(new File(uploadPath + orgFile)); // new File(uploadPath + orgFile) : ���� 媛�泥� �ㅼ��
			
			return orgFile; // ���λ�� ���� �대��� 由ы��
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} // uploadImgCreate()硫������� ��

	@Override
	public void joinsms(Member member) {
		memDao.joinsms(member);
	}

} // ProjectServiceImpl �대���ㅼ�� ��

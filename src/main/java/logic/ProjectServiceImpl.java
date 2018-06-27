package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import dao.MemberDao;

@Service
public class ProjectServiceImpl implements ProjectService {

	private MemberDao memDao;
	
	
	@Override
	public Member getMember(String id) {
		return memDao.select(id);
	}


	@Override
	public int boardcount(String searchType, String searchContent) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Board> boardList(String searchType, String searchContent, Integer pageNum, int limit) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void boardWrite(Board board, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Board getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void boardReply(Board board) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void boardUpdate(Board board, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void boardDelete(Integer num) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateReadCnt(Integer num) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
	
	
	
	
	
//	private void uploadFileCreate(MultipartFile picture, HttpServletRequest request) {
//		String uploadPath = request.getServletContext().getRealPath("/") + "/picture/";	// 파일 업로드 위치 설정
//		String orgFile = picture.getOriginalFilename();	// 파일의 이름 설정
//
//		try {
//			picture.transferTo(new File(uploadPath + orgFile));	// new File(uploadPath + orgFile) : 파일 객체 설정
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


//	@Override
//	public void itemCreate(Item item, HttpServletRequest request) {
//
//		if (item.getPicture() != null && !item.getPicture().isEmpty()) {	//업로드 된 이미지가 존재하는 경우
//			uploadFileCreate(item.getPicture(), request);	// 파일 생성
//			item.setPictureUrl(item.getPicture().getOriginalFilename());	//파일의 이름을 등록
//			// getPicture() = MultipartFile picture : 업로드 된 파일의 정보 (이름, 내용 등)
//		}
//		itemDao.insert(item);
//
//	}

}

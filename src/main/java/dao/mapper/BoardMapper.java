package dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;

public interface BoardMapper {

	@Select("select ifnull(max(num),0) from board")
	int maxNum();
	
	@Insert("insert into board(bNo, sNo, id, email, content, qType, regDate, ref, refLevel, score, img1, img2, img3, img4, kind) "
			+ "values(#{bNo}, #{sNo}, #{id}, #{email}, #{content}, #{qType}, now(), #{ref}, #{refLevel}, #{score}, "
			+ "#{img1}, #{img2}, #{img3}, #{img4}, #{kind})")
	void insert(Board board);

	@Update("update board set content=#{content}, qType=#{qType}, regDate=now(), score=#{score} where bNo=#{bNo}")
	void update(Board board);

	@Delete("delete from board where bNo=#{value}")
	void delete(Integer num);
}

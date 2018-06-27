package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;

public interface BoardMapper {

	@Select("select ifnull(max(num),0) from board")
	int maxNum();
	
	@Insert("insert into board(num, name, pass, subject, content, file1, regdate, readcnt, ref, reflevel, refstep) "
			+ "values(#{num}, #{name}, #{pass}, #{subject}, #{content}, #{fileurl}, now(), #{readcnt}, #{ref}, #{reflevel}, #{refstep})")
	void insert(Board board);

	@Update("update board set readcnt=readcnt+1 where num=#{value}")
	void addReadCnt(Integer num);

	@Update("update board set refstep = refstep+1 where ref = #{ref} and refstep > #{refstep}")
	void refStepAdd(Board board);

	@Update("update board set subject=#{subject}, content=#{content}, file1=#{fileurl}, regdate=now() where num = #{num}")
	void update(Board board);

	@Delete("delete from board where num=#{value}")
	void delete(Integer num);
}

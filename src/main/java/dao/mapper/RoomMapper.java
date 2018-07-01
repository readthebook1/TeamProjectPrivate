package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import logic.Member;
import logic.Room;

public interface RoomMapper {
	
	
	@Insert("insert into room (sno,srno) values(#{sNo},#{sRNo})")
	void insertRoom(Room room);

	
//	@Update("update userAccount set userName=#{userName}, phoneNo=#{phoneNo},"
//		+ " postcode=#{postcode}, address=#{address}, email=#{email}, birthDay=#{birthDay} where userId=#{userId}")
//	void update(User user);
//
//	@Delete("delete from userAccount where userId=#{value}")
//	void delete(String userId);
}

package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import logic.Reserve;

public interface ReserveMapper {
	
	@Insert("insert into reserve(reNo, id, srNo, reDate, RegDate, totPrice, reCnt, reStat) "
			+ "values(#{reNo}, #{id}, #{srNo}, #{reDate}, now(), #{totPrice}, #{reCnt}, 0)")
	void insert(Reserve reserve);

}

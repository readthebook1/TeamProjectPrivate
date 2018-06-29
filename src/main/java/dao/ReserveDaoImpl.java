package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import logic.Reserve;

@Repository
public class ReserveDaoImpl implements ReserveDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.ReserveMapper.";

	@Override
	public Reserve getReserve(Integer reNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("reNo", reNo);
		return sqlSession.selectOne(NS + "selectOne", map);
	}

	@Override
	public List<Reserve> getReserveList(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		return sqlSession.selectList(NS + "list", map);
	}

}

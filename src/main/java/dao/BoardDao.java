package dao;

import java.util.List;
import java.util.Map;

import logic.Board;

public interface BoardDao {

	int count(String searchType, String searchContent);

	List<Board> list(String searchType, String searchContent, Integer pageNum, int limit);

	Board getBoard(Integer num);

	void insert(Board board);

	int maxNum();

	void update(Board board);

	void delete(Integer num);

	List<Map<String,Object>>graph();

}


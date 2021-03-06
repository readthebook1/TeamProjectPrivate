package dao;

import java.util.List;

import logic.Reserve;

public interface ReserveDao {

	Reserve getReserve(Integer reNo);

	List<Reserve> getReserveList(String id);

	int count(String searchType, String searchContent);

	List<Reserve> list(String id, String searchType, String searchContent, Integer pageNum, int limit);

	void insert(Reserve reserve);

}

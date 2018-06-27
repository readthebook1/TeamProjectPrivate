package dao;

import logic.Member;

public interface MemberDao {
	Member select(String id);
}

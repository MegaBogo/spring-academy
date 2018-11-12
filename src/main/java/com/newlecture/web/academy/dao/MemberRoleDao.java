package com.newlecture.web.academy.dao;

import java.util.List;

import com.newlecture.web.academy.entity.MemberRole;

public interface MemberRoleDao {
	List<MemberRole> getListByMemberId(String memberId);
}

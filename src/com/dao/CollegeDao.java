package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.College;

public interface CollegeDao {

	List<College> getAll() throws SQLException;

}
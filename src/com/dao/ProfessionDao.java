package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.Profession;

public interface ProfessionDao {

	List<Profession> getAll() throws SQLException;

}
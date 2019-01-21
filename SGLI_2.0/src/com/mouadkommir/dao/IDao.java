package com.mouadkommir.dao;

import java.util.List;

public interface IDao {

	boolean insert(Object obj);
	boolean update(Object obj);
	boolean delete(Object obj);
	List<Object> select(Object obj);

}

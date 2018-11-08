package com.icss.hr.pic.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

/**
 * Í¼¿âservice
 * @author Administrator
 *
 */
public class PicService {
	
	private PicDao dao = new PicDao();

	public void addPic(Pic pic) throws SQLException {
		dao.insert(pic);
	}
	
	public void delPic(Integer picId) throws SQLException {
		dao.delete(picId);
	}
	
	public ArrayList<Pic> queryPicByPage(Pager pager) throws SQLException {
		return dao.queryByPage(pager);
	}
	
	public int getPicCount() throws SQLException {
		return dao.getCount();
	}
	
	public Pic queryPicById(Integer picId) throws SQLException {
		return dao.queryById(picId);
	}
}

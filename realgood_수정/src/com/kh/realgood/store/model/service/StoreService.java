package com.kh.realgood.store.model.service;

import static com.kh.realgood.common.DBCP.getConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.kh.realgood.member.model.dto.Member;
import com.kh.realgood.store.model.dao.StoreDAO;
import com.kh.realgood.store.model.dto.Store;
import com.kh.realgood.store.model.dto.StoreImg;

public class StoreService {
	private StoreDAO dao;
	
	public StoreService() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		dao = new StoreDAO();
	}
	public List<Store> searchAddr(String group, String addr) throws Exception {
		
		Connection conn = getConnection();
		// dao 호출
		List<Store> searchAddr = dao.searchAddr(conn, group, addr);
		
		// 커넥션 반환
		conn.close();
		
		return searchAddr;
	}
	/** 이미지 찾기
	 * @param addrArr
	 * @return
	 */
	public List<StoreImg> searchStoreImg(List<Store> addrArr) throws Exception {
		Connection conn = getConnection();
		
		List<StoreImg> imgList = dao.searchStoreImg(conn, addrArr);
		
		conn.close();
		
		return imgList;
	}
}

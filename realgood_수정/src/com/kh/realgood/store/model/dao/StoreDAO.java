package com.kh.realgood.store.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.realgood.member.model.dao.MemberDAO;
import com.kh.realgood.store.model.dto.Store;
import com.kh.realgood.store.model.dto.StoreImg;

public class StoreDAO {
	private Properties prop = null;

	public StoreDAO() throws FileNotFoundException, IOException {
		String fileName = MemberDAO.class.getResource("/com/kh/realgood/sql/store/store.properties").getPath();

		prop = new Properties();

		prop.load(new FileReader(fileName));
	}

	public List<Store> searchAddr(Connection conn, String group, String addr) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Store> list = null;
		String query = prop.getProperty("searchAddr");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, addr);
			pstmt.setString(2, group);

			rset = pstmt.executeQuery();
			Store store = null;
			list = new ArrayList<Store>();
			while (rset.next()) {
				store = new Store(rset.getInt("STORE_NUM"), rset.getString("COR_NUM"), rset.getString("NAME"),
						rset.getString("STORE_CONTENT"), rset.getString("STORE_TEL"), rset.getString("GROUP_NAME"),
						rset.getString("STORE_ADDR"), rset.getString("STORE_ZIP"), rset.getDate("ENROLL_DATE"));
				store.setStoreTitleImg(storeTitleImg(conn, store.getStoreNum()));
				list.add(store);
			}

		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
		}

		return list;
	}



	/** 가게 대표이미지 설정
	 * @param storeNum
	 * @return
	 */
	private String storeTitleImg(Connection conn, int storeNum) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String titleImg = null;
		String query = prop.getProperty("searchStoreTitleImg");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeNum);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				titleImg = rset.getString(1);
			} else {
				titleImg = "storeBaseImg.png";
			}
		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
		}
		
		return titleImg;
	}

	public List<StoreImg> searchStoreImg(Connection conn, List<Store> addrArr) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<StoreImg> imgList = null;
		String query = prop.getProperty("searchStoreImg");
		try {
			for (int i = 0; i < addrArr.size(); i++) {
				Store store = addrArr.get(i);

				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, store.getStoreNum());

				rset = pstmt.executeQuery();
				StoreImg storeImg = null;
				if(i == 0) imgList = new ArrayList<StoreImg>();
				while (rset.next()) {
					storeImg = new StoreImg(rset.getInt("S_IMG_NUM"), rset.getInt("S_STORE_NUM"), rset.getString("S_OIMG_NAME"),
							rset.getString("S_RIMG_NAME"), rset.getDate("S_ENROLL_DATE"));
					imgList.add(storeImg);
				}
			}
		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
		}

		return imgList;
	}
}

package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlsession;
	
	public List<GalleryVo> select(GalleryVo galleryVo){
		return sqlsession.selectList("gallery.selectList",galleryVo);
	}
	
	//이미지 등록하기
	public int insert(GalleryVo galleryVo) {
		
		return sqlsession.insert("gallery.insert",galleryVo);
	}
	
	
	public GalleryVo selectOne(int no){
		return sqlsession.selectOne("gallery.selectOne",no);
	}
	
	public int delete(int no) {
		return sqlsession.delete("gallery.delete",no);
	}
	
	public int count() {
		return sqlsession.selectOne("gallery.count");
	}
}

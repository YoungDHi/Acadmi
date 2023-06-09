package com.acadmi.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.acadmi.util.FileVO;
import com.acadmi.util.Pagination;

public interface BoardService {
	
	public List<BoardVO> getList(Pagination pagination) throws Exception;
		
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
			
	public int setInsert(BoardVO boardVO, MultipartFile [] multipartFiles) throws Exception;

	public int setUpdate(BoardVO boardVO, MultipartFile [] multipartFiles) throws Exception;
			
	public int setDelete(BoardVO boardVO) throws Exception;
		
	public FileVO getFileDetail(FileVO fileVO) throws Exception;
	
	public int setBoardFileDelete(FileVO fileVO) throws Exception;
	
	
}

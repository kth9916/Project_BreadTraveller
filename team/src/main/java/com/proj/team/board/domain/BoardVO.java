package com.proj.team.board.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.proj.team.board.common.utiletc;

import lombok.Data;

@Data
public class BoardVO {

    private String bgno;			
    private String brdno;   //
    private String brdtitle; //
    private String brdwriter; //
    private String brdmemo; //
    private String brddate; //
    private String brdhit; //
    private String brddeleteflag; 
    private String filecnt;
    private String replycnt;
    
    
    /* 첨부파일 */
    private List<MultipartFile> uploadfile;

    /**
     * 게시물 제목을 글자수에 맞추어 자르기.
     */
    public String getShortTitle(Integer len) {
        return utiletc.getShortString(brdtitle, len);
    }

    public String getBrdmemo() {
        return brdmemo.replaceAll("(?i)<script", "&lt;script");
    }

}

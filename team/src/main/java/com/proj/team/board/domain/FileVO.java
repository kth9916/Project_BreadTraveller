package com.proj.team.board.domain;

import lombok.Data;

@Data
public class FileVO {
    private Integer fileno; 
    private String parentPK;
    private String filename;
    private String realname;
    private long filesize;
    
    /**
     * 파일 크기를 정형화하기.
     */
    public String size2String() {
        Integer unit = 1024;
        if (filesize < unit) {
            return String.format("(%d B)", filesize);
        }
        int exp = (int) (Math.log(filesize) / Math.log(unit));

        return String.format("(%.0f %s)", filesize / Math.pow(unit, exp), "KMGTPE".charAt(exp - 1));
    }
   
    
}

package com.proj.team.board.domain;

import java.util.List;

import lombok.Data;

@Data
public class TreeVO {
    private String key;
    private String title;
    private String parent;
    private boolean isFolder;
    private List children;
    
 

    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }
   
}
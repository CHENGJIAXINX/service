package org.tio.sitexxx.im.common.bs;

import java.io.Serializable;

public class GroupNoticeReq implements Serializable {
    //是否置顶公告，预约
    private boolean isTop = false;
    //公告标题
    private String title;
    //公告内容
    private String content;

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;

public class YxFaceEmotionMsgVo implements Serializable {
    private Integer type;
    private String emotion;
    private int width;
    private int height;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

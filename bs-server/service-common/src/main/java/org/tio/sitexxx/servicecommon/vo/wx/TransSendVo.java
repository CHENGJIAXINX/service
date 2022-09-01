package org.tio.sitexxx.servicecommon.vo.wx;

public class TransSendVo {

//jsonObject.put("fromChatMode", chatMode);
//		jsonObject.put("fromBizId", bizid);
//		jsonObject.put("msgIds", msgIds);
//		jsonObject.put("title", title);
//		jsonObject.put("content", msgListContent.size() > 3 ? msgListContent.subList(0, 3): msgListContent);

    private byte fromChatMode;
    private String fromBizId;
    private String msgIds;
    private String title;
    private String content;

    public byte getFromChatMode() {
        return fromChatMode;
    }

    public void setFromChatMode(byte fromChatMode) {
        this.fromChatMode = fromChatMode;
    }

    public String getFromBizId() {
        return fromBizId;
    }

    public void setFromBizId(String fromBizId) {
        this.fromBizId = fromBizId;
    }

    public String getMsgIds() {
        return msgIds;
    }

    public void setMsgIds(String msgIds) {
        this.msgIds = msgIds;
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

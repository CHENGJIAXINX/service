package org.tio.sitexxx.im.server.handler.wx;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.tio.core.OnOfflineListener;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.server.Ims;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.utils.CommonUtils;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.utils.json.Json;

import java.util.Date;
import java.util.HashMap;

public class OnOffLineApi implements OnOfflineListener {
    private final static ChatService chatService = ChatService.me;

    public void notifyOnOff(String uid, boolean isOnline){
        User curr = UserService.ME.getById(uid);
        try {
            Ret ret = chatService.mailList(curr,(byte)1,null,null);
            HashMap<String, Object>  map = (HashMap<String, Object>) RetUtils.getOkData(ret);
            if (map == null){
                return;
            }
            if (!map.containsKey("fd")){
                return;
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msgType", 1);
            jsonObject.put("time", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("uid", uid);
            jsonObject1.put("isOnline", isOnline);
            jsonObject1.put("timestamp",System.currentTimeMillis());
            jsonObject.put("data", jsonObject1);

            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(map.get("fd")));
            for (int i = 0; i < jsonArray.size(); i++){
                JSONObject jsonObject2 = jsonArray.getJSONObject(i).getJSONObject("columns");
                Integer uid1 = jsonObject2.getInteger("uid");
                if (uid1 == null){
                    continue;
                }
                ImPacket imPacket = new ImPacket(Command.YxOnOffLinePush, Json.toJson(jsonObject));
                Ims.sendToUser(uid1, imPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onoff(boolean b, String s) {
        notifyOnOff(s, b);
    }
}

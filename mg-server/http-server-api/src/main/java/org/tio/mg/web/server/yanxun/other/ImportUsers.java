package org.tio.mg.web.server.yanxun.other;

import cn.hutool.core.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.base.UserService;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.service.yxnxun.other.ImportUsersService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.io.File;
import java.util.*;

@RequestPath(value = "/importUsers")
public class ImportUsers {

    private static Logger log = LoggerFactory.getLogger(ImportUsers.class);
    private static final UserService userService = UserService.ME;

    @RequestPath(value = "/add")
    public Resp importUsers(HttpRequest request,String path) throws Exception{
        if(StrUtil.isBlank(path)){
            return Resp.fail("文件路径不可未空");
        }
        String path1 = Const.RES_ROOT+path;
        log.warn("导入用户文件地址：{}",path1);

//        FileReader reader = new FileReader(root+url,"utf-8");
//        List<String> fileContent = reader.readLines();
//        log.info(fileContent.toString());
        File file = FileUtil.file(path1);
        if(file==null){
            return Resp.fail("文件不存在");
        }
        String extName = FileUtil.extName(file);
        if(!Objects.equals(extName,"txt")){
            return Resp.fail("文件类型不匹配");
        }

        List<String> fileContent = FileUtil.readUtf8Lines(file);
        if(fileContent==null){
            return Resp.fail("文件内容为空，请重新上传");
        }
        Ret ret = ImportUsersService.ME.addUsers(fileContent,request.getClientIp());
        if (ret.isFail()){
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request),"批量导入用户",
                        MgConst.OperLogTypes.add,
                        "批量导入用户");
            }
        }).start();
        return Resp.ok(RetUtils.getRetMsg(ret));
    }




}

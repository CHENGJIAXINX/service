package org.tio.mg.web.server.controller.mg;

import cn.hutool.core.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.UploadFile;
import org.tio.http.server.annotation.RequestPath;
import org.tio.mg.service.model.main.File;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.web.server.utils.UploadUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.resp.Resp;

import java.util.ArrayList;
import java.util.List;

/**
 * 公共请求控制器
 */
@RequestPath(value = "/common")
public class CommonController {

    private static Logger log = LoggerFactory.getLogger(CommonController.class);

    /**
     * 单个文件上传
     *
     * @param request
     * @param uploadFile
     * @param type
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/file")
    public Resp file(HttpRequest request, UploadFile uploadFile, Byte type) throws Exception {
        try {
            if (uploadFile == null) {
                return Resp.fail("上传信息为空");
            }
            File dbFile = innerUploadFile(uploadFile, type);
            return Resp.ok(dbFile);
        } catch (Exception e) {
            log.error(e.toString(), e);
            return Resp.fail(RetUtils.SYS_ERROR);
        }
    }

    /**
     * 多文件上传
     *
     * @param request
     * @param uploadFile
     * @param type
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/files")
    public Resp files(HttpRequest request, UploadFile[] uploadFile, Byte type) throws Exception {
        try {
            if (uploadFile == null || uploadFile.length <= 0) {
                return Resp.fail("上传信息为空");
            }
            List<File> dbFiles = new ArrayList<>();
            for (UploadFile file : uploadFile) {
                File dbFile = innerUploadFile(file, type);
                dbFiles.add(dbFile);
            }
            return Resp.ok(dbFiles);
        } catch (Exception e) {
            log.error(e.toString(), e);
            return Resp.fail(RetUtils.SYS_ERROR);
        }
    }

    /**
     * 文件上传的具体实现
     *
     * @param uploadFile
     * @param type
     * @return
     * @throws Exception
     */
    private File innerUploadFile(UploadFile uploadFile, Byte type) throws Exception {
        byte[] bs = uploadFile.getData();
        String filename = uploadFile.getName();
        String ext = FileUtil.extName(filename);
        String urlWithoutExt = UploadUtils.newFile(UploadUtils.mgSubDir(type), -type, filename); //不带后缀的文件路径
        String url = urlWithoutExt + "." + ext;
        java.io.File file = new java.io.File(Const.RES_ROOT, url);
        FileUtil.writeBytes(bs, file);
        File dbFile = new File();
        dbFile.setExt(ext);
        dbFile.setFilename(uploadFile.getName());
        dbFile.setSize((long) bs.length);
        dbFile.setUid(-type);
        dbFile.setUrl(url);
        dbFile.save();
        return dbFile;
    }

}

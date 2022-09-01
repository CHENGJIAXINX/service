package org.tio.mg.service.vo;

import org.tio.mg.service.model.conf.YxConf;

import java.io.Serializable;
import java.util.List;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/9/11
 * @updateTIme :
 */
public class ConfigAllSaveVo implements Serializable {

    private static final long serialVersionUID = -4723738416587171465L;

    private Byte confType;

    private List<YxConf> confs;

    public Byte getConfType() {
        return confType;
    }

    public void setConfType(Byte confType) {
        this.confType = confType;
    }

    public List<YxConf> getConfs() {
        return confs;
    }

    public void setConfs(List<YxConf> confs) {
        this.confs = confs;
    }
}

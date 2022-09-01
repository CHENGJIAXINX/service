package org.tio.mg.service.vo;

import cn.hutool.core.io.FileUtil;
import org.tio.utils.jfinal.P;

/**
 * @author xufei
 * 2020年5月26日 上午10:35:25
 */
public class MgConst {

    public static final String RESOURCE_PATH = FileUtil.getAbsolutePath("classpath:");

    /**
     * 上传资源服务器存放上传文件的根目录
     */
    public static final String RES_ROOT = P.get("res.root");

    public static final String BS_SITE = P.get("bs.site");


    public static final String VIEW_PAGE_ROOT = P.get("http.view.page");

    /**
     * 服务器的IP地址或域名
     */
    public static final String MY_IP = P.get("my.ip");

    /**
     * 发票报销excel模板
     */
    public static final String INVOICE_EXCEL_TEMPLATE = P.get("invoice.excel.template");

    public static String MG_USER_DEFAULT_PWD = "888888";

    public interface AccessToken {
        /**
         * 存令牌(access_token)的cookie name
         */
        String COOKIENAME_FOR_ACCESSTOKEN = "tio_mg_access_token";
    }

    public interface Http {
        String SESSION_COOKIE_NAME = P.get("http.session.cookie.name", "tio_mg_session");
    }

    public interface BsToken {
        String TOKEN = "TioYanXunKeymqpad";
    }

    public interface Db {
        /**
         * tio_site_main数据库
         */
        String TIO_SITE_MAIN = "tio_site_main";
        /**
         * tio_site_stat数据库
         */
        String TIO_SITE_STAT = "tio_site_stat";
        /**
         * tio_site_conf数据库
         */
        String TIO_SITE_CONF = "tio_site_conf";
        /**
         * tio_site_mg数据库
         */
        String TIO_MG = "tio_mg";
    }

    /**
     * @author xufei
     * 2020年5月28日 下午3:01:10
     */
    public interface ConfMapping {
        /**
         * 管理后台vue根路由
         */
        String MG_VUE_ROOT_PATH = "mg.vue.root.path";

        /**
         * 管理后台vue根组件页面
         */
        String MG_VUE_ROOT_COMPONENT = "mg.vue.root.component";

        /**
         * 管理后台菜单同步网站
         */
        String MG_MENU_SYSN_SITE = "mg.menu.sysn.site";
    }

    /**
     * 操作日志标识
     */
    public interface OperLogType {
        /**
         * 菜单
         */
        byte MENU = 1;

        /**
         * 操作
         */
        byte OPER = 2;

        /**
         * 系统
         */
        Byte SYS = 3;
    }

    public interface OperLogTypes {
        /**
         * 菜单
         */
        byte add = 1;

        /**
         * 操作
         */
        byte update = 2;

        /**
         * 系统
         */
        Byte del = 3;

        Byte disable = 4;

        Byte rest = 5;
    }


    public interface AuthIndexType {
        /**
         * 菜单
         */
        byte change = 1;

        /**
         * 操作
         */
        byte index = 2;

        /**
         * 系统
         */
        Byte SYS = 3;
    }

    /**
     * 权限类型
     *
     * @author xufei
     * 2020年5月27日 上午11:16:15
     */
    public interface AuthType {
        /**
         * 菜单
         */
        byte MENU = 1;

        /**
         * 页面
         */
        byte PAGE = 2;

        /**
         * 操作
         */
        byte OPER = 3;

    }

    /**
     * 后台系统配置映射
     *
     * @author xufei
     * 2020年7月7日 下午3:42:34
     */
    public interface MgConfMapping {
        /**
         * 最近打开页面大小
         */
        String RECENT_PAGE_SIZE = "recent.page.size";

        /**
         * 收藏页面大小
         */
        String FAVORITE_PAGE_SIZE = "favorite.page.size";
    }

    /**
     * @author xufei
     * 2020年5月26日 下午3:11:20
     */
    public interface MgUserStatus {
        /**
         * 正常
         */
        byte NORMAL = 1;

        /**
         * 封停
         */
        byte INBLACK = 5;

        /**
         * 注销
         */
        byte LOGOUT = 6;
    }

    /**
     * APP类型
     *
     * @author xufei
     * 2020年6月28日 下午5:33:36
     */
    public interface AppType {
        /**
         * 安卓
         */
        byte ANDROID = 1;

        /**
         * ios
         */
        byte IOS = 2;
    }

    /**
     * 后台上传路径
     *
     * @author xufei
     * 2020年6月18日 上午10:11:06
     */
    public interface MgUploadDir {

        String DEFAULT_DIR = "mg/default";

        /**
         * 招聘企业log
         */
        byte RECRUIT_CMP_LOGO = 1;

        String RECRUIT_CMP_LOGO_DIR = "recruit/cmp/logo";

        /**
         * 订单电子合同
         */
        byte ORDER_CONTRACT = 2;

        String ORDER_CONTRACT_DIR = "order/contract";

        /**
         * app文件包
         */
        byte APP_FILE = 3;

        String APP_FILE_DIR = "app/file";

        /**
         * 后台发票路径
         */
        String MG_INVOICE_DIR = "mg/reimbursement";
    }

}

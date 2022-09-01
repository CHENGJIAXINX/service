package org.tio.mg.web.server.utils;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.UploadFile;
import org.tio.mg.service.model.main.Img;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author tanyaowu
 *
 */
public class ImgUtils {
    private static Logger log = LoggerFactory.getLogger(ImgUtils.class);
    /**
     * @deprecated 这个方法暂时执行不了
     * @param srcImg
     * @param desImg
     * @param scale
     * @author tanyaowu
     */
    public static void scale(String srcImg, String desImg, double scale) {
        Mat src = Imgcodecs.imread(srcImg);
        Mat dst = src.clone();
        Imgproc.resize(src, dst, new Size(src.width() * scale, src.height() * scale));
        Imgcodecs.imwrite(desImg, dst);
    }

    public static void scale(String srcImg, String desImg, double scale, double quality) throws Exception {
        Thumbnails.of(srcImg).scale(scale) //指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽
                .outputQuality(quality) //图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差
                .toFile(desImg);
    }

    static long c = 0;

    /**
     * @param args
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String rootPath = "F:\\work\\tio-site\\some\\技术白皮书";
        List<File> files = FileUtil.loopFiles(rootPath, new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                String ext = FileUtil.extName(pathname);
                if (ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg")) {
                    if (pathname.getName().startsWith("scaled_")) {
                        return false;
                    }
                    return true;
                }
                return false;
            }

        });
        int size = 1080;
        for (File file : files) {
            try {
                byte[] imageBytes = FileUtil.readBytes(file);
                BufferedImage bi = ImgUtil.toImage(imageBytes);
                if (bi.getWidth() <= size) {
                    //					System.out.println(c++ + "..");
                    continue;
                }

                float scale = ImgUtils.calcScaleWithWidth(size, bi);
                String imgFilePath = file.getCanonicalPath();
                File desFile = new File(file.getParent(), "scaled_" + scale + "_" + file.getName());
                String smImgFilePath = desFile.getCanonicalPath();

                //				scale(imgFilePath, smImgFilePath, scale);

                //				Img img = ImgUtils.processImg(bi, imgFilePath, smImgFilePath, scale);
                //				log.error(c++ + "、新size:{}, 文件:{}", img.getSize(), imgFilePath);

                Thumbnails.of(imgFilePath).scale(scale) //指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽
                        .outputQuality(0.8f) //图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差
                        .toFile(smImgFilePath);

            } catch (Exception e) {
                try {
                    log.error(file.getCanonicalPath(), e);
                } catch (IOException e1) {
                    log.error(e1.toString(), e1);
                }
            }
        }

    }

    /**
     * 用目标宽度计算缩放比
     * @param maxWidth
     * @param initBufferedImage
     * @return
     */
    public static float calcScaleWithWidth(int maxWidth, BufferedImage initBufferedImage) {
        int initWidth = initBufferedImage.getWidth();
        int newWidth = Math.min(maxWidth, initWidth);
        return (float) newWidth / (float) initWidth;
    }

    /**
     * 用目标高度计算缩放比
     * @param maxHeight
     * @param initBufferedImage
     * @return
     */
    public static float calcScaleWithHeight(int maxHeight, BufferedImage initBufferedImage) {
        int initHeight = initBufferedImage.getHeight();
        int newHeight = Math.min(maxHeight, initHeight);
        return (float) newHeight / (float) initHeight;
    }

    /**
     *
     * @param subDir BlogController.SUBDIR_IMG
     * @param uid
     * @param uploadFile
     * @param scale
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    public static Img processImg(String subDir, Integer uid, UploadFile uploadFile, float scale) throws Exception {
        String ext = FileUtil.extName(uploadFile.getName());
        if (StrUtil.isBlank(ext)) {
            ext = "gif";
        }
        boolean needScale = !"gif".equals(ext); //gif的不压缩

        String imgUrlWithoutExt = UploadUtils.newFile(subDir, uid, uploadFile.getName()); //不带后缀的文件路径

        String imgUrl = imgUrlWithoutExt + "." + ext;
        String smImgUrl = null;

        byte[] imgBytes = uploadFile.getData();

        if (needScale) {
            smImgUrl = imgUrlWithoutExt + "_sm." + ext;
        } else {
            smImgUrl = imgUrl;
        }

        String imgFilePath = Const.RES_ROOT + imgUrl; //文件路径
        String smImgFilePath = Const.RES_ROOT + smImgUrl;

        File imgFile = new File(imgFilePath);
        FileUtil.mkParentDirs(imgFilePath);
        File smImgFile = null;
        if (needScale) {
            smImgFile = new File(smImgFilePath);
            FileUtil.mkParentDirs(smImgFile);
        } else {
            smImgFile = imgFile;
        }

        BufferedImage bi = ImgUtil.toImage(imgBytes);

        Img img = new Img();
        if (needScale) {
            double quality = 0.5f;
            Thumbnails.of(bi).scale(1f) //指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽
                    .outputQuality(quality) //图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差
                    .toFile(imgFilePath);
            if (scale < 1f) {
                Thumbnails.of(bi).scale(scale).outputQuality(quality).toFile(smImgFilePath);
            } else {
                FileUtil.copy(imgFilePath, smImgFilePath, true);
            }
        } else {
            FileUtil.writeBytes(imgBytes, imgFile);
        }

        BufferedImage smBi = ImgUtil.read(smImgFile);
        img.setCoverheight(smBi.getHeight());
        img.setCoversize((int) FileUtil.size(smImgFile));
        img.setCoverwidth(smBi.getWidth());

        img.setCoverurl(smImgUrl);
        img.setUrl(imgUrl);

        img.setUid(uid);

        String filename = uploadFile.getName();//FileUtil.getName(imgFile);
        img.setFilename(filename);
        img.setHeight(bi.getHeight());
        img.setWidth(bi.getWidth());
        img.setSize(FileUtil.size(imgFile));

        img.setTitle(filename);

        return img;
    }


    /**
     * @param subDir
     * @param uploadFile
     * @return
     * @throws Exception
     * @author xufei
     * 2020年1月14日 下午4:21:45
     */
    public static Img processImg(String subDir, UploadFile uploadFile) throws Exception {
        String ext = FileUtil.extName(uploadFile.getName());
        if (StrUtil.isBlank(ext)) {
            ext = "gif";
        }
        String imgUrlWithoutExt = UploadUtils.dateFile(subDir); //不带后缀的文件路径
        String imgUrl = imgUrlWithoutExt + "." + ext;
        byte[] imgBytes = uploadFile.getData();
        String imgFilePath = Const.RES_ROOT + imgUrl; //文件路径
        File imgFile = new File(imgFilePath);
        FileUtil.mkParentDirs(imgFilePath);
        BufferedImage bi = ImgUtil.toImage(imgBytes);
        Img img = new Img();
        FileUtil.writeBytes(imgBytes, imgFile);
        img.setCoverheight(bi.getHeight());
        img.setCoversize((int) FileUtil.size(imgFile));
        img.setCoverwidth(bi.getWidth());
        img.setCoverurl(imgUrl);
        img.setUrl(imgUrl);
        img.setUid(null);
        String filename = uploadFile.getName();//FileUtil.getName(imgFile);
        img.setFilename(filename);
        img.setHeight(bi.getHeight());
        img.setWidth(bi.getWidth());
        img.setSize(FileUtil.size(imgFile));
        img.setTitle(filename);
        return img;
    }

}

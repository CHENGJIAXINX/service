package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;

public class YxLocationMsgVo implements Serializable {
    private String lat;
    private String lng;
    private String address;

    private String title;
    private String filename;
    private String url;
    private int comefrom;
    private int width;
    private int height;
    private long size;
    private String coverurl;
    private int coverwidth;
    private int coverheight;
    private long coversize;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getComefrom() {
        return comefrom;
    }

    public void setComefrom(int comefrom) {
        this.comefrom = comefrom;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }

    public int getCoverwidth() {
        return coverwidth;
    }

    public void setCoverwidth(int coverwidth) {
        this.coverwidth = coverwidth;
    }

    public int getCoverheight() {
        return coverheight;
    }

    public void setCoverheight(int coverheight) {
        this.coverheight = coverheight;
    }

    public long getCoversize() {
        return coversize;
    }

    public void setCoversize(long coversize) {
        this.coversize = coversize;
    }
}

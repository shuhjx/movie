package com.shuh.mydemo1.model;

import com.google.gson.annotations.SerializedName;
import com.shuh.commonlib.adapter.CommonRecyclerAdapter;

/**
 * Created by pc-135 on 2017/11/20.
 */

public class Movie extends CommonRecyclerAdapter.BaseModel {

    /**
     * showInfo : 今天182家影院放映2821场
     * late : false
     * sn : 0
     * cnms : 0
     * scm :
     * imax : true
     * snum : 114171
     * img : http://p1.meituan.net/165.220/movie/b9395cd202a461303cf06cea89292071556090.png
     * src :
     * showDate :
     * pn : 283
     * preSale : 0
     * vd :
     * dir : 扎克·施奈德
     * star : 本·阿弗莱克,亨利·卡维尔,盖尔·加朵
     * cat : 动作,冒险,科幻
     * wish : 176293
     * 3d : true
     * nm : 正义联盟
     * sc : 8.6
     * ver : 3D/IMAX 3D/中国巨幕/全景声
     * rt : 2017-11-17上映
     * dur : 120
     * time :
     * id : 341195
     */

    private String showInfo;
    private boolean late;
    private int sn;
    private int cnms;
    private String scm;
    private boolean imax;
    private int snum;
    private String img;
    private String src;
    private String showDate;
    private int pn;
    private int preSale;
    private String vd;
    private String dir;
    private String star;
    private String cat;
    private int wish;
    @SerializedName("3d")
    private boolean _$3d;
    private String nm;
    private double sc;
    private String ver;
    private String rt;
    private int dur;
    private String time;
    private int id;

    public String getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(String showInfo) {
        this.showInfo = showInfo;
    }

    public boolean isLate() {
        return late;
    }

    public void setLate(boolean late) {
        this.late = late;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public int getCnms() {
        return cnms;
    }

    public void setCnms(int cnms) {
        this.cnms = cnms;
    }

    public String getScm() {
        return scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

    public boolean isImax() {
        return imax;
    }

    public void setImax(boolean imax) {
        this.imax = imax;
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public int getPreSale() {
        return preSale;
    }

    public void setPreSale(int preSale) {
        this.preSale = preSale;
    }

    public String getVd() {
        return vd;
    }

    public void setVd(String vd) {
        this.vd = vd;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getWish() {
        return wish;
    }

    public void setWish(int wish) {
        this.wish = wish;
    }

    public boolean is_$3d() {
        return _$3d;
    }

    public void set_$3d(boolean _$3d) {
        this._$3d = _$3d;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public double getSc() {
        return sc;
    }

    public void setSc(double sc) {
        this.sc = sc;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public int getDur() {
        return dur;
    }

    public void setDur(int dur) {
        this.dur = dur;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "showInfo='" + showInfo + '\'' +
                ", cnms=" + cnms +
                ", img='" + img + '\'' +
                ", time='" + time + '\'' +
                ", id=" + id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}

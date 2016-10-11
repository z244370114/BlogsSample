package com.zy.blogs.blogssample.model;

import java.io.Serializable;
import java.util.List;

/**
 * <p/>
 * 作者：zhouyuan on  2016/10/11 15:09
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class GankModel implements Serializable {

    /**
     * error : false
     * results : [{"_id":"57f0e616421aa95ddb9cb577","createdAt":"2016-10-02T18:48:54.166Z","desc":"又一个LowPoly图片, 另外这个还可以让图片变成沙画","images":["http://img.gank.io/4b93fe53-bb4f-4dfb-b058-4fc7aebdedce","http://img.gank.io/917ce961-f026-4bdf-9f36-7877709805cd"],"publishedAt":"2016-10-11T11:42:22.814Z","source":"web","type":"Android","url":"https://github.com/xyzxqs/XLowPoly","used":true,"who":"xyzxqs"},{"_id":"57fb0f38421aa95dd351b0ef","createdAt":"2016-10-10T11:47:04.29Z","desc":"豆瓣的混合开发框架 -- Rexxar","publishedAt":"2016-10-11T11:42:22.814Z","source":"chrome","type":"Android","url":"https://github.com/douban/rexxar-android","used":true,"who":"wuzheng"},{"_id":"57fb4987421aa95dd351b0f2","createdAt":"2016-10-10T15:55:51.411Z","desc":"当Rxjava遇上databinding","images":["http://img.gank.io/1a9db224-2809-4fca-bfb9-22d467bfe07e"],"publishedAt":"2016-10-11T11:42:22.814Z","source":"chrome","type":"Android","url":"https://github.com/TangoAgency/android-data-binding-rxjava","used":true,"who":"有时放纵"},{"_id":"57fc4248421aa95de3b8ab7c","createdAt":"2016-10-11T09:37:12.796Z","desc":"支持自动高亮关键字的 TextView，很实用。","images":["http://img.gank.io/1296065e-d8a3-4edc-8d70-ce9e5bdfe79b"],"publishedAt":"2016-10-11T11:42:22.814Z","source":"chrome","type":"Android","url":"https://github.com/wangshaolei/UnderLineLinkTextView","used":true,"who":"机器人"},{"_id":"57f9fb7e421aa95dd78e8dc5","createdAt":"2016-10-09T16:10:38.710Z","desc":"跨平台(Android,iOS,web)的 IM 开源项目","publishedAt":"2016-10-10T11:41:33.500Z","source":"web","type":"Android","url":"https://github.com/sealtalk/sealtalk-android","used":true,"who":"AMing"},{"_id":"57facd09421aa95dd351b0e6","createdAt":"2016-10-10T07:04:41.740Z","desc":"Android 指纹识别身份验证 Demo 一例","images":["http://img.gank.io/3a5366c2-fd48-4706-b8a6-2f60f04189ab","http://img.gank.io/e1c8a695-9095-4997-a113-90c627657be7"],"publishedAt":"2016-10-10T11:41:33.500Z","source":"chrome","type":"Android","url":"https://github.com/pro100svitlo/FingerprintAuthHelper","used":true,"who":"机器人"},{"_id":"57facd2f421aa95dd351b0e7","createdAt":"2016-10-10T07:05:19.450Z","desc":"一款漂亮的 Bottom Sheet 选择器","images":["http://img.gank.io/6a097553-00d2-4895-86f9-12af888681a9"],"publishedAt":"2016-10-10T11:41:33.500Z","source":"chrome","type":"Android","url":"https://github.com/philliphsu/BottomSheetPickers","used":true,"who":"机器人"},{"_id":"57faed42421aa95dd351b0e8","createdAt":"2016-10-10T09:22:10.810Z","desc":"一个别致的环形菜单","images":["http://img.gank.io/d4baf374-f8a1-4b39-bf55-b087abf0bf34"],"publishedAt":"2016-10-10T11:41:33.500Z","source":"web","type":"Android","url":"https://github.com/Hitomis/CircleMenu","used":true,"who":"Hitomi"},{"_id":"57fb0c82421aa95de3b8ab71","createdAt":"2016-10-10T11:35:30.877Z","desc":"带有动态效果的表单引导进度条。","images":["http://img.gank.io/dcfcdf95-22e1-41dc-8fb8-a921f4a6e42d"],"publishedAt":"2016-10-10T11:41:33.500Z","source":"chrome","type":"Android","url":"https://github.com/VictorAlbertos/BreadcrumbsView","used":true,"who":"机器人"},{"_id":"57f3e181421aa95ddb9cb57d","createdAt":"2016-10-05T01:06:09.944Z","desc":"一个通用状态切换视图","images":["http://img.gank.io/58cec842-0078-4be1-986b-ebc9895a6e80"],"publishedAt":"2016-10-09T11:45:38.236Z","source":"web","type":"Android","url":"https://github.com/XuDaojie/MultiStateView","used":true,"who":null}]
     */

    private boolean error;
    /**
     * _id : 57f0e616421aa95ddb9cb577
     * createdAt : 2016-10-02T18:48:54.166Z
     * desc : 又一个LowPoly图片, 另外这个还可以让图片变成沙画
     * images : ["http://img.gank.io/4b93fe53-bb4f-4dfb-b058-4fc7aebdedce","http://img.gank.io/917ce961-f026-4bdf-9f36-7877709805cd"]
     * publishedAt : 2016-10-11T11:42:22.814Z
     * source : web
     * type : Android
     * url : https://github.com/xyzxqs/XLowPoly
     * used : true
     * who : xyzxqs
     */
    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    private List<GankModel> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<GankModel> getResults() {
        return results;
    }

    public void setResults(List<GankModel> results) {
        this.results = results;
    }
}

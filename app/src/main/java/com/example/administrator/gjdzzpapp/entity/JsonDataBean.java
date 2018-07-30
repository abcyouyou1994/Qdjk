package com.example.administrator.gjdzzpapp.entity;

import java.util.List;

/**
 * Created by dingchao on 2018/3/23.
 */

public class JsonDataBean {

    public JsonDataBean() {
    }

    public JsonDataBean(String home_shopnewnum, String home_shopline, String home_people, List<HomeImgurlBean> home_imgurl, List<HomeH5urlBean> home_h5url, List<HomeNewsBean> home_news, List<HomeShoplistBean> home_shoplist) {
        this.home_shopnewnum = home_shopnewnum;
        this.home_shopline = home_shopline;
        this.home_people = home_people;
        this.home_imgurl = home_imgurl;
        this.home_h5url = home_h5url;
        this.home_news = home_news;
        this.home_shoplist = home_shoplist;
    }

    /**
     * home_imgurl : [{"imgId":1,"imgUrl":"http://img4.duitang.com/uploads/item/201403/27/20140327114737_w3uA3.jpeg"},{"imgId":1,"imgUrl":"http://img4.duitang.com/uploads/item/201403/27/20140327114737_w3uA3.jpeg"},{"imgId":1,"imgUrl":"http://img4.duitang.com/uploads/item/201403/27/20140327114737_w3uA3.jpeg"},{"imgId":1,"imgUrl":"http://img4.duitang.com/uploads/item/201403/27/20140327114737_w3uA3.jpeg"}]
     * home_h5url : [{"url":"暂定"}]
     * home_news : [{"newsId":1,"newUrl":"http://192.168.1.197/web/upH5/consult.html?id=123&url=2"},{"newsId":1,"newUrl":"http://192.168.1.197/web/upH5/consult.html?id=123&url=2"},{"newsId":1,"newUrl":"http://192.168.1.197/web/upH5/consult.html?id=123&url=2"}]
     * home_shoplist : [{"shopId":1,"shopImgUrl":"http://up.enterdesk.com/edpic_source/e2/37/f1/e237f1f737e24dc0dbd6030a22b72005.jpg","shopName":"朝阳-双井|100㎡","shopAddress":"广平门黄平路平米","shopTags":[{"tag":"随便四字"},{"tag":"临近地铁"},{"tag":"最多四字"}],"shopMonery":"8000","shopMoneryUnit":"元/月"},{"shopId":1,"shopImgUrl":"http://up.enterdesk.com/edpic_source/e2/37/f1/e237f1f737e24dc0dbd6030a22b72005.jpg","shopName":"朝阳-双井|100㎡","shopAddress":"广平门黄平路平米","shopTags":[{"tag":"随便四字"},{"tag":"临近地铁"},{"tag":"最多四字"}],"shopMonery":"5.5","shopMoneryUnit":"万/月"}]
     * home_shopnewnum : 814
     * home_shopline : 77847
     * home_people : 20173
     */

    private String home_shopnewnum;
    private String home_shopline;
    private String home_people;
    private List<HomeImgurlBean> home_imgurl;
    private List<HomeH5urlBean> home_h5url;
    private List<HomeNewsBean> home_news;
    private List<HomeShoplistBean> home_shoplist;

    public String getHome_shopnewnum() {
        return home_shopnewnum;
    }

    public void setHome_shopnewnum(String home_shopnewnum) {
        this.home_shopnewnum = home_shopnewnum;
    }

    public String getHome_shopline() {
        return home_shopline;
    }

    public void setHome_shopline(String home_shopline) {
        this.home_shopline = home_shopline;
    }

    public String getHome_people() {
        return home_people;
    }

    public void setHome_people(String home_people) {
        this.home_people = home_people;
    }

    public List<HomeImgurlBean> getHome_imgurl() {
        return home_imgurl;
    }

    public void setHome_imgurl(List<HomeImgurlBean> home_imgurl) {
        this.home_imgurl = home_imgurl;
    }

    public List<HomeH5urlBean> getHome_h5url() {
        return home_h5url;
    }

    public void setHome_h5url(List<HomeH5urlBean> home_h5url) {
        this.home_h5url = home_h5url;
    }

    public List<HomeNewsBean> getHome_news() {
        return home_news;
    }

    public void setHome_news(List<HomeNewsBean> home_news) {
        this.home_news = home_news;
    }

    public List<HomeShoplistBean> getHome_shoplist() {
        return home_shoplist;
    }

    public void setHome_shoplist(List<HomeShoplistBean> home_shoplist) {
        this.home_shoplist = home_shoplist;
    }

    public static class HomeImgurlBean {
        /**
         * imgId : 1
         * imgUrl : http://img4.duitang.com/uploads/item/201403/27/20140327114737_w3uA3.jpeg
         */

        private int imgId;
        private String imgUrl;

        public int getImgId() {
            return imgId;
        }

        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }

    public static class HomeH5urlBean {
        /**
         * url : 暂定
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class HomeNewsBean {
        /**
         * newsId : 1
         * newUrl : http://192.168.1.197/web/upH5/consult.html?id=123&url=2
         */

        private int newsId;
        private String newUrl;
        private String newMsg;

        public String getNewMsg() {
            return newMsg;
        }

        public void setNewMsg(String newMsg) {
            this.newMsg = newMsg;
        }

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public String getNewUrl() {
            return newUrl;
        }

        public void setNewUrl(String newUrl) {
            this.newUrl = newUrl;
        }
    }

    public static class HomeShoplistBean {
        /**
         * shopId : 1
         * shopImgUrl : http://up.enterdesk.com/edpic_source/e2/37/f1/e237f1f737e24dc0dbd6030a22b72005.jpg
         * shopName : 朝阳-双井|100㎡
         * shopAddress : 广平门黄平路平米
         * shopTags : [{"tag":"随便四字"},{"tag":"临近地铁"},{"tag":"最多四字"}]
         * shopMonery : 8000
         * shopMoneryUnit : 元/月
         */

        private int shopId;
        private String shopImgUrl;
        private String shopName;
        private String shopAddress;
        private String shopMonery;
        private String shopMoneryUnit;
        private List<ShopTagsBean> shopTags;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopImgUrl() {
            return shopImgUrl;
        }

        public void setShopImgUrl(String shopImgUrl) {
            this.shopImgUrl = shopImgUrl;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopAddress() {
            return shopAddress;
        }

        public void setShopAddress(String shopAddress) {
            this.shopAddress = shopAddress;
        }

        public String getShopMonery() {
            return shopMonery;
        }

        public void setShopMonery(String shopMonery) {
            this.shopMonery = shopMonery;
        }

        public String getShopMoneryUnit() {
            return shopMoneryUnit;
        }

        public void setShopMoneryUnit(String shopMoneryUnit) {
            this.shopMoneryUnit = shopMoneryUnit;
        }

        public List<ShopTagsBean> getShopTags() {
            return shopTags;
        }

        public void setShopTags(List<ShopTagsBean> shopTags) {
            this.shopTags = shopTags;
        }

        public static class ShopTagsBean {
            /**
             * tag : 随便四字
             */

            private String tag;

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }
    }
}


package com.zy.blogs.blogssample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GWDatas implements Serializable {

    public static String GWDatas_tag = "GWDatas";
    public static String GWDatas_id = "id";
    /**
     *
     */
    private static final long serialVersionUID = 2904619327511024202L;
    private long timeTag;
    private int total_nums;

    private ArrayList<GWDatas> data;
    private ArrayList<GrouponInfoEntity> discount_info;
    private String valued;
    private String visibility;
    private String releaseNum;

    private String supplier_discounts;
    private String area_code_id;

    private String id;
    private String title;
    private String rights;
    private String price;
    private String orig_price;
    private String max_nums;
    private String start_time;
    private String end_time;
    private String usable_time;
    private String desc_content;
    private String cover_img;
    private String url_address;
    private String status;
    private String is_deleted;
    private String is_top;
    private String how_to_use;
    private int sold_out;
    private String area_code;
    private String info_username;
    private String info_mobile;
    private String info_station;
    private String info_station_config;
    private String info_address;
    private String info_area;
    private String info_plantime;
    private String hit;
    private String activity_address;
    private String activity_phone;
    private String activity_time;
    private String activity_progress;
    private String topic;
    private String discount_rate;
    private String display_uniqid;
    private String qrcode;
    private String goods_ids;
    private String supplier_ids;
    private int is_released_to_user;
    private int num;
    private ArrayList<GoodsInfo> goods_info;
    private String current_time;
    private int height;
    private String cover_img_top;
    private String benefit_addres;
    private String mobile;
    private String activity_desc;
    private String activity_prize;
    private String activity_url;
    private String views;
    private String is_new;
    private String is_official;


    /**
     * 倒计时字段
     */
    private String over;

    private String type;
    private String typeid;
    private List<String> benefit_address_arr;

    public List<String> getBenefit_address_arr() {
        return benefit_address_arr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeid() {
        return typeid;
    }

    public String getOver() {
        return over;
    }

    public String getIs_new() {
        return is_new;
    }

    public String getIs_official() {
        return is_official;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCover_img_top() {
        return cover_img_top;
    }

    public ArrayList<GoodsInfo> getGoods_info() {
        return goods_info;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getInfo_username() {
        return info_username;
    }

    public String getInfo_mobile() {
        return info_mobile;
    }

    public String getInfo_station() {
        return info_station;
    }

    public String getInfo_station_config() {
        return info_station_config;
    }

    public String getInfo_address() {
        return info_address;
    }

    public String getInfo_area() {
        return info_area;
    }

    public String getInfo_plantime() {
        return info_plantime;
    }

    public String getDiscount_rate() {
        return discount_rate;
    }

    public String getReleaseNum() {
        long temp = Long.valueOf(max_nums) - Long.valueOf(num);
        return String.valueOf(temp);
    }

    public String getValued() {
        return valued;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public ArrayList<GrouponInfoEntity> getDiscount_info() {
        return discount_info;
    }

    public String getActivity_address() {
        return activity_address;
    }

    public String getActivity_phone() {
        return activity_phone;
    }

    public String getActivity_time() {
        return activity_time;
    }

    public long getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(long timeTag) {
        this.timeTag = timeTag;
    }

    public int getTotal_nums() {
        return total_nums;
    }

    public void setTotal_nums(int total_nums) {
        this.total_nums = total_nums;
    }

    public ArrayList<GWDatas> getData() {
        return data;
    }

    public void setData(ArrayList<GWDatas> data) {
        this.data = data;
    }

    public int getSold_out() {
        return sold_out;
    }

    @Override
    public boolean equals(Object o) {
        return id.equals(((GWDatas) o).getId());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc_content() {
        return desc_content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRights() {
        return rights;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMax_nums() {
        return max_nums;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getUsable_time() {
        return usable_time;
    }


    public String getCover_img() {
        return cover_img;
    }

    public String getUrl_address() {
        return url_address;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getIs_top() {
        return is_top;
    }

    public void setIs_top(String is_top) {
        this.is_top = is_top;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrig_price() {
        return orig_price;
    }

    public int getIs_released_to_user() {
        return is_released_to_user;
    }

    public void setIs_released_to_user(int is_released_to_user) {
        this.is_released_to_user = is_released_to_user;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getHow_to_use() {
        return how_to_use;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public static class GoodsInfo implements Serializable {

        private static final long serialVersionUID = -3735830405928595023L;
        private String id;
        private String goods_name;
        private String selling_price;
        private String cost_price;
        private String goods_img;
        private int total_nums;
        private int buy_count;
        private String subhead;
        private String goods_inventory;
        private String goods_type;//1--普通，2-秒杀
        private String is_new;
        private String is_hot;

        public String getIs_new() {
            return is_new;
        }

        public String getIs_hot() {
            return is_hot;
        }

        public String getGoods_type() {
            return goods_type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public String getSelling_price() {
            return selling_price;
        }

        public String getCost_price() {
            return cost_price;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public int getTotal_nums() {
            return total_nums;
        }

        public void setTotal_nums(int total_nums) {
            this.total_nums = total_nums;
        }

        public int getBuy_count() {
            return buy_count;
        }

        public String getGoods_inventory() {
            return goods_inventory;
        }

    }

    public static class GrouponInfoEntity implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * "discount_id": "2", "discount_name": "asdfsadfsad", "discount_ratio":
         * "0", "discount_type": "2", "full_amount": "0.00", "full_cut": "0.00",
         * "supplier_id": "1", "supplier_logo": "", "supplier_name": "wangkang"
         */

        private String supplier_name; // ���̵�����
        private String supplier_logo; // ����ͼƬ
        private String supplier_id; // ���̵�id
        private String discount_name; // �ۿ����
        private float discount_ratio; // �ۿ۱���
        private String discount_type; // �ۿ�����
        private String discount_id; // �ۿ�Id
        private float full_amount; // �����
        private float full_cut; // ������
        private String supplier_phone;
        private String supplier_address;

        public String getSupplier_phone() {
            return supplier_phone;
        }

        public void setSupplier_name(String supplier_name) {
            this.supplier_name = supplier_name;
        }

        public String getDiscount_name() {
            return discount_name;
        }

        public String getSupplier_name() {
            return supplier_name;
        }

        public String getSupplier_logo() {
            return supplier_logo;
        }

        public String getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(String supplier_id) {
            this.supplier_id = supplier_id;
        }

        public String getDiscount_type() {
            return discount_type;
        }

        public float getDiscount_ratio() {
            return discount_ratio;
        }


        public float getFull_amount() {
            return full_amount;
        }


        public float getFull_cut() {
            return full_cut;
        }


    }
}

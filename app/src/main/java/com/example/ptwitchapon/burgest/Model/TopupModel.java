package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 17/6/2561.
 */

public class TopupModel {


    /**
     * status : success
     * code : 200
     * describtion : get items successfuly
     * items : [{"id_member":"1","picture":"1.png","cash":"50.00","Date":"2018-06-01 23:53:25","id_topupstatus":"2"},{"id_member":"1","picture":"2.png","cash":"50.00","Date":"2018-06-01 23:53:29","id_topupstatus":"3"},{"id_member":"1","picture":"4.jpg","cash":"300.00","Date":"2018-06-12 15:38:45","id_topupstatus":"3"},{"id_member":"1","picture":"5.jpg","cash":"500.00","Date":"2018-06-12 15:42:00","id_topupstatus":"3"},{"id_member":"1","picture":"6.jpg","cash":"400.00","Date":"2018-06-14 23:54:40","id_topupstatus":"3"},{"id_member":"1","picture":"7.","cash":"400.00","Date":"2018-06-15 00:24:05","id_topupstatus":"3"},{"id_member":"1","picture":"8.","cash":"4000.00","Date":"2018-06-15 00:28:39","id_topupstatus":"3"},{"id_member":"1","picture":"9.jpg","cash":"4000.00","Date":"2018-06-15 00:28:53","id_topupstatus":"3"},{"id_member":"1","picture":"10.jpg","cash":"500.00","Date":"2018-06-15 01:51:36","id_topupstatus":"3"},{"id_member":"1","picture":"11.jpg","cash":"10.00","Date":"2018-06-17 20:34:49","id_topupstatus":"1"},{"id_member":"1","picture":"12.jpg","cash":"50.00","Date":"2018-06-17 20:36:51","id_topupstatus":"1"},{"id_member":"1","picture":"5.jpg","cash":"4000.00","Date":"2018-06-17 20:55:45","id_topupstatus":"1"},{"id_member":"1","picture":"16.jpg","cash":"5000.00","Date":"2018-06-17 21:40:30","id_topupstatus":"1"},{"id_member":"1","picture":"17.jpg","cash":"2235.00","Date":"2018-06-17 21:43:00","id_topupstatus":"1"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<ItemsBean> items;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id_member : 1
         * picture : 1.png
         * cash : 50.00
         * Date : 2018-06-01 23:53:25
         * id_topupstatus : 2
         */

        private String id_member;
        private String picture;
        private String cash;
        private String Date;
        private String id_topupstatus;

        public String getId_member() {
            return id_member;
        }

        public void setId_member(String id_member) {
            this.id_member = id_member;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getCash() {
            return cash;
        }

        public void setCash(String cash) {
            this.cash = cash;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }

        public String getId_topupstatus() {
            return id_topupstatus;
        }

        public void setId_topupstatus(String id_topupstatus) {
            this.id_topupstatus = id_topupstatus;
        }
    }
}

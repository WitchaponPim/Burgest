package com.example.ptwitchapon.burgest.Model;

import java.util.List;

public class StoreModel {

    /**
     * status : success
     * code : 200
     * describtion : get store successfuly
     * store : [{"id_address":"1","address":"ประชาสงเคราะห์ 22","distance":"4","latitude":"13.775116","longitude":"100.562396","timeopen":"12:00:00","timeclose":"23:00:00","id_shop":"1"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<StoreBean> store;

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

    public List<StoreBean> getStore() {
        return store;
    }

    public void setStore(List<StoreBean> store) {
        this.store = store;
    }

    public static class StoreBean {
        /**
         * id_address : 1
         * address : ประชาสงเคราะห์ 22
         * distance : 4
         * latitude : 13.775116
         * longitude : 100.562396
         * timeopen : 12:00:00
         * timeclose : 23:00:00
         * id_shop : 1
         */

        private String id_address;
        private String address;
        private String distance;
        private String latitude;
        private String longitude;
        private String timeopen;
        private String timeclose;
        private String id_shop;

        public String getId_address() {
            return id_address;
        }

        public void setId_address(String id_address) {
            this.id_address = id_address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getTimeopen() {
            return timeopen;
        }

        public void setTimeopen(String timeopen) {
            this.timeopen = timeopen;
        }

        public String getTimeclose() {
            return timeclose;
        }

        public void setTimeclose(String timeclose) {
            this.timeclose = timeclose;
        }

        public String getId_shop() {
            return id_shop;
        }

        public void setId_shop(String id_shop) {
            this.id_shop = id_shop;
        }
    }
}

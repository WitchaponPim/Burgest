package com.example.ptwitchapon.burgest.Model;

import java.util.List;

public class PromotionModel {

    /**
     * status : success
     * code : 200
     * describtion : get promotions successfuly
     * promotions : [{"id_promotion":"30001","PromotionName":"last year","Amount":"1000","Price":"10","Path":"10","DateStart":"2018-12-20 23:40:30","DateEnd":"2019-01-05 23:40:46","QRCode":"","id_promotionstatus":"1","Use":null,"limited":"1","status":"พร้อมใช้งาน"},{"id_promotion":"30002","PromotionName":"FINAL DAY 5B","Amount":"50","Price":"5","Path":"ss","DateStart":"2018-05-10 19:38:05","DateEnd":"2018-05-31 19:38:08","QRCode":"","id_promotionstatus":"1","Use":null,"limited":"1","status":"พร้อมใช้งาน"},{"id_promotion":"30003","PromotionName":"mid year","Amount":"10","Price":"500","Path":"","DateStart":"2018-06-14 00:00:00","DateEnd":"2018-06-14 00:00:00","QRCode":"","id_promotionstatus":"1","Use":null,"limited":"1","status":"พร้อมใช้งาน"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<PromotionsBean> promotions;

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

    public List<PromotionsBean> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<PromotionsBean> promotions) {
        this.promotions = promotions;
    }

    public static class PromotionsBean {
        /**
         * id_promotion : 30001
         * PromotionName : last year
         * Amount : 1000
         * Price : 10
         * Path : 10
         * DateStart : 2018-12-20 23:40:30
         * DateEnd : 2019-01-05 23:40:46
         * QRCode :
         * id_promotionstatus : 1
         * Use : null
         * limited : 1
         * status : พร้อมใช้งาน
         */

        private String id_promotion;
        private String PromotionName;
        private String Amount;
        private String Price;
        private String Path;
        private String DateStart;
        private String DateEnd;
        private String QRCode;
        private String id_promotionstatus;
        private Object Use;
        private String limited;
        private String status;

        public String getId_promotion() {
            return id_promotion;
        }

        public void setId_promotion(String id_promotion) {
            this.id_promotion = id_promotion;
        }

        public String getPromotionName() {
            return PromotionName;
        }

        public void setPromotionName(String PromotionName) {
            this.PromotionName = PromotionName;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String Amount) {
            this.Amount = Amount;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }

        public String getPath() {
            return Path;
        }

        public void setPath(String Path) {
            this.Path = Path;
        }

        public String getDateStart() {
            return DateStart;
        }

        public void setDateStart(String DateStart) {
            this.DateStart = DateStart;
        }

        public String getDateEnd() {
            return DateEnd;
        }

        public void setDateEnd(String DateEnd) {
            this.DateEnd = DateEnd;
        }

        public String getQRCode() {
            return QRCode;
        }

        public void setQRCode(String QRCode) {
            this.QRCode = QRCode;
        }

        public String getId_promotionstatus() {
            return id_promotionstatus;
        }

        public void setId_promotionstatus(String id_promotionstatus) {
            this.id_promotionstatus = id_promotionstatus;
        }

        public Object getUse() {
            return Use;
        }

        public void setUse(Object Use) {
            this.Use = Use;
        }

        public String getLimited() {
            return limited;
        }

        public void setLimited(String limited) {
            this.limited = limited;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

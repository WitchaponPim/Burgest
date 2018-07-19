package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 20/7/2561.
 */

public class StockDetailModel {

    /**
     * status : success
     * code : 200
     * describtion : get stock successfuly
     * stock : [{"id_stockdetail":"40001","id_stock":"20001","amount":"795","create_timestamp":"2018-07-18 13:17:47","expire_date":"2018-07-31"},{"id_stockdetail":"40029","id_stock":"20001","amount":"795","create_timestamp":"2018-07-18 13:30:54","expire_date":"2018-08-04"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<StockBean> stock;

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

    public List<StockBean> getStock() {
        return stock;
    }

    public void setStock(List<StockBean> stock) {
        this.stock = stock;
    }

    public static class StockBean {
        /**
         * id_stockdetail : 40001
         * id_stock : 20001
         * amount : 795
         * create_timestamp : 2018-07-18 13:17:47
         * expire_date : 2018-07-31
         */

        private String id_stockdetail;
        private String id_stock;
        private String amount;
        private String create_timestamp;
        private String expire_date;

        public String getId_stockdetail() {
            return id_stockdetail;
        }

        public void setId_stockdetail(String id_stockdetail) {
            this.id_stockdetail = id_stockdetail;
        }

        public String getId_stock() {
            return id_stock;
        }

        public void setId_stock(String id_stock) {
            this.id_stock = id_stock;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCreate_timestamp() {
            return create_timestamp;
        }

        public void setCreate_timestamp(String create_timestamp) {
            this.create_timestamp = create_timestamp;
        }

        public String getExpire_date() {
            return expire_date;
        }

        public void setExpire_date(String expire_date) {
            this.expire_date = expire_date;
        }
    }
}

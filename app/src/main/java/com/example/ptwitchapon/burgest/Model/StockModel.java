package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 15/7/2561.
 */

public class StockModel {

    /**
     * status : success
     * code : 200
     * describtion : get stock successfuly
     * stocks : [{"id_stock":"20001","Name":"CHICKEN","total_amount":"1590","desc":"Ready"},{"id_stock":"20002","Name":"FISH","total_amount":"2000","desc":"Ready"},{"id_stock":"20003","Name":"BEEF LARGE","total_amount":"1000","desc":"Ready"},{"id_stock":"20004","Name":"BEEF","total_amount":"1000","desc":"Ready"},{"id_stock":"20005","Name":"PORK","total_amount":"1000","desc":"Ready"},{"id_stock":"20006","Name":"CHICKEN SPICY","total_amount":"1000","desc":"Ready"},{"id_stock":"20007","Name":"EGG","total_amount":"1580","desc":"Ready"},{"id_stock":"20008","Name":"CHEESE","total_amount":"985","desc":"Ready"},{"id_stock":"20009","Name":"BACON","total_amount":"1991","desc":"Ready"},{"id_stock":"20010","Name":"BREAD","total_amount":"795","desc":"Ready"},{"id_stock":"20011","Name":"LETTUCE","total_amount":"785","desc":"Ready"},{"id_stock":"20012","Name":"TOMATO","total_amount":"785","desc":"Ready"},{"id_stock":"20013","Name":"ONION","total_amount":"790","desc":"Ready"},{"id_stock":"20014","Name":"CUCUMBER","total_amount":"780","desc":"Ready"},{"id_stock":"20015","Name":"FRENFRIED","total_amount":"1000","desc":"Ready"},{"id_stock":"20016","Name":"KARA-AGE","total_amount":"1000","desc":"Ready"},{"id_stock":"20017","Name":"NUGGET CHEESE","total_amount":"1000","desc":"Ready"},{"id_stock":"20018","Name":"COKE MEDIUM","total_amount":"1000","desc":"Ready"},{"id_stock":"20019","Name":"COKE SMALL","total_amount":"1000","desc":"Ready"},{"id_stock":"20020","Name":"SPRITE MEDIUM","total_amount":"1000","desc":"Ready"},{"id_stock":"20021","Name":"SPRITE SMALL","total_amount":"1000","desc":"Ready"},{"id_stock":"20022","Name":"WATER MEDIUM","total_amount":"1000","desc":"Ready"},{"id_stock":"20023","Name":"WATER SMALL","total_amount":"1000","desc":"Ready"},{"id_stock":"20024","Name":"KETCHUP","total_amount":"1775","desc":"Ready"},{"id_stock":"20025","Name":"MAYONNAISE","total_amount":"1000","desc":"Ready"},{"id_stock":"20026","Name":"THOUSAND","total_amount":"1000","desc":"Ready"},{"id_stock":"20027","Name":"BLACK PEPPER","total_amount":"995","desc":"Ready"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<StocksBean> stocks;

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

    public List<StocksBean> getStocks() {
        return stocks;
    }

    public void setStocks(List<StocksBean> stocks) {
        this.stocks = stocks;
    }

    public static class StocksBean {
        /**
         * id_stock : 20001
         * Name : CHICKEN
         * total_amount : 1590
         * desc : Ready
         */

        private String id_stock;
        private String Name;
        private String total_amount;
        private String desc;

        public String getId_stock() {
            return id_stock;
        }

        public void setId_stock(String id_stock) {
            this.id_stock = id_stock;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}

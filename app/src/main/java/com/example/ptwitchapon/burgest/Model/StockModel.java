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
     * stocks : [{"id_stock":"20001","Name":"CHICKEN","Amount":"978","EXP":null,"QRCode":""},{"id_stock":"20002","Name":"FISH","Amount":"96","EXP":null,"QRCode":""},{"id_stock":"20003","Name":"BEEF LARGE","Amount":"53","EXP":null,"QRCode":""},{"id_stock":"20004","Name":"BEEF","Amount":"76","EXP":null,"QRCode":""},{"id_stock":"20005","Name":"PORK","Amount":"43","EXP":null,"QRCode":""},{"id_stock":"20006","Name":"CHICKEN SPICY","Amount":"98","EXP":null,"QRCode":""},{"id_stock":"20007","Name":"EGG","Amount":"35","EXP":null,"QRCode":""},{"id_stock":"20008","Name":"CHEESE","Amount":"933","EXP":"2018-04-30","QRCode":""},{"id_stock":"20009","Name":"BACON","Amount":"14","EXP":"2018-04-30","QRCode":""},{"id_stock":"20010","Name":"BREAD","Amount":"448","EXP":"2018-05-19","QRCode":""},{"id_stock":"20011","Name":"LETTUCE","Amount":"128","EXP":"2018-04-30","QRCode":""},{"id_stock":"20012","Name":"TOMATO","Amount":"116","EXP":"2018-04-28","QRCode":""},{"id_stock":"20013","Name":"ONION","Amount":"111","EXP":"2018-04-28","QRCode":""},{"id_stock":"20014","Name":"CUCUMBER","Amount":"59","EXP":"2018-05-25","QRCode":""},{"id_stock":"20015","Name":"FRENFRIED","Amount":"95399","EXP":null,"QRCode":""},{"id_stock":"20016","Name":"KARA-AGE","Amount":"99","EXP":null,"QRCode":""},{"id_stock":"20017","Name":"NUGGET CHEESE","Amount":"99","EXP":null,"QRCode":""},{"id_stock":"20018","Name":"COKE MEDIUM","Amount":"34","EXP":null,"QRCode":""},{"id_stock":"20019","Name":"COKE SMALL","Amount":"19","EXP":null,"QRCode":""},{"id_stock":"20020","Name":"SPRITE MEDIUM","Amount":"49","EXP":null,"QRCode":""},{"id_stock":"20021","Name":"SPRITE SMALL","Amount":"49","EXP":null,"QRCode":""},{"id_stock":"20022","Name":"WATER MEDIUM","Amount":"49","EXP":null,"QRCode":""},{"id_stock":"20023","Name":"WATER SMALL","Amount":"49","EXP":null,"QRCode":""},{"id_stock":"20024","Name":"KETCHUP","Amount":"998","EXP":null,"QRCode":""},{"id_stock":"20025","Name":"MAYONNAISE","Amount":"998","EXP":null,"QRCode":""},{"id_stock":"20026","Name":"THOUSAND","Amount":"998","EXP":null,"QRCode":""},{"id_stock":"20027","Name":"BLACK PEPPER","Amount":"998","EXP":null,"QRCode":""}]
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
         * Amount : 978
         * EXP : null
         * QRCode :
         */

        private String id_stock;
        private String Name;
        private String Amount;
        private String EXP;
        private String QRCode;

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

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String Amount) {
            this.Amount = Amount;
        }

        public String getEXP() {
            return EXP;
        }

        public void setEXP(String EXP) {
            this.EXP = EXP;
        }

        public String getQRCode() {
            return QRCode;
        }

        public void setQRCode(String QRCode) {
            this.QRCode = QRCode;
        }
    }
}

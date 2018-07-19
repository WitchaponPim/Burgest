package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 29/5/2561.
 */

public class Orderlist_item {

    /**
     * status : success
     * code : 200
     * describtion : get items successfuly
     * items : [{"id_order":"24","id_member":"2","id_emp":null,"date":"2018-05-29 23:20:14","totalPrice":"112","id_promotion":null,"id_status":"5","id_orderType":"2","id_orderDetail":"42","id_product":"35","price":"20","qty":"2","note":"tomato Sauce||","status":"รอการอนุมัติ","ProductName":"FRENFRIED SMALL","id_productType":"7","Price":"20","QRCode":"","Path":"fren204060b.png"},{"id_order":"24","id_member":"2","id_emp":null,"date":"2018-05-29 23:20:14","totalPrice":"112","id_promotion":null,"id_status":"5","id_orderType":"2","id_orderDetail":"43","id_product":"40","price":"32","qty":"1","note":"||","status":"รอการอนุมัติ","ProductName":"COKE MEDIUM","id_productType":"8","Price":"32","QRCode":"","Path":"cm32.jpg"},{"id_order":"24","id_member":"2","id_emp":null,"date":"2018-05-29 23:20:14","totalPrice":"112","id_promotion":null,"id_status":"5","id_orderType":"2","id_orderDetail":"44","id_product":"23","price":"40","qty":"1","note":"tomato Sauce||","status":"รอการอนุมัติ","ProductName":"PORK","id_productType":"5","Price":"40","QRCode":"","Path":"p40b.png"}]
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
         * id_order : 24
         * id_member : 2
         * id_emp : null
         * date : 2018-05-29 23:20:14
         * totalPrice : 112
         * id_promotion : null
         * id_status : 5
         * id_orderType : 2
         * id_orderDetail : 42
         * id_product : 35
         * price : 20
         * qty : 2
         * note : tomato Sauce||
         * status : รอการอนุมัติ
         * ProductName : FRENFRIED SMALL
         * id_productType : 7
         * Price : 20
         * QRCode :
         * Path : fren204060b.png
         */
        private String id_order;
        private String id_member;
        private Object id_emp;
        private String date;
        private String totalPrice;
        private Object id_promotion;
        private String id_status;
        private String id_orderType;
        private String id_orderDetail;
        private String id_product;
        private String price;
        private String qty;

        private String note;
        private String status;
        private String ProductName;
        private String id_productType;
        private String Price;
        private String QRCode;
        private String Path;

        public String getId_order() {
            return id_order;
        }

        public void setId_order(String id_order) {
            this.id_order = id_order;
        }

        public String getId_member() {
            return id_member;
        }

        public void setId_member(String id_member) {
            this.id_member = id_member;
        }

        public Object getId_emp() {
            return id_emp;
        }

        public void setId_emp(Object id_emp) {
            this.id_emp = id_emp;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Object getId_promotion() {
            return id_promotion;
        }

        public void setId_promotion(Object id_promotion) {
            this.id_promotion = id_promotion;
        }

        public String getId_status() {
            return id_status;
        }

        public void setId_status(String id_status) {
            this.id_status = id_status;
        }

        public String getId_orderType() {
            return id_orderType;
        }

        public void setId_orderType(String id_orderType) {
            this.id_orderType = id_orderType;
        }

        public String getId_orderDetail() {
            return id_orderDetail;
        }

        public void setId_orderDetail(String id_orderDetail) {
            this.id_orderDetail = id_orderDetail;
        }

        public String getId_product() {
            return id_product;
        }

        public void setId_product(String id_product) {
            this.id_product = id_product;
        }

        public String getprice() {
            return price;
        }

        public void setprice(String price) {
            this.price = price;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public String getId_productType() {
            return id_productType;
        }

        public void setId_productType(String id_productType) {
            this.id_productType = id_productType;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }

        public String getQRCode() {
            return QRCode;
        }

        public void setQRCode(String QRCode) {
            this.QRCode = QRCode;
        }

        public String getPath() {
            return Path;
        }

        public void setPath(String Path) {
            this.Path = Path;
        }
    }
}

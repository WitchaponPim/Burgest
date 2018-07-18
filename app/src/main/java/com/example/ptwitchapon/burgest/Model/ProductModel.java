package com.example.ptwitchapon.burgest.Model;

import java.util.List;

public class ProductModel {

    /**
     * status : success
     * code : 200
     * describtion : get producttype successfuly
     * product : [{"id_product":"10001","ProductName":"CHICKEN","id_productType":"1","Price":"40","QRCode":"","Path":"c40b.png"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<ProductBean> product;

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

    public List<ProductBean> getProduct() {
        return product;
    }

    public void setProduct(List<ProductBean> product) {
        this.product = product;
    }

    public static class ProductBean {
        /**
         * id_product : 10001
         * ProductName : CHICKEN
         * id_productType : 1
         * Price : 40
         * QRCode :
         * Path : c40b.png
         */

        private String id_product;
        private String ProductName;
        private String id_productType;
        private String Price;
        private String QRCode;
        private String Path;

        public String getId_product() {
            return id_product;
        }

        public void setId_product(String id_product) {
            this.id_product = id_product;
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

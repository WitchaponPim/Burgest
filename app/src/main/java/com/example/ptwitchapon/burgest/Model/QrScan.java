package com.example.ptwitchapon.burgest.Model;

/**
 * Created by Killy77 on 19/6/2561.
 */

public class QrScan {

    /**
     * checklogin : {"status":"success","code":"200","description":{"id_product":"2","ProductName":"CHICKEN EGG","id_productType":"1","Price":"47","QRCode":"","Path":"c47b.png"}}
     */

    private CheckloginBean checklogin;

    public CheckloginBean getChecklogin() {
        return checklogin;
    }

    public void setChecklogin(CheckloginBean checklogin) {
        this.checklogin = checklogin;
    }

    public static class CheckloginBean {
        /**
         * status : success
         * code : 200
         * description : {"id_product":"2","ProductName":"CHICKEN EGG","id_productType":"1","Price":"47","QRCode":"","Path":"c47b.png"}
         */

        private String status;
        private String code;
        private DescriptionBean description;

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

        public DescriptionBean getDescription() {
            return description;
        }

        public void setDescription(DescriptionBean description) {
            this.description = description;
        }

        public static class DescriptionBean {
            /**
             * id_product : 2
             * ProductName : CHICKEN EGG
             * id_productType : 1
             * Price : 47
             * QRCode :
             * Path : c47b.png
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
}

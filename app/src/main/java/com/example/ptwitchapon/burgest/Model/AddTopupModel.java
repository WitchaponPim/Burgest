package com.example.ptwitchapon.burgest.Model;

/**
 * Created by Killy77 on 14/6/2561.
 */

public class AddTopupModel {

    /**
     * insert : {"status":"success","code":"800","description":"add topup is successfuly"}
     */

    private InsertBean insert;

    public InsertBean getInsert() {
        return insert;
    }

    public void setInsert(InsertBean insert) {
        this.insert = insert;
    }

    public static class InsertBean {
        /**
         * status : success
         * code : 800
         * description : add topup is successfuly
         */

        private String status;
        private String code;
        private String description;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

package com.example.ptwitchapon.burgest.Model;

/**
 * Created by Killy77 on 16/7/2561.
 */

public class UpdateStockResponse {

    /**
     * update : {"status":"success","code":"800","description":"update is successfuly"}
     */

    private UpdateBean update;

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    public static class UpdateBean {
        /**
         * status : success
         * code : 800
         * description : update is successfuly
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

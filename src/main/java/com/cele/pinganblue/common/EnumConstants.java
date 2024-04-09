package com.cele.pinganblue.common;

/**
 * Author: kingcobra
 * create on 2020/10/12 11:24
 **/
public class EnumConstants {
    /**
     * Response结果
     */
    public enum ResponseResult{
        success,failure
    }

    public enum UserStatus{
        unaudit(0),audit(1),enable(2), disable(3);
        private int code;
        UserStatus(int code){
            this.code = code;
        }
        public static UserStatus getStatus(int code) {
            switch (code) {
                case 0:
                    return unaudit;
                case 1:
                    return audit;
                case 2:
                    return enable;
                case 3:
                    return disable;
                default:
                    return unaudit;
            }
        }

        public int getCode() {
            return code;
        }
    }
}

package com.zaitsava.springboot_touristsite;

public enum OrderStatusEnum {
    unpaid((short)0),
    paid((short)1),
    finished((short)2);


    short value;

    OrderStatusEnum(short i) {
        this.value  = i;
    }

}
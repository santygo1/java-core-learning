package com.ds.serializing;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
@Getter
@Setter
public class Card implements Serializable{
    private String title;
    private int CVV;
    private long number;

    public Card(String title, int CVV, long number) {
        this.title = title;
        this.CVV = CVV;
        this.number = number;
    }

    @Override
    public String toString() {
        return '\"' + title + '\"'
                + " " + number
                + " CVV: " + CVV;
    }
}

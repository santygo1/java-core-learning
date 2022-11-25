package com.ds.serializing;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
@Getter
@Setter
public class Wallet implements Serializable {

    private int cash;

    private final List<Card> cards;

    public Wallet(int cash) {
        this.cash = cash;
        this.cards = new ArrayList<>();
    }

    public void addCash(int amount){
        cash += amount;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Wallet:")
                .append('\n').append('\t').append('\t').append("Cash: ").append(cash);

        for (int counter = 0; counter < cards.size(); counter++) {
            builder.append('\n').append('\t').append('\t')  //tabs
                    .append("Card №").append(counter+1).append(":") // title
                    .append(cards.get(counter)); //card information
        }

        return builder.toString();
    }
}

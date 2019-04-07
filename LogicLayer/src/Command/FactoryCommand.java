package Command;

import Models.Deck.Deck;

public class FactoryCommand {

    public static FillDeskCommand createFillDeskCommand(Deck deck) {
        return new FillDeskCommand(deck);

    }

}

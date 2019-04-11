package Command;

import Models.Deck.Deck;

public class FactoryCommand {

    public static FillDeskCommand createFillDeskCommand() {
        return new FillDeskCommand();

    }

}

package Command;

import Factory.*;
import Models.Card.ICard;
import Models.Deck.Deck;

import java.util.ArrayList;

/**
 *
 * Commando que se encargara de llenar el desk de cartas
 *
 * */
public class FillDeskCommand extends Command{

    Deck deck;
    ICardFactory cardFactory;
    ArrayList<ICard> cardList;

    public FillDeskCommand(Deck deck) {
        this.cardList = new ArrayList<ICard>();
        this.deck = deck;
    }

    @Override
    public void execute() throws Exception {
        cardFactory = new CardBastosFactory(this.cardList);
        cardFactory.crearTodos();
        cardFactory = new CardGoldFactory(cardList);
        cardFactory.crearTodos();
        cardFactory = new CardSwordFactory(cardList);
        cardFactory.crearTodos();
        cardFactory = new CardCupFactory(cardList);
        cardFactory.crearTodos();
    }

    @Override
    public ArrayList<ICard>  Return() {
        return cardList;
    }
}

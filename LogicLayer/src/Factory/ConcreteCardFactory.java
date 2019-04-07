package Factory;

public class ConcreteCardFactory implements IConcreteCardFactory {

    @Override
    public CardFactory createBastosFactory() {
        return new CardBastosFactory();
    }

    @Override
    public CardFactory createSwordFactory() {

        return new CardSwordFactory();
    }

    @Override
    public CardFactory createCupFactory() {

        return new CardCupFactory();
    }

    @Override
    public CardFactory createGoldFactory() {
        return new CardGoldFactory();
    }
}

package Factory;

public interface IConcreteCardFactory {
    CardFactory createBastosFactory();
    CardFactory createSwordFactory();
    CardFactory createCupFactory();
    CardFactory createGoldFactory();
}

package Logic.Command;

public class FactoryCommand {

    public static FillDeskCommand createFillDeskCommand(){
        return new FillDeskCommand();
    }

}

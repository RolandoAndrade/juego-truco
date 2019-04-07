package Models.Player;

import Models.Player.Hand.IHand;

public class Player implements IPlayer {

    private String _name;
    private IHand _hand;

    public Player(String _name, IHand _hand) {
        this._name = _name;
        this._hand = _hand;
    }
}

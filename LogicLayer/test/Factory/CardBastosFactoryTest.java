package Factory;

import Models.Card.ICard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardBastosFactoryTest {
    ArrayList<ICard> cardList;
    CardFactory cardFactory;

    @BeforeEach
    void setUp() {
        cardList = new ArrayList<ICard>();
    }

    @Test
    void crearTodos() {
        cardFactory = new CardBastosFactory(cardList);
        cardFactory.crearTodos();
        assertNotNull(cardFactory.cardList);
    }

    @Test
    void crearUno() {

    }

    @Test
    void crearDos() {
    }

    @Test
    void crearTres() {
    }

    @Test
    void crearCuatro() {
    }

    @Test
    void crearCinco() {
    }

    @Test
    void crearSeis() {
    }

    @Test
    void crearSiete() {
    }

    @Test
    void crearDiez() {
    }

    @Test
    void crearOnce() {
    }

    @Test
    void crearDoce() {
    }
}
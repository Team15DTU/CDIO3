package model.player.token;

import org.junit.Test;

import static org.junit.Assert.*;

public class TokenTest {

    @Test
    public void getType() {
        Token token = new Token("cat");
        assertEquals("cat",token.getType());
    }

    @Test
    public void setType() {
        Token token = new Token("cat");
        token.setType("fish");
        assertEquals("fish",token.getType());
    }
}
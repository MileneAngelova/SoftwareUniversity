package UnitTests.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int HEALTH = 10;
    private static final int XP = 10;
    private Dummy dummy;

    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, XP);
        this.deadDummy = new Dummy(0, XP);
    }

    @Test
    public void testDummyLosesHealthIfAttacked() {
        int attackPoints = 1;
        dummy.takeAttack(attackPoints);
        Assert.assertEquals(HEALTH - attackPoints, dummy.getHealth());

    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionWhenAttacked() {
        deadDummy.takeAttack(1);
    }

    @Test
    public void testDeadDummyGiveExperience() {
        Assert.assertEquals(10, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyThrowsWhenGivesXP() {
        dummy.giveExperience();
    }
}
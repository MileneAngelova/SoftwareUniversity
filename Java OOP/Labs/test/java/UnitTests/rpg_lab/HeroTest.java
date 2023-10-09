package UnitTests.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private Hero hero;

    @Before
    public void setUp() {
        Weapon mock = Mockito.mock(Weapon.class);
        this.hero = new Hero("Geralt", mock);
    }

    @Test
    public void testHeroGetsXPWhenTargetIsDead() {
        Target mokedTarget = Mockito.mock(Target.class);
        Mockito.when(mokedTarget.isDead()).thenReturn(true);
        Mockito.when(mokedTarget.giveExperience()).thenReturn(10);

        this.hero.attack(mokedTarget);
        Assert.assertEquals(10, this.hero.getExperience());
    }

    @Test
    public void testHeroDoesNotReceiveXPWhenTargetIsAlive() {
        Target mockedAliveTarget = Mockito.mock(Target.class);
        Mockito.when(mockedAliveTarget.isDead()).thenReturn(false);
        Mockito.when(mockedAliveTarget.giveExperience()).thenReturn(0);

        hero.attack(mockedAliveTarget);
        Assert.assertEquals(0, hero.getExperience());
    }
}
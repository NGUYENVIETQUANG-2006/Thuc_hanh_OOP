interface CanFly {void fly();}
interface CanSwim {void swim();}
interface CanFight {void fight();}

class ActionCharacter {
    public void fight() {
        System.out.println("Đấm bốc...");
    }
}

class Hero extends ActionCharacter implements CanFly, CanSwim, CanFight {
    @Override
    public void fly() {
        System.out.println("Hero is flying...");
    }

    @Override
    public void swim() {
        System.out.println("Hero is swimming...");
    }
}

public class main2 {
    public static void main(String[] args) {
        Hero hero = new Hero();
        CanSwim swimmer = (CanSwim) hero;
        swimmer.swim();
        CanFight fighter = (CanFight) hero;
        fighter.fight();
    }
}

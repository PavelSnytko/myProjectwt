package Lection6;


import java.util.Random;
import java.util.Scanner;

class Game {


    static class menu{                //содаем класс меню с выбором;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Выберите героя: 1 - Воин, 2 - Маг, 3 - Лучник");
            int number = sc.nextInt();
            System.out.println("Введите имя: ");
            String name = sc.next();
            Hero hero = new Warrior(name);
            switch (number) {
                case 1:
                    hero = new Warrior(name);
                    break;
                case 2:
                    hero = new Mage(name);
                    break;
                case 3:
                    hero = new Archer(name);
                    break;
            }
            System.out.println("Выберите врага: 1 - Тигр, 2 - Дракон, 3 - Орк");
            int number1 = sc.nextInt();
            Enemy enemy = new Orc();

            switch (number1) {
                case 1:
                    enemy = new Tiger();
                    break;
                case 2:
                    enemy = new Dragon();
                    break;
                case 3:
                    enemy = new Orc();
                    break;
            }
            startBattle(enemy, hero);
        }
    }

    static void startBattle(Enemy enemy, Hero hero){
        System.out.println("Вы вступили в бой");
        while(enemy.getHealth()>0 & hero.getHealthPoint()>0){
            hero.AttackEnemy(enemy);
        }
    }

}



abstract class Hero{
    private String name;
    private int healthPoint;

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    Hero(String name){
        this.name = name;
    }

    abstract void AttackEnemy(Enemy enemy);

    void takeDamage(int damage){
        setHealthPoint(getHealthPoint()-damage);
        if(getHealthPoint() > 0){
            System.out.println("У вас осталось " + getHealthPoint() + " ед.здоровья");
        }
        else {
            System.out.println("Вы погибли!");
        }
    }

}



class Warrior extends Hero{

    Warrior(String name) {
        super(name);
        setHealthPoint(120);
    }

    @Override
    void AttackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(30);
        if(damage==0){
            System.out.println("Вы промахнулись!");
        }
        else{
            System.out.println("Воин " + getName() + " aтакует врага мечем нанося " + damage + " ед. урона");
        }
        enemy.takeDamage(damage);
        if (enemy.isAlive()) {
            takeDamage(enemy.counterBlow());
        }
    }

    @Override
    void takeDamage(int damage) {
        Random random = new Random();
        int parry = random.nextInt(10);
        if(parry == 0 || parry == 1){
            System.out.println("Вы уклонились от удара!");
        }
        else{
            setHealthPoint(getHealthPoint()-damage);
            if(getHealthPoint() > 0){
                System.out.println("У вас осталось " + getHealthPoint() + " ед.здоровья");
            }
            else {
                System.out.println("Вы погибли!");
            }
        }
    }
}



class Mage extends Hero{

    Mage(String name) {
        super(name);
        setHealthPoint(100);
    }

    @Override
    void AttackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(30);
        int frost = random.nextInt(99);
        if(damage==0){
            System.out.println("Вы промахнулись!");
        }
        else{
            System.out.println("Маг " + getName() + " aтакует врага молнией " + damage + " ед. урона");
            if (frost > 75) {
                System.out.println("Попытка поразить врага удалась!");
                enemy.frozen = true;
            }
            enemy.takeDamage(damage);
            if (enemy.isAlive() & !enemy.frozen) {
                takeDamage(enemy.counterBlow());
            }
            enemy.frozen = false;
        }
    }
}



class Archer extends Hero{

    Archer(String name) {
        super(name);
        setHealthPoint(110);
    }

    @Override
    void AttackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(30);
        int critical = random.nextInt(5);
        if(critical == 0 || critical == 1){
            damage *= 2;
        }
        if(damage==0){
            System.out.println("Вы промахнулись!");
        }
        else{
            if(critical == 0 || critical == 1){
                System.out.println("Лучник " + getName() + " наносит критический удар на " + damage*2 + " ед. урона");
            }
            else{
                System.out.println("Лучник " + getName() + " пускает в врага стрелу нанося " + damage + " ед. урона");
            }
        }
        enemy.takeDamage(damage);
        if (enemy.isAlive()) {
            takeDamage(enemy.counterBlow());
        }
    }
}



interface Mortal{
    boolean isAlive();
}

abstract class Enemy implements Mortal{
    private int health = 100;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    boolean frozen = false;

    void takeDamage(int damage){
        setHealth(getHealth()-damage);
        if(isAlive()){
            System.out.println("У врага осталось " + getHealth() + " ед. здоровья");
        }
        else {
            System.out.println("Враг повержен!");
        }
    }

    int counterBlow(){
        Random random = new Random();
        int counterblow = random.nextInt(20);
        if (counterblow == 0) {
            System.out.println("Враг промахнулся в ответ!");
            return counterblow;
        }
        else {
            System.out.println("Враг в ответ наносит " + counterblow + " ед. урона");
            return counterblow;
        }
    }

    @Override
    public boolean isAlive() {
        if(getHealth()>0){
            return true;
        }
        else return false;
    }
}



class Tiger extends Enemy{
    boolean alive = true;

    Tiger(){
        setHealth(100);
    }

    @Override
    public boolean isAlive() {
        Random random = new Random();
        int ressurect = random.nextInt(5);
        if (getHealth()>0) {
            return true;
        }
        else{
            if(ressurect == 1 || ressurect == 3 || ressurect ==5 & alive){
                System.out.println("тигр ожил!");
                setHealth(100);
                alive = false;
                return true;
            }
            else{
                return false;
            }
        }
    }

}

class Dragon extends Enemy{

    int poisoncounter = 0;

    Dragon(){
        setHealth(100);
    }

    @Override
    int counterBlow(){
        Random random = new Random();
        int counterblow = random.nextInt(20);
        if (counterblow == 0) {
            System.out.println("Дракон промахивается в ответ.");
            return counterblow;
        }
        else {
            ++poisoncounter;
            if (poisoncounter == 5) {
                System.out.println("Вы получаете смертельный урон от пламя!");
                return 500;
            }
            else {
                System.out.println("Дракон в ответ наносит " + counterblow + " ед. урона, степень поражения пламенем: " + poisoncounter);
                return counterblow;
            }
        }
    }
}

class Orc extends Enemy{

    Orc(){
        setHealth(100);
    }

    @Override
    int counterBlow(){
        Random random = new Random();
        int counterblow = random.nextInt(20);
        if(counterblow==0){
            System.out.println("Орк промахивается в ответ.");
            return counterblow;
        }
        else {
            System.out.println("Орк в ответ наносит " + counterblow + " ед. урона и восстанавливает себе " + counterblow/2 + " ед. здоровья");
            setHealth(getHealth()+counterblow/2);
            return counterblow;
        }
    }

}
import java.util.Random;

public  abstract class Persos {
    private int pv;
    private int attack;
    private String name;
    protected String weapon;

    public Persos (String name, int pv, int attack) {
        this.name = name;
        this.pv = pv;
        this.attack = attack;
        this.weapon = weaponShuffle();
    }

    public String getName() {
        return this.name;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getPv() {
        return this.pv;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    //choix de l'arme
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon() {
        return this.weapon;
    }   
    
    public boolean isKo() {
        return getPv() <= 0;
    }

    public String weaponShuffle() {
        int index = 0;
        Random r = new Random();        
        index = r.nextInt((2 - 0) + 2) + 0;
        if(index == 0) {
            return "staff";
        }
        else if(index == 1) {
            return "axe";
        }
        else {
            return "sword";
        }
    }

    public void damage(Persos p) {
        
        //switch en fonction de l'attaquant
        switch(this.weapon) {
            case "sword" :
                if(p.weapon.equals("axe")) {
                    p.setPv(p.getPv() - this.getAttack()*2);
                }
                else if (p.weapon.equals("staff")) {
                    p.setPv(p.getPv() - (this.getAttack()/2));
                }
                else {
                    p.setPv(p.getPv() - this.getAttack());
                }
                break;
            case "axe" :
                if(p.weapon.equals("staff")) {
                    p.setPv(p.getPv() - this.getAttack()*2);
                }
                else if (p.weapon.equals("sword")) {
                    p.setPv(p.getPv() - (this.getAttack()/2));
                }
                else {
                    p.setPv(p.getPv() - this.getAttack());
                }   
                break;
            case "staff" :
                if(p.weapon.equals("sword")) {
                    p.setPv(p.getPv() - this.getAttack()*2);
                }
                else if (p.weapon.equals("axe")) {
                    p.setPv(p.getPv() - (this.getAttack()/2));
                }
                else {
                    p.setPv(p.getPv() - this.getAttack());
                }   
                break;
        }
    }
 }
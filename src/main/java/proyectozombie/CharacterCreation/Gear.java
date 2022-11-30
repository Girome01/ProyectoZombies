package proyectozombie.CharacterCreation;

import java.io.Serializable;

public class Gear implements iPrototype, Serializable{
    private String gName;
    private int gRange;
    private int gDamage;
    private int gLevel;
    private int gGearBLast;
    private String gAppearanceURL;
    private boolean gActive; 

    public Gear(String gName, int gRange, int gDamage, int gLevel, int gGearBLast, String gAppearanceURL,
    boolean gActive) {
        this.gName = gName;
        this.gRange = gRange;
        this.gDamage = gDamage;
        this.gLevel = gLevel;
        this.gGearBLast = gGearBLast;
        this.gAppearanceURL = gAppearanceURL;
        this.gActive = gActive;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgRange() {
        return gRange;
    }

    public void setgRange(int gRange) {
        this.gRange = gRange;
    }

    public int getgDamage() {
        return gDamage;
    }

    public void setgDamage(int gDamage) {
        this.gDamage = gDamage;
    }

    public int getgLevel() {
        return gLevel;
    }

    public void setgLevel(int gLevel) {
        this.gLevel = gLevel;
    }

    public int getgGearBLast() {
        return gGearBLast;
    }

    public void setgGearBLast(int gGearBLast) {
        this.gGearBLast = gGearBLast;
    }

    public String getgAppearanceURL() {
        return gAppearanceURL;
    }

    public void setgAppearanceURL(String gAppearanceURL) {
        this.gAppearanceURL = gAppearanceURL;
    }

    public boolean isgActive() {
        return gActive;
    }

    public void setgActive(boolean gActive) {
        this.gActive = gActive;
    }

    @Override
    public iPrototype clone() {
        return new Gear(gName, gRange, gDamage, gLevel, gGearBLast, gAppearanceURL, gActive);
    }

    @Override
    public iPrototype deepClone() {
        return clone();
    }

    public void levelUp(){
        this.gLevel+=1;
    }

    public void useGear(){
        
    }

}
    

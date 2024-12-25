import java.util.Scanner;

abstract class Compte {
    private int number;
    private String propietaire;
    private long soldeinitial;
    private String type;


    public Compte(int num,String propietaire,long soldeinitial){
        this.number=number;
        this.propietaire=propietaire;
        this.soldeinitial=soldeinitial;
    }

    public int getNum() {
        return number;
    }
    public void setNum(int number) {
        this.number = number;
    }

    public String getPropietaire() {
        return propietaire;
    }
    public void setPropietaire(String propietaire) {
        this.propietaire = propietaire;
    }

    public long getSoldeinitial() {
        return soldeinitial;
    }

    public void setSoldeinitial(long soldeinitial) {
        this.soldeinitial = soldeinitial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

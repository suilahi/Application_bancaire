abstract class Compte {
    private int number;
    private double salaire;
    private String propietaire;

    public Compte(int num,double salaire,String propietaire){
        this.number=number;
        this.propietaire=propietaire;
        this.salaire=salaire;
    }

    public int getNum() {
        return number;
    }

    public void setNum(int number) {
        this.number = number;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPropietaire() {
        return propietaire;
    }

    public void setPropietaire(String propietaire) {
        this.propietaire = propietaire;
    }
}

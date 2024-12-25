public class CompteCourant extends Compte{
    private double fraisbancaire;
    public CompteCourant(int num,String propietaire,long soldeinitial,double fraisbancaire){
        super(num, propietaire, soldeinitial);
        fraisbancaire=fraisbancaire;
    }


}

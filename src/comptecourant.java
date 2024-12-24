public class comptecourant extends Compte{
   private double tauxinteret;

   public comptecourant(int num, double salaire, String propietaire,double tauxinteret) {
        super(num, salaire, propietaire);
        this.tauxinteret=tauxinteret;
    }


}

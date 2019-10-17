public class Jeu {
    
    
    public int dimension = 5;
    public int nbrTours = 25;
    public Monde monde;
    

    public Jeu(int dimension) {
        this.monde = new Monde(dimension);  
    }

    
    
    
    public Jeu() {
         monde = new Monde(dimension);  
    }

    

    
     
      

}
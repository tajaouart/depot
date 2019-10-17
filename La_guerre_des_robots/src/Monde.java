
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

public class Monde {

	public ArrayList lesTueurs;
	public ArrayList lesClassiques;
	public ArrayList lesDemineurs;
        public int nbrRobotDemineur = 1;
        public int nbrRobotsTueurs = 2;
        public int nbrRobotsClassiques = 4;
        public int nbrToursDeJeu = 25;
        public int demensions = 5;
        public Object[][] scene;
        public char[] directions= {'H','D','B','G'};

    public Monde(int dimensions) {
        scene = new Object[dimensions][dimensions];
        this.demensions = dimensions;
        int doubleNbrRobots =  dimensions/5;
        nbrRobotDemineur = nbrRobotDemineur * doubleNbrRobots;
        nbrRobotsTueurs = nbrRobotsTueurs * doubleNbrRobots;
        nbrRobotsClassiques = nbrRobotsClassiques * doubleNbrRobots;
        nbrToursDeJeu = nbrToursDeJeu * doubleNbrRobots;
        lesTueurs = new ArrayList<Tueur>();
        lesClassiques = new ArrayList<Robot>();
        lesDemineurs = new ArrayList<Démineur>();
        
        peuplerScene();
        
        
        
        
    }
    
    void CommencerLeJeu() {
        
        for(int i =0; i<lesDemineurs.size(); i++){
            int index = getRandomNumberInRange(0, 100)%3;
            char direction = directions[index];
            Démineur demineur = (Démineur)lesDemineurs.get(i);
            demineur.seDeplacer(direction);
        }
        
        for(int i =0; i<lesClassiques.size(); i++){
            int index = getRandomNumberInRange(0, 100)%3;
            char direction = directions[index];
            Robot classique = (Robot)lesClassiques.get(i);
            classique.seDeplacer(direction);
        }
        
        
        for(int i =0; i<lesTueurs.size(); i++){
            int index = getRandomNumberInRange(0, 100)%3;
            char direction = directions[index];
            Tueur tueur = (Tueur)lesTueurs.get(i);
            tueur.seDeplacer(direction);
        }
        
        System.out.println("==================== "+nbrToursDeJeu+"========================");
        Afficher();
        
        TourSuivant();
    }
    
    public void TourSuivant(){
        if(nbrToursDeJeu>1){
            nbrToursDeJeu--;
            CommencerLeJeu();
        } else{
            System.out.println("Nombre de classiques : "+this.nbrRobotsClassiques);
            System.out.println("Nombre de tueurs : "+this.nbrRobotsTueurs);
            System.out.println("Nombre de Demineurs : "+this.nbrRobotDemineur);
        }
            
    }
    
    

        public void peuplerScene(){
            for(int i = 0; i < this.demensions; i++){
                    for(int j = 0; j < this.demensions; j++){
                        scene[i][j] = null;
                    }
                }
            insererRobots();
        }
        
        
        public void insererRobots(){
            
            int cptRobot =1;
            while(cptRobot <=4){
                int x = getRandomNumberInRange(0, this.demensions-1);
                int y = getRandomNumberInRange(0, this.demensions-1);
                if(estLibre(x, y)){
                    Robot classique = new Robot(x, y, this);
                    //lesClassiques.add(classique);
                    scene[x][y] = classique;
                    cptRobot++;
                }
                
            }
            
            
            
            int cptTueur =1;
            while(cptTueur <= 2){
                int x = getRandomNumberInRange(0, this.demensions-1);
                int y = getRandomNumberInRange(0, this.demensions-1);
                if(estLibre(x, y)){
                    Tueur tueur = new Tueur(x, y, this);
                    //lesTueurs.add(tueur);
                    scene[x][y] = tueur;
                    cptTueur++;
                }
            }
            
            int cptdemineur = 1;
            while(cptdemineur < 2){
                int x = getRandomNumberInRange(0, this.demensions-1);
                int y = getRandomNumberInRange(0, this.demensions-1);
                if(estLibre(x, y)){
                    Démineur demineur = new Démineur(x, y, this);
                    //lesDemineurs.add(demineur);
                    scene[x][y] = demineur;
                    cptdemineur++;
                }
            }
        }
        
        private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
        
        

	/**
	 * 
	 * @param unX
	 * @param unY
	 */
	public boolean estLibre(int unX, int unY) {
            return scene[unX][unY] ==  null || scene[unX][unY] instanceof  Bombe ;
	}

	/**
	 * 
	 * @param unX
	 * @param unY
	 */
	public void Liberer(int unX, int unY) {
		scene[unX][unY]= null;
	}

	/**
	 * 
	 * @param unX
	 * @param unY
	 */
	public void Occuper(int unX, int unY) {
		// TODO - implement Monde.Occuper
		throw new UnsupportedOperationException();
	}

	public void Afficher() {
		for(int i = 0; i < this.scene.length; i++){
                    for(int j = 0; j < this.scene[0].length; j++){
                        if(scene[i][j]==null){
                            System.out.print("o ");
                        } else{
                            System.out.print(scene[i][j].toString()+" ");
                        }
                    }
                    System.out.println();
                }
	}

	/**
	 * 
	 * @param unX
	 * @param unY
	 */
	public boolean Bombe(int unX, int unY) {
		// TODO - implement Monde.Bombe
		throw new UnsupportedOperationException();
	}

}
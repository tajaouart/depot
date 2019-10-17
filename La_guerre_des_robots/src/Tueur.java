public class Tueur extends Robot {

	private int compteur=0;
        private char idRobot = 'T';

    public Tueur(int saPosX, int saPoxY, Monde unMonde) {
        super(saPosX, saPoxY, unMonde);
        monde.lesTueurs.add(this);
    }

	/**
	 * 
	 * @param unX
	 * @param unY
	 */
	public void PoserUneBomb(int unX, int unY) {
		// TODO - implement Tueur.PoserUneBomb
		throw new UnsupportedOperationException();
	}

    @Override
    public void seDeplacer(char unDep) {
            
            if(unDep == 'H' &&   saPosX>0 && monde.estLibre(saPosX-1,saPoxY) ){
                if(monde.scene[saPosX-1][saPoxY] instanceof  Bombe){
                    SeExploser(saPosX-1,saPoxY);
                }else{
                    monde.Liberer(saPosX, saPoxY);
                    Miner(saPosX,saPoxY);
                    monde.scene[saPosX-1][saPoxY] = this;
                    this.saPosX -=1;
                    compteur--;
                }
            }else if(unDep == 'D' && saPoxY  < monde.demensions-1 && monde.estLibre(saPosX,saPoxY+1) ){
                if(monde.scene[saPosX][saPoxY+1] instanceof  Bombe){
                    SeExploser(saPosX,saPoxY+1);
                }else{
                   monde.Liberer(saPosX, saPoxY);
                   Miner(saPosX,saPoxY);
                   monde.scene[saPosX][saPoxY+1] = this;
                   this.saPoxY += 1;
                   compteur--;
                }

                
            }else if(unDep == 'B' && saPosX  < monde.demensions-1 && monde.estLibre(saPosX+1,saPoxY)){
                if(monde.scene[saPosX+1][saPoxY] instanceof  Bombe){
                    SeExploser(saPosX+1,saPoxY);
                }else{
                    monde.Liberer(saPosX, saPoxY);
                    Miner(saPosX,saPoxY);
                    monde.scene[saPosX+1][saPoxY] = this;
                    this.saPosX += 1;
                    compteur--;
                }
                
                
            }else if(unDep == 'G' && saPoxY  > 0 && monde.estLibre(saPosX,saPoxY-1)){
                if(monde.scene[saPosX][saPoxY-1] instanceof  Bombe){
                    SeExploser(saPosX,saPoxY-1);
                }else{
                    monde.Liberer(saPosX, saPoxY);
                    Miner(saPosX,saPoxY);
                    monde.scene[saPosX][saPoxY-1] = this;
                    this.saPoxY -= 1;
                    compteur--;
                }
                
                
            }
            
   
	}
        
        

	public void Miner(int x, int y) {
		if(compteur <= 0){
                    Bombe uneBombe = new Bombe();
                     monde.scene[x][y] = uneBombe;
                        compteur=3;
            }
	}
        
        @Override
        public void SeExploser(int x, int y) {
            // remove bomb
            monde.scene[x][y] = null;
            // remove robot
            monde.scene[saPosX][saPoxY] = null;
            this.monde.lesTueurs.remove(this);
	}
        
        
        
        
        @Override
    public String toString() {
        return String.valueOf(this.idRobot);
    }

}
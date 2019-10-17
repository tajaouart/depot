public class Démineur extends Robot {

	private boolean disponible;
        private char idRobot = 'D';

    public Démineur(int saPosX, int saPosY, Monde unMonde) {
        super(saPosX, saPosY, unMonde);
        monde.lesDemineurs.add(this);
    }
    
    @Override
    public void seDeplacer(char unDep) {
            
            if(unDep == 'H' &&   saPosX>0 && monde.estLibre(saPosX-1,saPoxY) ){
                if(monde.scene[saPosX-1][saPoxY] instanceof  Bombe){
                    Deminer(saPosX-1,saPoxY);
                }
                monde.Liberer(saPosX, saPoxY);
                monde.scene[saPosX-1][saPoxY] = this;
                this.saPosX -=1;
                
            }else if(unDep == 'D' && saPoxY  < monde.demensions-1 && monde.estLibre(saPosX,saPoxY+1) ){
                if(monde.scene[saPosX][saPoxY+1] instanceof  Bombe){
                    Deminer(saPosX,saPoxY+1);
                }
                monde.Liberer(saPosX, saPoxY);
                monde.scene[saPosX][saPoxY+1] = this;
                this.saPoxY += 1;
                

                
            }else if(unDep == 'B' && saPosX  < monde.demensions-1 && monde.estLibre(saPosX+1,saPoxY)){
                if(monde.scene[saPosX+1][saPoxY] instanceof  Bombe){
                    Deminer(saPosX+1,saPoxY);
                }
                monde.Liberer(saPosX, saPoxY);
                monde.scene[saPosX+1][saPoxY] = this;
                this.saPosX += 1;
                
                
                
            }else if(unDep == 'G' && saPoxY  > 0 && monde.estLibre(saPosX,saPoxY-1)){
                if(monde.scene[saPosX][saPoxY-1] instanceof  Bombe){
                    Deminer(saPosX,saPoxY-1);
                }
                monde.Liberer(saPosX, saPoxY);
                monde.scene[saPosX][saPoxY-1] = this;
                this.saPoxY -= 1;
                
                
                
            }
            
   
	}

	public void Deminer(int x,int y) {
            if(monde.nbrToursDeJeu % 3 == 0){
                monde.scene[x][y] = null ;
                disponible = false;
            }
	}
    
        @Override
    public String toString() {
        return String.valueOf(this.idRobot);
    }
        

}
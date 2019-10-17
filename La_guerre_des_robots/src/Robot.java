
import java.awt.Dimension;

public class Robot {

	protected int saPosX;
	protected int saPoxY;
	protected char idRobot ;
        protected Monde monde;

    public Robot(int saPosX, int saPoxY, Monde unMonde) {
        this.monde = unMonde;
        this.saPosX = saPosX;
        this.saPoxY = saPoxY;
        this.idRobot = 'C';
        monde.lesClassiques.add(this);
    }
        
    
       
	/**
	 * 
	 * @param unX
	 * @param unY
	 */
	public void seDeplacer(char unDep) {
            
            if(unDep == 'H' &&   saPosX>0 && monde.estLibre(saPosX-1,saPoxY) ){
                if(monde.scene[saPosX-1][saPoxY] instanceof  Bombe){
                    SeExploser(saPosX-1,saPoxY);
                }else{
                    monde.Liberer(saPosX, saPoxY);
                    monde.scene[saPosX-1][saPoxY] = this;
                    this.saPosX -=1;
                }
            }else if(unDep == 'D' && saPoxY  < monde.demensions-1 && monde.estLibre(saPosX,saPoxY+1) ){
                if(monde.scene[saPosX][saPoxY+1] instanceof  Bombe){
                    SeExploser(saPosX,saPoxY+1);
                }else{
                   monde.Liberer(saPosX, saPoxY);
                   monde.scene[saPosX][saPoxY+1] = this;
                   this.saPoxY += 1;
                }

                
            }else if(unDep == 'B' && saPosX  < monde.demensions-1 && monde.estLibre(saPosX+1,saPoxY)){
                if(monde.scene[saPosX+1][saPoxY] instanceof  Bombe){
                    SeExploser(saPosX+1,saPoxY);
                }else{
                    monde.Liberer(saPosX, saPoxY);
                    monde.scene[saPosX+1][saPoxY] = this;
                    this.saPosX += 1;
                }
                
                
            }else if(unDep == 'G' && saPoxY  > 0 && monde.estLibre(saPosX,saPoxY-1)){
                if(monde.scene[saPosX][saPoxY-1] instanceof  Bombe){
                    SeExploser(saPosX,saPoxY-1);
                }else{
                    monde.Liberer(saPosX, saPoxY);
                    monde.scene[saPosX][saPoxY-1] = this;
                    this.saPoxY -= 1;
                }
                
                
            }
            
   
	}

	public void SeExploser(int x, int y) {
            // remove bomb
            monde.scene[x][y] = null;
            // remove robot
            monde.scene[saPosX][saPoxY] = null;
            this.monde.lesClassiques.remove(this);
	}

        @Override
        public String toString() {
            return String.valueOf(this.idRobot);
        }
        
        
        

}
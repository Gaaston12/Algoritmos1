package damas;
public class Par{

    private Integer x;
    private Integer y;

    public Par(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX(){
        return this.x;
    }

    public void setX (int x){
        this.x = x;
    }

    public void setY (int x){
        this.x = x;
    }
    public Integer getY(){
        return this.y;
    }

    //Parsea de par a entero
    public static int  parToInt (Par coord, int lado){
        return lado * coord.getX()+ coord.getY();
    }

    //Parsea de entero de a par
    public static Par intToPar(int n, int pos){
        int x = pos / n;
        int y = pos % n;
        return new Par(x,y);
    }
    
}

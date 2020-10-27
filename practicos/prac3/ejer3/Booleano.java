//abstracto {True, False, ^, V, !, =>}
//concreto {True', False', ^', V', !', =>'}
//0 False; != 0 True
//True' 0
//False' > 1
//^':  * 
//v: +
//!: si x==0? 1:0


public interface Booleano{



    pubilc Booleano negacion();

    pubilc Booleano conjuncion(Booleano b);

    pubilc Booleano disyuncion(Booleano b);

}

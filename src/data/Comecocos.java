/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author isra
 */
public class Comecocos {
    public static final int IZQUIERDA = 1;
    public static final int DERECHA = 2;
    public static final int ARRIBA  = 3;
    public static final int ABAJO = 4;

    // Posibles situaciones al mover el comecocos
    static final int VACIA = 0;
    static final int CHOCA_BLOQUE = 1;
    static final int CHOCA_FANTASMA = 2;
    static final int COME_BOLA = 3;
    static final int COME_BOLITA = 4;
    
    private int fila; // posicion y
    private int columna; // posicion x
    private int direccion_actual; // Direccion que tiene actualmente
    private int direccion_nueva; // Direccion nueva cuando sea posible
    private Rejilla rejilla;
    private int secuencia; // Secuencia de la animacion
    private boolean moviendose;

    public Comecocos(Rejilla r){
        rejilla=r;
        initComecocos();
    }

    public void setDireccion(int d){
        direccion_nueva=d;
    }

    public int getDireccion(){
        return direccion_actual;
    }


    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public void setSecuencia(int s){
       secuencia=s;
    }

    public int getSecuencia(){
        return secuencia;
    }

    public boolean getMoviendose(){
        return moviendose;
    }

    public void setMoviendose(boolean m){
        moviendose=m;
    }

    public void initComecocos(){
        fila=23;
        columna=13;
        direccion_actual=IZQUIERDA;
        direccion_nueva=IZQUIERDA;
        secuencia=2;
        moviendose=true;
    }

    public int avanza(){
        int fil_temp,col_temp;
        char c;

        fil_temp=fila;
        col_temp=columna;
        // Si son iguales las dos direcciones
        if(direccion_actual==direccion_nueva){
            if(direccion_actual==IZQUIERDA){
                if(columna==0){ // Por si esta en el pasillo de comunicacion
                    col_temp=27;
                }
                else{
                    col_temp--;
                }
            }
            else if(direccion_actual==DERECHA){
                if(columna==27){ // Por si esta en el pasillo de comunicacion
                    col_temp=0;
                }
                else{
                    col_temp++;
                }
            }
            else if(direccion_actual==ABAJO){
                fil_temp++;
            }
            else if(direccion_actual==ARRIBA){
                fil_temp--;
            }
            //Comprobar la casilla y actuar segun se la casilla
            c=rejilla.getTipoCelda(fil_temp, col_temp);
            if(c==Rejilla.VACIA){
                rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                fila=fil_temp;
                columna=col_temp;
                moviendose=true;
                return VACIA;
            }
            else if(c==Rejilla.BOLA){
                rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                fila=fil_temp;
                columna=col_temp;
                moviendose=true;
                return COME_BOLA;
            }
            else if(c==Rejilla.BOLITA){
                rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                fila=fil_temp;
                columna=col_temp;
                moviendose=true;
                return COME_BOLITA;
            }
            else{ // Es algun tipo de BLOQUE o un FANTASMA
                rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                moviendose=false;
                return CHOCA_BLOQUE;
            }
        }
        else{ // Si no son iguales el comecocos cambiara de direccion en caso de no poder seguira con la que tenga actualmente hasta que pueda cambiarla
            fil_temp=fila;
            col_temp=columna;
            if(direccion_nueva==IZQUIERDA){
                if(columna==0){
                    col_temp=27;
                }
                else{
                    col_temp--;
                }
            }
            else if(direccion_nueva==DERECHA){
                if(columna==27){
                    col_temp=0;
                }
                else{
                    col_temp++;
                }
            }
            else if(direccion_nueva==ABAJO){
                fil_temp++;
            }
            else if(direccion_nueva==ARRIBA){
                fil_temp--;
            }
            //Comprobar la casilla y actuar segun se la casilla
            c=rejilla.getTipoCelda(fil_temp, col_temp);
            if(c==Rejilla.VACIA){ // Ya puede cambiar de direccion
                rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                fila=fil_temp;
                columna=col_temp;
                moviendose=true;
                direccion_actual=direccion_nueva;
                return VACIA;
            }
            else if(c==Rejilla.BOLA){ // Ya puede cambiar de direccion
                rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                fila=fil_temp;
                columna=col_temp;
                moviendose=true;
                direccion_actual=direccion_nueva;
                return COME_BOLA;
            }
            else if(c==Rejilla.BOLITA){ // Ya puede cambiar de direccion
                rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                fila=fil_temp;
                columna=col_temp;
                moviendose=true;
                direccion_actual=direccion_nueva;
                return COME_BOLITA;
            }
            else{ // Es algun tipo de BLOQUE, sigue con la direccion actual
                fil_temp=fila;
                col_temp=columna;
                if(direccion_actual==IZQUIERDA){
                    if(columna==0){
                        col_temp=27;
                    }
                    else{
                        col_temp--;
                    }
                }
                else if(direccion_actual==DERECHA){
                    if(columna==27){
                        col_temp=0;
                    }
                    else{
                        col_temp++;
                    }
                }
                else if(direccion_actual==ABAJO){
                    fil_temp++;
                }
                else if(direccion_actual==ARRIBA){
                    fil_temp--;
                }
                //Comprobar la casilla y actuar segun se la casilla
                c=rejilla.getTipoCelda(fil_temp, col_temp);
                if(c==Rejilla.VACIA){
                    rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                    fila=fil_temp;
                    columna=col_temp;
                    moviendose=true;
                    return VACIA;
                }
                else if(c==Rejilla.BOLA){
                    rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                    fila=fil_temp;
                    columna=col_temp;
                    moviendose=true;
                    return COME_BOLA;
                }
                else if(c==Rejilla.BOLITA){
                    rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                    fila=fil_temp;
                    columna=col_temp;
                    moviendose=true;
                    return COME_BOLITA;
                }
                else{ // Es algun tipo de BLOQUE
                    rejilla.assignTipoCelda(fila,columna,rejilla.VACIA);
                    moviendose=false;
                    return CHOCA_BLOQUE;
                }
            }

        }
    }

    // Inicializa al comecocos
    public void matarComecocos(){
        fila=23;
        columna=13;
        direccion_actual=IZQUIERDA;
        direccion_nueva=IZQUIERDA;
        secuencia=2;
        moviendose=true;
    }
}

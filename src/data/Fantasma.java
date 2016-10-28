/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import java.util.Random;
/**
 *
 * @author isra
 */
public class Fantasma {
    public static final int IZQUIERDA = 1;
    public static final int DERECHA = 2;
    public static final int ARRIBA  = 3;
    public static final int ABAJO = 4;

    private int fila; // posicion y del fantasma
    private int columna; // posicion x del fantasma
    private boolean comestible; // Indica si esta en estado comestible o no
    private boolean vivo; // Indica si el fantasma esta en la casa o no
    private int direccion; // Indica la direccion actual del fantasma
    private int secuencia; // Indica la secuencia de animacion del fantasma
    private Rejilla rejilla;
    private int idFantasma; // Identificador de fantasma
    private Random rand; // Objeto rand para generar la direccion aleatoria del fantasma
    private int ncasillas; // Indica el numero de casillas avanzadas por el fantasma desde que nace
    private int ncasillasComestible; // Indica el numero de casillas avanzadas en estado comestible

    public Fantasma(Rejilla r,int id){
        initFantasma(r,id);
    }

    // Inicializa los fantasmas
    public void initFantasma(Rejilla r,int id){
        rejilla=r;
        if(id==0){
            idFantasma=0;
            vivo=true; // El primer fantasma si estara activo al principio
            direccion=ARRIBA;
            fila=11;
            columna=13;
        }
        else if(id==1){
            idFantasma=1;
            vivo=false;
            direccion=ARRIBA;
            fila=14;
            columna=13;
        }
        else if(id==2){
            idFantasma=2;
            vivo=false;
            direccion=ARRIBA;
            fila=14;
            columna=14;
        }
        else{
            idFantasma=3;
            vivo=false;
            direccion=ARRIBA;
            fila=14;
            columna=15;
        }
        comestible=false;
        secuencia=4;
        rand=new Random();
        ncasillas=0;
        ncasillasComestible=0;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public void setComestible(boolean c){
        comestible=c;
    }

    public boolean getComestible(){
        return comestible;
    }

    public void setVivo(boolean a){
        vivo=a;
    }

    public boolean getVivo(){
        return vivo;
    }

    public void setDireccion(int dir){
        direccion=dir;
    }

    public int getDireccion(){
        return direccion;
    }

    public void setSecuencia(int s){
        secuencia=s;
    }

    public int getSecuencia(){
        return secuencia;
    }

    public int getIdFantasma(){
        return idFantasma;
    }

    public int getNcasillas(){
        return ncasillas;
    }

    public void setNcasillas(int nc){
        ncasillas=nc;
    }

    public int getNcasillasComestible(){
        return ncasillasComestible;
    }

    public void setNcasillasComestible(int nc){
        ncasillasComestible=nc;
    }

    /* Mueve el fantasma segun su direccion, si el fantasma choca contra un muro se generara
     * aleatoriamente con probabilidad 1/2 una nueva direccion no permitiendo un cambio inverso
     * de direccion.
     */
    public void avanza(){
        int fil,col;
        char c;

        fil=fila;
        col=columna;
        if(direccion==IZQUIERDA){
            if(col==0){
               col=27;
            }
            else{
                 col--;
            }
         }
         else if(direccion==DERECHA){
             if(col==27){
                 col=0;
             }
             else{
                 col++;
             }
         }
         else if(direccion==ABAJO){
             fil++;
         }
         else if(direccion==ARRIBA){
             fil--;
         }
         //Comprobar la casilla y actuar segun se la casilla
         c=rejilla.getTipoCelda(fil, col);
         if((c==Rejilla.VACIA) || (c==Rejilla.BOLA) || (c==Rejilla.BOLITA) || (c==Rejilla.PUERTA)){
             fila=fil;
             columna=col;
         }
         else{ // Choca con algun tipo de BLOQUE
             fil=fila;
             col=columna;
             // Generar nueva direccion aleatoria no permitiendo direccion contaria
             direccion=direccionAleatoria();
             // Avanzar segun la direccion
             if(direccion==IZQUIERDA){
                if(col==0){
                   col=27;
                }
                else{
                     col--;
                }
             }
             else if(direccion==DERECHA){
                 if(col==27){
                     col=0;
                 }
                 else{
                     col++;
                 }
             }
             else if(direccion==ABAJO){
                fil++;
             }
             else if(direccion==ARRIBA){
                fil--;
             }
             fila=fil;
             columna=col;
         }
         ncasillas++; // Incrementa numero de casillas avanzadas
         if(comestible){
             ncasillasComestible++; // Incrementa numero de casillas avanzadas en estado comestible
         }
    }

    // Genera una direccion aleatoria con probabilidad 1/2
    private int direccionAleatoria(){
        int d,dir,fil,col;
        char c;

        fil=fila;
        col=columna;
        dir=0;
        if(direccion==DERECHA || direccion==IZQUIERDA){
            // Generar entre arriba o abajo con 1/2 de posiblidades
           d = rand.nextInt(2);
           if(d==0){ // arriba
               fil--;
               // Comprobar que es posible ir hacia arriba
               c=rejilla.getTipoCelda(fil, col);
               if((c==Rejilla.VACIA) || (c==Rejilla.BOLA) || (c==Rejilla.BOLITA)){ // Es posible
                    dir=ARRIBA;
               }
               else{ //  No es posible
                   // Se asigna direccion contraria
                   dir=ABAJO;
               }
           }
           else{ // abajo
               fil++;
               // Comprobar que es posible ir hacia abajo
               c=rejilla.getTipoCelda(fil, col);
               if((c==Rejilla.VACIA) || (c==Rejilla.BOLA) || (c==Rejilla.BOLITA)){ // Es posible
                    dir=ABAJO;
               }
               else{ //  No es posible
                   // Se asigna direccion contraria
                   dir=ARRIBA;
               }
           }
        }
        else if(direccion==ABAJO || direccion==ARRIBA){
             // Generar entre izquierda o derecha con 1/2 de posiblidades
           d = rand.nextInt(2);
           if(d==0){ // izquierda
               col--;
               // Comprobar que es posible ir hacia izquierda
               c=rejilla.getTipoCelda(fil, col);
               if((c==Rejilla.VACIA) || (c==Rejilla.BOLA) || (c==Rejilla.BOLITA)){ // Es posible
                    dir=IZQUIERDA;
               }
               else{ //  No es posible
                   // Se asigna direccion contraria
                   dir=DERECHA;
               }
           }
           else{ // derecha
               col++;
               // Comprobar que es posible ir hacia derecha
               c=rejilla.getTipoCelda(fil, col);
               if((c==Rejilla.VACIA) || (c==Rejilla.BOLA) || (c==Rejilla.BOLITA)){ // Es posible
                    dir=DERECHA;
               }
               else{ //  No es posible
                   // Se asigna direccion contraria
                   dir=IZQUIERDA;
               }
           }
        }
        return dir;
    }

    // Reinicia a un fantasma despues de ser comido por el comecocos
    void matarFantasma(){
        vivo=true;
        comestible=false;
        direccion=ARRIBA;
        fila=14;
        columna=14;
    }

}

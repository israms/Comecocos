/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RejillaPanel.java
 *
 * Created on Feb 12, 2011, 10:09:26 PM
 */

package guicomecocos;
import data.*;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author isra
 */
public class RejillaPanel extends javax.swing.JPanel {
    /**
     * Referencia al ComecocosFrame donde se incluye este JPanel
     */
    private ComecocosFrame ventanaPrincipal;

    /**
     * Numero de pixeles de ancho y alto de cada celda de este tablero de juego
     */
    private int anchoCelda;

    /*
     *  Banderas booleanas utilizadas para dibujar texto en distintas situaciones
     */
    private boolean primera;
    private boolean finalizado;
    private boolean derrotado;

    /** Creates new form RejillaPanel */
    public RejillaPanel() {
        initComponents();
        anchoCelda=-1;
        primera=true;
        finalizado=false;
        derrotado=false;
    }

    /**
     * Crea rejilla asociada a un frame
     * @param vp Frame asociado a RejillaPanel
     */
    public RejillaPanel(ComecocosFrame vp){
        this();
        ventanaPrincipal=vp;
    }

    public void setFinalizado(boolean b){
        finalizado=b;
    }

    public void setDerrotado(boolean b){
        derrotado=b;
    }

    // Dibuja el escenario
    public void dibujaRejilla(java.awt.Graphics g){
        int i,j;
        Rejilla rejilla=ventanaPrincipal.getRejilla();
        int xoffset=0;

        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        for(i=0;i<rejilla.getAltura();i++){
            for(j=0;j<rejilla.getAnchura();j++){
               if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_1){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_2){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_3){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_4){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2),xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda);
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_5){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_6){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_7){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_8){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2),xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda);
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_e){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_f){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_g){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+anchoCelda);
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_h){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_m){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2),xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda);
               }
               else if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE_n){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_A){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2),xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_B){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2),xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_a){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2),xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_b){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+(anchoCelda/2),xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+(anchoCelda/2));
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_I){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda,xoffset+j*anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda,xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda);
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_D){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+anchoCelda,i*anchoCelda,xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda,xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda);
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_i){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda,xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda);
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BLOQUE_d){
                    g.setColor(Color.BLUE);
                    g.drawLine(xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda,xoffset+j*anchoCelda+(anchoCelda/2),i*anchoCelda+anchoCelda);
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.PUERTA){
                    g.setColor(Color.WHITE);
                    g.drawLine(xoffset+j*anchoCelda,i*anchoCelda+anchoCelda-(anchoCelda/5),xoffset+j*anchoCelda+anchoCelda,i*anchoCelda+anchoCelda-(anchoCelda/5));
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BOLA){
                    g.setColor(Color.WHITE);
                    g.fillOval(xoffset+j*anchoCelda+(anchoCelda/4),i*anchoCelda+(anchoCelda/4),8,8);
               }
               else if(rejilla.getTipoCelda(i, j) == Rejilla.BOLITA){
                    g.setColor(Color.WHITE);
                    g.fillOval(xoffset+j*anchoCelda+(anchoCelda/2)-1,i*anchoCelda+(anchoCelda/2),3,3);
               }
            }
        }
    }

    /*
     * Dibuja el comecocos en el tablero segun su posicion,secuencia de la animacion y direccion
     * Para dibujar la animacion va dibujando desde la posicion origen hasta la posicion destino
     */
    public void dibujaComecocos(java.awt.Graphics g){
        Comecocos cm=ventanaPrincipal.getComecocos();
        // Obtener atributos del comecocos
        int direccion=cm.getDireccion();
        int fil=cm.getFila();
        int col=cm.getColumna();
        int cx,cy,secuencia;
        int col_anterior,fil_anterior;
        boolean moviendose=cm.getMoviendose();
        int r = anchoCelda/2;
        secuencia=cm.getSecuencia();

        g.setColor(Color.YELLOW);
        if(direccion==cm.DERECHA & moviendose){
            cy = fil*anchoCelda+(anchoCelda/2)-1;
            col_anterior=col-1;
            if(secuencia==0){
                cx = col_anterior*anchoCelda+(anchoCelda/2);
                g.fillArc(cx -r , cy - r, 2 * r, 2 * r, 60, 240);
            }
            else if(secuencia==1){
                cx = col_anterior*anchoCelda+(anchoCelda/2)+(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 45, 270);
            }
            else if(secuencia==2){
                cx = col_anterior*anchoCelda+(anchoCelda/2)+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 30, 300);
            }
            else if(secuencia==3){
                cx = col*anchoCelda+(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 15, 345);
            }
            else if(secuencia==4){
                cx = col*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 0, 360);
                cm.setSecuencia(0); // Reinicia la secuencia
            }
        }
        else if(direccion==cm.IZQUIERDA & moviendose){
            cy = fil*anchoCelda+(anchoCelda/2)-1;
            col_anterior=col+1;
            if(secuencia==0){
                cx = col_anterior*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 240, 240);
            }
            else if(secuencia==1){
                cx = col_anterior*anchoCelda+(anchoCelda/2)-(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 225, 270);
            }
            else if(secuencia==2){
                cx = col_anterior*anchoCelda+(anchoCelda/2)-(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 210, 300);
            }
            else if(secuencia==3){
                cx = col*anchoCelda+3*(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 195, 330);
            }
            else if(secuencia==4){
                cx = col*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 240, 360);
                cm.setSecuencia(0); // Reinicia la secuencia
            }
        }
        else if(direccion==cm.ARRIBA & moviendose){
            cx = col*anchoCelda+(anchoCelda/2)-1;
            fil_anterior=fil+1;
            if(secuencia==0){
                cy = fil_anterior*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 150, 240);
            }
            else if(secuencia==1){
                cy = fil_anterior*anchoCelda+(anchoCelda/2)-(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 135, 270);
            }
            else if(secuencia==2){
                cy = fil_anterior*anchoCelda+(anchoCelda/2)-(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 120, 300);
            }
            else if(secuencia==3){
                cy = fil*anchoCelda+3*(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 105, 330);
            }
            else if(secuencia==4){
                cy = fil*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 90, 360);
                cm.setSecuencia(0); // Reinicia la secuencia
            }
        }
        else if(direccion==cm.ABAJO & moviendose){
            cx = col*anchoCelda+(anchoCelda/2)-1;
            fil_anterior=fil-1;
            if(secuencia==0){
                cy = fil_anterior*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 330, 240);
            }
            else if(secuencia==1){
                cy = fil_anterior*anchoCelda+(anchoCelda/2)+(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 315, 270);
            }
            else if(secuencia==2){
                cy = fil_anterior*anchoCelda+(anchoCelda/2)+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 300, 300);
            }
            else if(secuencia==3){
                cy = fil*anchoCelda+(anchoCelda/4);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 285, 330);
            }
            else if(secuencia==4){
                cy = fil*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 270, 360);
                cm.setSecuencia(0); // Reinicia la secuencia
            }
        }
        else if(!moviendose){
            if(direccion==cm.DERECHA){
                cy = fil*anchoCelda+(anchoCelda/2)-1;
                cx = col*anchoCelda+(anchoCelda/2);
                g.fillArc(cx -r , cy - r, 2 * r, 2 * r, 60, 240);
            }
            else if(direccion==cm.IZQUIERDA){
                cy = fil*anchoCelda+(anchoCelda/2)-1;
                cx = col*anchoCelda+(anchoCelda/2);
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 240, 240);
            }
            else if(direccion==cm.ARRIBA){
                cy = fil*anchoCelda+(anchoCelda/2);
                cx = col*anchoCelda+(anchoCelda/2)-1;
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 150, 240);
            }
            else if(direccion==cm.ABAJO){
                cy = fil*anchoCelda+(anchoCelda/2);
                cx = col*anchoCelda+(anchoCelda/2)-1;
                g.fillArc(cx - r, cy - r, 2 * r, 2 * r, 330, 240);
            }
        }
    }

    /*
     * Dibuja todos los fantasmas
     */
    public void dibujaFantasmas(java.awt.Graphics g){
        Fantasma fantasmas[]=ventanaPrincipal.getFantasmas();
        int direccion;
        int fil;
        int col;
        int secuencia;
        int col_anterior,fil_anterior;
        int id_fantasma;
        boolean vivo;


        for(int i=0;i<4;i++){
            // Obtener los atributos del fantasma i
            secuencia=fantasmas[i].getSecuencia();
            id_fantasma=fantasmas[i].getIdFantasma();
            fil=fantasmas[i].getFila();
            col=fantasmas[i].getColumna();
            direccion=fantasmas[i].getDireccion();
            vivo=fantasmas[i].getVivo();

            // En funcion del id del fantasma utiliza un color
            if(id_fantasma==0 && !fantasmas[i].getComestible()){
                g.setColor(Color.RED);
            }
            else if(id_fantasma==1 && !fantasmas[i].getComestible()){
                g.setColor(Color.PINK);
            }
            else if(id_fantasma==2 && !fantasmas[i].getComestible()){
                g.setColor(Color.CYAN);
            }
            else if(id_fantasma==3 && !fantasmas[i].getComestible()){
                g.setColor(Color.ORANGE);
            }
            else{ // Es comestible
                // Pintarlo de azul
                g.setColor(Color.BLUE);
            }


            if(direccion==fantasmas[i].DERECHA && vivo){
                col_anterior=col-1;
                if(secuencia==0){
                    g.fillRect(col_anterior*anchoCelda,fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col_anterior*anchoCelda,fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col_anterior*anchoCelda+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==1){
                    g.fillRect(col_anterior*anchoCelda+(anchoCelda/4),fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/4),fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/4)+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/4)+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==2){
                    g.fillRect(col_anterior*anchoCelda+(anchoCelda/2),fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/2),fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/2)+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/2)+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==3){
                    g.fillRect(col_anterior*anchoCelda+3*(anchoCelda/4),fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col_anterior*anchoCelda+3*(anchoCelda/4),fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col_anterior*anchoCelda+3*(anchoCelda/4)+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col_anterior*anchoCelda+3*(anchoCelda/4)+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==4){
                    g.fillRect(col*anchoCelda,fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                    fantasmas[i].setSecuencia(0); // Reinicia la secuencia
                }
            }
            else if(direccion==fantasmas[i].IZQUIERDA && vivo){
                col_anterior=col+1;
                if(secuencia==0){
                    g.fillRect(col_anterior*anchoCelda,fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col_anterior*anchoCelda,fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col_anterior*anchoCelda+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col_anterior*anchoCelda+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==1){
                    g.fillRect(col_anterior*anchoCelda-(anchoCelda/4),fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col_anterior*anchoCelda-(anchoCelda/4),fil*anchoCelda-5,anchoCelda,anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col_anterior*anchoCelda-(anchoCelda/4)+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col_anterior*anchoCelda-(anchoCelda/4)+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==2){
                    g.fillRect(col_anterior*anchoCelda-(anchoCelda/2),fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col_anterior*anchoCelda-(anchoCelda/2),fil*anchoCelda-5,anchoCelda,anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col_anterior*anchoCelda-(anchoCelda/2)+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col_anterior*anchoCelda-(anchoCelda/2)+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==3){
                    g.fillRect(col*anchoCelda+(anchoCelda/4),fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil*anchoCelda-5,anchoCelda,anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4)+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col*anchoCelda+(anchoCelda/4)+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                }
                else if(secuencia==4){
                    g.fillRect(col*anchoCelda,fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil*anchoCelda-5,anchoCelda,anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                    fantasmas[i].setSecuencia(0); // Reinicia la secuencia
                }
            }
            else if(direccion==fantasmas[i].ARRIBA && vivo){
                fil_anterior=fil+1;
                if(secuencia==0){
                    g.fillRect(col*anchoCelda,fil_anterior*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil_anterior*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda+4,4,4);
                }
                else if(secuencia==1){
                    g.fillRect(col*anchoCelda,fil_anterior*anchoCelda-(anchoCelda/4),anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil_anterior*anchoCelda-(anchoCelda/4)-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda-(anchoCelda/4)+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda-(anchoCelda/4)+4,4,4);
                }
                else if(secuencia==2){
                    g.fillRect(col*anchoCelda,fil_anterior*anchoCelda-(anchoCelda/2),anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil_anterior*anchoCelda-(anchoCelda/2)-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda-(anchoCelda/2)+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda-(anchoCelda/2)+4,4,4);
                }
                else if(secuencia==3){
                    g.fillRect(col*anchoCelda,fil*anchoCelda+(anchoCelda/4),anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil*anchoCelda+(anchoCelda/4)-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil*anchoCelda+(anchoCelda/4)+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil*anchoCelda+(anchoCelda/4)+4,4,4);
                }
                else if(secuencia==4){
                    g.fillRect(col*anchoCelda,fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                    fantasmas[i].setSecuencia(0); // Reinicia la secuencia
                }
            }
            else if(direccion==fantasmas[i].ABAJO && vivo){
                fil_anterior=fil-1;
                if(secuencia==0){
                    g.fillRect(col*anchoCelda,fil_anterior*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil_anterior*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda+4,4,4);
                }
                else if(secuencia==1){
                    g.fillRect(col*anchoCelda,fil_anterior*anchoCelda+(anchoCelda/4),anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil_anterior*anchoCelda+(anchoCelda/4)-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda+(anchoCelda/4)+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda+(anchoCelda/4)+4,4,4);
                }
                else if(secuencia==2){
                    g.fillRect(col*anchoCelda,fil_anterior*anchoCelda+(anchoCelda/2),anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil_anterior*anchoCelda+(anchoCelda/2)-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda+(anchoCelda/2)+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda+(anchoCelda/2)+4,4,4);
                }
                else if(secuencia==3){
                    g.fillRect(col*anchoCelda,fil_anterior*anchoCelda+3*(anchoCelda/4),anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil_anterior*anchoCelda+3*(anchoCelda/4)-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda+3*(anchoCelda/4)+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda+3*(anchoCelda/4)+4,4,4);
                }
                else if(secuencia==4){
                    g.fillRect(col*anchoCelda,fil*anchoCelda,anchoCelda,anchoCelda);
                    g.fillOval(col*anchoCelda,fil*anchoCelda-5, anchoCelda, anchoCelda+1);
                    g.setColor(Color.BLACK);
                    g.fillOval(col*anchoCelda+(anchoCelda/4),fil*anchoCelda+4,4,4);
                    g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil*anchoCelda+4,4,4);
                    fantasmas[i].setSecuencia(0); // Reinicia la secuencia
                }
            }
            else if(!vivo){ // Si no esta activo no se mueve
                fil_anterior=fil+1;
                g.fillRect(col*anchoCelda,fil_anterior*anchoCelda-(anchoCelda/2),anchoCelda,anchoCelda);
                g.fillOval(col*anchoCelda,fil_anterior*anchoCelda-(anchoCelda/2)-4, anchoCelda, anchoCelda+1);
                g.setColor(Color.BLACK);
                g.fillOval(col*anchoCelda+(anchoCelda/4),fil_anterior*anchoCelda-(anchoCelda/2)+4,4,4);
                g.fillOval(col*anchoCelda+3*(anchoCelda/4),fil_anterior*anchoCelda-(anchoCelda/2)+4,4,4);
                fantasmas[i].setSecuencia(0); // Reinicia la secuencia
            }
        }
    }

    /*
     * Llama a todas las funciona que dibujan sobre el tablero
     */
    protected void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        // Calcula el ancho en pixeles de las celdas
        if(anchoCelda==-1){
           anchoCelda=Math.min(getWidth()/ventanaPrincipal.getRejilla().getAnchura(),(getHeight()-3)/ventanaPrincipal.getRejilla().getAltura());
        }
        dibujaRejilla(g);
        dibujaComecocos(g);
        dibujaFantasmas(g);
        if(primera){ // Al inciar la primera partida
            g.setColor(Color.YELLOW);
            g.drawString("PULSA Iniciar PARA COMENZAR",144,304);
            primera=false;
        }
        else if(finalizado){ // En caso de comerse todas las bolas
            System.out.println("finalizado en paintComponent");
            g.setColor(Color.WHITE);
            g.drawString("FIN DEL JUEGO!! HAS GANADO!", 144, 304);
            finalizado=false;
        }
        else if(derrotado){ // En caso de agotar las tres vidas del comecocos
            g.setColor(Color.GREEN);
            g.drawString("GAME OVER", 204, 304);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(200, 400));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Controlar los eventos del teclado
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_UP){
            Comecocos c=ventanaPrincipal.getComecocos();
            c.setDireccion(3);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            Comecocos c=ventanaPrincipal.getComecocos();
            c.setDireccion(4);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            Comecocos c=ventanaPrincipal.getComecocos();
            c.setDireccion(1);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
            Comecocos c=ventanaPrincipal.getComecocos();
            c.setDireccion(2);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            if(evt.getKeyCode()==KeyEvent.VK_SPACE){
                if(ventanaPrincipal.getMueve().getParado()){
                    ventanaPrincipal.getMueve().reanudar();
                }
                else{
                    ventanaPrincipal.getMueve().suspender();
                }
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
       requestFocus();
    }//GEN-LAST:event_formMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}

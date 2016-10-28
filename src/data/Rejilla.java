package data;
/**
 * Esta clase representa una rejilla con una determinada Anchura
 * y Altura, en la que cada celda puede estar VACIA, contener
 * un tipo de BLOQUE (muro exterior), una BOLA o BOLITA
 */
public class Rejilla{
    public static final char BLOQUE_1 = '1';
    public static final char BLOQUE_2 = '2';
    public static final char BLOQUE_3 = '3';
    public static final char BLOQUE_4 = '4';
    public static final char BLOQUE_5 = '5';
    public static final char BLOQUE_6 = '6';
    public static final char BLOQUE_7 = '7';
    public static final char BLOQUE_8 = '8';
    public static final char BLOQUE_A = 'A';
    public static final char BLOQUE_B = 'B';
    public static final char BLOQUE_a = 'a';
    public static final char BLOQUE_b = 'b';
    public static final char BLOQUE_I = 'I';
    public static final char BLOQUE_D = 'D';
    public static final char BLOQUE_i = 'i';
    public static final char BLOQUE_d = 'd';
    public static final char BLOQUE_e = 'e';
    public static final char BLOQUE_f = 'f';
    public static final char BLOQUE_g = 'g';
    public static final char BLOQUE_h = 'h';
    public static final char BLOQUE_m = 'm';
    public static final char BLOQUE_n = 'n';
    public static final char PUERTA = 'P';
    public static final char BOLITA = '.';
    public static final char BOLA = 'o';
    public static final char VACIA = '_';

    private int anchura=27;
    private int altura=30;
    private char[][] celdas;
    
    /**
     * Crea espacio para una rejilla con anchura igual a w y altura
     * igual a h.
     * @param w anchura de la nueva Rejilla
     * @param h altura de la nueva Rejilla
     */
    public Rejilla(int h,int w){
        altura=h;
        anchura=w;
        celdas= new char[altura][anchura];
        initRejilla();
    }
    
    /**
     * Devuelve la anchura de la rejilla.
     * @return la anchura de la rejilla
     */
    public int getAnchura(){
        return anchura;
    }
    
    /**
     * Devuelve la altura de la rejilla.
     * @return la altura de la rejilla
     */
    public int getAltura(){
        return altura;
    }
       
    /**
     * Establece el tipo de celda en las coordenadas x e y de esta Rejilla
     * @param x coordenada x (columna)
     * @param y coordenada y (fila)
     * @param valor el tipo de celda (VACIA, BOLA, BLOQUE_A, BLOQUE_B, etc.)
     */
    public void assignTipoCelda(int x,int y,char valor){
        celdas[x][y]= valor ;
    }
    
    /**
     * Obtiene el tipo de celda en las coordenadas x e y de esta Rejilla
     * @param x coordenada x (columna)
     * @param y coordenada y (fila)
     * @return el tipo de Celda en la coordenada x,y.
     */
    
    public char getTipoCelda(int x,int y){
        return celdas[x][y];
    }
    
    /**
     * Inicializa la rejilla con un mapa de juego predeterminado
     */
    public void initRejilla(){
        int i,j;
        String rejilla[]={
            "1AAAAAAAAAAAAfeAAAAAAAAAAAA2",
            "I............di............D",
            "I.5BB6.5BBB6.di.5BBB6.5BB6.D",
            "IoD__I.D___I.di.D___I.D__IoD",
            "I.7AA8.7AAA8.78.7AAA8.7AA8.D",
            "I..........................D",
            "I.5bb6.56.5bbbbbb6.56.5bb6.D",
            "I.7aa8.di.7aa65aa8.di.7aa8.D",
            "I......di....di....di......D",
            "3BBBB6.d7bb6_di_5bb8i.5BBBB4",
            "_____I.d5aa8_78_7aa6i.D_____",
            "_____I.di__________di.D_____",
            "_____I.di_5BPPPPB6_di.D_____",
            "AAAAA8.78_D______I_78.7AAAAA",
            "______.___D______I___.______",
            "BBBBB6.56_D______I_56.5BBBBB",
            "_____I.di_7AAAAAA8_di.D_____",
            "_____I.di__________di.D_____",
            "_____I.di_5bbbbbb6_di.D_____",
            "1AAAA8.78_7aa65aa8_78.7AAAA2",
            "I............di............D",
            "I.5bb6.5bbb6.di.5bbb6.5bb6.D",
            "I.7a6i.7aaa8.78.7aaa8.d5a8.D",
            "Io..di................di..oD",
            "gb6.di.56.5bbbbbb6.56.di.5bm",
            "ha8.78.di.7aa65aa8.di.78.7an",
            "I......di....di....di......D",
            "I.5bbbb87bb6.di.5bb87bbbb6.D",
            "I.7aaaaaaaa8.78.7aaaaaaaa8.D",
            "I..........................D",
            "3BBBBBBBBBBBBBBBBBBBBBBBBBB4"
        };

        // Inicializar el tablero original
        for(i=0;i<altura;i++){
            for(j=0;j<anchura;j++){
                assignTipoCelda(i,j,rejilla[i].charAt(j));
            }
        }
    }
}
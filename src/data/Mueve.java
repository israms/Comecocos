package data;
import guicomecocos.*;
import java.util.Calendar;
import javax.swing.JLabel;

/**
 * Esta clase implementa una hebra que hace que se muevan el comecocos y los fantasmas.
 * La hebra se encarga tambien de ir refrescando el tablero
 * donde se dibuja todo. Además controla si el comecocos choca contra un BLOQUE, come una bola
 * o choca contra un fantasma para comerselo o ser comido.
 */
public class Mueve implements Runnable{
    private int retardo; // Tiempo de espera de la hebra
    private boolean continuar=true;
    private boolean suspendFlag=true;
    private ComecocosFrame ventanaPrincipal;
    private Fantasma fantasmas[]; // Vector de fantasmas
    private int puntuacion; // Puntuacion del juego
    private int numVidas; // Numero de vidas del comecocos
    private JLabel etiqueta_puntos;
    private JLabel etiqueta_tiempo;
    private int numBolas; // Numero de bolas que hay en el tablero
    private long tiempoInicial = 0;
    private int numFantasmasMatados; // Numero de fantasmas matados consecutivamente

       
    /**
     * Constructor de la clase, que establece el retardo en milisegundos
     * entre movimiento y movimiento del comecocos y los fantasmas, y comienza a ejecutar
     * la hebra. 
     */
    public Mueve(ComecocosFrame vp,int r,JLabel etiqueta1,JLabel etiqueta2){
        ventanaPrincipal=vp;
        retardo=r;
        etiqueta_puntos=etiqueta1;
        etiqueta_tiempo=etiqueta2;
        initMueve();
        Thread t=new Thread(this);
        t.start();
    }

    public void initMueve(){
        puntuacion=0;
        numVidas=3;
        numBolas=245;
        numFantasmasMatados=0;
        tiempoInicial = System.currentTimeMillis();
        etiqueta_puntos.setText("Puntuacion = "+puntuacion);
        etiqueta_tiempo.setText("Tiempo = "+"0:0");
    }

    public int getNumeroVidas(){
        return numVidas;
    }
    
    /**
     * Codigo que constituye las sentencias de la hebra. En este caso, se encarga
     * de hacer que se muevan continuamente el comecocos y los fantasmas.
     * La hebra se encarga tambien de ir refrescando el tablero
     * donde se dibuja todo, os puntos acumulados, el tiempo de duracion de la partida.
     */
    public void run(){
        try{
            Calendar tiempo = Calendar.getInstance(); // Tomar hora para calcular el tiempo de juego
            while(continuar){
                synchronized(this){
                    while(suspendFlag){
                        wait();
                    }
                }
                //System.out.println("Ejecutando hebra");
                Thread.sleep(retardo);
                Comecocos c=ventanaPrincipal.getComecocos();
                fantasmas=ventanaPrincipal.getFantasmas();
                int m=c.avanza(); // Mover el comecocos
                compruebaChocaFantasmas(c); // Comprobar si se encuentra con algun fantasma
                for(int i=0;i<4;i++){ // Mover los fantasmas si estan vivos (activos)
                    if(fantasmas[i].getVivo()){
                        fantasmas[i].avanza();
                    }
                }
                compruebaChocaFantasmas(c); // Comprobar si se encuentra con algun fantasma
                RejillaPanel tablero=ventanaPrincipal.getPanel();
                if(tablero!=null){
                    tablero.repaint();
                }
                
                Thread.sleep(retardo);
                if(c.getMoviendose()){ // Si el comecocos se mueve actualizar secuencia de la animacion
                    c.setSecuencia(1);
                }
                for(int i=0;i<4;i++){ // Actualizar secuencia de la animacion de los fantasmas vivos
                    if(fantasmas[i].getVivo()){
                        fantasmas[i].setSecuencia(1);
                    }
                }
                tablero.repaint(); // Repintar todo

                Thread.sleep(retardo);
                if(c.getMoviendose()){ // Si el comecocos se mueve actualizar secuencia de la animacion
                    c.setSecuencia(2);
                }
                for(int i=0;i<4;i++){
                    if(fantasmas[i].getVivo()){ // Actualizar secuencia de la animacion de los fantasmas vivos
                        fantasmas[i].setSecuencia(2);
                    }
                }
                tablero.repaint(); // Repintar todo

                Thread.sleep(retardo);
                if(c.getMoviendose()){ // Si el comecocos se mueve actualizar secuencia de la animacion
                    c.setSecuencia(3);
                }
                for(int i=0;i<4;i++){
                    if(fantasmas[i].getVivo()){ // Actualizar secuencia de la animacion de los fantasmas vivos
                        fantasmas[i].setSecuencia(3);
                    }
                }
                tablero.repaint(); // Repintar todo

                Thread.sleep(retardo);
                if(c.getMoviendose()){ // Si el comecocos se mueve actualizar secuencia de la animacion
                    c.setSecuencia(4);
                }
                for(int i=0;i<4;i++){
                    if(fantasmas[i].getVivo()){ // Actualizar secuencia de la animacion de los fantasmas vivos
                        fantasmas[i].setSecuencia(4);
                    }
                }
                tablero.repaint(); // Repintar todo

                // Calcula tiempo transcurrido y lo actualiza
                tiempo.setTimeInMillis( System.currentTimeMillis() - tiempoInicial);
                etiqueta_tiempo.setText("Tiempo = "+tiempo.get(Calendar.MINUTE)+":"+tiempo.get(Calendar.SECOND));


                for(int i=0;i<3;i++){
                    if(fantasmas[i].getNcasillas()>=10){ // Si el fantasma anterior en salir ha avanzado 10 casillar despertar al siguiente fantasma
                        fantasmas[i+1].setVivo(true);
                    }
                }
                for(int i=0;i<4;i++){ // Cuando un fantasma comestible avanza 40 casillas pasa a estado NO comestible
                    if(fantasmas[i].getComestible() && fantasmas[i].getNcasillasComestible()>=40){
                        numFantasmasMatados=0;
                        fantasmas[i].setComestible(false);
                        fantasmas[i].setNcasillasComestible(0);
                    }
                }

                if(m==c.CHOCA_BLOQUE){ // Si el comecocos choca contra un BLOQUE
                    tablero.repaint();
                }
                else if(m==c.COME_BOLA){ // Si el comecocos come una bola
                    numFantasmasMatados=0;
                    puntuacion+=50; // Aumentar puntuacion y actualizarla
                    etiqueta_puntos.setText("Puntuacion = "+puntuacion);
                    numBolas--; // Disminuair numero de bolas

                    for(int i=0;i<4;i++){ // Poner a los fantasmas vivos en estado comestible
                        if(fantasmas[i].getVivo()){
                            fantasmas[i].setComestible(true);
                            fantasmas[i].setNcasillasComestible(0);
                        }
                    }
                    if(numBolas==0){ // NO hay mas bolas que comer, termina la partida
                        tablero.setFinalizado(true);
                        tablero.repaint();
                        parar();
                    }
                }
                else if(m==c.COME_BOLITA){ // Si el comecocos come una bolita
                    puntuacion+=10;
                    etiqueta_puntos.setText("Puntuacion = "+puntuacion);
                    numBolas--;
                    if(numBolas==0){ // NO hay mas bolas que comer, termina la partida
                        tablero.setFinalizado(true);
                        tablero.repaint();
                        parar();
                    }
                }
                else if(m==c.VACIA){
                    //tablero.repaint();
                }
            }// end while(continuar)
        } catch(InterruptedException e){
            System.out.println("Hilo MueveComecocos interrumpido");
        }
    }

    /**
     * Comrpueba si el comecocos se choca con un fantasma.
     * Si el fantasma esta comestible, el comecocos se lo come y lo envia a la
     * casa de los fantasmas para que vuelva a participar en el juego. Si el fantasma
     * no esta en estado comestible se comera al comecocos, restandole una vida
     * @param c Comecocos del juego
     */
    public void compruebaChocaFantasmas(Comecocos c){
       for(int i=0;i<4;i++){
           if((c.getFila()==fantasmas[i].getFila()) && (c.getColumna()==fantasmas[i].getColumna()) && (!fantasmas[i].getComestible())){
             if(numVidas>0){
                numVidas--;
                if(numVidas==0){ // Finaliza la partida
                   ventanaPrincipal.getPanel().setDerrotado(true);
                   ventanaPrincipal.getPanel().repaint();
                   ventanaPrincipal.getPanelPuntuacion().repaint();
                   suspender();
                }
                else{ // Se reaunda la partida
                   ventanaPrincipal.reanudarPartida();
                }
             }
           }
           else if((c.getFila()==fantasmas[i].getFila()) && (c.getColumna()==fantasmas[i].getColumna()) && (fantasmas[i].getComestible())){
               fantasmas[i].matarFantasma();
               numFantasmasMatados++;
               if(numFantasmasMatados==1){
                   puntuacion+=200;
               }
               else if(numFantasmasMatados==2){
                   puntuacion+=400;
               }
               else if(numFantasmasMatados==3){
                   puntuacion+=800;
               }
               else if(numFantasmasMatados==4){
                   puntuacion+=1600;
                   numFantasmasMatados=0;
               }
               etiqueta_puntos.setText("Puntuacion = "+puntuacion);
           }
       }
    }
    
    /**
     * Detiene momentaneamente la ejecución de la hebra, haciendo que la Figura actual
     * quede parada.
     */
    synchronized public void suspender(){
        ventanaPrincipal.getPanel().repaint();
        suspendFlag=true;
    }
    
    /**
     * Reanuda el movimiento de la hebra. La Figura actual vuelve  a moverse.
     */
    public synchronized void reanudar(){
        if(ventanaPrincipal.getPanel()!=null)
            ventanaPrincipal.getPanel().repaint();
        suspendFlag = false;

        notify();
    }
    
    /**
     * Termina la ejecución de la hebra.
     */
    public void parar(){
        continuar=false;
    }
    
    /**
     * Nos dice si la hebra está o no parada.
     * @return true si la hebra de movimiento está parada, false en otro caso
     */
    synchronized public boolean getParado(){
        return suspendFlag;
    }
}
package game;

public class Timer extends Thread{
    private int seconds = 0;
    private boolean isRunning = true;
    
    // Secondi necessari per fare attivare il forno,rubinetto,lavatrice 
    private int secondsForno = 8;          
    private int secondsRubinetto = 12;
    private int secondsLavatrice = 20;
   
    // Costruttore per il timer 
    public Timer(){
        runTimer();
    }


    public void runTimer() {
        this.isRunning = true;
        while(isRunning) {
            try {
                Thread.sleep(1000);
                this.seconds++;
                if(this.seconds % secondsForno == 0)
                {
                    // Attivo il forno dopo secondsForno secondi
                }
                else if(this.seconds % secondsRubinetto == 0)
                {
                    // Attivo il rubinetto dopo secondsRubinetto secondi
                }
                else if(this.seconds % secondsLavatrice == 0)
                {
                    // Attivo la lavatrice dopo secondsLavatrice secondi
                }
                System.out.println("Secondi passati : "+seconds);
            } catch (InterruptedException e) {
                System.out.println("Errore, il Thread è stato interrotto in modo anomalo");
                break;
            }
        }
    }

    public void stopCounter() {
        this.isRunning = false;
    }

    public int getSecondaElapsed() {
        return this.seconds;
    }
}

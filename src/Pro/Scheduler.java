package Pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Scheduler {
    
	//OBJETO DE TIPO GAME SCENE
    private GameScene instanceGame;
    
    //ARREGLO DE TIPO ACTION LISTENER PARA MOVER LA SERIPIENTE
    private ActionListener[] actions = {
    		
    	//SE ENCARGA DE LOS MOVIMIENTOS A LA IZQUIERDA
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueSpeed(instanceGame.getPlay().getScore());
                startBonus();
                instanceGame.getPlay().moveSnake("Left");  
            }
        },
        //SE ENCARGA DE LOS MOVIMIENTOS A LA DERECHA
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueSpeed(instanceGame.getPlay().getScore());
                startBonus();
                instanceGame.getPlay().moveSnake("Right");
            }
        },
        //SE ENCARGA DE LOS MOVIMIENTOS A LA ARRIBA
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueSpeed(instanceGame.getPlay().getScore());
                startBonus();
                instanceGame.getPlay().moveSnake("Up");
            }
        },
        //SE ENCARGA DE LOS MOVIMIENTOS ABAJO
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueSpeed(instanceGame.getPlay().getScore());
                startBonus();
                instanceGame.getPlay().moveSnake("Down");
            }
        }
    };
    
    //TIMER PARA EL BONUS
    private Timer timerBonus;
    //TIMER PARA MANEJAR EL MOVIMIENTO DE LA SERPIENTE
    private Timer[] timerMotion;
    //VARIABLES PARA GUARDAR MOMENTOS
    private int timeBonus, goal, delay, currentMotion;
    
    public Scheduler(GameScene instanceGame) {
        this.instanceGame = instanceGame;
        currentMotion = 0;
        delay = 500;
        goal = 100;
        timeBonus = (900 * 5); //A second can be approximated to 900 milliseconds, multiplied by five, are 13500 milliseconds (5 seconds)
        timerMotion = new Timer[actions.length];
        
        createMotion();
        createBonus();
    }
    
    /*
        If you get to the 100 points the speed of the snake increases 
        and add another 100 to the next goal!
    */
    public void valueSpeed(int x) {
        if(x  >= goal && delay >= 100) {
            increaseSpeed();
            goal+=x;
        }
    }
    
    /*
        Time runs enable you chose and others hold ...
    */
    public void actuate(int e) {
        if (timerMotion[currentMotion].isRunning()) {
            timerMotion[currentMotion].stop();
            currentMotion = e;
            timerMotion[currentMotion].start();
        } else {
            currentMotion = e;
            timerMotion[currentMotion].start();
        }
    }
    
    /*
        This method defines a timer that makes the frame flashes white, 
        updated every 100 milliseconds the time remaining to complete the bonus and 
        when it is right to block special color or variable reaches zero this timer 
        is stopped and restarted certain variables ...
    */
    private void createBonus() {
        timerBonus = new Timer(70, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                timeBonus -= timerBonus.getDelay();             
                instanceGame.changeColorPanel();
                
                if (!(instanceGame.getPlay().getBonus()) || timeBonus <= 0) {
                    instanceGame.getPlay().setBonus(false);
                    instanceGame.restoreColorPanel();
                    timeBonus = (900 * 5);
                    timerBonus.stop();                   
                }
            }
        });
    }
    
    // Activates the timer bonus
    public void startBonus() {
        if (instanceGame.getPlay().getBonus() && !timerBonus.isRunning()) 
            timerBonus.start();      
    }
    
    private void stopBonus() {
        if (timerBonus.isRunning())
            timerBonus.stop();
    }
    
    // Defines the movement times, it is responsible for moving the snake "automatically"
    private void createMotion() {
        for (int i = 0; i < timerMotion.length; i++) 
            timerMotion[i] = new Timer(delay, actions[i]);
    }
    // If possible start the timer indicated
    public void startMotion(int t) {
        if (!timerMotion[t].isRunning()) 
            timerMotion[t].start();      
    }
    
    // If possible stops the timer indicated
    public void stopMotion(int t) {
        if (timerMotion[t].isRunning()) 
            timerMotion[t].stop();      
    }
    
    // If possible stop all movements
    public void stopAllMotions() {
        for (Timer motion : timerMotion) 
            if (motion.isRunning()) 
                motion.stop();           
    }
    
    // Increases speed in all directions
    public void increaseSpeed() {
        delay-=80;
        
        for (Timer motion : timerMotion) 
            motion.setDelay(delay);       
    }
    
    // The delay returns to normal in all movements
    public void restoreSpeed() {
        delay = 500;
        
        for (Timer motion : timerMotion) 
            motion.setDelay(delay);
    }
    
    public void stopAllTimers() {
        stopAllMotions();
        stopBonus();
    }
    
    public int getSpeed() {
        return delay;
    }
    
}

package proyectozombie.GameEnviroment;

import java.io.Serializable;

public class Log implements Serializable{
    private String log;

    public void writeLog(String logContent){
        log += "---------------------------------";
        log += logContent;
    }
    
    public String readLog(){
        return log;
    }

}

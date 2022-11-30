package proyectozombie.GameEnviroment;

import java.io.Serializable;

public class Log implements Serializable{
    private String log = "";
    private String tmp = null;

    public void writeLog(String logContent){
        log += "\n---------------------------------\n";
        log += tmp;
    }
    
    public String readLog(){
        if(tmp != null){
            String print = tmp;
            log += tmp;
            tmp = null;
            return print;
        }else{
            return null;
        }
    }
    
    public String readAllLog(){
        return log;
    }

}

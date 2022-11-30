package proyectozombie.GameEnviroment;

import java.io.Serializable;

public class Log implements Serializable{
    private String firstLog = "";
    private String log = "";
    private String tmp = "";

    
    public Log(String firstLog){
        this.firstLog = firstLog;
    }
    
    public void writeLog(String logContent){
        tmp += logContent;
    }
    
    public String readLog(){
        if(tmp != ""){
            String print = "\n-----------------------------------\n"+tmp;
            log += "\n"+tmp;
            tmp = "";
            return print;
        }else{
            return "";
        }
    }
    
    public String readAllLog(int finalLife){
        String finallLog = "\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n\n<><><><><><><><><><><><><><><><><><><><>\n" 
                + firstLog + finalLife + "\n<><><><><><><><><><><><><><><><><><><><>\n" 
                + log + "\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n";
        return finallLog;
    }

}

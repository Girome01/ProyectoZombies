package proyectozombie.GameEnviroment;

public class Log {
    private String log;

    public void writeLog(String logContent){
        log += "---------------------------------";
        log += logContent;
    }
    
    public String readLog(){
        return log;
    }

}

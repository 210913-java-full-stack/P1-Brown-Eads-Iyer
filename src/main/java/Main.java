import utils.FileLogger;

public class Main {

    public static void main(String[] args){
        FileLogger.getFileLogger().console(true).threshold(0).writeLog("Yea we be loggin messages",0);
    }
}

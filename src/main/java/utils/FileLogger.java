package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TODO DOCUMENTATION
public class FileLogger {

    private static FileLogger fileLogger;
    private static int threshold;
    private static boolean printToConsole;
    private static boolean printToConsoleTemp;

//    public enum Threshold{
//        INFO,
//        WARN,
//        MODERATE,
//        SEVERE
//    }

    private FileLogger(){
        printToConsole = false;
        printToConsoleTemp = false;
        threshold = -1;
    }


    public static FileLogger getFileLogger(){
        if (fileLogger == null){
            fileLogger = new FileLogger();
        }
        return fileLogger;
    }

    private String getLogFileName(){
        String filename = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return filename + ".log";
    }

    public void writeLog(String msg, int lvl){
        try (FileWriter fw = new FileWriter(getLogFileName(), true)){
            String entry = formatLog(msg);

            //TODO: Write logging logic
            if (lvl >= threshold){
                fw.write(entry);
            }

            if (printToConsole || printToConsoleTemp){
                System.out.println(entry);
                printToConsoleTemp = false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatLog(String msg){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[3].toString();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s:   [%s]   %s", timestamp, stackInfo, msg);
    }

    public FileLogger console(boolean o){
        printToConsoleTemp = true;
        return fileLogger;
    }

    public static boolean isPrintToConsole() {
        return printToConsole;
    }

    public FileLogger threshold(int th){
        threshold = th;
        return fileLogger;
    }

//    private boolean checkThreshold(Threshold lvl){
//        int i = -1;
//        switch(lvl){
//            case MODERATE:
//                i = 2;
//                break;
//            case INFO:
//                i = 0;
//                break;
//            case SEVERE:
//                i = 3;
//                break;
//            case WARN:
//                i = 1;
//                break;
//        }
//    }

    public static void setPrintToConsole(boolean printToConsole) {
        FileLogger.printToConsole = printToConsole;
    }
}

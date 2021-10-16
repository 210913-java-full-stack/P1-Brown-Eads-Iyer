package utils;

import views.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Singleton to keep track of view and some user relevant fields.
 */
public class ViewManager {
    private static ViewManager viewManager;
    //private static view nextView;
    //view stuff goes here
    //private List<view> viewList;
    private boolean running;
    private Scanner sc;
    private String currentUsername;

    private ViewManager(){
        //viewList = new List<view>();
        viewManager = this;
        running = true;
        sc = new Scanner(System.in);

        /**
         * Add stuff to viewList here
         */
    }

    public static ViewManager getViewManager(){
        if (viewManager == null){
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    /**
     * sets up nextView before goToNextView() is called
     * @param newView is the name of the next view
     */
    public void navigate(String newView){
//        view v;
//        for (int i = 0; i < viewList.getCount(); i++){
//            v = viewList.get(i);
//            if (v.getViewName().equals(newView)){
//                nextView = v;
//            }
//        }
    }

    /**
     * drives the program to the next view
     * @throws SQLException
     */
    public void goToNextView() throws SQLException{
    }

    public boolean isRunning(){
        return running;
    }

    public void setRunning(boolean run){
        running = run;
    }

    /**
     * for keeping track of current user
     * @return
     */
    public String getCurrentUsername() {
        return currentUsername;
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

}
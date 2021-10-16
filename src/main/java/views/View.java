package views;

import utils.ViewManager;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class View {
    protected Scanner sc;
    protected String viewName;
    protected ViewManager vm;

    public View(String vn, Scanner sc){
        this.sc = sc;
        viewName = vn;
        vm = ViewManager.getViewManager();
    }

    public String getViewName(){return viewName;}

    /**
     * @throws SQLException
     */
    public abstract void createView() throws SQLException;
}

package org.vaadin.test;

import com.vaadin.flow.component.UI;
import com.vaadin.mpr.MprUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;


/**
 * Main UI class of the application that shows either the login screen or the
 * main view of the application depending on whether a user is signed in.
 *
 * The @Viewport annotation configures the viewport meta tags appropriately on
 * mobile devices. Instead of device based scaling (default), using responsive
 * layouts.
 */
public class MyUI extends MprUI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	System.out.println("\nInitialized: "+ VaadinSession.getCurrent().getSession().getId());

        super.init(vaadinRequest);
    }

    public static MyUI get() {
        return (MyUI) MprUI.getCurrent();
    }

}

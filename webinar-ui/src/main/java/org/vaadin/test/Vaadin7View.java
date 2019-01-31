package org.vaadin.test;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class Vaadin7View extends CssLayout {

    public Vaadin7View() {
        setSizeFull();
        addComponent(new Label("Vaadin 7 label"));
    }

}

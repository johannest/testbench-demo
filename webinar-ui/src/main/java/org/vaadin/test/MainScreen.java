package org.vaadin.test;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;
import com.vaadin.ui.CssLayout;

/**
 * Content of the UI when the user is logged in.
 * 
 * 
 */
@Route(value = "", layout = RootViewImpl.class)
public class MainScreen extends HorizontalLayout {

    public MainScreen() {
        setSizeFull();
        addClassName("main-screen");

        CssLayout viewContainer = new CssLayout();
        viewContainer.setSizeFull();
        viewContainer.addComponent(new Vaadin7View());

        add(new Button("test", e->{
            System.out.println("aadsad");
        }));

        LegacyWrapper legacyWrapper = new LegacyWrapper(viewContainer);
        legacyWrapper.setSizeFull();
        add(legacyWrapper);
        setSizeFull();
    }
}

package com.locopoems.views.mainpage;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.locopoems.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("MainPage")
@Route(value = "main", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class MainPageView extends Div {

    public MainPageView() {
        addClassName("main-page-view");
        add(new Text("Content placeholder"));
    }

}

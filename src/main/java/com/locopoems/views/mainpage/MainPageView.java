package com.locopoems.views.mainpage;

import com.locopoems.dao.Entity.Poem;
import com.sun.xml.bind.v2.TODO;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.locopoems.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@PageTitle("MainPage")
@Route(value = "main", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class MainPageView extends Div {
    List<Poem> poem_list;
    List<Button> buttonList;
    Grid<Button> grid;

    public MainPageView() {
        poem_list = new ArrayList<>();
        addClassName("main-page-view");

        loadPoems();
        createPoemsView();
    }
    void loadPoems(){
        //TODO podmienic na normalna baze danych a nie jakieś fejury
        poem_list.add(new Poem(0,"tytul","autor","tresc",LocalDate.now()));
        poem_list.add(new Poem(1,"tytul1","autor1","tresc1",LocalDate.now()));

    }
    void createPoemsView(){
        grid = new Grid<>();
        buttonList = new ArrayList<>();
        for (Poem p : poem_list) buttonList.add(new Button(p.getTitle()));

        grid.setItems(buttonList);
        add(grid);
    }
    void goToPoemPage(){

    }

}

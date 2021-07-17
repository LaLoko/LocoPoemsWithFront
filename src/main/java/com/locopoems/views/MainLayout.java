package com.locopoems.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.locopoems.views.MainLayout;
import com.locopoems.views.mainpage.MainPageView;
import com.locopoems.views.about.AboutView;

/**
 * The main view is a top-level placeholder for other views.
 */
@PageTitle("Main")
public class MainLayout extends AppLayout {

    public static class MenuItemInfo {

        private String text;
        private String iconClass;
        private Class<? extends Component> view;

        public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
            this.text = text;
            this.iconClass = iconClass;
            this.view = view;
        }

        public String getText() {
            return text;
        }

        public String getIconClass() {
            return iconClass;
        }

        public Class<? extends Component> getView() {
            return view;
        }

    }

    private final Tabs menu;

    public MainLayout() {
        HorizontalLayout header = createHeader();
        menu = createMenuTabs();
        addToNavbar(createTopBar(header, menu));
    }

    private VerticalLayout createTopBar(HorizontalLayout header, Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.getThemeList().add("dark");
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setPadding(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(header, menu);
        return layout;
    }

    private HorizontalLayout createHeader() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setClassName("topmenu-header");
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.setWidthFull();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        Image logo = new Image("images/logo.png", "LocoPoems logo");
        logo.setId("logo");
        layout.add(logo);
        layout.add(new H1("LocoPoems"));

        Avatar avatar = new Avatar();
        avatar.addClassNames("ms-auto", "me-m");
        layout.add(avatar);

        return layout;
    }

    private Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.getStyle().set("max-width", "100%");
        for (Tab menuTab : createMenuItems()) {
            tabs.add(menuTab);
        }
        return tabs;
    }

    private List<Tab> createMenuItems() {
        MenuItemInfo[] menuItems = new MenuItemInfo[]{ //
                new MenuItemInfo("MainPage", "la la-file", MainPageView.class), //

                new MenuItemInfo("About", "la la-file", AboutView.class), //

        };
        List<Tab> tabs = new ArrayList<>();
        for (MenuItemInfo menuItemInfo : menuItems) {
            tabs.add(createTab(menuItemInfo));

        }
        return tabs;
    }

    private Tab createTab(MenuItemInfo menuItemInfo) {
        Tab tab = new Tab();
        RouterLink link = new RouterLink();
        link.setRoute(menuItemInfo.getView());
        Span iconElement = new Span();
        iconElement.addClassNames("text-l", "pr-s");
        if (!menuItemInfo.getIconClass().isEmpty()) {
            iconElement.addClassNames(menuItemInfo.getIconClass());
        }
        link.add(iconElement, new Text(menuItemInfo.getText()));
        tab.add(link);
        ComponentUtil.setData(tab, Class.class, menuItemInfo.getView());

        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }
}

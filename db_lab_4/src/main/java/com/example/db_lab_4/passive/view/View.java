package com.example.db_lab_4.passive.view;

import com.example.db_lab_4.passive.controller.*;
import com.example.db_lab_4.passive.controller.impl.*;
import com.example.db_lab_4.passive.model.entities.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final String KEY_EXIT = "Q";

    private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

    private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
    private static final String TEXT_GO_BACK = "Go back or quit";

    private static Scanner input = new Scanner(System.in, "UTF-8");

    public View() {
    }

    public void show() {
        showTablesMenu();
    }

    private void showTablesMenu() {
        Map<String, String> tablesMenu = generateTablesMenu();
        Map<String, Printable> tablesMenuMethods = generateTablesMenuMethods();
        showMenuFromMaps(tablesMenu, tablesMenuMethods);
    }

    private Map<String, String> generateTablesMenu() {
        Map<String, String> tablesMenu = new LinkedHashMap<String, String>();
        tablesMenu.put("1", "Table: City");
        tablesMenu.put("2", "Table: Country");
        tablesMenu.put("3", "Table: Guide");
        tablesMenu.put("4", "Table: Hotel");
        tablesMenu.put("5", "Table: Payment type");
        tablesMenu.put("6", "Table: Place");
        tablesMenu.put("7", "Table: Route");
        tablesMenu.put("8", "Table: Transport type");
        return tablesMenu;
    }

    private Map<String, Printable> generateTablesMenuMethods() {
        Map<String, Printable> tableMenuMethods = new LinkedHashMap<String, Printable>();
        tableMenuMethods.put("1", this::showCityMenu);
        tableMenuMethods.put("2", this::showCountryMenu);
        tableMenuMethods.put("3", this::showGuideMenu);
        tableMenuMethods.put("4", this::showHotelMenu);
        tableMenuMethods.put("5", this::showPaymentTypeMenu);
        tableMenuMethods.put("6", this::showPlaceMenu);
        tableMenuMethods.put("7", this::showRouteMenu);
        tableMenuMethods.put("8", this::showTransportTypeMenu);

        return tableMenuMethods;
    }

    private void showCityMenu() {
        Map<String, String> menu = generateCityMenu();
        Map<String, Printable> menuMethods = generateCityMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }


    private void showCountryMenu() {
        Map<String, String> menu = generateCountryMenu();
        Map<String, Printable> menuMethods = generateCountryMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showGuideMenu() {
        Map<String, String> menu = generateGuideMenu();
        Map<String, Printable> menuMethods = generateGuideMenuMethods();
        showMenuFromMaps(menu, menuMethods);

    }

    private void showHotelMenu() {
        Map<String, String> menu = generateHotelMenu();
        Map<String, Printable> menuMethods = generateHotelMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showPaymentTypeMenu() {
        Map<String, String> menu = generatePaymentTypeMenu();
        Map<String, Printable> menuMethods = generatePaymentTypeMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showPlaceMenu() {
        Map<String, String> menu = generatePlaceMenu();
        Map<String, Printable> menuMethods = generatePlaceMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showRouteMenu() {
        Map<String, String> menu = generateRouteMenu();
        Map<String, Printable> menuMethods = generateRouteMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showTransportTypeMenu() {
        Map<String, String> menu = generateTransportTypeMenu();
        Map<String, Printable> menuMethods = generateTransportTypeMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }


    private Map<String, String> generateCityMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all cities");
        menu.put("2", "Select city");
        menu.put("3", "Create city");
        menu.put("4", "Update city");
        menu.put("5", "Delete city");
        return menu;
    }


    private Map<String, String> generateCountryMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all countries");
        menu.put("2", "Select country");
        menu.put("3", "Create country");
        menu.put("4", "Update country");
        menu.put("5", "Delete country");
        return menu;
    }


    private Map<String, String> generateGuideMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all guides");
        menu.put("2", "Select guide");
        menu.put("3", "Create guide");
        menu.put("4", "Update guide");
        menu.put("5", "Delete guide");
        return menu;
    }

    private Map<String, String> generateHotelMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all hotels");
        menu.put("2", "Select hotel");
        menu.put("3", "Create hotel");
        menu.put("4", "Update hotel");
        menu.put("5", "Delete hotel");
        return menu;
    }

    private Map<String, String> generatePaymentTypeMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all payment types");
        menu.put("2", "Select payment type");
        menu.put("3", "Create payment type");
        menu.put("4", "Update payment type");
        menu.put("5", "Delete payment type");
        return menu;
    }

    private Map<String, String> generatePlaceMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all places");
        menu.put("2", "Select place");
        menu.put("3", "Create place");
        menu.put("4", "Update place");
        menu.put("5", "Delete place");
        return menu;
    }

    private Map<String, String> generateRouteMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all routes");
        menu.put("2", "Select route");
        menu.put("3", "Create route");
        menu.put("4", "Update route");
        menu.put("5", "Delete route");
        return menu;
    }

    private Map<String, String> generateTransportTypeMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all transport types");
        menu.put("2", "Select transport type");
        menu.put("3", "Create transport type");
        menu.put("4", "Update transport type");
        menu.put("5", "Delete transport type");
        return menu;
    }

    private Map<String, Printable> generateCityMenuMethods() {
        Controller<CityEntity, Integer> cityController = new CityControllerImpl();
        Formatter<CityEntity, Integer> formatter = new Formatter<>(CityEntity.class);
        ViewOperations<CityEntity, Integer> cityOperation = new ViewOperations<>(cityController, formatter,
                CityEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", cityOperation::findAll);
        menuMethods.put("2", cityOperation::findById);
        menuMethods.put("3", cityOperation::create);
        menuMethods.put("4", cityOperation::update);
        menuMethods.put("5", cityOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateCountryMenuMethods() {
        Controller<CountryEntity, Integer> countryController = new CountryControllerImpl();
        Formatter<CountryEntity, Integer> formatter = new Formatter<>(CountryEntity.class);
        ViewOperations<CountryEntity, Integer> countryOperation = new ViewOperations<>(countryController, formatter,
                CountryEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", countryOperation::findAll);
        menuMethods.put("2", countryOperation::findById);
        menuMethods.put("3", countryOperation::create);
        menuMethods.put("4", countryOperation::update);
        menuMethods.put("5", countryOperation::delete);
        return menuMethods;
    }


    private Map<String, Printable> generateGuideMenuMethods() {
        Controller<GuideEntity, Integer> guideController = new GuideControllerImpl();
        Formatter<GuideEntity, Integer> formatter = new Formatter<>(GuideEntity.class);
        ViewOperations<GuideEntity, Integer> guideOperation = new ViewOperations<>(guideController, formatter,
                GuideEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", guideOperation::findAll);
        menuMethods.put("2", guideOperation::findById);
        menuMethods.put("3", guideOperation::create);
        menuMethods.put("4", guideOperation::update);
        menuMethods.put("5", guideOperation::delete);
        return menuMethods;
    }


    private Map<String, Printable> generateHotelMenuMethods() {
        Controller<HotelEntity, Integer> hotelController = new HotelControllerImpl();
        Formatter<HotelEntity, Integer> formatter = new Formatter<>(HotelEntity.class);
        ViewOperations<HotelEntity, Integer> hotelOperation = new ViewOperations<>(hotelController,
                formatter, HotelEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", hotelOperation::findAll);
        menuMethods.put("2", hotelOperation::findById);
        menuMethods.put("3", hotelOperation::create);
        menuMethods.put("4", hotelOperation::update);
        menuMethods.put("5", hotelOperation::delete);
        return menuMethods;
    }


    private Map<String, Printable> generatePaymentTypeMenuMethods() {
        Controller<PaymentTypeEntity, Integer> paymentTypeController = new PaymentTypeControllerImpl();
        Formatter<PaymentTypeEntity, Integer> formatter = new Formatter<>(PaymentTypeEntity.class);
        ViewOperations<PaymentTypeEntity, Integer> paymentTypeOperation = new ViewOperations<>(paymentTypeController,
                formatter, PaymentTypeEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", paymentTypeOperation::findAll);
        menuMethods.put("2", paymentTypeOperation::findById);
        menuMethods.put("3", paymentTypeOperation::create);
        menuMethods.put("4", paymentTypeOperation::update);
        menuMethods.put("5", paymentTypeOperation::delete);
        return menuMethods;
    }


    private Map<String, Printable> generatePlaceMenuMethods() {
        Controller<PlaceEntity, Integer> placeController = new PlaceControllerImpl();
        Formatter<PlaceEntity, Integer> formatter = new Formatter<>(PlaceEntity.class);
        ViewOperations<PlaceEntity, Integer> placeOperation = new ViewOperations<>(placeController, formatter,
                PlaceEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", placeOperation::findAll);
        menuMethods.put("2", placeOperation::findById);
        menuMethods.put("3", placeOperation::create);
        menuMethods.put("4", placeOperation::update);
        menuMethods.put("5", placeOperation::delete);
        return menuMethods;
    }


    private Map<String, Printable> generateRouteMenuMethods() {
        Controller<RouteEntity, Integer> routeController = new RouteControllerImpl();
        Formatter<RouteEntity, Integer> formatter = new Formatter<>(RouteEntity.class);
        ViewOperations<RouteEntity, Integer> routeOperation = new ViewOperations<>(routeController, formatter, RouteEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", routeOperation::findAll);
        menuMethods.put("2", routeOperation::findById);
        menuMethods.put("3", routeOperation::create);
        menuMethods.put("4", routeOperation::update);
        menuMethods.put("5", routeOperation::delete);
        return menuMethods;
    }


    private Map<String, Printable> generateTransportTypeMenuMethods() {
        Controller<TransportTypeEntity, Integer> transportTypeController = new TransportTypeControllerImpl();
        Formatter<TransportTypeEntity, Integer> formatter = new Formatter<>(TransportTypeEntity.class);
        ViewOperations<TransportTypeEntity, Integer> transportTypeOperation = new ViewOperations<>(transportTypeController, formatter,
                TransportTypeEntity.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", transportTypeOperation::findAll);
        menuMethods.put("2", transportTypeOperation::findById);
        menuMethods.put("3", transportTypeOperation::create);
        menuMethods.put("4", transportTypeOperation::update);
        menuMethods.put("5", transportTypeOperation::delete);
        return menuMethods;
    }


    private void showMenuFromMaps(Map<String, String> keyName, Map<String, Printable> keyMethod) {
        String keyMenu;
        do {
            printMenu(keyName);
            System.out.println(TEXT_SELECT_MENU_OPTION);
            keyMenu = input.nextLine().toUpperCase();
            Printable method = keyMethod.get(keyMenu);
            if (method != null) {
                method.print();
            } else if (!keyMenu.equals(KEY_EXIT)) {
                System.out.println(ERROR_NO_SUCH_OPTION);
            }
        } while (!keyMenu.equals(KEY_EXIT));
    }

    private void printMenu(Map<String, String> keyName) {
        for (String key : keyName.keySet()) {
            System.out.format("%3s - %s%n", key, keyName.get(key));
        }
        System.out.format("%3s - %s%n", KEY_EXIT, TEXT_GO_BACK);
    }
}

package com.gonzaloquiroga.app.libreria.libreriaapp.constants;

public class PathConstants {

    public static final String API_V1 = "/api/v1";

    //USER
    public static final String USER = API_V1 + "/user";
    public static final String GET_CART = "/cart";
    public static final String CART = "/cart/{id}";
    public static final String GET_USER_ORDER = "/order";
    public static final String GET_USER_ORDER_ID = "/order/{id}";
    public static final String GET_USER_ORDER_DETAIL_ID = "/order-detail/{id}";
    public static final String UPDATE = "/update";
    public static final String SAVE_ORDER = GET_USER_ORDER + "/save";
    public static final String DELETE_CART_ITEM = "/delete-cart/{id}";

    //AUTH
    public static final String AUTH = API_V1 + "/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";

    //HOME
    public static final String HOME = API_V1;
    public static final String GET_BOOK_BY_ID = "/{id}";

    //ADMIN
    public static final String ADMIN = API_V1 + "/admin";
    public static final String GET_USER = "/user/{id}";
    public static final String GET_USERS = "/users";
    public static final String GET_BOOKS = "/books";
    public static final String SAVE_BOOK = "/book/save";
    public static final String DELETE_BOOK = "/book/delete/{id}";
    public static final String GET_BOOK = "/book/{id}";
    public static final String UPDATE_BOOK = "/book/update/{id}";
    public static final String DELETE_USER = "/user/delete/{id}";
}

import {BASKET_ROUTE, HOME_ROUTE, LOGIN_ROUTE, PRODUCTS_ROUTE, REGISTRATION_ROUTE, USERS_ROUTE} from "./consts";
import ProductList from "../productList/productList";
import UsersList from "../Users/UsersList";
import ProductEdit from "../productList/ProductEdit";
import UsersEdit from "../Users/UsersEdit";
import Auth from "./Auth";
import Home from "../Home";
import Basket from "./Basket";

export const authRoutes = [

    {
        path: USERS_ROUTE,
        Component: UsersList
    },
    {
        path:USERS_ROUTE,
        Component:UsersEdit
    }

]

export const publicRoutes = [
    {
        path:HOME_ROUTE,
        Component:Home
    },
    {
        path:PRODUCTS_ROUTE,
        Component:ProductList
    },
    {
        path: PRODUCTS_ROUTE + '/:id',
        Component: ProductEdit
    },
    {
        path:LOGIN_ROUTE,
        Component: Auth
    },
    {
        path: REGISTRATION_ROUTE,
        Component: Auth
    },
    {
        path: BASKET_ROUTE,
        Component: Basket
    }
]
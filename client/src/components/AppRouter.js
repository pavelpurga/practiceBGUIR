import React, {useContext} from 'react';
import {Redirect, Route, Switch} from "react-router-dom";
import {HOME_ROUTE, LOGIN_ROUTE} from "./pages/consts";
import {authRoutes, publicRoutes} from "./pages/routes";
import {Context} from "../index";
import {observer} from "mobx-react-lite";

const AppRouter = observer(() => {
    const {user} = useContext(Context)
    console.log(user)
    return (
        <Switch>
            {user.isAuth && authRoutes.map(({path,Component})=>
                <Route key={path} path={path} component={Component} exact/>
            )}
            {publicRoutes.map(({path,Component})=>
                <Route key={path} path={path} component={Component} exact/>
            )}
            <Redirect to = {HOME_ROUTE}/>
        </Switch>
    );
});

export default AppRouter;
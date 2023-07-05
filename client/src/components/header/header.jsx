import React, {Component, useContext} from 'react';
import {Link, NavLink, useHistory} from 'react-router-dom';
import {Button, Navbar, NavbarBrand} from "reactstrap";
import {HOME_ROUTE, LOGIN_ROUTE} from "../pages/consts";
import {Context} from "../../index";
import {observer} from "mobx-react-lite";

const Header = observer(() => {

        const {user}=useContext(Context)
        const history = useHistory()
        return <Navbar color="dark" dark expand="md">
            <NavLink style={{color:'white'}} to={HOME_ROUTE}>Home</NavLink>
            <Button onClick={()=>history.push(LOGIN_ROUTE)}>
                Авторизация
            </Button>
        </Navbar>;

});

export default Header;
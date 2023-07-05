import React, {Component, useContext, useEffect, useState} from "react";
import {BrowserRouter} from "react-router-dom";
import Home from "./components/Home";
import ProductList from "./components/productList/productList";
import ProductEdit from "./components/productList/ProductEdit";
import UsersList from "./components/Users/UsersList";
import UsersEdit from "./components/Users/UsersEdit";
import Auth from "./components/pages/Auth";
import Header from "./components/header/header";
import AppRouter from "./components/AppRouter";
import {observer} from "mobx-react-lite";
import {Context} from "./index";
import {check} from "./components/http/userApi";
import {Spinner} from "reactstrap";

const App = observer(() => {
    const {user}=useContext(Context)
    const [loading,setLoading] = useState(true)

    useEffect(()=>{
        check().then(data=>{
            user.setUser(true)
            user.setIsAuth(true)
        }).finally(()=>setLoading(false))
    },[])
    if (loading){
        return <Spinner animation={"grow"}/>
    }

    return (
        <BrowserRouter>
            <Header/>
            <AppRouter/>
        </BrowserRouter>
    );
});

export default App;

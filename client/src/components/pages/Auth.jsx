import React, {useContext, useState} from 'react';
import {Button, Card, Container, Form, Input, Row} from "reactstrap";
import {NavLink, useHistory, useLocation} from "react-router-dom";
import {login, registration} from "../http/userApi";
import {HOME_ROUTE, LOGIN_ROUTE, REGISTRATION_ROUTE} from "./consts";
import {Context} from "../../index";
import {observer} from "mobx-react-lite";

const Auth = observer (() => {
    const {user}=useContext(Context)
    const history = useHistory()
    const locator = useLocation()
    const isLogin = locator.pathname === LOGIN_ROUTE
    const [name,setName]=useState('')
    const [password,setPassword]=useState('')
    const click = async ()=>{
        try {
            let data;
            if(isLogin){
                data = await login(name,password)
            }else{
                data = await registration(name, password)
            }
            user.setUser(user)
            user.setIsAuth(true)
            history.push(HOME_ROUTE)
        }catch (e){
            alert(e.response.data.message)
        }
    }
    return (
        <Container
            className="d-flex justify-content-center align-items-center"
            style={{height:window.innerHeight-54}}
        >
            <Card style={{width:600}} className="p-5">
                <h2 className="m-auto"></h2>
                <Form className="d-flex flex-column">
                    <Input
                        className="m-3"
                    placeholder="Введите Имя..."
                        value={name}
                        onChange={e => setName(e.target.value)}
                    />
                    <Input
                    className="m-3"
                    placeholder="Введите пароль..."
                    type="password"
                    value={password}
                    onChange={e =>setPassword(e.target.value)}
                    />
                    <Row className="d-flex justify-content-between mt-3 pl-3 pr-3">
                        {isLogin ?
                        <div>
                            Нет аккаунта? <NavLink to={REGISTRATION_ROUTE}>Зарегистрируйся!</NavLink>
                        </div>
                            :
                            <div>Есть аккаунт? <NavLink to={LOGIN_ROUTE} >Войдите!</NavLink> </div>
                        }
                        <Button onClick={click} className="align-self-end">{isLogin ? 'Войти' : 'Регистрация'}</Button>
                    </Row>
                </Form>
            </Card>
        </Container>
    );
});

export default Auth;
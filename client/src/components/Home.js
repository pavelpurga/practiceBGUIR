import React from 'react';
import {Button, Container} from 'reactstrap';
import ProductListForUser from "./productList/ProductListForUser";
import {observer} from "mobx-react-lite";
import {useHistory} from "react-router-dom";
import {BASKET_ROUTE} from "./pages/consts";


const Home = observer(() => {
    const history = useHistory()
    return (
        <div>
            <Container fluid>
                <Button onClick={()=>history.push(BASKET_ROUTE)}>Basket</Button>
                <ProductListForUser/>
            </Container>
        </div>
    );
});

export default Home;
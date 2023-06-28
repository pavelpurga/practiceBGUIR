import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import Header from "./header/header";

class Home extends Component {
    render() {
        return (
            <div>
                <Header/>
                <Container fluid>
                    <Button color="link">< Link to="/products">Products</Link></Button>
                </Container>
            </div>
        );
    }
}
export default Home;
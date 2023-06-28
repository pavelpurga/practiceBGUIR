import React, {Component} from 'react';
import {Link} from "react-router-dom";
import {Button, ButtonGroup, Container, Table} from "reactstrap";
import Header from "../header/header";
class ProductList extends Component {
    constructor(props) {
        super(props);
        this.state = {products:[]};
        this.remove = this.remove.bind(this);
    }
    componentDidMount(){
        fetch('/products')
        .then(response => response.json())
            .then(data => this.setState({products: data}));
    }
    async remove(id) {
        await fetch(`/products/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedProducts = [...this.state.products].filter(i => i.id !== id);
            this.setState({products: updatedProducts});
        });
    }

    render() {
        const {products} = this.state;
        const productList = products.map(product => {
            return <tr key={product.id}>
                <td style={{whiteSpace: 'nowrap'}}>{product.name}</td>
                <td>{product.price}</td>
                <td>{product.description}</td>
                <td>{product.type}</td>
                <td>{product.brand}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/products/" + product.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(product.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <Header/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/products/new">Add Product</Button>
                    </div>
                    <h3>Products</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            <th width="30%">Price</th>
                            <th width="40%">Description</th>
                            <th width="30%">Type</th>
                            <th width="30%">Brand</th>
                        </tr>
                        </thead>
                        <tbody>
                        {productList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default ProductList;
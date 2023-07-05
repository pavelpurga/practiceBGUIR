import React, {Component} from 'react';
import {Button, ButtonGroup, Container, Table} from "reactstrap";
import { connect } from 'react-redux';
import { addToCart } from '../reduxBasket/Actions';
class ProductListForUser extends Component {
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
    handleAddToCart = () => {
        const {id,name,price,description} = this.props
        this.props.addToCart({id,name,price,description,quantity: 1})
    }

    render() {
        const {id,name,price,description} = this.props
        const {products} = this.state;
        const productList = products.map(product => {
            return <tr key={product.id}>
                <td style={{whiteSpace: 'nowrap'}}>{product.name}</td>
                <td>{product.price}</td>
                <td>{product.description}</td>
                <td>{product.type}</td>
                <td>{product.brand}</td>
                <td>
                    <Button onClick={this.handleAddToCart}>
                        Add to basket
                    </Button>
                </td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
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
const mapDispatchToProps = {
    addToCart,
}
export default connect(null,mapDispatchToProps)(ProductListForUser)
import React, { Component } from 'react';
import { connect } from 'react-redux';

class Basket extends Component {
    render() {
        const { products } = this.props;

        return (
            <div>
                <h2>Cart</h2>
                {products.map(product => (
                    <div key={product.id}>
                        <h3>{product.name}</h3>
                        <p>Price: {product.price}</p>
                        <p>Description: {product.description}</p>
                        <p>Quantity: {product.quantity}</p>
                    </div>
                ))}
                <p>Total Items: {products.reduce((total, item) => total + item.quantity, 0)}</p>
                <p>Total Cost: {products.reduce((total, item) => total + item.quantity * item.price, 0)}</p>
            </div>
        );
    }
}

const mapStateToProps = state => ({
    products: state.products,
});

export default connect(mapStateToProps)(Basket);
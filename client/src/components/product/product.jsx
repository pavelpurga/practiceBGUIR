import React from 'react';
import './product.css'
const Product = ({product}) => {
    return (
        <li className="products">
            <section className="product">
                <div className="product_category">
                    {product.type && <p className="product_category product_category_type">{product.type}</p>}
                    {product.brand && <p className="product_category product_category_brand">{product.brand}</p>}
                </div>
                <div className="product_content">
                    <h2 className="product_text">{product.name}</h2>
                    <p className="product_description">{product.description}</p>
                    <div className="product_price_box">
                        <p className="product_price">{product.price}</p>
                    </div>
                </div>
            </section>
        </li>
    );
};

export default Product;
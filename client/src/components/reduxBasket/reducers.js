import { ADD_TO_CART, REMOVE_FROM_CART, UPDATE_CART_ITEM_QUANTITY } from './Actions';

const initialState = {
    products: [],
};

export default function cartReducer(state = initialState, action) {
    switch (action.type) {
        case ADD_TO_CART:
            return {
                ...state,
                products: [...state.products, action.payload.product],
            };
        case REMOVE_FROM_CART:
            return {
                ...state,
                items: state.products.filter(item => item.id !== action.payload.id),
            };
        case UPDATE_CART_ITEM_QUANTITY:
            return {
                ...state,
                products: state.products.map(product => {
                    if (product.id === action.payload.id) {
                        return { ...product, quantity: action.payload.quantity };
                    }
                    return product;
                }),
            };
        default:
            return state;
    }
}
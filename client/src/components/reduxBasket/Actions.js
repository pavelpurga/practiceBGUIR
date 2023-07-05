export const ADD_TO_CART = 'ADD_TO_CART';
export const REMOVE_FROM_CART = 'REMOVE_FROM_CART';
export const UPDATE_CART_ITEM_QUANTITY = 'UPDATE_CART_ITEM_QUANTITY';

export function addToCart(products) {
    return {
        type: ADD_TO_CART,
        payload: { products },
    };
}

export function removeFromCart(id) {
    return {
        type: REMOVE_FROM_CART,
        payload: { id },
    };
}

export function updateCartItemQuantity(id, quantity) {
    return {
        type: UPDATE_CART_ITEM_QUANTITY,
        payload: { id, quantity },
    };
}
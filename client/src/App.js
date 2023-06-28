import React, {Component} from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Home from "./components/Home";
import ProductList from "./components/productList/productList";
import ProductEdit from "./components/productList/ProductEdit";

class App extends Component {
  render() {
      return (
          <BrowserRouter>
              <Switch>
                  <Route path='/' exact={true} component ={Home}/>
                  <Route path='/products' exact={true} component ={ProductList}/>
                  <Route path='/products/:id'  component = {ProductEdit}/>
              </Switch>
          </BrowserRouter>
      );
  }
}

export default App;

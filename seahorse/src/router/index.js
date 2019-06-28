import Vue from 'vue'
import Router from 'vue-router'
import Cargo from "../components/cargo/Cargo";
import Shelves from "../components/cargo/Shelves";
import Dealer from "../components/dealer/Dealer";
import HelloWorld from "../components/HelloWorld";
import Market from "../components/dealer/Market";
import Goods from "../components/goods/Goods";
import Management from "../components/goods/Management";
import Shop from "../components/shop/Shop";
import Activities from "../components/shop/Activities";
import Appraise from "../components/appraise_business/Appraise";
import Business from "../components/appraise_business/Business";
import Merchant from "../components/trade/Merchant";
import Trade from "../components/trade/Trade";
import Order from "../components/distribition/Order";
import Deliveryclerk from "../components/distribition/Deliveryclerk";
import Orders from "../components/orders/Orders";
import User from "../components/orders/User";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/components/cargo',
      name: 'cargo',
      component: Cargo
    },
    {
      path: '/components/shelves',
      name: 'shelves',
      component: Shelves
    },
    {
      path:'/components/dealer',
      name:'dealer',
      component:Dealer
    },
    {
      path:'/components/market',
      name:'market',
      component:Market
    },
    {
      path:'/components/goods',
      name:'goods',
      component:Goods
    },
    {
      path:'/components/management',
      name:'management',
      component:Management
    },
    {
      path:'/components/shop',
      name:'shop',
      component:Shop
    },
    {
      path:'/components/activities',
      name:'activities',
      component:Activities
    },
    {
      path:'/components/appraise',
      name:'appraise',
      component:Appraise
    },
    {
      path:'/components/business',
      name:'business',
      component:Business
    },
    {
      path:'/components/merchant',
      name:'merchant',
      component:Merchant
    },
    {
      path:'/components/trade',
      name:'trade',
      component:Trade
    },
    {
      path:'/components/order',
      name:'order',
      component:Order
    },
    {
      path:'/components/deliveryclerk',
      name:'deliveryclerk',
      component:Deliveryclerk
    },
    {
      path:'/components/orders',
      name:'orders',
      component:Orders
    },
    {
      path:'/components/user',
      name:'user',
      component:User
    },

  ]
})

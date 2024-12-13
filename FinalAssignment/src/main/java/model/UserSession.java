package model;

import model.Personnel.Person;

import java.util.ArrayList;
import java.util.List;

public class UserSession {
    private List<SolutionOffer> cart;  // 购物车
    private Market selectedMarket;      // 选中的市场
    private Channel selectedChannel;    // 选中的渠道

    // 构造函数
    public UserSession() {
        this.cart = new ArrayList<>();
    }

    // 添加商品到购物车
    public void addToCart(SolutionOffer offer) {
        cart.add(offer);
    }

    // 计算购物车总价格
    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        // 遍历购物车中的所有商品，累加价格
        for (SolutionOffer offer : cart) {
            totalPrice += offer.getPrice();  // 获取每个商品的价格并加到总价上
        }

        return totalPrice;  // 返回总价格
    }

    // 获取购物车
    public List<SolutionOffer> getCart() {
        return cart;
    }

    // 设置市场
    public void setMarket(Market selectedMarket) {
        this.selectedMarket = selectedMarket;
    }

    // 设置渠道
    public void setChannel(Channel selectedChannel) {
        this.selectedChannel = selectedChannel;
    }

    // 获取市场
    public Market getMarket() {
        return selectedMarket;  // 返回选中的市场对象
    }

    // 获取渠道
    public Channel getChannel() {
        return selectedChannel;  // 返回选中的渠道对象
    }
}

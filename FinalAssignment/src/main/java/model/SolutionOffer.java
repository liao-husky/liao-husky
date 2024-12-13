/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.ProductManagement.Product;

import java.util.ArrayList;


/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    ArrayList<Product> products;
    int price;// floor, ceiling, and target ideas
    MarketChannelAssignment marketChannelComb;

    public SolutionOffer(MarketChannelAssignment m) {
        marketChannelComb = m;
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void setPrice(int p) {
        price = p;
    }

        private String name;

    public SolutionOffer(String name, double price) {
            this.name = name;
            this.price = (int) price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }


package model;

import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.ProductManagement.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderManager {

    public static List<Order> generateSampleOrders(List<Market> markets, List<Channel> channels) {
        List<Order> orders = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) { // 生成 100 个订单
            Order order = new Order();

            // 随机选择市场和渠道
            Market market = markets.get(random.nextInt(markets.size()));
            Channel channel = channels.get(random.nextInt(channels.size()));

            // 添加订单项
            for (int j = 0; j < random.nextInt(5) + 1; j++) { // 每个订单 1-5 个商品
                double ceilingPrice = 0;
                double targetPrice = 0;
                Product product = new Product("Product " + (j + 1), 10 + random.nextDouble() * 90, ceilingPrice, targetPrice); // 随机价格 10-100
                order.addItem(new OrderItem(product, market, channel, random.nextInt(10) + 1)); // 随机数量 1-10
            }

            orders.add(order);
        }

        return orders;
    }
}

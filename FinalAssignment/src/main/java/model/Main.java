package model;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建业务实例
        Business business = new Business("Sample Business");

        // 设置市场和渠道
        business.getMarkets().add(new Market("US Market"));
        business.getMarkets().add(new Market("EU Market"));
        business.getMarkets().add(new Market("Asia Market"));
        business.getChannels().add(new Channel("Online"));
        business.getChannels().add(new Channel("Retail"));
        business.getChannels().add(new Channel("Wholesale"));
        business.getChannels().add(new Channel("Direct"));

        // 设置广告费用
        AdvertisingCosts advertisingCosts = business.getAdvertisingCosts();
        advertisingCosts.setMarketCost("US Market", 1000);
        advertisingCosts.setMarketCost("EU Market", 1200);
        advertisingCosts.setMarketCost("Asia Market", 800);
        advertisingCosts.setChannelCost("Online", 500);
        advertisingCosts.setChannelCost("Retail", 600);
        advertisingCosts.setChannelCost("Wholesale", 700);
        advertisingCosts.setChannelCost("Direct", 400);

        // 启动业务并生成报告
        business.startBusiness();

        // 用户交互菜单
        Scanner scanner = new Scanner(System.in);
        UserSession userSession = new UserSession();

        // 配置业务实例
        business.generateReports(business.generateSampleOrders());

        while (true) {
            System.out.println("\n--- Admin Report Menu ---");
            System.out.println("1. Market Profitability Report");
            System.out.println("2. Channel Profitability Report");
            System.out.println("3. Advertising Efficiency Report");
            System.out.println("4. User Interaction Menu");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> business.generateMarketProfitabilityReport(business.generateSampleOrders());
                case 2 -> business.generateChannelProfitabilityReport(business.generateSampleOrders());
                case 3 -> business.generateAdvertisingEfficiencyReport(business.generateSampleOrders());
                case 4 -> userInteractionMenu(business, userSession, scanner);
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // 用户交互菜单处理
    private static void userInteractionMenu(Business business, UserSession userSession, Scanner scanner) {
        while (true) {
            System.out.println("\n--- User Interaction Menu ---");
            System.out.println("1. Choose Market & Channel");
            System.out.println("2. See Advertisement");
            System.out.println("3. View Solution Offers & Prices");
            System.out.println("4. Add to Cart");
            System.out.println("5. Complete Purchase");
            System.out.println("6. Back to Admin Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> chooseMarketAndChannel(userSession, business, scanner);
                case 2 -> displayAdvertisement(userSession);
                case 3 -> viewSolutionOffers(business);
                case 4 -> addToCart(userSession, business, scanner);
                case 5 -> completePurchase(userSession);
                case 6 -> {
                    System.out.println("Returning to Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // 选择市场和渠道
    private static void chooseMarketAndChannel(UserSession userSession, Business business, Scanner scanner) {
        System.out.println("\nAvailable Markets:");
        List<Market> markets = business.getMarkets();
        for (int i = 0; i < markets.size(); i++) {
            System.out.println((i + 1) + ". " + markets.get(i).getName());
        }

        System.out.print("Choose a market (number): ");
        int marketChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (marketChoice < 1 || marketChoice > markets.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Market selectedMarket = markets.get(marketChoice - 1);
        userSession.setMarket(selectedMarket);

        System.out.println("\nAvailable Channels:");
        List<Channel> channels = business.getChannels();
        for (int i = 0; i < channels.size(); i++) {
            System.out.println((i + 1) + ". " + channels.get(i).getName());
        }

        System.out.print("Choose a channel (number): ");
        int channelChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (channelChoice < 1 || channelChoice > channels.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Channel selectedChannel = channels.get(channelChoice - 1);
        userSession.setChannel(selectedChannel);

        System.out.println("You have selected: " + selectedMarket.getName() + " - " + selectedChannel.getName());
    }

    // 显示广告
    private static void displayAdvertisement(UserSession userSession) {
        if (userSession.getMarket() != null && userSession.getChannel() != null) {
            System.out.println("\nDisplaying Advertisement for " +
                    userSession.getMarket().getName() + " via " + userSession.getChannel().getName());
        } else {
            System.out.println("Please choose a Market & Channel first.");
        }
    }

    // 查看解决方案报价
    private static void viewSolutionOffers(Business business) {
        System.out.println("\nAvailable Solution Offers:");
        List<SolutionOffer> offers = business.getSolutionOffers();
        for (int i = 0; i < offers.size(); i++) {
            System.out.println((i + 1) + ". " + offers.get(i).getName() + " | Price: $" + offers.get(i).getPrice());
        }
    }

    // 添加到购物车
    private static void addToCart(UserSession userSession, Business business, Scanner scanner) {
        if (userSession.getMarket() == null || userSession.getChannel() == null) {
            System.out.println("Please choose a Market & Channel first.");
            return;
        }

        System.out.println("\nAvailable Solution Offers:");
        List<SolutionOffer> offers = business.getSolutionOffers();
        for (int i = 0; i < offers.size(); i++) {
            System.out.println((i + 1) + ". " + offers.get(i).getName() + " | Price: $" + offers.get(i).getPrice());
        }

        System.out.print("Choose a solution offer to add to cart (number): ");
        int offerChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (offerChoice < 1 || offerChoice > offers.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        SolutionOffer selectedOffer = offers.get(offerChoice - 1);
        userSession.addToCart(selectedOffer);
        System.out.println("Added " + selectedOffer.getName() + " to cart.");
    }

    // 完成购买
    private static void completePurchase(UserSession userSession) {
        if (userSession.getCart().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("\nOrder Summary:");
            for (SolutionOffer offer : userSession.getCart()) {
                System.out.println(offer.getName() + " | Price: $" + offer.getPrice());
            }
            System.out.println("Total: $" + userSession.calculateTotalPrice());
            System.out.println("Thank you for your purchase!");
        }
    }
}

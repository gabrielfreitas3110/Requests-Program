package entities;

import entities.enums.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment = new Date();
    private OrderStatus status;

    List<OrderItem> items = new ArrayList<>();
    private Client client;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(Date moment,OrderStatus status,Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrder() {
        return items;
    }
        
    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }
    
    public void removeItem(OrderItem orderItem) {
        items.remove(orderItem);
    }
    
    public double total() {
        double sum = 0.0;
        for(OrderItem o: items) {
            sum += o.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment)+"\n");
        sb.append("Order status: ");
        sb.append(status+"\n");
        sb.append("Client: "+client+"\n");
        sb.append("Order items: "+"\n");
        for(OrderItem item: items) {
            sb.append(item+"\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f",total()));
        return(sb.toString());
    }
}

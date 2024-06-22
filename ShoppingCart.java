import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item,Integer> cartItems;


    public ShoppingCart(){
        cartItems=new HashMap<>();
    }
    
    //Add item to cart 
    public void addToCart(Item item,int quantity){
        if(quantity<=0){
            System.out.println("Quantity should be greater than zero.Item not added");
            return;
        }
        cartItems.put(item, cartItems.getOrDefault(item, 0)+quantity);
        System.out.println(quantity+" "+item.getName()+"(s) added to cart.");
    }

    // Display Quantity fo added item
    public int displayQty(Item item){
        return cartItems.getOrDefault(item, 06);
    }

    //Update Quantity for added item
    public void updateQty(Item item,int quantity){
        if(quantity<=0){
            System.out.println("Quantity should be greater than zero.");
            return;
        }
        cartItems.put(item, quantity);
        System.out.println("Quantity of "+item.getName()+"is updated to "+quantity);
    }

    //Delete item from cart
    public void deleteItem(Item item){
        cartItems.remove(item);
        System.out.println(item.getName()+"Removed from cart");
    }

    //Display total bill amount
    public double displayBill(){
        double total = 0.0;
        for (Map.Entry<Item,Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}

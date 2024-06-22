import java.util.Scanner;

public class Main {
    private static Item[] items = {
        new Item(1, "Biscuit", "Cadbery Oreo Choclate Flavour", 10.0),
        new Item(2, "Choclate", "Cadbery Silk Heart-Pop", 170.0),
        new Item(3, "Namkeen", "Bikaji bhujia made in bikaner", 40.0),
        new Item(4, "ColdDrink", "Coke zero diet", 60.0)
    };

    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayItems();
        while(true){
            System.out.println("\n------------Shopping Cart Menu--------------");
            System.out.println("1: Add Item to cart");
            System.out.println("2: Display Quantity of an Item in cart");
            System.out.println("3: Update Quantity of an Item in the cart");
            System.out.println("4: Delete Item From cart");
            System.out.println("5: Display Total Bill");
            System.out.println("6: Exit");

            System.out.println("Enter Your Choice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addToCart();
                    break;
                case 2:
                    displayQuantity();
                    break;
                case 3:
                    updateQuantity();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    displayTotalBill();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
            
                default:
                    System.out.println("No such choice please check your input and try again");
                    break;
            }

        }

    }

    //Display Items
    private static void displayItems(){
        System.out.println("Available Items in the cart");
        for(Item item:items){
            System.out.println("Item ID:"+item.getItemId());
            System.out.println("Item Name:"+item.getName());
            System.out.println("Item Description:"+item.getDescription());
            System.out.println("Item Price:"+item.getPrice());
            System.out.println("________________________________________");
        }
    }

    // Add items to cart
    private static void addToCart(){
        System.out.print("Enter the item Id of the item to add to cart :");
        int itemId=scanner.nextInt();
        scanner.nextLine();
        Item selected = findItemById(itemId);
        if(selected!=null){
            System.out.print("Enter Quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            cart.addToCart(selected, quantity);
        }
        else{
            System.out.println("Invalid Item Id");
        }
    }

    //Display the quantity of the item
    private static void displayQuantity(){
        System.out.print("Enter item ID to display quantity:");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        Item selected = findItemById(itemId);
        if(selected!=null){
            System.out.print("Quantity of "+selected.getName()+" in cart :"+cart.displayQty(selected));
        }
        else{
            System.out.println("Invalid item id");
        }
    }

    // Update quantity of the Item
    private static void updateQuantity(){
        System.out.print("Enter the itemId to update quantity:");
        int itemId=scanner.nextInt();
        scanner.nextLine();
        Item selected = findItemById(itemId);
        if(selected!=null){
            System.out.print("Enter new Quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            cart.updateQty(selected, quantity);
        }
        else{
            System.out.println("Invalid Item Id");
        }
    }

    //Delete Item from the cart
    private static void deleteItem(){
        System.out.print("Enter the itemId to Delete:");
        int itemId=scanner.nextInt();
        scanner.nextLine();
        Item selected = findItemById(itemId);
        if(selected!=null){
            cart.deleteItem(selected);
        }
        else{
            System.out.println("Invalid Item Id");
        }
    }

    // Total bill amount
    private static void displayTotalBill(){
        System.out.println("Total Bill amount: ₹ " + cart.displayBill());
    }

    private static Item findItemById(int itemId){
        for(Item item : items){
            if(item.getItemId()==itemId){
            return item;
            }
        }
        return null;
    }

}

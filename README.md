# Order Processing System

#### This is a continuation of the Customer Order Service with some extra features.

### Graphical User Interface
* A graphical user interface was implemented using JavaFX for this project.

## Customer

### Create Account
* Create an account with an ID, password, name, address, credit card number, security question and answer. 
* The system verifies that the ID does not exist already.
* The password must contain at least six characters, one digit, one special character and an upper case letter. 

### Log On 
* The customer enters ID, password and answers the security question.
* The system validates the information and allows for 3 password attempts. 

### Select Items
* A product catalog is displayed which contains name, description, regular and sales prices.
* The customer selects the desired products and its quantities. 
* The system displays the selected products, quantities, taxes and total price. 

### Make Order
* The customer places an order from the items selected. 
* There are two delivery methods: free pickup or mailing with a small fee.
* The system retrieves the customer's credit card number and makes a request to the bank. If the purchase is successful it will display a four digit authorization number. If the card is denied due to insufficient balance, the system requests a new card.

### View Order
* The system displays the order with the order's date, products names and quantities, total price and order status.

### Log Out
* The system logs out.

## Supplier

### Create Account
* Create an account with an ID, password, name, address, security question and answer. 
* The system verifies that the ID does not exist already.
* The password must contain at least six characters, one digit, one special character and an upper case letter. 

### Log On 
* The customer enters ID, password and answers the security question.
* The system validates the information and allows for 3 password attempts. 

### Process Order
* The supplier requests orders.
* The system displays customer orders and their items to the supplier.
* The supplier selects an order.
* The system checks if the warehouse has the items in stock.
* If the items are in stock, the system reserves the order’s items and changes the order status from “ordered” to “ready”.
* If an item(s) is out of stock, the system displays that the item(s) needs to be refilled.
* The system updates the number of available and reserved items in the warehouse. The total of items in the warehouse is a summation of available items and reserved items. 
* The system displays a message that the items have been reserved.  
### Ship Order
* The supplier requests customer orders in “ready” status.  * The system displays the customer orders and items in “ready” status. 
* The supplier selects a customer order and ships the order’s items manually to the customer. 
* The supplier changes the customer order status to “shipped’ status. 
* The system updates the number of reserved items in stock. 
* The system displays the order’s status to the supplier. 

### View Stock
* The supplier requests items in stock.
* The system displays all items in stock regarding item name, item quantity, available item quantity, and reserved item quantity.


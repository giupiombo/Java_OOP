# Customer Order Service

## Create Account
* Create an account with an ID, password, name, address, credit card number, security question and answer. 
* The system verifies that the ID does not exist already.
* The password must containg at least six characters, one digit, one special character and an upper case letter. 

## Log On 
* The customer enters ID, password and answers the security question.
* The system validates the infomation and allows for 3 password attempts. 

## Select Items
* A product catalog is displayed which contains name, description, regular and sales prices.
* The customer selects the desired products and its quantities. 
* The system displays the selected products, quantities, taxes and total price. 

## Make Order
* The customer places an order from the items selected. 
* There are two delivery methods: free pickup or mailing with a small fee.
* The system retrieves the customer's credit card number and makaes an request to the bank. If the purchase is successfull it will display a four digit authorization number. If the card is denied due to insuficient balance, the system requests a new card.

## View Order
* The system displays the order with the order's date, products names and quantities and total price.

## Log Out
* The system logs out.

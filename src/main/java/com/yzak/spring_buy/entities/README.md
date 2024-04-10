# Entities
* User
    - ID int PK
    - ROLE string(30)
    - NAME string(50)
    - EMAIL	string(254)
    - PASSWORD string(60)
    - BIRTH date
    - PHONE int

* Customer
    - USER_ID int FK USERS column ID
    - ADDRESSES Set<Address> 
    - CARDS Set<Card> int FK PAYMENTS column ID *
    - PROFILE blob! *

* Delivery
    - USER_ID INT FK USERS column ID
    - CPF int ✔
    - FINANCIAL_NAME string(50) ✔
    - BANK string(30) ✔
    - BANK_AGENCY int ✔
    - BANK_ACCOUNT int ✔
    - VEHICLE_ID int FK VEHICLES column ID *
    - BALANCE float(8,2)
    - DOCUMENT blob! *
    - SELFIE blob! *
    - PROFILE blob! *

* Market
    - ID int PK
    - NAME string(50)
    - PRODUCTS Set<Product>
    - ADDRESS
    - BANNER blob! *
    - CATEGORY json

* Support
    - USER_ID INT FK USERS column ID
    - PROFILE blob! *

* Order
    - ID int PK
    - STATUS OrderStatus
    - CUSTOMER_ID int FK CUSTOMERS column ID
    - SHOPPER_ID FK SHOPPERS column ID
    - DELIVERYMAN_ID FK DELIVERY_PEOPLE column ID
    - ITEMS Set<OrderItem> 
    - PAYMENT
    - COUPON
    - CUSTOMER_OBSERVATION
    - SHOPPER_OBSERVATION

* Product
    - ID int PK
    - IMAGE blob!*
    - NAME string(30)
    - DESCRIPTION string(60)
    - PRICE float(8,2)
    - CATEGORY string(20)
    - UNIT string(20)

* OrderItem
    - ORDER
    - PRODUCT
    - QUANTITY int
    - PRICE double

* Address
    - ID int PK
    - USER
    - POSTAL_CODE int
    - STREET string(30)
    - NUMBER int
    - COMPLEMENT string(50)
    - DISTRICT string(40)
    - CITY string(30)
    - STATE string(30)

* Card
    - ID int PK
    - NUMBER int
    - NAME string
    - CPF int
    - CVV int
    - VALIDITY date(MM/yy)
    - CUSTOMER_ID int FK CUSTOMERS column ID

* Vehicles
    - DELIVERYMAN_ID int FK DELIVERY_PEOPLE column ID
    - MODEL string(30)
    - YEAR int
    - PLATE string(30)
    - COLOR string(20)
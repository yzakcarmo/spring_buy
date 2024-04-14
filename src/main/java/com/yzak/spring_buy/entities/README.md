# Entities
* User
    - ID Long PK
    - ROLE UserRole
    - NAME string(50)
    - EMAIL	string(254)
    - PASSWORD string(60)
    - PHONE int

* Customer
    - ID Long PK
    - USER FK user_id
    - ADDRESSES Set<Address> 
    - CARDS Set<Card>
    - PROFILE blob!

* Order
  - ID Long PK
  - STATUS OrderStatus
  - CUSTOMER_ID int FK CUSTOMERS column ID
  - DELIVERYMAN_ID FK DELIVERY_PEOPLE column ID
  - ITEMS Set<OrderItem>
  - PAYMENT
  - CUSTOMER_OBSERVATION

* OrderItem ✔️
  - ORDER
  - PRODUCT
  - QUANTITY int
  - PRICE double

* Payment ✔️
  - ID Long PK
  - MOMENT Instant
  - ORDER

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

* Delivery
    - ID Long PK
    - USER_ID INT FK USERS column ID
    - CPF int 
    - FINANCIAL_NAME string(50) 
    - BANK string(30)
    - BANK_AGENCY int
    - BANK_ACCOUNT int
    - VEHICLE_ID int FK VEHICLES column ID *
    - BALANCE float(8,2)
    - DOCUMENT blob! *
    - SELFIE blob! *
    - PROFILE blob! *

* Market
    - ID Long PK
    - NAME string(50)
    - PRODUCTS Set<Product>
    - ADDRESS
    - BANNER blob! *
    - CATEGORY json

* Support
    - USER_ID INT FK USERS column ID
    - PROFILE blob! *

* Product
    - ID int PK
    - NAME string(30)
    - DESCRIPTION string(60)
    - PRICE float(8,2)
    - CATEGORY string(20)

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
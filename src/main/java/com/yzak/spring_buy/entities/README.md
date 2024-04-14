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
    - ADDRESSES Set Address

* Order
  - ID Long PK
  - STATUS OrderStatus
  - CUSTOMER FK customer_id
  - DELIVERY FK delivery_id
  - ITEMS Set OrderItem
  - PAYMENT FK payment
  - CUSTOMER_OBSERVATION

* Product
  - ID int PK
  - NAME string(30)
  - DESCRIPTION string(60)
  - PRICE float(8,2)
  - CATEGORY string(20)

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
    - USER FK user_id
    - CPF int
    - BALANCE float(8,2)

* Market
    - ID Long PK
    - NAME string(50)
    - PRODUCTS Set<Product>
    - ADDRESS
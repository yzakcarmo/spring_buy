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
    - ADDRESS_STREET string(30)
    - ADDRESS_NUMBER int
    - ADDRESS_COMPLEMENT string(50)
    - ADDRESS_DISTRICT string(40)
    - ADDRESS_CITY string(30)
    - ADDRESS_STATE string(30)
    - CARD int FK PAYMENTS column ID *
    - COUPON int FK COUPONS column ID *
    - PROFILE blob! *

* Shopper
    - USER_ID INT FK USERS column ID
    - ADDRESS_STREET string(30)
    - ADDRESS_NUMBER int
    - ADDRESS_COMPLEMENT string(50)
    - ADDRESS_DISTRICT string(40)
    - ADDRESS_CITY string(30)
    - ADDRESS_STATE string(30)
    - CPF int
    - FINANCIAL_NAME string(50)
    - BANK string(30)
    - BANK_AGENCY int
    - BANK_ACCOUNT int
    - MARKET_ID int FK MARKETS column ID *
    - BALANCE float(8,2)
    - DOCUMENT blob! *
    - SELFIE blob! *
    - PROFILE blob! *

* Delivery_people
    - USER_ID INT FK USERS column ID
    - ADDRESS_STREET string(30) ✔
    - ADDRESS_NUMBER int ✔
    - ADDRESS_COMPLEMENT string(50) ✔
    - ADDRESS_DISTRICT string(40) ✔
    - ADDRESS_CITY string(30) ✔
    - ADDRESS_STATE string(30) ✔
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
    - ADDRESS_STREET string(30)
    - ADDRESS_NUMBER int
    - ADDRESS_COMPLEMENT string(50)
    - ADDRESS_DISTRICT string(40)
    - ADDRESS_CITY string(30)
    - ADDRESS_STATE string(30)
    - BANNER blob! *
    - CATEGORY json

* Supports ✔
    - USER_ID INT FK USERS column ID
    - PROFILE blob! *

* Requests
    - ID int PK
    - STATUS string(50)
    - CUSTOMER_ID int FK CUSTOMERS column ID
    - SHOPPER_ID FK SHOPPERS column ID
    - DELIVERYMAN_ID FK DELIVERY_PEOPLE column ID
    - CHEST
    - PAYMENT
    - COUPON
    - CUSTOMER_OBSERVATION
    - SHOPPER_OBSERVATION

* Products
    - ID int PK
    - IMAGE blob!*
    - NAME string(30)
    - DESCRIPTION string(60)
    - PRICE float(8,2)
    - CATEGORY string(20)
    - UNIT string(20)

* Chests
    - PRODUCT json[PRODUCT_ID, QUANTITY]
    - AMOUNT float(8,2)

* Addresses ✔
    - ID int PK
    - USER_ID int FK USERS column ID
    - STREET string(30)
    - NUMBER int
    - COMPLEMENT string(50)
    - DISTRICT string(40)
    - CITY string(30)
    - STATE string(30)

* Payments
    - ID int PK
    - NUMBER int
    - NAME string
    - CPF int
    - CVV int
    - VALIDITY date(MM/YY)
    - CUSTOMER_ID int FK CUSTOMERS column ID

* Coupons
    - CODE int PK
    - VALUE int

* Pantrys
    - PRODUCT json[PRODUCT_ID,QUANTITY]

* Vehicles ✔
    - DELIVERYMAN_ID int FK DELIVERY_PEOPLE column ID
    - MODEL string(30)
    - YEAR int
    - PLATE string(30)
    - COLOR string(20)
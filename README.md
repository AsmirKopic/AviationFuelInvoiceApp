
# ✈️ Aviation fuel invoice application

This application is a simple CRUD (create, read, update, delete) invoice application for aircraft refueling.
Application takes input from delivery voucher provided in time of aircraft refueling. 

The interface is console based.


## Interface

#### 1. Main menu

![interface1](https://github.com/AsmirKopic/AviationFuelTEST/blob/master/images/interface.png)

#### 2. Airline management menu

![interface2](https://github.com/AsmirKopic/AviationFuelTEST/blob/master/images/interface2.png)

#### 3. Invoice management menu

![interface3](https://github.com/AsmirKopic/AviationFuelTEST/blob/master/images/interface3.png)


## First use instructions

* Clone the GitHub repo to your computer

            gh repo clone AsmirKopic/AviationFuelTEST

* Import the project in Intellij/Eclipse or any other IDE of your choice
* Run Main class

## User Case:

After receiving the voucher obtained during the aircraft uplift, 
we enter the basic data into the application:
   * Airline name (Client) - If it does not exist in the database, we can enter it using the Airline menu).
   * Date - of time of refueling.
   * Aircraft registration.
   * Aircraft flight number.
   * Uplift in litters.
   * Uplift in kg – calculated based on uplift litters using kerosene specific weight (0.8). 
                  
                  Uplift in kg value = litters * spec weight (0.8)
   *	Price terms (Based on what payment terms airline have).
   * 	Total price (total = kg value * price terms).
            


## 🛠 Tools used
Java, JDBC, SQLlite, JUnit

## Author

**Asmir Kopić**

- Github: [@AsmirKopic](https://github.com/AsmirKopic)
- Linkedin: [@AsmirKopić](https://ba.linkedin.com/in/asmir-kopic-7b0a379a)
  

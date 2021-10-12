
# ✈️ Aviation fuel invoice application

This application is a simple CRUD (create, read, update, delete) invoice application for aircraft refueling.
Application takes input from delivery voucher provided in time of aircraft refueling. 

The interface is console based.


## Interface

<p align="middle">
   <img src="../master/images/main menu.PNG" width="400"/>
  
</p>

      1. Main menu 
      (picture1)

      2. Airline management menu
      (picture2)

      3. Invoice management menu
      (pciture3)


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
            
                  









## 🛠 Skills
Java, JDBC, SQLlite, Junit


  

#Assignment - Automate_Coach_Gift_Card


------------------------------------------------------------------------------------------------------------


TestCoachGiftCard.java - It is used to test all gift card for checking gift card values.

TestCoachCheckOut.java- It is used to check all credit card for checking order is placed or not.

You can also run the TestCase Using Maven Command:

#For Testing all Test Files
mvn package

#For testing TestCoachGiftCard.java
mvn clean verify -D
test="TestCoachGiftCard.java"

#For testing TestCoachCheckOut.java 
mvn clean verify -D
test="TestCoachCheckOut.java" -Dcursor="1"

#here Cusror=1 means that it check the credit card which is at position 1 in USCreditCardDetails.xls

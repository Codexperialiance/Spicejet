Feature: User's Successful flight search to compare fares
Scenario: Student travler's flight booking on spicejet.com website

Given User is on www.spicejet.com home page using "chrome" browser
When User submit necessary travel information travelOption "RoundTrip" origin "Bengaluru (BLR)"and destination "BOM"
And User submit departing Date "23" Month "May" Year "2019"
And User submit returning Date "3" Month "July" Year "2019"
And User submit  currency "USD" dicountPromo "student" expectedPass "3"
Then User will land on a page with available flight and price offers
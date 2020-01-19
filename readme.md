# Bioscoop applicatie

TODO Emiel: uitleg verschil master en dockerized branche

Hieronder is er per service die beschikbaar is, via een frontend die de gateway gebruikt, een scenario geschreven van hoe getest kan worden.

## Schedule service

## Hall management service
### Hall by number
Dit is een get request dat een hall ophaalt via het hall nummer. De output is een JSON met daarin de details van hoe de zaal er uit ziet. De JSON bevat number (= zaal nummer), seats (= array met alle seats), screenSize, facilities (= array met verschillende faciliteiten van een zaal) en technologies (= array met technische specificaties).
De seats array bevat seat-objecten. Iedere seat wordt in de zaal gelocaliseerd door een nummer en een rij. Daarnaast heeft het ook een type (= NORMAL, TWIN, ...) en een status. De status is hier enkel van belang om een seat aan te duiden als "OUT OF ORDER" zodat deze seat zeker niet kan geboekt worden wanneer de zaal gereserveerd wordt als eventhall.

### EventHall by eventID
> *Vooraf*: maak een event aan in de schedule service en gebruik dat eventID om een eventhall op te vragen. *Of*: gebruik eventID 4 dat reeds in de database aanwezig is.

Bij het aanmaken van een event wordt een zaal aan het event gekoppeld. Van die zaal wordt een kopie gemaakt -> eventhall. Het JSON-object is identiek aan dat van een hall met dat verschil dat de id's van een seat hier gebruikt worden in de ticket service om een specifieke seat te boeken. Na het boeken van een seat zal de status van de seat hier veranderen naar "BOOKED".

## Ticket service

## Staff service

## Media service

## Advertisement service

# Bioscoop applicatie

TODO Emiel: uitleg verschil master en dockerized branche

Hieronder is er per service die beschikbaar is, via een frontend die de gateway gebruikt, een scenario geschreven van hoe getest kan worden. Via de index.html pagina is er een overzicht van de verschillende frontend om de services te gebruiken beschikbaar.

## Schedule service

## Hall management service
### Hall by number
Dit is een get request dat een hall ophaalt via het hall nummer. De output is een JSON met daarin de details van hoe de zaal er uit ziet. De JSON bevat number (= zaal nummer), seats (= array met alle seats), screenSize, facilities (= array met verschillende faciliteiten van een zaal) en technologies (= array met technische specificaties).
De seats array bevat seat-objecten. Iedere seat wordt in de zaal gelocaliseerd door een nummer en een rij. Daarnaast heeft het ook een type (= NORMAL, TWIN, ...) en een status. De status is hier enkel van belang om een seat aan te duiden als "OUT OF ORDER" zodat deze seat zeker niet kan geboekt worden wanneer de zaal gereserveerd wordt als eventhall.

### EventHall by eventID
> *Vooraf*: maak een event aan in de schedule service en gebruik dat eventID om een eventhall op te vragen. *Of*: gebruik eventID 4 dat reeds in de database aanwezig is.

Bij het aanmaken van een event wordt een zaal aan het event gekoppeld. Van die zaal wordt een kopie gemaakt -> eventhall. Het JSON-object is identiek aan dat van een hall met dat verschil dat de id's van een seat hier gebruikt worden in de ticket service om een specifieke seat te boeken. Het is dit seat-id dat gebruikt kan worden in de *ticket service*. Na het boeken van een seat zal de status van de seat hier veranderen naar "BOOKED".

## Ticket service
### Ticket boeken
Bij enkele velden zoals DateEvent, Name, Hallnumber en EventId wordt er van uit gegaan dat dit al in een eerdere stap is gekozen en wordt ingevuld. Omdat deze front-end dit niet ophaalt uit vorige stappen kunnen deze hier ingevuld worden.

Hoofdzakelijk het eventid is belangrijk omdat aan de hand hiervan de zetels bij de juiste zaal terechtkomen.

Uiteraard ook de verplichte keuze van de zetels. Dit gebeurt aan de hand van een id dat wordt samengesteld door eerst het rijnummer, dan het zetelnummer en dan het eventnummer. Om meerdere zetels mee te geven, worden de zetelid's gescheiden door komma's. De 0 die normaal nog zou vooraf moeten gaan voor het rijnummer in het voorbeeld werd nooit getoond door formattering.

De consumpties zijn optioneel. Er zijn enkele id's mogelijk (1,2,3,4). Indien meerdere consumpties gekozen worden, worden deze gescheiden door komma's.

Als antwoord bij het boeken van een ticket wordt een veld "booked" ingevuld dat al dan niet weergeeft of de boeking geslaagd is (True) of niet.

### Get tickets
Deze request haalt alle tickets op. Zo kan om te testen makkelijk bekeken worden of het ticket goed is opgeslagen.

## Staff service
### Generate tasks
Dit is een job die iedere nacht automatisch zou uitgevoerd worden om op basis van de schedule taken voor het personeel te genereren. Op die manier moet er doorheen de dag niet telkens heel wat computing gebeuren bij het opvragen van een taak (Get task). In deze test omgeving moet die job manueel uitgevoerd worden voordat er taken kunnen opgehaald worden door op de knop *Generate tasks* te klikken.

### Get task
Haal taken op voor het personeel voor een bepaalde datum.

### Add task
Voeg manueel een taak toe aan de automatisch gegenereerde taken door middel van een JSON-object te posten.

## Media service
Een media item is een film dat aan event kan gekoppeld worden.
### Get media by title
Als er een film werd toegevoeged via *Post media* kan er gezocht worden naar die film op titel.

### Post media
Toevoegen van een film. Er staat een JSON-object klaar dat gepost kan worden. Daarna kan dit media-item via titel opgehaald worden.

### Post file
Via post file kan je media-bestanden aan een media-item hangen. Het film bestand zelf van een bepaalde film, een trailer, reclame filmpjes. Op die manier kunnen de techniekers met één get alle media ophalen die ze nodig hebben om de filmvoorstelling te laten doorgaan.
Het media id kan gekopieerd worden uit de response van *Get media by title*. Bij *Bestand kiezen* kan als test een leeg tekstbestand opgeven. Enkel de title van het bestand zal gebruikt en opgeslagen worden in deze test omgeving. *Type* is het type media dat je aan het media-item hangt: trailer, advertisement, film.

## Advertisement service

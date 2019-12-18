package be.ugent.hallmgmtservice.adapters.messaging;


import be.ugent.hallmgmtservice.domain.Seat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookSeatRequest extends BookSeatMessage { }

package com.drools;

import java.util.HashMap;
import java.util.List;

public class ReservationAlerts {

       public enum AlertType {
            RESERVATIONDETAILSRESPONSE
        }

        @SuppressWarnings("rawtypes")
        private List<HashMap> reservationMap;

        @SuppressWarnings("rawtypes")
        public List<HashMap> getReservationMap() {
            return reservationMap;
        }

        @SuppressWarnings("rawtypes")
        public void setReservationMap(List<HashMap> reservationMap) {
            this.reservationMap = reservationMap;
        }
        }
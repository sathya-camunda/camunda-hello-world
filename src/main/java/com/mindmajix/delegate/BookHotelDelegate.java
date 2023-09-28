package com.mindmajix.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

@Component
public class BookHotelDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution context) throws Exception {
        HotelBookingForm thisBooking = new HotelBookingForm("NicePlace", 2, true);
        ObjectValue thisBookingValue = Variables.objectValue(thisBooking)
                .serializationDataFormat(Variables.SerializationDataFormats.JAVA)
                .create();
        context.setVariable("ThisBooking", thisBookingValue);

        boolean bookingError = (Boolean) context.getVariable("bookingHotelError");
        if (bookingError)
            throw new BpmnError("THIS_IS_NOT_GOOD");

    }

}

package com.mindmajix.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CancelBookingDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution exec) throws Exception {
		HotelBookingForm thisBooking = (HotelBookingForm) exec.getVariable("thisBooking");
		exec.removeVariable("thisBooking");
		exec.setVariable("cancelledBooking", thisBooking);
		throw new BpmnError("THIS_IS_NOT_GOOD");
	}

}

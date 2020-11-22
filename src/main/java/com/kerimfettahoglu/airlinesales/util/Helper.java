package com.kerimfettahoglu.airlinesales.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kerimfettahoglu.airlinesales.entity.Flight;

public class Helper {
	private static int seatInWhichPortion(Flight f, int seatNumber) {
		int portionSize = (int) (f.getCapacity() * 0.1);
		int counter = 0;
		for (int i = portionSize; i <= f.getCapacity(); i += portionSize) {
			if (i >= seatNumber) {
				break;
			}
			counter++;
		}
		return counter;
	}

	public static double calculateSeatPrice(Flight f) {
		double increase = f.getBasePrice() * 0.1;
		int portionNumber = Helper.seatInWhichPortion(f, f.getSoldTicket());
		double accumulater = portionNumber * increase;
		return f.getBasePrice() + accumulater;
	}

	public static double calculateNextSeatPrice(Flight f) {
		double increase = f.getBasePrice() * 0.1;
		int portionNumber = Helper.seatInWhichPortion(f, f.getSoldTicket() + 1);
		double accumulater = portionNumber * increase;
		return f.getBasePrice() + accumulater;
	}

	public static String getMaskedCreditCardNumber(String number) {
		number = number.replaceAll("[^0-9]", "");
		if (number.length() == 16) {
			number = number.substring(0, 6) + "******" + number.substring(12,16);
			return number;	
		}
		throw new IllegalArgumentException("Credit card is not valid.");
	}
	
	/*public static void main(String[] args) {
		String str = "4221-1611-2233-0005";
		
		System.out.println(Helper.getMaskedCreditCardNumber(str));
		Flight f = new Flight();
		f.setBasePrice(1200D);
		f.setCapacity(10);
		f.setSoldTicket(0);
		for (int i = 1; i <= f.getCapacity() + 5; i++) {
			if (f.isAvailable()) {
				System.out.println("---------" + i + "----------");
				f.sellSeat();
				System.out.println(f.calculateSeatPrice());
				System.out.println("---------------------");
			} else {
				System.out.println("there is no available seat.");
			}
		}
	}*/
}

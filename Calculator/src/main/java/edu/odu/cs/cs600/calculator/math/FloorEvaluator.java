package edu.odu.cs.cs600.calculator.math;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FloorEvaluator implements IUnaryEvaluator {

	private static Logger logger = LogManager.getLogger(FloorEvaluator.class);
	
	public double compute(double value) throws ArithmeticException
	{
		logger.error("Floor function has not yet been completed and is using a JAVA OOTB function right now.");
		return Math.floor(value);
	}	
}
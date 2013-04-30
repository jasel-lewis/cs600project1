package edu.odu.cs.cs600.calculator;

/**
 * Interface for power state of the calculator
 */
public interface PowerStateChangedListener {
	public void powerStateChanged(boolean powerState);
}
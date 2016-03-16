import java.io.*;
import java.util.*;

public class Stopwatch {

	private final long start;

	public Stopwatch() {
		start = System.nanoTime();
	} //Stopwatch (constructor)

	public double elapsedTime() {
		long now = System.nanoTime();
		return (now - start) / 1000000000.0;
	} //elapsedTime

} //Stopwatch (class)

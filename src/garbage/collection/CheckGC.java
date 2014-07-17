package garbage.collection;

import java.util.Date;

public class CheckGC {

	public static void main(String[] args) {

		Runtime runtime = Runtime.getRuntime();

		System.out.println("Total JVM memory: " + runtime.totalMemory());
		System.out.println("Before: " + runtime.freeMemory());

		Date date = null;

		// if we don't null out each date object, we cause obsolete references and memory leak
		// the garbage collector have to take care all the inaccessible objects but this is impossible
		for (long i = 0; i < 999999999; i++) {
			date = new Date();
			//date = null;
		}

		System.out.println("After: " + runtime.freeMemory());
		//System.gc(); equals to Runtime.gc();
		runtime.gc();
		System.out.println("After GC: " + runtime.freeMemory());
	}
}
